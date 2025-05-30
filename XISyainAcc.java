package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XISyainAcc
{
	public static XISyain[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzÐõ}X^ ORDER BY ÐõR[h ASC";
		XISyain[] rc = XISyainAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XISyain[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzÐõ}X^";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE ¼ LIKE '%" + kwd + "%'"
								+ "  OR ¼ LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY ÐõR[h ASC";
		XISyain[] rc = XISyainAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XISyain getByCd( String syaincd ) throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzÐõ}X^ WHERE ÐõR[h = '" + syaincd + "'";
		XISyain[] recs = XISyainAcc.getBySQL( sqlstr );
		XISyain rc = recs[0];
		return( rc );
	}

	public static XISyain[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XISyain> list = new ArrayList<XISyain>();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XISyain rec = new XISyain();
			rec.setSyainCode( xidb.getClmn("ÐõR[h") );
			rec.setSyainName( xidb.getClmn("¼") );
			rec.setBusyoName( xidb.getClmn("¼") );
			rec.setMailAddress( xidb.getClmn("Ah") );
			list.add( rec );
		}
		xidb.close();

		XISyain[] rc = new XISyain[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static long copyIn( String inf ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE yXIzÐõ}X^";
		xidb.setUpdate( sqlstr );

		String tblnm = "yXIzÐõ}X^";
		String[] colmns = XISyainAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "ÐõR[h" , "¼" , "¼" , "Ah" };
		return( rc );
	}
}
