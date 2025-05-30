package xinvoice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XIBBTorikomiRirekiAcc
{
	public static XIBBTorikomiRireki[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzBBæð ORDER BY ðÔ DESC";
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
			rec.setNo( xidb.getClmnAsLong("ðÔ") );
			rec.setOperationDate( xidb.getClmnAsDate("æú") );
			rec.setFileName( xidb.getClmn("t@C¼") );
			rec.setKensuu( xidb.getClmnAsLong("") );
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
		xidb.insert( "yXIzBBæð" , fldtbl , vltbl );
		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = { "æú" , "t@C¼" , "" };
		return( rc );
	}

}
