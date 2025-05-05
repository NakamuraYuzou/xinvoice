package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVSeikyuusakiFuzaiAcc
{
	public static int getCount() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT COUNT(*) AS CNT FROM yXIzVBB¿‹æ•sİ";
		xidb.setSQL( sqlstr );
		xidb.getRow();
		int rc = xidb.getClmnAsInt("CNT");
		xidb.close();

		return( rc );
	}

	public static XIBBVSeikyuusakiFuzai[] getAll() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIBBVSeikyuusakiFuzai> list = new ArrayList<XIBBVSeikyuusakiFuzai>();
		String sqlstr = "SELECT * FROM yXIzVBB¿‹æ•sİ";
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIBBVSeikyuusakiFuzai rec = new XIBBVSeikyuusakiFuzai();
			rec.setSeikyuuMoto( xidb.getClmn("¿‹Œ³") );
			rec.setSeikyuuSaki( xidb.getClmn("¿‹æ") );
			rec.setKenmei( xidb.getClmn("Œ–¼") );
			list.add( rec );
		}
		xidb.close();

		XIBBVSeikyuusakiFuzai[] rc = new XIBBVSeikyuusakiFuzai[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}
}
