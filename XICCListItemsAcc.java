package xinvoice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;

public class XICCListItemsAcc
{

	public static XICCListItems getListItems( String host ) throws Exception
	{
		XICCAPIAccess ccapi = new XICCAPIAccess( host , "GET" );
		String res = ccapi.connect();
//		int code = ccapi.getResopnseCode();
//		String msg = ccapi.getResponseMessage();
		ccapi.close();

		XICCListItems rc = XICCListItemsAcc.getFromJson( res );
		return( rc );
	}

	public static String getJson( XICCListItems arg ) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy( PropertyNamingStrategies.SNAKE_CASE ) ;
		mapper.enable( SerializationFeature.INDENT_OUTPUT );
		String rc = mapper.writeValueAsString( arg );
		return( rc );
	}

	public static XICCListItems getFromJson( String jsonstr ) throws Exception
	{
		XICCListItems rc = new XICCListItems();
		ObjectMapper mapper = new ObjectMapper();
		rc = mapper.readValue( jsonstr , XICCListItems.class );
		return( rc );
	}

	public static void insert( XICCListItem item ) throws Exception
	{
		String ListID = item.getListID();
		String Name = item.getName();
		String ParentID = item.getParentID();
		String Level1Code = item.getLevel1Code();
		String Level2Code = item.getLevel2Code();
		String Level3Code = item.getLevel3Code();
		String Level4Code = item.getLevel4Code();
		String Level5Code = item.getLevel5Code();
		String Level6Code = item.getLevel6Code();
		String Level7Code = item.getLevel7Code();
		String Level8Code = item.getLevel8Code();
		String Level9Code = item.getLevel9Code();
		String Level10Code = item.getLevel10Code();
		String IsDeleted = item.getIsDeleted();
		String ID = item.getID();
		String URI = item.getURI();

		String[] fldtbl = XIBBSeikyuusakiAcc.getFieldList();
		String[] vltbl = new String[16];
		if ( ListID != null ) vltbl[0] = "'" + ListID + "'";
		if ( Name != null ) vltbl[1] = "'" + Name + "'";
		if ( ParentID != null ) vltbl[2] = "'" + ParentID + "'";
		if ( Level1Code != null ) vltbl[3] = "'" + Level1Code + "'";
		if ( Level2Code != null ) vltbl[4] = "'" + Level2Code + "'";
		if ( Level3Code != null ) vltbl[5] = "'" + Level3Code + "'";
		if ( Level4Code != null ) vltbl[6] = "'" + Level4Code + "'";
		if ( Level5Code != null ) vltbl[7] = "'" + Level5Code + "'";
		if ( Level6Code != null ) vltbl[8] = "'" + Level6Code + "'";
		if ( Level7Code != null ) vltbl[9] = "'" + Level7Code + "'";
		if ( Level8Code != null ) vltbl[10] = "'" + Level8Code + "'";
		if ( Level9Code != null ) vltbl[11] = "'" + Level9Code + "'";
		if ( Level10Code != null ) vltbl[12] = "'" + Level10Code + "'";
		if ( IsDeleted != null ) vltbl[13] = "'" + IsDeleted + "'";
		if ( ID != null ) vltbl[14] = "'" + ID + "'";
		if ( URI != null ) vltbl[15] = "'" + URI + "'";
		XIDBAccess xidb = new XIDBAccess();
		xidb.insert( "ÅyXIÅzzCCListItem" , fldtbl , vltbl );
		xidb.close();
	}

	public static void insertBulk( XICCListItem[] items ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();

		for ( int i = 0 ; i < items.length ; i++ )
		{
			String ListID = items[i].getListID();
			String Name = items[i].getName();
			String ParentID = items[i].getParentID();
			String Level1Code = items[i].getLevel1Code();
			String Level2Code = items[i].getLevel2Code();
			String Level3Code = items[i].getLevel3Code();
			String Level4Code = items[i].getLevel4Code();
			String Level5Code = items[i].getLevel5Code();
			String Level6Code = items[i].getLevel6Code();
			String Level7Code = items[i].getLevel7Code();
			String Level8Code = items[i].getLevel8Code();
			String Level9Code = items[i].getLevel9Code();
			String Level10Code = items[i].getLevel10Code();
			String IsDeleted = items[i].getIsDeleted();
			String ID = items[i].getID();
			String URI = items[i].getURI();

			String[] fldtbl = XICCListItemsAcc.getFieldList();
			String[] vltbl = new String[16];
			if ( ListID != null ) vltbl[0] = "'" + ListID + "'";
			if ( Name != null ) vltbl[1] = "'" + Name + "'";
			if ( ParentID != null ) vltbl[2] = "'" + ParentID + "'";
			if ( Level1Code != null ) vltbl[3] = "'" + Level1Code + "'";
			if ( Level2Code != null ) vltbl[4] = "'" + Level2Code + "'";
			if ( Level3Code != null ) vltbl[5] = "'" + Level3Code + "'";
			if ( Level4Code != null ) vltbl[6] = "'" + Level4Code + "'";
			if ( Level5Code != null ) vltbl[7] = "'" + Level5Code + "'";
			if ( Level6Code != null ) vltbl[8] = "'" + Level6Code + "'";
			if ( Level7Code != null ) vltbl[9] = "'" + Level7Code + "'";
			if ( Level8Code != null ) vltbl[10] = "'" + Level8Code + "'";
			if ( Level9Code != null ) vltbl[11] = "'" + Level9Code + "'";
			if ( Level10Code != null ) vltbl[12] = "'" + Level10Code + "'";
			if ( IsDeleted != null ) vltbl[13] = "'" + IsDeleted + "'";
			if ( ID != null ) vltbl[14] = "'" + ID + "'";
			if ( URI != null ) vltbl[15] = "'" + URI + "'";

			xidb.insert( "ÅyXIÅzCCListItem" , fldtbl , vltbl );
		}
		xidb.close();
	}

	public static void delete( String listid ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();

		String sqlstr = "DELETE FROM ÅyXIÅzCCListItem"
					+ " WHERE ListID = '" + listid + "'";
		xidb.setUpdate( sqlstr );

		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = {  "ListID" , "Name" , "ParentID" ,
						 "Level1Code" , "Level2Code" , "Level3Code" , "Level4Code" , "Level5Code" ,
						 "Level6Code" , "Level7Code" , "Level8Code" , "Level9Code" , "Level10Code" ,
						 "IsDeleted" , "ID" , "URI" };
		return( rc );
	}
}
