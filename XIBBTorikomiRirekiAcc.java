package xinvoice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XIBBTorikomiRirekiAcc
{
	public static XIBBTorikomiRireki[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】BB取込履歴 ORDER BY 履歴番号 DESC";
		XIBBTorikomiRireki[] rc = XIBBTorikomiRirekiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBTorikomiRireki[] getBySQL( String sqlstr ) throws Exception
	{
		List<XIBBTorikomiRireki> list = new ArrayList<XIBBTorikomiRireki>();

		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIBBTorikomiRireki rec = new XIBBTorikomiRireki();
			rec.setNo( xidb.getClmnAsLong("履歴番号") );
			rec.setOperationDate( xidb.getClmnAsDate("取込日時") );
			rec.setFileName( xidb.getClmn("ファイル名") );
			rec.setKensuu( xidb.getClmnAsLong("件数") );
			list.add( rec );
		}
		xidb.close();

		XIBBTorikomiRireki[] rc = new XIBBTorikomiRireki[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}


	public static void insert( XIBBTorikomiRireki xitr ) throws Exception
	{
		Date opdate = xitr.getOperationDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String opdatestr = sdf.format( opdate );
		String filenm = xitr.getFileName();
		long kensuu = xitr.getKensuu();

		String[] fldtbl = XIBBTorikomiRirekiAcc.getFieldList();
		String[] vltbl = new String[3];
		vltbl[0] = "'" + opdatestr + "'";
		vltbl[1] = "'" + filenm + "'";
		vltbl[2] = String.valueOf( kensuu );

		XIDBAccess xidb = new XIDBAccess();
		xidb.insert( "【XI】BB取込履歴" , fldtbl , vltbl );
		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = { "取込日時" , "ファイル名" , "件数" };
		return( rc );
	}

}
