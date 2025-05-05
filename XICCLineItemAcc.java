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
			rc[i].setDescription( lines[i].getMeisaiKoumoku() );					//説明(明細項目)
			rc[i].setUnitPrice( String.valueOf( lines[i].getMeisaiTanka() ) );		//単価
			rc[i].setQuantity( String.valueOf( lines[i].getMeisaiSuuryou() ) );		//数量
			rc[i].setCustom1("SADENKO");											//?
			rc[i].setCustom2( lines[i].getHiyouKubun() );							//費用区分
			rc[i].setCustom3( lines[i].getBumonCode() );							//部門コード
			rc[i].setCustom4( lines[i].getKoujiCode() );							//工事コード
			rc[i].setCustom5( lines[i].getKoujiSyousaiCode() );						//工事詳細コード
			rc[i].setCustom7("N");													//給与相殺

			String ritsustr = lines[i].getMeisaiZeiritsu();
			if ( ritsustr == null ) ritsustr = "10%";
			if ( ritsustr.length() == 0 ) ritsustr = "10%";
			String exptype = lines[i].getExpenseTypeCode10();
			if ( ritsustr.equals("8%") ) exptype = lines[i].getExpenseTypeCode08();
			rc[i].setExpenseTypeCode( exptype );									//経費タイプ

			int ritsu = Integer.parseInt( ritsustr.substring( 0 , ritsustr.length() - 1 ) );
			long zeikomi = lines[i].getMeisaiSeikyuuGaku();
			if ( zeikomi == 0 )
			{
				long zeinuki = lines[i].getMeisaiKingaku();
				long zei = zeinuki * ritsu / 100;
				zeikomi = zeinuki + zei;
			}
			rc[i].setUnitPrice( String.valueOf( zeikomi ) );						//単価
			rc[i].setQuantity("1");	//数量
		}

		return( rc );
	}
}
