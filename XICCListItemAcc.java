package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XICCListItemAcc
{
	public static XICCListItem[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM ÅyXIÅzCCListItem";
		XICCListItem[] rc = XICCListItemAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XICCListItem[] getRoot( String listid ) throws Exception
	{
		String sqlstr = "SELECT * FROM ÅyXIÅzCCListItem"
						+ " WHERE ListID = '" + listid + "'"
						+ "   AND ParentID IS NULL"
						+ " ORDER BY Level1Code ASC , Level2Code ASC , Level3Code ASC , Level4Code ASC";
		XICCListItem[] rc = XICCListItemAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XICCListItem[] getByParentID( String id ) throws Exception
	{
		String sqlstr = "SELECT * FROM ÅyXIÅzCCListItem"
						+ " WHERE ParentID = '" + id + "'";
		XICCListItem[] rc = XICCListItemAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XICCListItem[] getBySQL( String sqlstr ) throws Exception
	{
		List<XICCListItem> list = new ArrayList<XICCListItem>();
		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			XICCListItem rec = new XICCListItem();
			rec.setListID( xidb.getClmn("ListID") );
			rec.setName( xidb.getClmn("Name") );
			rec.setParentID( xidb.getClmn("ParentID") );
			rec.setLevel1Code( xidb.getClmn("Level1Code") );
			rec.setLevel2Code( xidb.getClmn("Level2Code") );
			rec.setLevel3Code( xidb.getClmn("Level3Code") );
			rec.setLevel4Code( xidb.getClmn("Level4Code") );
			rec.setLevel5Code( xidb.getClmn("Level5Code") );
			rec.setLevel6Code( xidb.getClmn("Level6Code") );
			rec.setLevel7Code( xidb.getClmn("Level7Code") );
			rec.setLevel8Code( xidb.getClmn("Level8Code") );
			rec.setLevel9Code( xidb.getClmn("Level9Code") );
			rec.setLevel10Code( xidb.getClmn("Level10Code") );
			rec.setIsDeleted( xidb.getClmn("IsDeleted") );
			rec.setID( xidb.getClmn("ID") );
			rec.setURI( xidb.getClmn("URI") );
			list.add( rec );
		}
		xidb.close();

		XICCListItem[] rc = new XICCListItem[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}
}
