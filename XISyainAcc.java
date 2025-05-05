package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XISyainAcc
{
	public static XISyain[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】社員マスタ ORDER BY 社員コード ASC";
		XISyain[] rc = XISyainAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XISyain[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】社員マスタ";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE 氏名 LIKE '%" + kwd + "%'"
								+ "  OR 部署名 LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY 社員コード ASC";
		XISyain[] rc = XISyainAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XISyain getByCd( String syaincd ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】社員マスタ WHERE 社員コード = '" + syaincd + "'";
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
			rec.setSyainCode( xidb.getClmn("社員コード") );
			rec.setSyainName( xidb.getClmn("氏名") );
			rec.setBusyoName( xidb.getClmn("部署名") );
			rec.setMailAddress( xidb.getClmn("メアド") );
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
		String sqlstr = "TRUNCATE TABLE 【XI】社員マスタ";
		xidb.setUpdate( sqlstr );

		String tblnm = "【XI】社員マスタ";
		String[] colmns = XISyainAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "社員コード" , "氏名" , "部署名" , "メアド" };
		return( rc );
	}
}
