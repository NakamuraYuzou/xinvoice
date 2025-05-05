package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVBBtoCCLineAcc
{
	public static XIBBVBBtoCCLine[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】VBBtoCCLine";
		XIBBVBBtoCCLine[] rc = XIBBVBBtoCCLineAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCLine[] getByKanriCode( String code ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】VBBtoCCLine WHERE 請求書管理コード = '" + code + "'";
		XIBBVBBtoCCLine[] rc = XIBBVBBtoCCLineAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCLine[] getBySQL( String sqlstr ) throws Exception
	{
		List<XIBBVBBtoCCLine> list = new ArrayList<XIBBVBBtoCCLine>();
		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			XIBBVBBtoCCLine rec = new XIBBVBBtoCCLine();
			rec.setKanriCode( xidb.getClmn("請求書管理コード") );
			rec.setKanriNo( xidb.getClmnAsLong("請求書管理番号") );
			rec.setSeikyuuNo( xidb.getClmn("請求書番号") );
			rec.setZeinukiSeikyuugaku( xidb.getClmnAsLong("税抜請求金額") );
			rec.setTorihikisakiCode( xidb.getClmn("取引先コード") );
			rec.setSeikyuumoto( xidb.getClmn("請求元") );
			rec.setPatternTorihikisakiCode( xidb.getClmn("パターン取引先コード") );
			rec.setExpenseTypeCode08( xidb.getClmn("経費タイプコード08") );
			rec.setExpenseTypeName08( xidb.getClmn("経費タイプ名称08") );
			rec.setExpenseTypeCode10( xidb.getClmn("経費タイプコード10") );
			rec.setExpenseTypeName10( xidb.getClmn("経費タイプ名称10") );
			rec.setHiyouKubun( xidb.getClmn("費用区分") );
			rec.setKoujiCode( xidb.getClmn("工事コード") );
			rec.setKoujiSyousaiCode( xidb.getClmn("工事詳細コード") );
			rec.setBumonCode( xidb.getClmn("部門コード") );
			rec.setMeisaiRenban( xidb.getClmnAsInt("明細連番") );
			rec.setMeisaiBangou( xidb.getClmn("明細番号") );
			rec.setMeisaiKoumoku( xidb.getClmn("明細項目") );
			rec.setMeisaiBumon( xidb.getClmn("明細部門名") );
			rec.setMeisaiTanka( xidb.getClmnAsLong("単価") );
			rec.setMeisaiTani( xidb.getClmn("単位") );
			rec.setMeisaiSuuryou( xidb.getClmnAsLong("数量") );
			rec.setMeisaiZeiritsu( xidb.getClmn("税率") );
			rec.setMeisaiKingaku( xidb.getClmnAsLong("金額") );
			rec.setMeisaiSyouhizeiGaku( xidb.getClmnAsLong("消費税額"));
			rec.setMeisaiSeikyuuGaku( xidb.getClmnAsLong("請求金額"));
			rec.setMeisaiBikou( xidb.getClmn("明細備考") );
			list.add( rec );
		}
		xidb.close();

		XIBBVBBtoCCLine[] rc = new XIBBVBBtoCCLine[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

}
