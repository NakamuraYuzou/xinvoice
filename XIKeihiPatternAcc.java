package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIKeihiPatternAcc
{
	public static XIKeihiPattern[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】経費タイプパターン ORDER BY 取引先コード ASC";
		XIKeihiPattern[] rc = XIKeihiPatternAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiPattern[] getByCodeName( String cd , String moto ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】経費タイプパターン"
						+ " WHERE 取引先コード = '" + cd + "'"
						+ "   AND 請求元 = '" + moto + "'"
						+ " ORDER BY パターン ASC";
		XIKeihiPattern[] rc = XIKeihiPatternAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiPattern[] getByKeyword( String cd , String moto , String kwd ) throws Exception
	{
		String sqltop = "SELECT * FROM 【XI】経費タイプパターン"
						+ " WHERE 取引先コード = '" + cd + "'"
						+ "   AND 請求元 = '" + moto + "'";
		String sqlmid = "";
		String sqlbot =  " ORDER BY パターン ASC";
		if ( kwd.length() > 0 ) sqlmid = "   AND パターン LIKE '%" + kwd + "%'";
		String sqlstr = sqltop + sqlmid + sqlbot;
		XIKeihiPattern[] rc = XIKeihiPatternAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiPattern getByCdNamePtn( String cd , String moto , String ptn) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】経費タイプパターン"
						+ " WHERE 取引先コード = '" + cd + "'"
						+ "  AND  請求元 = '" + moto + "'"
						+ "  AND  パターン = '" + ptn + "'";
		XIKeihiPattern[] recs = XIKeihiPatternAcc.getBySQL( sqlstr );
		XIKeihiPattern rc = recs[0];
		return( rc );
	}

	public static XIKeihiPattern[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIKeihiPattern> list = new ArrayList<XIKeihiPattern>();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIKeihiPattern rec = new XIKeihiPattern();
			rec.setTorihikisakiCode( xidb.getClmn("取引先コード") );
			rec.setSeikyuumoto( xidb.getClmn("請求元") );
			rec.setExpenseTypePattern( xidb.getClmn("パターン") );
			rec.setExpenseTypeCode08( xidb.getClmn("経費タイプコード08") );
			rec.setExpenseTypeName08( xidb.getClmn("経費タイプ名称08") );
			rec.setExpenseTypeCode10( xidb.getClmn("経費タイプコード10") );
			rec.setExpenseTypeName10( xidb.getClmn("経費タイプ名称10") );
			list.add( rec );
		}
		xidb.close();

		XIKeihiPattern[] rc = new XIKeihiPattern[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static String[][] getKouhoList( String cd , String moto , String kwd) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<String[]> list = new ArrayList<String[]>();
		String sqlstr = "SELECT * FROM 【XI】VBB経費パターン候補"
						+ " WHERE 取引先コード = '" + cd + "'"
						+ "  AND  請求元 = '" + moto + "'";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 ) 	sqlstr = sqlstr +  "  AND  明細項目 LIKE '%" + kwd + "%'";
		}
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			String[] rec = new String[7];
			rec[0] = xidb.getClmn("取引先コード");
			rec[1] = xidb.getClmn("請求元");
			rec[2] = xidb.getClmn("元経費タイプコード08");
			rec[3] = xidb.getClmn("元経費タイプ名称08");
			rec[4] = xidb.getClmn("元経費タイプコード10");
			rec[5] = xidb.getClmn("元経費タイプ名称10");
			rec[6] = xidb.getClmn("明細項目");
			list.add( rec );
		}
		xidb.close();

		String[][] rc = new String[ list.size() ][5];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static String[] getMeisaiByPattern(  String moto , String ptn ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<String> list = new ArrayList<String>();
		String sqlstr = "SELECT DISTINCT 【明細情報】明細項目 FROM 【XI】BBCsv"
						+ " WHERE 【おもて情報】請求元 LIKE '" + moto + "'"
						+ "   AND 【明細情報】明細項目 LIKE '" + ptn + "'";
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			String meisai = xidb.getClmn("【明細情報】明細項目");
			list.add( meisai );
		}
		xidb.close();

		String[] rc = new String[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static void insert( XIKeihiPattern xiseik ) throws Exception
	{
		String toricode = xiseik.getTorihikisakiCode();
		String seikname = xiseik.getSeikyuumoto();
		String pattern = xiseik.getExpenseTypePattern();
		String expcode08 = xiseik.getExpenseTypeCode08();
		String expname08 = xiseik.getExpenseTypeName08();
		String expcode10 = xiseik.getExpenseTypeCode10();
		String expname10 = xiseik.getExpenseTypeName10();

		String[] fldtbl = XIKeihiPatternAcc.getFieldList();
		String[] vltbl = new String[7];
		if ( toricode != null ) vltbl[0] = "'" + toricode + "'";
		if ( seikname != null ) vltbl[1] = "'" + seikname + "'";
		if ( pattern != null ) vltbl[2] = "'" + pattern + "'";
		if ( expcode08 != null ) vltbl[3] = "'" + expcode08 + "'";
		if ( expname08 != null ) vltbl[4] = "'" + expname08 + "'";
		if ( expcode10 != null ) vltbl[5] = "'" + expcode10 + "'";
		if ( expname10 != null ) vltbl[6] = "'" + expname10 + "'";

		XIDBAccess xidb = new XIDBAccess();
		xidb.insert( "【XI】経費タイプパターン" , fldtbl , vltbl );
		xidb.close();
	}

	public static void delete( String cd , String moto , String ptn ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();

		String sqlstr = "DELETE FROM 【XI】経費タイプパターン"
						+ " WHERE 取引先コード = '" + cd + "'"
						+ "  AND  請求元 = '" + moto + "'"
						+ "  AND  パターン = '" + ptn + "'";
		xidb.setUpdate( sqlstr );

		xidb.close();
	}

	public static void update( String cd , String moto , String ptn , XIKeihiPattern xiseik1 ) throws Exception
	{
		String[] fldtbl = XIKeihiPatternAcc.getFieldList();

		String[] vltbl = new String[7];
		String torihikicd1 = xiseik1.getTorihikisakiCode();
		String seikname1 = xiseik1.getSeikyuumoto();
		String pattern1 = xiseik1.getExpenseTypePattern();
		String expcode081 = xiseik1.getExpenseTypeCode08();
		String expname081 = xiseik1.getExpenseTypeName08();
		String expcode101 = xiseik1.getExpenseTypeCode10();
		String expname101 = xiseik1.getExpenseTypeName10();
		if ( torihikicd1 != null ) vltbl[0] = "'" + torihikicd1 + "'";
		if ( seikname1 != null ) vltbl[1] = "'" + seikname1 + "'";
		if ( pattern1 != null ) vltbl[2] = "'" + pattern1 + "'";
		if ( expcode081 != null ) vltbl[3] = "'" + expcode081 + "'";
		if ( expname081 != null ) vltbl[4] = "'" + expname081 + "'";
		if ( expcode101 != null ) vltbl[5] = "'" + expcode101 + "'";
		if ( expname101 != null ) vltbl[6] = "'" + expname101 + "'";

		XIKeihiPattern xiseik2 = XIKeihiPatternAcc.getByCdNamePtn( cd , moto , ptn);
		String[] orgtbl = new String[7];
		String torihikicd2 = xiseik2.getTorihikisakiCode();
		String seikname2 = xiseik2.getSeikyuumoto();
		String pattern2 = xiseik2.getExpenseTypePattern();
		String expcode082 = xiseik2.getExpenseTypeCode08();
		String expname082 = xiseik2.getExpenseTypeName08();
		String expcode102 = xiseik2.getExpenseTypeCode10();
		String expname102 = xiseik2.getExpenseTypeName10();
		if ( torihikicd2 != null ) orgtbl[0] = "'" + torihikicd2 + "'";
		if ( seikname2 != null ) orgtbl[1] = "'" + seikname2 + "'";
		if ( pattern2 != null ) orgtbl[2] = "'" + pattern2 + "'";
		if ( expcode082 != null ) orgtbl[3] = "'" + expcode082 + "'";
		if ( expname082 != null ) orgtbl[4] = "'" + expname082 + "'";
		if ( expcode102 != null ) orgtbl[5] = "'" + expcode102 + "'";
		if ( expname102 != null ) orgtbl[6] = "'" + expname102 + "'";

		String tblnm = "【XI】経費タイプパターン";
		String jyouken = "取引先コード = '" + cd + "'"
						+ " AND 請求元 = '" + moto + "'"
						+ " AND パターン = '" + ptn + "'";

		XIDBAccess xidb = new XIDBAccess();
		xidb.update( tblnm , jyouken , fldtbl, orgtbl, vltbl);
		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = { "取引先コード" , "請求元" , "パターン" ,
						"経費タイプコード08" , "経費タイプ名称08" , "経費タイプコード10" , "経費タイプ名称10" };
		return( rc );
	}
}
