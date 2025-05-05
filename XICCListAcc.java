package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XICCListAcc
{
	public static XICCList[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM ÅyXIÅzCCList"
						+ " ORDER BY ListNo ASC";
		XICCList[] rc =XICCListAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XICCList[] getBySQL( String sqlstr ) throws Exception
	{
		List<XICCList> list = new ArrayList<XICCList>();
		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			XICCList rec = new XICCList();
			rec.setNo( xidb.getClmnAsLong("ListNo") );
			rec.setListID( xidb.getClmn("ListID") );
			rec.setName( xidb.getClmn("Name") );
			list.add( rec );
		}
		xidb.close();

		XICCList[] rc = new XICCList[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}
}
