package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBumonAcc
{
	public static XIBumon[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】部門マスタ ORDER BY 部門コード ASC";
		XIBumon[] rc = XIBumonAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBumon[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】部門マスタ";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE 部門名称 LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY 部門コード ASC";
		XIBumon[] rc = XIBumonAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBumon getByCd( String bumoncd ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】部門マスタ WHERE 部門コード = '" + bumoncd + "'";
		XIBumon[] recs = XIBumonAcc.getBySQL( sqlstr );
		XIBumon rc = recs[0];
		return( rc );
	}

	public static XIBumon[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIBumon> list = new ArrayList<XIBumon>();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIBumon rec = new XIBumon();
			rec.setBumonCode( xidb.getClmn("部門コード") );
			rec.setBumonMeisyou( xidb.getClmn("部門名称") );
			rec.setBumonRyakusyou( xidb.getClmn("部門略称") );
			list.add( rec );
		}
		xidb.close();

		XIBumon[] rc = new XIBumon[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static long copyIn( String inf ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE 【XI】部門マスタ";
		xidb.setUpdate( sqlstr );

		String tblnm = "【XI】部門マスタ";
		String[] colmns = XIBumonAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "部門コード" , "部門名称" , "部門略称" };
		return( rc );
	}
}
