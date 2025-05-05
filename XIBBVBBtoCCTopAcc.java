package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVBBtoCCTopAcc
{
	public static XIBBVBBtoCCTop[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】VBBtoCCTop";
		XIBBVBBtoCCTop[] rc = XIBBVBBtoCCTopAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCTop[] getByStatus( String sts ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】VBBtoCCTop WHERE ステータス = '" + sts + "'";
		XIBBVBBtoCCTop[] rc = XIBBVBBtoCCTopAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCTop getByKanriCode( String code ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】VBBtoCCTop WHERE 請求書管理コード = '" + code + "'";
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
			rec.setKanriCode( xidb.getClmn("請求書管理コード") );
			rec.setSeikyuusyoBangou( xidb.getClmn("請求書番号") );
			rec.setHakkouDate( xidb.getClmnAsDate("請求書発行日") );
			rec.setKigenDate( xidb.getClmnAsDate("支払期限") );
			rec.setKenmei( xidb.getClmn("件名") );
			rec.setAmount( xidb.getClmnAsLong("請求金額") );
			rec.setSeikyuumoto( xidb.getClmn("請求元") );
			rec.setSeikyuusaki( xidb.getClmn("請求先") );
			rec.setStatus( xidb.getClmn("ステータス") );
			rec.setTorihikisakiCode( xidb.getClmn("取引先コード") );
			rec.setCheckPattern( xidb.getClmn("チェックパターン") );
			rec.setHiyouCode( xidb.getClmn("費用区分") );
			rec.setHiyouName( xidb.getClmn("費用区分名") );
			rec.setMailAddress( xidb.getClmn("メアド") );
			rec.setKihyousyaName( xidb.getClmn("起票者名") );
			rec.setKoujiCode( xidb.getClmn("工事コード") );
			rec.setKoujiSyousaiCode( xidb.getClmn("工事詳細コード") );
			rec.setKoujiName( xidb.getClmn("工事名") );
			rec.setBumonCode( xidb.getClmn("部門コード") );
			rec.setBumonName( xidb.getClmn("部門名") );
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
