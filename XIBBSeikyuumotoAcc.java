package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBSeikyuumotoAcc
{
	public static XIBBSeikyuumoto[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】BB請求元マスタ ORDER BY 取引先コード ASC";
		XIBBSeikyuumoto[] rc = XIBBSeikyuumotoAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBSeikyuumoto getByCdName( String cd , String nm ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】BB請求元マスタ"
						+ " WHERE 取引先コード = '" + cd + "'"
						+ "  AND  請求元 = '" + nm + "'";
		XIBBSeikyuumoto[] recs = XIBBSeikyuumotoAcc.getBySQL( sqlstr );
		XIBBSeikyuumoto rc = recs[0];
		return( rc );
	}

	public static XIBBSeikyuumoto[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIBBSeikyuumoto> list = new ArrayList<XIBBSeikyuumoto>();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIBBSeikyuumoto rec = new XIBBSeikyuumoto();
			rec.setTorihikisakiCode( xidb.getClmn("取引先コード") );
			rec.setSeikyuumotoName( xidb.getClmn("請求元") );
			rec.setExpenseTypeCode08( xidb.getClmn("経費タイプコード08") );
			rec.setExpenseTypeName08( xidb.getClmn("経費タイプ名称08") );
			rec.setExpenseTypeCode10( xidb.getClmn("経費タイプコード10") );
			rec.setExpenseTypeName10( xidb.getClmn("経費タイプ名称10") );
			list.add( rec );
		}
		xidb.close();

		XIBBSeikyuumoto[] rc = new XIBBSeikyuumoto[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}

	public static void insert( XIBBSeikyuumoto xiseik ) throws Exception
	{
		String toricode = xiseik.getTorihikisakiCode();
		String seikname = xiseik.getSeikyuumotoName();
		String expcode08 = xiseik.getExpenseTypeCode08();
		String expname08 = xiseik.getExpenseTypeName08();
		String expcode10 = xiseik.getExpenseTypeCode10();
		String expname10 = xiseik.getExpenseTypeName10();

		String[] fldtbl = XIBBSeikyuumotoAcc.getFieldList();
		String[] vltbl = new String[6];
		if ( toricode != null ) vltbl[0] = "'" + toricode + "'";
		if ( seikname != null ) vltbl[1] = "'" + seikname + "'";
		if ( expcode08 != null ) vltbl[2] = "'" + expcode08 + "'";
		if ( expname08 != null ) vltbl[3] = "'" + expname08 + "'";
		if ( expcode10 != null ) vltbl[4] = "'" + expcode10 + "'";
		if ( expname10 != null ) vltbl[5] = "'" + expname10 + "'";

		XIDBAccess xidb = new XIDBAccess();
		xidb.insert( "【XI】BB請求元マスタ" , fldtbl , vltbl );
		xidb.close();
	}

	public static void delete( String cd , String nm ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();

		String sqlstr = "DELETE FROM 【XI】BB請求元マスタ"
						+ " WHERE 取引先コード = '" + cd + "'"
						+ "  AND  請求元 = '" + nm + "'";
		xidb.setUpdate( sqlstr );

		xidb.close();
	}

	public static void update( String cd , String nm , XIBBSeikyuumoto xiseik1 ) throws Exception
	{
		String[] fldtbl = XIBBSeikyuumotoAcc.getFieldList();

		String[] vltbl = new String[6];
		String toricode1 = xiseik1.getTorihikisakiCode();
		String seikname1 = xiseik1.getSeikyuumotoName();
		String expcode081 = xiseik1.getExpenseTypeCode08();
		String expname081 = xiseik1.getExpenseTypeName08();
		String expcode101 = xiseik1.getExpenseTypeCode10();
		String expname101 = xiseik1.getExpenseTypeName10();
		if ( toricode1 != null ) vltbl[0] = "'" + toricode1 + "'";
		if ( seikname1 != null ) vltbl[1] = "'" + seikname1 + "'";
		if ( expcode081 != null ) vltbl[2] = "'" + expcode081 + "'";
		if ( expname081 != null ) vltbl[3] = "'" + expname081 + "'";
		if ( expcode101 != null ) vltbl[4] = "'" + expcode101 + "'";
		if ( expname101 != null ) vltbl[5] = "'" + expname101 + "'";

		XIBBSeikyuumoto xiseik2 = XIBBSeikyuumotoAcc.getByCdName( cd , nm );
		String[] orgtbl = new String[6];
		String toricode2 = xiseik2.getTorihikisakiCode();
		String seikname2 = xiseik2.getSeikyuumotoName();
		String expcode082 = xiseik2.getExpenseTypeCode08();
		String expname082 = xiseik2.getExpenseTypeName08();
		String expcode102 = xiseik2.getExpenseTypeCode10();
		String expname102 = xiseik2.getExpenseTypeName10();
		if ( toricode2 != null ) orgtbl[0] = "'" + toricode2 + "'";
		if ( seikname2 != null ) orgtbl[1] = "'" + seikname2 + "'";
		if ( expcode082 != null ) orgtbl[2] = "'" + expcode082 + "'";
		if ( expname082 != null ) orgtbl[3] = "'" + expname082 + "'";
		if ( expcode102 != null ) orgtbl[4] = "'" + expcode102 + "'";
		if ( expname102 != null ) orgtbl[5] = "'" + expname102 + "'";

		String tblnm = "【XI】BB請求元マスタ";
		String jyouken = "取引先コード = '" + cd + "' AND 請求元 = '" + nm + "'";

		XIDBAccess xidb = new XIDBAccess();
		xidb.update( tblnm , jyouken , fldtbl, orgtbl, vltbl);
		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = { "取引先コード" , "請求元" ,
						"経費タイプコード08" , "経費タイプ名称08" , "経費タイプコード10" , "経費タイプ名称10" };
		return( rc );
	}
}
