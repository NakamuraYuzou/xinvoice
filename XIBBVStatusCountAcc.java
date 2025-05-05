package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVStatusCountAcc
{
	public static int getCountByStatus( String sts , XIBBVStatusCount[] cnts )
	{
		int rc = 0;
		for ( int i = 0 ; i < cnts.length ; i++ )
		{
			String wsts = cnts[i].getStatus();
			if ( wsts.equals( sts ) ) rc = cnts[i].getCount();
		}

		return( rc );
	}

	public static XIBBVStatusCount[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】VBBステータス別件数";
		XIBBVStatusCount[] rc = XIBBVStatusCountAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVStatusCount[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );
		List<XIBBVStatusCount> list = new ArrayList<XIBBVStatusCount>();
		while( xidb.getRow() )
		{
			XIBBVStatusCount rec = new XIBBVStatusCount();
			rec.setStatus( xidb.getClmn("ステータス") );
			rec.setCount( xidb.getClmnAsInt("件数") );
			list.add( rec );
		}
		xidb.close();

		XIBBVStatusCount[] rc = new XIBBVStatusCount[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}
}
