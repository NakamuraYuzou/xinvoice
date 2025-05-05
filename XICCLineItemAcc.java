package xinvoice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;

public class XICCLineItemAcc
{
	public static XICCLineItem mapFromJson( String jsonstr ) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		XICCLineItem rc = mapper.readValue( jsonstr , XICCLineItem.class );
		return( rc );
	}

	public static String getJson( XICCLineItem arg ) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy( PropertyNamingStrategies.UPPER_CAMEL_CASE ) ;
		mapper.enable( SerializationFeature.INDENT_OUTPUT );
		String rc = mapper.writeValueAsString( arg );
		return( rc );
	}

	public static XICCLineItem[] getByKanriCode( String code ) throws Exception
	{
		XIBBVBBtoCCLine[] lines = XIBBVBBtoCCLineAcc.getByKanriCode( code );
		XICCLineItem[] rc = new XICCLineItem[ lines.length ];
		XICCAllocation[] alc = new XICCAllocation[1];
		alc[0] = new XICCAllocation();
		alc[0].setPercentage("100");
		for ( int i = 0 ; i < lines.length ; i++ )
		{
			rc[i] = new XICCLineItem();
			rc[i].setAllocations( alc );
			rc[i].setDescription( lines[i].getMeisaiKoumoku() );					//����(���׍���)
			rc[i].setUnitPrice( String.valueOf( lines[i].getMeisaiTanka() ) );		//�P��
			rc[i].setQuantity( String.valueOf( lines[i].getMeisaiSuuryou() ) );		//����
			rc[i].setCustom1("SADENKO");											//?
			rc[i].setCustom2( lines[i].getHiyouKubun() );							//��p�敪
			rc[i].setCustom3( lines[i].getBumonCode() );							//����R�[�h
			rc[i].setCustom4( lines[i].getKoujiCode() );							//�H���R�[�h
			rc[i].setCustom5( lines[i].getKoujiSyousaiCode() );						//�H���ڍ׃R�[�h
			rc[i].setCustom7("N");													//���^���E

			String ritsustr = lines[i].getMeisaiZeiritsu();
			if ( ritsustr == null ) ritsustr = "10%";
			if ( ritsustr.length() == 0 ) ritsustr = "10%";
			String exptype = lines[i].getExpenseTypeCode10();
			if ( ritsustr.equals("8%") ) exptype = lines[i].getExpenseTypeCode08();
			rc[i].setExpenseTypeCode( exptype );									//�o��^�C�v

			int ritsu = Integer.parseInt( ritsustr.substring( 0 , ritsustr.length() - 1 ) );
			long zeikomi = lines[i].getMeisaiSeikyuuGaku();
			if ( zeikomi == 0 )
			{
				long zeinuki = lines[i].getMeisaiKingaku();
				long zei = zeinuki * ritsu / 100;
				zeikomi = zeinuki + zei;
			}
			rc[i].setUnitPrice( String.valueOf( zeikomi ) );						//�P��
			rc[i].setQuantity("1");	//����
		}

		return( rc );
	}
}
