package xinvoice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class XIKoujiAcc
{
	public static XIKouji[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�H���}�X�^ ORDER BY �H���R�[�h ASC";
		XIKouji[] rc = XIKoujiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKouji[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�H���}�X�^";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE �H������ LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY �H���R�[�h ASC";
		XIKouji[] rc = XIKoujiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKouji[] getByRequestParameter( HttpServletRequest request ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�H���}�X�^";
		String nm = request.getParameter("nm");
		String[] bumon = request.getParameterValues("bumon");

		String whereand = " WHERE ";
		if ( nm != null )
		{
			if ( nm.length() > 0 )
			{
				sqlstr = sqlstr + whereand + "�H������ LIKE '%" + nm + "%'";
				whereand = " AND ";
			}
		}
		if ( bumon != null )
		{
			boolean prmflg = false;
			String wstr = "����R�[�h IN (";
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

		sqlstr = sqlstr + " ORDER BY �H���R�[�h ASC";

		XIKouji[] rc = XIKoujiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKouji getByCd( String koujicd ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�H���}�X�^ WHERE �H���R�[�h = '" + koujicd + "'";
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
			rec.setKoujiCode( xidb.getClmn("�H���R�[�h") );
			rec.setKoujiSyousaiCode( xidb.getClmn("�H���ڍ׃R�[�h") );
			rec.setKoujiMeisyou( xidb.getClmn("�H������") );
			rec.setKoujiRyakusyou( xidb.getClmn("�H������") );
			rec.setBumonCode( xidb.getClmn("����R�[�h") );
			rec.setBumonMeisyou( xidb.getClmn("���喼��") );
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
		String sqlstr = "TRUNCATE TABLE �yXI�z�H���}�X�^";
		xidb.setUpdate( sqlstr );

		String tblnm = "�yXI�z�H���}�X�^";
		String[] colmns = XIKoujiAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "�H���R�[�h" , "�H���ڍ׃R�[�h" , "�H������" , "�H������" , "����R�[�h" , "���喼��" };
		return( rc );
	}
}
