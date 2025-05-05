package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIKeihiPatternAcc
{
	public static XIKeihiPattern[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�o��^�C�v�p�^�[�� ORDER BY �����R�[�h ASC";
		XIKeihiPattern[] rc = XIKeihiPatternAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiPattern[] getByCodeName( String cd , String moto ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�o��^�C�v�p�^�[��"
						+ " WHERE �����R�[�h = '" + cd + "'"
						+ "   AND ������ = '" + moto + "'"
						+ " ORDER BY �p�^�[�� ASC";
		XIKeihiPattern[] rc = XIKeihiPatternAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiPattern[] getByKeyword( String cd , String moto , String kwd ) throws Exception
	{
		String sqltop = "SELECT * FROM �yXI�z�o��^�C�v�p�^�[��"
						+ " WHERE �����R�[�h = '" + cd + "'"
						+ "   AND ������ = '" + moto + "'";
		String sqlmid = "";
		String sqlbot =  " ORDER BY �p�^�[�� ASC";
		if ( kwd.length() > 0 ) sqlmid = "   AND �p�^�[�� LIKE '%" + kwd + "%'";
		String sqlstr = sqltop + sqlmid + sqlbot;
		XIKeihiPattern[] rc = XIKeihiPatternAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIKeihiPattern getByCdNamePtn( String cd , String moto , String ptn) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�z�o��^�C�v�p�^�[��"
						+ " WHERE �����R�[�h = '" + cd + "'"
						+ "  AND  ������ = '" + moto + "'"
						+ "  AND  �p�^�[�� = '" + ptn + "'";
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
			rec.setTorihikisakiCode( xidb.getClmn("�����R�[�h") );
			rec.setSeikyuumoto( xidb.getClmn("������") );
			rec.setExpenseTypePattern( xidb.getClmn("�p�^�[��") );
			rec.setExpenseTypeCode08( xidb.getClmn("�o��^�C�v�R�[�h08") );
			rec.setExpenseTypeName08( xidb.getClmn("�o��^�C�v����08") );
			rec.setExpenseTypeCode10( xidb.getClmn("�o��^�C�v�R�[�h10") );
			rec.setExpenseTypeName10( xidb.getClmn("�o��^�C�v����10") );
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
		String sqlstr = "SELECT * FROM �yXI�zVBB�o��p�^�[�����"
						+ " WHERE �����R�[�h = '" + cd + "'"
						+ "  AND  ������ = '" + moto + "'";
		if ( kwd != null )
		{
			if ( kwd.length() > 0 ) 	sqlstr = sqlstr +  "  AND  ���׍��� LIKE '%" + kwd + "%'";
		}
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			String[] rec = new String[7];
			rec[0] = xidb.getClmn("�����R�[�h");
			rec[1] = xidb.getClmn("������");
			rec[2] = xidb.getClmn("���o��^�C�v�R�[�h08");
			rec[3] = xidb.getClmn("���o��^�C�v����08");
			rec[4] = xidb.getClmn("���o��^�C�v�R�[�h10");
			rec[5] = xidb.getClmn("���o��^�C�v����10");
			rec[6] = xidb.getClmn("���׍���");
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
		String sqlstr = "SELECT DISTINCT �y���׏��z���׍��� FROM �yXI�zBBCsv"
						+ " WHERE �y�����ď��z������ LIKE '" + moto + "'"
						+ "   AND �y���׏��z���׍��� LIKE '" + ptn + "'";
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			String meisai = xidb.getClmn("�y���׏��z���׍���");
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
		xidb.insert( "�yXI�z�o��^�C�v�p�^�[��" , fldtbl , vltbl );
		xidb.close();
	}

	public static void delete( String cd , String moto , String ptn ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();

		String sqlstr = "DELETE FROM �yXI�z�o��^�C�v�p�^�[��"
						+ " WHERE �����R�[�h = '" + cd + "'"
						+ "  AND  ������ = '" + moto + "'"
						+ "  AND  �p�^�[�� = '" + ptn + "'";
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

		String tblnm = "�yXI�z�o��^�C�v�p�^�[��";
		String jyouken = "�����R�[�h = '" + cd + "'"
						+ " AND ������ = '" + moto + "'"
						+ " AND �p�^�[�� = '" + ptn + "'";

		XIDBAccess xidb = new XIDBAccess();
		xidb.update( tblnm , jyouken , fldtbl, orgtbl, vltbl);
		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = { "�����R�[�h" , "������" , "�p�^�[��" ,
						"�o��^�C�v�R�[�h08" , "�o��^�C�v����08" , "�o��^�C�v�R�[�h10" , "�o��^�C�v����10" };
		return( rc );
	}
}
