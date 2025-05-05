package xinvoice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class XIKoujiAcc
{
	public static XIKouji[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】工事マスタ ORDER BY 工事コード ASC";
		XIKouji[] rc = XIKoujiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKouji[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】工事マスタ";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE 工事名称 LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY 工事コード ASC";
		XIKouji[] rc = XIKoujiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKouji[] getByRequestParameter( HttpServletRequest request ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】工事マスタ";
		String nm = request.getParameter("nm");
		String[] bumon = request.getParameterValues("bumon");

		String whereand = " WHERE ";
		if ( nm != null )
		{
			if ( nm.length() > 0 )
			{
				sqlstr = sqlstr + whereand + "工事名称 LIKE '%" + nm + "%'";
				whereand = " AND ";
			}
		}
		if ( bumon != null )
		{
			boolean prmflg = false;
			String wstr = "部門コード IN (";
			String wcon = "";
			for ( int i = 0 ; i < bumon.length ; i++  )
			{
				wstr = wstr + wcon + " '" + bumon[i] + "'";
				wcon = " ,";
				prmflg = true;
			}

			if( prmflg == true )
			{
				sqlstr = sqlstr + whereand + wstr + ")";
				whereand = " AND ";
			}
		}

		sqlstr = sqlstr + " ORDER BY 工事コード ASC";

		XIKouji[] rc = XIKoujiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKouji getByCd( String koujicd ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】工事マスタ WHERE 工事コード = '" + koujicd + "'";
		XIKouji[] recs = XIKoujiAcc.getBySQL( sqlstr );
		XIKouji rc = recs[0];
		return( rc );
	}

	public static XIKouji[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIKouji> list = new ArrayList<XIKouji>();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIKouji rec = new XIKouji();
			rec.setKoujiCode( xidb.getClmn("工事コード") );
			rec.setKoujiSyousaiCode( xidb.getClmn("工事詳細コード") );
			rec.setKoujiMeisyou( xidb.getClmn("工事名称") );
			rec.setKoujiRyakusyou( xidb.getClmn("工事略称") );
			rec.setBumonCode( xidb.getClmn("部門コード") );
			rec.setBumonMeisyou( xidb.getClmn("部門名称") );
			list.add( rec );
		}
		xidb.close();

		XIKouji[] rc = new XIKouji[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static long copyIn( String inf ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE 【XI】工事マスタ";
		xidb.setUpdate( sqlstr );

		String tblnm = "【XI】工事マスタ";
		String[] colmns = XIKoujiAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "工事コード" , "工事詳細コード" , "工事名称" , "工事略称" , "部門コード" , "部門名称" };
		return( rc );
	}
}
