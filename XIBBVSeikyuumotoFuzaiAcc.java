package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVSeikyuumotoFuzaiAcc
{
	public static int getCount() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT COUNT(*) AS CNT FROM ÅyXIÅzVBBêøãÅå≥ïsç›";
		xidb.setSQL( sqlstr );
		xidb.getRow();
		int rc = xidb.getClmnAsInt("CNT");
		xidb.close();

		return( rc );
	}

	public static XIBBVSeikyuumotoFuzai[] getAll() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIBBVSeikyuumotoFuzai> list = new ArrayList<XIBBVSeikyuumotoFuzai>();
		String sqlstr = "SELECT * FROM ÅyXIÅzVBBêøãÅå≥ïsç›";
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIBBVSeikyuumotoFuzai rec = new XIBBVSeikyuumotoFuzai();
			rec.setSeikyuumotoName( xidb.getClmn("êøãÅå≥") );
			list.add( rec );
		}
		xidb.close();

		XIBBVSeikyuumotoFuzai[] rc = new XIBBVSeikyuumotoFuzai[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}
}
