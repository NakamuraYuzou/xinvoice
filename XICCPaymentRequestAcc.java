package xinvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;

public class XICCPaymentRequestAcc
{
	public static XICCPaymentRequest mapFromJson( String jsonstr ) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		XICCPaymentRequest rc = mapper.readValue( jsonstr , XICCPaymentRequest.class );
		return( rc );
	}

	public static String getJson( XICCPaymentRequest arg ) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy( PropertyNamingStrategies.UPPER_CAMEL_CASE ) ;
		mapper.enable( SerializationFeature.INDENT_OUTPUT );
		String rc = mapper.writeValueAsString( arg );
		return( rc );
	}

	public static int putPaymentRequest( String code ) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
		XIBBVBBtoCCTop top = XIBBVBBtoCCTopAcc.getByKanriCode( code );

		XICCVendorRemitToIdentifier vendor = new XICCVendorRemitToIdentifier();
		vendor.setVendorCode( top.getTorihikisakiCode() );

		XICCLineItem[] lineitems = XICCLineItemAcc.getByKanriCode( code );

		XICCPaymentRequest payreq = new XICCPaymentRequest();
		payreq.setInvoiceNumber( top.getSeikyuusyoBangou() );
		payreq.setInvoiceDate( sdf.format( top.getHakkouDate() ) );
		Date wdate = top.getKigenDate();
		String kigenstr = "";
		if ( wdate != null ) kigenstr = sdf.format( top.getKigenDate() );
		payreq.setPaymentDueDate( kigenstr );
		payreq.setName( top.getKenmei() );
		payreq.setDescription( top.getSeikyuusaki() );
		payreq.setInvoiceAmount( String.valueOf( top.getAmount() ) );
		payreq.setEmployeeLoginId( top.getMailAddress() );
		payreq.setCreatedByUsername( top.getMailAddress() );
		payreq.setVendorRemitToIdetifier( vendor );
		payreq.setLineItems( lineitems );

		String jsonstr = XICCPaymentRequestAcc.getJson( payreq );
//		System.out.println( jsonstr );


		String url = "/api/v3.0/invoice/paymentrequest";
		XICCAPIAccess ccapi = new XICCAPIAccess( url , "POST" );
		ccapi.setRequest( jsonstr );
		String resp = ccapi.submit();
		int rc = ccapi.getResopnseCode();
//		String msg = ccapi.getResponseMessage();
		ccapi.close();
		if ( rc != 200 )
		{
			XICCErrorLog log = new XICCErrorLog();
			log.setCode( rc );
			log.setMessage( resp );
			log.setJson( jsonstr );
			XICCErrorLogAcc.insert( log );
		}

		return( rc );

	}
}
