package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XISyainAcc
{
	public static XISyain[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�Ј��}�X�^ ORDER BY �Ј��R�[�h ASC";
		XISyain[] rc = XISyainAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XISyain[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�Ј��}�X�^";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE ���� LIKE '%" + kwd + "%'"
								+ "  OR ������ LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY �Ј��R�[�h ASC";
		XISyain[] rc = XISyainAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XISyain getByCd( String syaincd ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�Ј��}�X�^ WHERE �Ј��R�[�h = '" + syaincd + "'";
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
			rec.setSyainCode( xidb.getClmn("�Ј��R�[�h") );
			rec.setSyainName( xidb.getClmn("����") );
			rec.setBusyoName( xidb.getClmn("������") );
			rec.setMailAddress( xidb.getClmn("���A�h") );
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
		String sqlstr = "TRUNCATE TABLE �yXI�z�Ј��}�X�^";
		xidb.setUpdate( sqlstr );

		String tblnm = "�yXI�z�Ј��}�X�^";
		String[] colmns = XISyainAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "�Ј��R�[�h" , "����" , "������" , "���A�h" };
		return( rc );
	}
}
