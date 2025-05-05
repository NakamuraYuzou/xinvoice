package xinvoice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XICCErrorLogAcc
{
	public static XICCErrorLog[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】CCエラーログ ORDER BY 番号 DESC";
		XICCErrorLog[] rc = XICCErrorLogAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XICCErrorLog getByNo( long no ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】CCエラーログ WHERE 番号 = " + no;
		XICCErrorLog[] rc = XICCErrorLogAcc.getBySQL( sqlstr );
		return( rc[0] );
	}

	public static XICCErrorLog[] getBySQL( String sqlstr ) throws Exception
	{
		List<XICCErrorLog> list = new ArrayList<XICCErrorLog>();
		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			XICCErrorLog rec = new XICCErrorLog();
			rec.setNo( xidb.getClmnAsLong("番号") );
			rec.setCode( xidb.getClmnAsInt("コード") );
			rec.setMessage( xidb.getClmn("メッセージ") );
			rec.setJson( xidb.getClmn("JSON") );
			rec.setTimeStamp( xidb.getClmnAsDate("発生日時") );
			list.add( rec );
		}
		xidb.close();

		XICCErrorLog[] rc = new XICCErrorLog[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static void insert( XICCErrorLog xilog ) throws Exception
	{
		int code = xilog.getCode();
		String msg = xilog.getMessage();
		String json = xilog.getJson();
		Date stamp = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
		String stampstr = sdf.format( stamp );

		String[] fldtbl = XICCErrorLogAcc.getFieldList();
		String[] vltbl = new String[4];
		vltbl[0] = String.valueOf( code );
		if ( msg != null ) vltbl[1] = "'" + msg + "'";
		if ( json != null ) vltbl[2] = "'" + json + "'";
		if ( stampstr != null ) vltbl[3] = "'" + stampstr + "'";

		XIDBAccess xidb = new XIDBAccess();
		xidb.insert( "【XI】CCエラーログ" , fldtbl , vltbl );
		xidb.close();
	}

	public static void delete( long no ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();

		String sqlstr = "DELETE FROM 【XI】CCエラーログ"
					+ " WHERE 番号 = " + no;
		xidb.setUpdate( sqlstr );

		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = {  "コード" , "メッセージ" , "JSON" , "発生日時" };
		return( rc );
	}
}
