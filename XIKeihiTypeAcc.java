package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIKeihiTypeAcc
{
	public static XIKeihiType[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】経費タイプ ORDER BY コード ASC";
		XIKeihiType[] rc = XIKeihiTypeAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiType[] getByKeyword( String kwd ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】経費タイプ";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 )
			{
				sqlstr = sqlstr + " WHERE 経費タイプ LIKE '%" + kwd + "%'";
			}
		}
		sqlstr = sqlstr + " ORDER BY コード ASC";
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
			rec.setExpenseTypeCode( xidb.getClmn("コード") );
			rec.setExpenseTypeName( xidb.getClmn("経費タイプ") );
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
		String sqlstr = "TRUNCATE TABLE 【XI】経費タイプ";
		xidb.setUpdate( sqlstr );

		String tblnm = "【XI】経費タイプ";
		String[] colmns = XIKeihiTypeAcc.getFieldList();
		long rc = xidb.copyIn( tblnm , colmns , inf );
		xidb.close();

		return( rc );
	}

	public static String[] getFieldList()
	{
		String[] rc = { "コード" , "経費タイプ" };
		return( rc );
	}
}
