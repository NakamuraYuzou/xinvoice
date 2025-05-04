package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBSeikyuuMeisaiAcc
{
	public static XIBBSeikyuuMeisai[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zBB�����斾�׃}�X�^ ORDER BY ���׊Ǘ��ԍ� ASC";
		XIBBSeikyuuMeisai[] rc = XIBBSeikyuuMeisaiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBSeikyuuMeisai[] getByKenmeiKanriNo( long ken_no ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zBB�����斾�׃}�X�^"
						+ " WHERE �����Ǘ��ԍ� = " + ken_no
						+ " ORDER BY ���׊Ǘ��ԍ� ASC";
		XIBBSeikyuuMeisai[] rc = XIBBSeikyuuMeisaiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBSeikyuuMeisai getByNo( long no ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zBB�����斾�׃}�X�^"
						+ " WHERE ���׊Ǘ��ԍ� = " + no;
		XIBBSeikyuuMeisai[] recs = XIBBSeikyuuMeisaiAcc.getBySQL( sqlstr );
		XIBBSeikyuuMeisai rc = recs[0];
		return( rc );
	}

	public static XIBBSeikyuuMeisai[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIBBSeikyuuMeisai> list = new ArrayList<XIBBSeikyuuMeisai>();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIBBSeikyuuMeisai rec = new XIBBSeikyuuMeisai();
			rec.setNo( xidb.getClmnAsLong("���׊Ǘ��ԍ�") );
			rec.setKenmeiKanriNo( xidb.getClmnAsLong("�����Ǘ��ԍ�") );
			rec.setCheckPattern( xidb.getClmn("�`�F�b�N�p�^�[��") );
			rec.setMeisaiPattern( xidb.getClmn("���׃p�^�[��") );
			rec.setMeisaiKoumoku( xidb.getClmn("���׍���") );
			rec.setMeisaiBumon( xidb.getClmn("���ו��喼") );
			rec.setMeisaiBikou( xidb.getClmn("���ה��l") );
			rec.setHiyouCode( xidb.getClmn("��p�敪"));
			rec.setHiyouName( xidb.getClmn("��p�敪��"));
			rec.setKoujiCode( xidb.getClmn("�H���R�[�h") );
			rec.setKoujiSyousaiCode( xidb.getClmn("�H���ڍ׃R�[�h") );
			rec.setKoujiMeisyou( xidb.getClmn("�H����") );
			rec.setBumonCode( xidb.getClmn("����R�[�h") );
			rec.setBumonMeisyou( xidb.getClmn("���喼") );
			list.add( rec );
		}
		xidb.close();

		XIBBSeikyuuMeisai[] rc = new XIBBSeikyuuMeisai[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}


	public static void insert( XIBBSeikyuuMeisai xiseik ) throws Exception
	{
		long ken_no = xiseik.getKenmeiKanriNo();
		String chk_ptn = xiseik.getCheckPattern();
		String meisai_ptn = xiseik.getMeisaiPattern();
		String koumoku = xiseik.getMeisaiKoumoku();
		String meisai_bumon = xiseik.getMeisaiBumon();
		String bikou = xiseik.getMeisaiBikou();
		String hiyoucd = xiseik.getHiyouCode();
		String hiyounm = xiseik.getHiyouName();
		String koujicd = xiseik.getKoujiCode();
		String koujinm = xiseik.getKoujiMeisyou();
		String koujisycd = xiseik.getKoujiSyousaiCode();
		String bumoncd = xiseik.getBumonCode();
		String bumonnm = xiseik.getBumonMeisyou();

		String[] fldtbl = XIBBSeikyuuMeisaiAcc.getFieldList();
		String[] vltbl = new String[13];
		vltbl[0] = String.valueOf( ken_no );
		if ( chk_ptn != null ) vltbl[1] = "'" + chk_ptn + "'";
		if ( meisai_ptn != null ) vltbl[2] = "'" + meisai_ptn + "'";
		if ( koumoku != null ) vltbl[3] = "'" + koumoku + "'";
		if ( meisai_bumon != null ) vltbl[4] = "'" + meisai_bumon + "'";
		if ( bikou != null ) vltbl[5] = "'" + bikou + "'";
		if ( hiyoucd != null ) vltbl[6] = "'" + hiyoucd + "'";
		if ( hiyounm != null ) vltbl[7] = "'" + hiyounm + "'";
		if ( koujicd != null ) vltbl[8] = "'" + koujicd + "'";
		if ( koujisycd != null ) vltbl[9] = "'" + koujisycd + "'";
		if ( koujinm != null ) vltbl[10] = "'" + koujinm + "'";
		if ( bumoncd != null ) vltbl[11] = "'" + bumoncd + "'";
		if ( bumonnm != null ) vltbl[12] = "'" + bumonnm + "'";

		XIDBAccess xidb = new XIDBAccess();
		xidb.insert( "�yXI�zBB�����斾�׃}�X�^" , fldtbl , vltbl );
		xidb.close();
	}

	public static void delete( long no , String code ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();

		String sqlstr = "DELETE FROM �yXI�zBB�����斾�׃}�X�^"
					+ " WHERE ���׊Ǘ��ԍ� = " + no;
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCsv SET �y�ǉ����z�X�e�[�^�X = '71' ,"
				+ " �y�ǉ����z���׃p�^�[�� = null , �y�ǉ����z���׊Ǘ��ԍ� = 0"
				+ " WHERE �y�ǉ����z�X�e�[�^�X IN ( '20' , '72' )"
				+ " AND �y�ǉ����z���׊Ǘ��ԍ� = " + no;
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCsv SET �y�ǉ����z�X�e�[�^�X = '72' ,"
				+ " �y�ǉ����z���׃p�^�[�� = null , �y�ǉ����z���׊Ǘ��ԍ� = 0"
				+ " WHERE �y�ǉ����z�X�e�[�^�X = '20'"
				+ " AND �y�S�̏��z�������Ǘ��R�[�h = '" + code + "'";
		xidb.setUpdate( sqlstr );

		xidb.close();
	}

	public static void update( long no , XIBBSeikyuuMeisai xiseik1 ) throws Exception
	{
		String[] fldtbl = XIBBSeikyuuMeisaiAcc.getFieldList2();

		String[] vltbl = new String[7];
		String hiyoucd1 = xiseik1.getHiyouCode();
		String hiyounm1 = xiseik1.getHiyouName();
		String koujicd1 = xiseik1.getKoujiCode();
		String koujisycd1 = xiseik1.getKoujiSyousaiCode();
		String koujinm1 = xiseik1.getKoujiMeisyou();
		String bumoncd1 = xiseik1.getBumonCode();
		String bumonnm1 = xiseik1.getBumonMeisyou();
		if ( hiyoucd1 != null ) vltbl[0] = "'" + hiyoucd1 + "'";
		if ( hiyounm1 != null ) vltbl[1] = "'" + hiyounm1 + "'";
		if ( koujicd1 != null ) vltbl[2] = "'" + koujicd1 + "'";
		if ( koujisycd1 != null ) vltbl[3] = "'" + koujisycd1 + "'";
		if ( koujinm1 != null ) vltbl[4] = "'" + koujinm1 + "'";
		if ( bumoncd1 != null ) vltbl[5] = "'" + bumoncd1 + "'";
		if ( bumonnm1 != null ) vltbl[6] = "'" + bumonnm1 + "'";

		XIBBSeikyuuMeisai xiseik2 = XIBBSeikyuuMeisaiAcc.getByNo( no );
		String[] orgtbl = new String[7];
		String hiyoucd2 = xiseik2.getHiyouCode();
		String hiyounm2 = xiseik2.getHiyouName();
		String koujicd2 = xiseik2.getKoujiCode();
		String koujisycd2 = xiseik2.getKoujiSyousaiCode();
		String koujinm2 = xiseik2.getKoujiMeisyou();
		String bumoncd2 = xiseik2.getBumonCode();
		String bumonnm2 = xiseik2.getBumonMeisyou();
		if ( hiyoucd2 != null ) orgtbl[0] = "'" + hiyoucd2 + "'";
		if ( hiyounm2 != null ) orgtbl[1] = "'" + hiyounm2 + "'";
		if ( koujicd2 != null ) orgtbl[2] = "'" + koujicd2 + "'";
		if ( koujisycd2 != null ) orgtbl[3] = "'" + koujisycd2 + "'";
		if ( koujinm2 != null ) orgtbl[4] = "'" + koujinm2 + "'";
		if ( bumoncd2 != null ) orgtbl[5] = "'" + bumoncd2 + "'";
		if ( bumonnm2 != null ) orgtbl[6] = "'" + bumonnm2 + "'";

		String tblnm = "�yXI�zBB�����斾�׃}�X�^";
		String jyouken = "���׊Ǘ��ԍ� = " + no;

		XIDBAccess xidb = new XIDBAccess();
		xidb.update( tblnm , jyouken , fldtbl, orgtbl, vltbl);
		xidb.close();
	}

	public static void setLastMatchDate( long no ) throws Exception
	{
		String sqlstr = "UPDATE �yXI�zBB�����斾�׃}�X�^"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP WHERE ���׊Ǘ��ԍ� = " + no;
		XIDBAccess xidb = new XIDBAccess();
		xidb.setUpdate( sqlstr );;
		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = { "�����Ǘ��ԍ�" , "�`�F�b�N�p�^�[��" , "���׃p�^�[��" , "���׍���" ,
						"���ו��喼" , "���ה��l" , "��p�敪" , "��p�敪��" ,
						"�H���R�[�h" , "�H���ڍ׃R�[�h" , "�H����" ,
						"����R�[�h" , "���喼" };
		return( rc );
	}

	public static String[] getFieldList2()
	{
		String[] rc = { "��p�敪" , "��p�敪��" ,	"�H���R�[�h" , "�H���ڍ׃R�[�h" ,
						"�H����" ,	"����R�[�h" , "���喼" };
		return( rc );
	}
}
