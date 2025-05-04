package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBSeikyuusakiAcc
{
	public static XIBBSeikyuusaki[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zBB�����挏���}�X�^ ORDER BY ������ ASC";
		XIBBSeikyuusaki[] rc = XIBBSeikyuusakiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBSeikyuusaki[] getByKeyword( String base , String kwd1 , String kwd2 , String kwd3 ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zBB�����挏���}�X�^";
		String wherestr = " WHERE ( " + base + " )";
		if ( kwd1 != null )
		{
			if ( kwd1.length() > 0 )
			{
				wherestr = wherestr + " AND ( ������ LIKE '%" + kwd1 + "%'"
											+ " OR ������ LIKE '%" + kwd1 + "%'"
											+ " OR ���� LIKE '%" + kwd1 + "%'"
											+ " OR �H���� LIKE '%" + kwd1 + "%'"
											+ " OR �N�[�҃��A�h LIKE '%" + kwd1 + "%'"
											+ " OR �N�[�Җ� LIKE '%" + kwd1 + "%'"
											+ " OR ���喼 LIKE '%" + kwd1 + "%' )";
			}
		}
		if ( kwd2 != null )
		{
			if ( kwd2.length() > 0 )
			{
				wherestr = wherestr + " AND ( ������ LIKE '%" + kwd2 + "%'"
											+ " OR ������ LIKE '%" + kwd2 + "%'"
											+ " OR ���� LIKE '%" + kwd2 + "%'"
											+ " OR �H���� LIKE '%" + kwd2 + "%'"
											+ " OR �N�[�҃��A�h LIKE '%" + kwd2 + "%'"
											+ " OR �N�[�Җ� LIKE '%" + kwd2 + "%'"
											+ " OR ���喼 LIKE '%" + kwd2 + "%' )";
			}
		}
		if ( kwd3 != null )
		{
			if ( kwd3.length() > 0 )
			{
				wherestr = wherestr + " AND ( ������ LIKE '%" + kwd3 + "%'"
											+ " OR ������ LIKE '%" + kwd3 + "%'"
											+ " OR ���� LIKE '%" + kwd3 + "%'"
											+ " OR �H���� LIKE '%" + kwd3 + "%'"
											+ " OR �N�[�҃��A�h LIKE '%" + kwd3 + "%'"
											+ " OR �N�[�Җ� LIKE '%" + kwd3 + "%'"
											+ " OR ���喼 LIKE '%" + kwd3 + "%' )";
			}
		}

		sqlstr = sqlstr + wherestr + " ORDER BY ������ ASC";
		XIBBSeikyuusaki[] rc = XIBBSeikyuusakiAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBSeikyuusaki getByNo( long no ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zBB�����挏���}�X�^"
						+ " WHERE �����Ǘ��ԍ� = " + no;
		XIBBSeikyuusaki[] recs = XIBBSeikyuusakiAcc.getBySQL( sqlstr );
		XIBBSeikyuusaki rc = recs[0];
		return( rc );
	}

	public static XIBBSeikyuusaki[] getBySQL( String sqlstr ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		List<XIBBSeikyuusaki> list = new ArrayList<XIBBSeikyuusaki>();
		xidb.setSQL( sqlstr );
		while( xidb.getRow() )
		{
			XIBBSeikyuusaki rec = new XIBBSeikyuusaki();
			rec.setNo( xidb.getClmnAsLong("�����Ǘ��ԍ�") );
			rec.setCheckPattern( xidb.getClmn("�`�F�b�N�p�^�[��") );
			rec.setHiyouCode( xidb.getClmn("��p�敪"));
			rec.setHiyouName( xidb.getClmn("��p�敪��"));
			rec.setKoujiCode( xidb.getClmn("�H���R�[�h") );
			rec.setKoujiSyousaiCode( xidb.getClmn("�H���ڍ׃R�[�h") );
			rec.setKoujiMeisyou( xidb.getClmn("�H����") );
			rec.setBumonCode( xidb.getClmn("����R�[�h") );
			rec.setBumonMeisyou( xidb.getClmn("���喼") );
			rec.setKihyou( xidb.getClmn("�N�[�҃��A�h") );
			rec.setKihyouName( xidb.getClmn("�N�[�Җ�") );
			rec.setSeikyuuMoto( xidb.getClmn("������") );
			rec.setSeikyuuSaki( xidb.getClmn("������") );
			rec.setKenmei( xidb.getClmn("����") );
			rec.setLastMatchDate( xidb.getClmnAsDate("�ŏI�}�b�`��") );
			list.add( rec );
		}
		xidb.close();

		XIBBSeikyuusaki[] rc = new XIBBSeikyuusaki[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get( i );
		}
		return( rc );
	}


	public static void insert( XIBBSeikyuusaki xiseik ) throws Exception
	{
		String chk_ptn = xiseik.getCheckPattern();
		String seikmoto = xiseik.getSeikyuuMoto();
		String seiksaki = xiseik.getSeikyuuSaki();
		String kenmei = xiseik.getKenmei();
		String hiyoucd = xiseik.getHiyouCode();
		String hiyounm = xiseik.getHiyouName();
		String koujicd = xiseik.getKoujiCode();
		String koujinm = xiseik.getKoujiMeisyou();
		String koujisycd = xiseik.getKoujiSyousaiCode();
		String bumoncd = xiseik.getBumonCode();
		String bumonnm = xiseik.getBumonMeisyou();
		String kihyou = xiseik.getKihyou();
		String kihyounm = xiseik.getKihyouName();

		String[] fldtbl = XIBBSeikyuusakiAcc.getFieldList();
		String[] vltbl = new String[13];
		if ( chk_ptn != null ) vltbl[0] = "'" + chk_ptn + "'";
		if ( seikmoto != null ) vltbl[1] = "'" + seikmoto + "'";
		if ( seiksaki != null ) vltbl[2] = "'" + seiksaki + "'";
		if ( kenmei != null ) vltbl[3] = "'" + kenmei + "'";
		if ( hiyoucd != null ) vltbl[4] = "'" + hiyoucd + "'";
		if ( hiyounm != null ) vltbl[5] = "'" + hiyounm + "'";
		if ( koujicd != null ) vltbl[6] = "'" + koujicd + "'";
		if ( koujisycd != null ) vltbl[7] = "'" + koujisycd + "'";
		if ( koujinm != null ) vltbl[8] = "'" + koujinm + "'";
		if ( bumoncd != null ) vltbl[9] = "'" + bumoncd + "'";
		if ( bumonnm != null ) vltbl[10] = "'" + bumonnm + "'";
		if ( kihyou != null ) vltbl[11] = "'" + kihyou + "'";
		if ( kihyounm != null ) vltbl[12] = "'" + kihyounm + "'";

		XIDBAccess xidb = new XIDBAccess();
		xidb.insert( "�yXI�zBB�����挏���}�X�^" , fldtbl , vltbl );
		xidb.close();
	}

	public static void delete( long no ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();

		String sqlstr = "DELETE FROM �yXI�zBB�����挏���}�X�^"
					+ " WHERE �����Ǘ��ԍ� = " + no;
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCsv SET �y�ǉ����z�X�e�[�^�X = '70' ,"
				+ " �y�ǉ����z�`�F�b�N�p�^�[�� = null , �y�ǉ����z�����Ǘ��ԍ� = 0"
				+ " WHERE �y�ǉ����z�X�e�[�^�X = '20' AND �y�ǉ����z�����Ǘ��ԍ� = " + no;
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCsv SET �y�ǉ����z�X�e�[�^�X = '70' ,"
				+ " �y�ǉ����z�`�F�b�N�p�^�[�� = null , �y�ǉ����z�����Ǘ��ԍ� = 0"
				+ " WHERE �y�ǉ����z�X�e�[�^�X IN ( '71' , '72' ) AND �y�ǉ����z�����Ǘ��ԍ� = " + no;
		xidb.setUpdate( sqlstr );

		sqlstr = "DELETE FROM �yXI�zBB�����斾�׃}�X�^"
				+ " WHERE �����Ǘ��ԍ� = " + no;
		xidb.setUpdate( sqlstr );

		xidb.close();
	}

	public static void update( long no , XIBBSeikyuusaki xiseik1 ) throws Exception
	{
		String[] fldtbl = XIBBSeikyuusakiAcc.getFieldList2();

		String[] vltbl = new String[9];
		String hiyoucd1 = xiseik1.getHiyouCode();
		String hiyounm1 = xiseik1.getHiyouName();
		String koujicd1 = xiseik1.getKoujiCode();
		String koujisycd1 = xiseik1.getKoujiSyousaiCode();
		String koujinm1 = xiseik1.getKoujiMeisyou();
		String bumoncd1 = xiseik1.getBumonCode();
		String bumonnm1 = xiseik1.getBumonMeisyou();
		String kihyou1 = xiseik1.getKihyou();
		String kihyounm1 = xiseik1.getKihyouName();
		if ( hiyoucd1 != null ) vltbl[0] = "'" + hiyoucd1 + "'";
		if ( hiyounm1 != null ) vltbl[1] = "'" + hiyounm1 + "'";
		if ( koujicd1 != null ) vltbl[2] = "'" + koujicd1 + "'";
		if ( koujisycd1 != null ) vltbl[3] = "'" + koujisycd1 + "'";
		if ( koujinm1 != null ) vltbl[4] = "'" + koujinm1 + "'";
		if ( bumoncd1 != null ) vltbl[5] = "'" + bumoncd1 + "'";
		if ( bumonnm1 != null ) vltbl[6] = "'" + bumonnm1 + "'";
		if ( kihyou1 != null ) vltbl[7] = "'" + kihyou1 + "'";
		if ( kihyounm1 != null ) vltbl[8] = "'" + kihyounm1 + "'";

		XIBBSeikyuusaki xiseik2 = XIBBSeikyuusakiAcc.getByNo( no );
		String[] orgtbl = new String[9];
		String hiyoucd2 = xiseik2.getHiyouCode();
		String hiyounm2 = xiseik2.getHiyouName();
		String koujicd2 = xiseik2.getKoujiCode();
		String koujisycd2 = xiseik2.getKoujiSyousaiCode();
		String koujinm2 = xiseik2.getKoujiMeisyou();
		String bumoncd2 = xiseik2.getBumonCode();
		String bumonnm2 = xiseik2.getBumonMeisyou();
		String kihyou2 = xiseik2.getKihyou();
		String kihyounm2 = xiseik2.getKihyouName();
		if ( hiyoucd2 != null ) orgtbl[0] = "'" + hiyoucd2 + "'";
		if ( hiyounm2 != null ) orgtbl[1] = "'" + hiyounm2 + "'";
		if ( koujicd2 != null ) orgtbl[2] = "'" + koujicd2 + "'";
		if ( koujisycd2 != null ) orgtbl[3] = "'" + koujisycd2 + "'";
		if ( koujinm2 != null ) orgtbl[4] = "'" + koujinm2 + "'";
		if ( bumoncd2 != null ) orgtbl[5] = "'" + bumoncd2 + "'";
		if ( bumonnm2 != null ) orgtbl[6] = "'" + bumonnm2 + "'";
		if ( kihyou2 != null ) orgtbl[7] = "'" + kihyou2 + "'";
		if ( kihyounm2 != null ) orgtbl[8] = "'" + kihyounm2 + "'";

		String tblnm = "�yXI�zBB�����挏���}�X�^";
		String jyouken = "�����Ǘ��ԍ� = " + no;

		XIDBAccess xidb = new XIDBAccess();
		xidb.update( tblnm , jyouken , fldtbl, orgtbl, vltbl);
		xidb.close();
	}

	public static String[] getFieldList()
	{
		String[] rc = {  "�`�F�b�N�p�^�[��" , "������" , "������" , "����" ,
						 "��p�敪" , "��p�敪��" , "�H���R�[�h" , "�H���ڍ׃R�[�h" , "�H����" ,
						 "����R�[�h" , "���喼" , "�N�[�҃��A�h" , "�N�[�Җ�" };
		return( rc );
	}


	public static String[] getFieldList2()
	{
		String[] rc = {  "��p�敪" , "��p�敪��" , "�H���R�[�h" , "�H���ڍ׃R�[�h" , "�H����" ,
						 "����R�[�h" ,"���喼" , "�N�[�҃��A�h" , "�N�[�Җ�" };
		return( rc );
	}
}
