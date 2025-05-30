package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVBBtoCCTopAcc
{
	public static XIBBVBBtoCCTop[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzVBBtoCCTop";
		XIBBVBBtoCCTop[] rc = XIBBVBBtoCCTopAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCTop[] getByStatus( String sts ) throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzVBBtoCCTop WHERE Xe[^X = '" + sts + "'";
		XIBBVBBtoCCTop[] rc = XIBBVBBtoCCTopAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCTop getByKanriCode( String code ) throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzVBBtoCCTop WHERE ¿ÇR[h = '" + code + "'";
		XIBBVBBtoCCTop[] rc = XIBBVBBtoCCTopAcc.getBySQL( sqlstr );
		return( rc[0] );
	}

	public static XIBBVBBtoCCTop[] getBySQL( String sqlstr ) throws Exception
	{
		List<XIBBVBBtoCCTop> list = new ArrayList<XIBBVBBtoCCTop>();
		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			XIBBVBBtoCCTop rec = new XIBBVBBtoCCTop();
			rec.setKanriCode( xidb.getClmn("¿ÇR[h") );
			rec.setSeikyuusyoBangou( xidb.getClmn("¿Ô") );
			rec.setHakkouDate( xidb.getClmnAsDate("¿­sú") );
			rec.setKigenDate( xidb.getClmnAsDate("x¥úÀ") );
			rec.setKenmei( xidb.getClmn("¼") );
			rec.setAmount( xidb.getClmnAsLong("¿àz") );
			rec.setSeikyuumoto( xidb.getClmn("¿³") );
			rec.setSeikyuusaki( xidb.getClmn("¿æ") );
			rec.setStatus( xidb.getClmn("Xe[^X") );
			rec.setTorihikisakiCode( xidb.getClmn("æøæR[h") );
			rec.setCheckPattern( xidb.getClmn("`FbNp^[") );
			rec.setHiyouCode( xidb.getClmn("ïpæª") );
			rec.setHiyouName( xidb.getClmn("ïpæª¼") );
			rec.setMailAddress( xidb.getClmn("Ah") );
			rec.setKihyousyaName( xidb.getClmn("N[Ò¼") );
			rec.setKoujiCode( xidb.getClmn("HR[h") );
			rec.setKoujiSyousaiCode( xidb.getClmn("HÚ×R[h") );
			rec.setKoujiName( xidb.getClmn("H¼") );
			rec.setBumonCode( xidb.getClmn("åR[h") );
			rec.setBumonName( xidb.getClmn("å¼") );
			list.add( rec );
		}
		xidb.close();

		XIBBVBBtoCCTop[] rc = new XIBBVBBtoCCTop[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}
}
