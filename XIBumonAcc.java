package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBumonAcc
{
	public static XIBumon[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z����}�X�^ ORDER BY ����R�[�h ASC";
		XIBumon[] rc = XIBumonAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBumon[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z����}�X�^";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE ���喼�� LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY ����R�[�h ASC";
		XIBumon[] rc = XIBumonAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBumon getByCd( String bumoncd ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z����}�X�^ WHERE ����R�[�h = '" + bumoncd + "'";
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
			rec.setBumonCode( xidb.getClmn("����R�[�h") );
			rec.setBumonMeisyou( xidb.getClmn("���喼��") );
			rec.setBumonRyakusyou( xidb.getClmn("���嗪��") );
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
		String sqlstr = "TRUNCATE TABLE �yXI�z����}�X�^";
		xidb.setUpdate( sqlstr );

		String tblnm = "�yXI�z����}�X�^";
		String[] colmns = XIBumonAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "����R�[�h" , "���喼��" , "���嗪��" };
		return( rc );
	}
}
