package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIKeihiTypeAcc
{
	public static XIKeihiType[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�o��^�C�v ORDER BY �R�[�h ASC";
		XIKeihiType[] rc = XIKeihiTypeAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiType[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�o��^�C�v";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE �o��^�C�v LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY �R�[�h ASC";
		XIKeihiType[] rc = XIKeihiTypeAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiType[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIKeihiType> list = new ArrayList<XIKeihiType>();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIKeihiType rec = new XIKeihiType();
			rec.setExpenseTypeCode( xidb.getClmn("�R�[�h") );
			rec.setExpenseTypeName( xidb.getClmn("�o��^�C�v") );
			list.add( rec );
		}
		xidb.close();

		XIKeihiType[] rc = new XIKeihiType[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static long copyIn( String inf ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE �yXI�z�o��^�C�v";
		xidb.setUpdate( sqlstr );

		String tblnm = "�yXI�z�o��^�C�v";
		String[] colmns = XIKeihiTypeAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "�R�[�h" , "�o��^�C�v" };
		return( rc );
	}
}
