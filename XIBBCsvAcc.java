package xinvoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XIBBCsvAcc
{
	public static XIBBCsv[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zBBCSV";
		XIBBCsv[] rc = XIBBCsvAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBCsv[] getByKanriCode( String code ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zBBCSV WHERE �y�S�̏��z�������Ǘ��R�[�h = '" + code + "'";
		XIBBCsv[] rc = XIBBCsvAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBCsv[] getBySQL( String sqlstr ) throws Exception
	{
		List<XIBBCsv> tbllst = new ArrayList<XIBBCsv>();
		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );

		while( xidb.getRow() )
		{
			XIBBCsv rec = new XIBBCsv();
			rec.setOrderDate( xidb.getClmnAsDate("�y�S�̏��z�˗���") );
			rec.setRemindDate( xidb.getClmnAsDate("�y�S�̏��z�Ñ���") );
			rec.setInvoiceMngNum( xidb.getClmnAsLong("�y�S�̏��z�������Ǘ��R�[�h") );
			rec.setSendDate( xidb.getClmnAsDate("�y�����ď��z���������s��") );
			rec.setCloseDate( xidb.getClmnAsDate("�y�����ď��z����") );
			rec.setPayDueDateS( xidb.getClmnAsDate("�y�����ď��z�x������") );
			rec.setPayDueDate( xidb.getClmnAsDate("�y�����ď��z���Ўx������") );
			rec.setCustomerCode1( xidb.getClmn("�y�����ď��z�ڋq�R�[�h�P") );
			rec.setCustomerCode2( xidb.getClmn("�y�����ď��z�ڋq�R�[�h�Q") );
			rec.setPrivateCustCdS( xidb.getClmn("�y�����ď��z�x����R�[�h") );
			rec.setPrivateCustCdB( xidb.getClmn("�y�����ď��z���s��R�[�h") );
			rec.setDestinationCode( xidb.getClmn("�y�����ď��z����R�[�h") );
			rec.setDestinationName( xidb.getClmn("�y�����ď��z���於") );
			rec.setInvNo( xidb.getClmn("�y�����ď��z�������ԍ�") );
			rec.setInvName( xidb.getClmn("�y�����ď��z����") );
			rec.setInvWithoutTax( xidb.getClmnAsLong("�y�����ď��z���񐿋����z���Ŕ�") );
			rec.setInvTax( xidb.getClmnAsLong("�y�����ď��z�������Ŋz") );
			rec.setInvAmount( xidb.getClmnAsLong("�y�����ď��z���񐿋����z���ō�") );
			rec.setInvShowAmount( xidb.getClmnAsLong("�y�����ď��z�����Ă̐������z") );
			rec.setRemarks( xidb.getClmn("�y�����ď��z���l") );
			rec.setInvFreeTxtTitle1( xidb.getClmn("�y�����ď��z������A1�^�C�g��") );
			rec.setInvFreeTxt1( xidb.getClmn("�y�����ď��z������A1�f�[�^") );
			rec.setInvFreeTxtTitle2( xidb.getClmn("�y�����ď��z������A2�^�C�g��") );
			rec.setInvFreeTxt2( xidb.getClmn("�y�����ď��z������A2�f�[�^") );
			rec.setInvFreeTxtTitle3( xidb.getClmn("�y�����ď��z������A3�^�C�g��") );
			rec.setInvFreeTxt3( xidb.getClmn("�y�����ď��z������A3�f�[�^") );
			rec.setInvFreeNumTitle1( xidb.getClmn("�y�����ď��z������B1�^�C�g��") );
			rec.setInvFreeTxt4( xidb.getClmnAsLong("�y�����ď��z������B1�f�[�^") );
			rec.setInvFreeNumTitle2( xidb.getClmn("�y�����ď��z������B2�^�C�g��") );
			rec.setInvFreeTxt5( xidb.getClmnAsLong("�y�����ď��z������B2�f�[�^") );
			rec.setInvFreeNumTitle3( xidb.getClmn("�y�����ď��z������B3�^�C�g��") );
			rec.setInvFreeTxt6( xidb.getClmnAsLong("�y�����ď��z������B3�f�[�^") );
			rec.setInvFreeNumTitle4( xidb.getClmn("�y�����ď��z������B4�^�C�g��") );
			rec.setInvFreeTxt7( xidb.getClmnAsLong("�y�����ď��z������B4�f�[�^") );
			rec.setInvFreeNumTitle5( xidb.getClmn("�y�����ď��z������B5�^�C�g��") );
			rec.setInvFreeNumTitle6( xidb.getClmn("�y�����ď��z������B6�^�C�g��") );
			rec.setInvFreeNumTitle7( xidb.getClmn("�y�����ď��z������B7�^�C�g��") );
			rec.setInvOpFreeTxtTitle1( xidb.getClmn("�y�����ď��z�ǉ����R���ڂP�^�C�g��") );
			rec.setInvOpFreeTxt1( xidb.getClmn("�y�����ď��z�ǉ����R���ڂP") );
			rec.setInvOpFreeTxtTitle2( xidb.getClmn("�y�����ď��z�ǉ����R���ڂQ�^�C�g��") );
			rec.setInvOpFreeTxt2( xidb.getClmn("�y�����ď��z�ǉ����R���ڂQ") );
			rec.setInvOpFreeTxtTitle3( xidb.getClmn("�y�����ď��z�ǉ����R���ڂR�^�C�g��") );
			rec.setInvOpFreeTxt3( xidb.getClmn("�y�����ď��z�ǉ����R���ڂR") );
			rec.setInvOpFreeTxtTitle4( xidb.getClmn("�y�����ď��z�ǉ����R���ڂS�^�C�g��") );
			rec.setInvOpFreeTxt4( xidb.getClmn("�y�����ď��z�ǉ����R���ڂS") );
			rec.setInvOpFreeTxtTitle5( xidb.getClmn("�y�����ď��z�ǉ����R���ڂT�^�C�g��") );
			rec.setInvOpFreeTxt5( xidb.getClmn("�y�����ď��z�ǉ����R���ڂT") );
			rec.setInvOpFreeTxtTitle6( xidb.getClmn("�y�����ď��z�ǉ����R���ڂU�^�C�g��") );
			rec.setInvOpFreeTxt6( xidb.getClmn("�y�����ď��z�ǉ����R���ڂU") );
			rec.setInvOpFreeTxtTitle7( xidb.getClmn("�y�����ď��z�ǉ����R���ڂV�^�C�g��") );
			rec.setInvOpFreeTxt7( xidb.getClmn("�y�����ď��z�ǉ����R���ڂV") );
			rec.setInvOpFreeTxtTitle8( xidb.getClmn("�y�����ď��z�ǉ����R���ڂW�^�C�g��") );
			rec.setInvOpFreeTxt8( xidb.getClmn("�y�����ď��z�ǉ����R���ڂW") );
			rec.setInvOpFreeTxtTitle9( xidb.getClmn("�y�����ď��z�ǉ����R���ڂX�^�C�g��") );
			rec.setInvOpFreeTxt9( xidb.getClmn("�y�����ď��z�ǉ����R���ڂX") );
			rec.setInvOpFreeTxtTitle10( xidb.getClmn("�y�����ď��z�ǉ����R���ڂP�O�^�C�g��") );
			rec.setInvOpFreeTxt10( xidb.getClmn("�y�����ď��z�ǉ����R���ڂP�O") );
			rec.setInvOpFreeTxtTitle11( xidb.getClmn("�y�����ď��z�ǉ����R���ڂP�P�^�C�g��") );
			rec.setInvOpFreeTxt11( xidb.getClmn("�y�����ď��z�ǉ����R���ڂP�P") );
			rec.setInvOpFreeTxtTitle12( xidb.getClmn("�y�����ď��z�ǉ����R���ڂP�Q�^�C�g��") );
			rec.setInvOpFreeTxt12( xidb.getClmn("�y�����ď��z�ǉ����R���ڂP�Q") );
			rec.setItemSlipDate( xidb.getClmn("�y���׏��z���ד��t") );
			rec.setItemSlipNo( xidb.getClmn("�y���׏��z���הԍ�") );
			rec.setItemProdCode( xidb.getClmn("�y���׏��z���i�R�[�h") );
			rec.setItemPrice( xidb.getClmnAsLong("�y���׏��z�P��") );
			rec.setItemUnit( xidb.getClmn("�y���׏��z�P��") );
			rec.setItemQty( xidb.getClmnAsLong("�y���׏��z����") );
			rec.setTaxFree( xidb.getClmn("�y���׏��z�ŋ敪") );
			rec.setTaxRate( xidb.getClmn("�y���׏��z�ŗ�") );
			rec.setItemWithoutTax( xidb.getClmnAsLong("�y���׏��z���z") );
			rec.setItemTax( xidb.getClmnAsLong("�y���׏��z����Ŋz") );
			rec.setItemAmount( xidb.getClmnAsLong("�y���׏��z�������z") );
			rec.setItemSecCode( xidb.getClmn("�y���׏��z����R�[�h") );
			rec.setItemSecName( xidb.getClmn("�y���׏��z���喼") );
			rec.setDetailRemarks( xidb.getClmn("�y���׏��z���ה��l") );
			rec.setItemFreeTxtTitle1( xidb.getClmn("�y���׏��z����01�^�C�g��") );
			rec.setItemFreeTxt1( xidb.getClmn("�y���׏��z����01�f�[�^") );
			rec.setItemFreeTxtTitle2( xidb.getClmn("�y���׏��z����02�^�C�g��") );
			rec.setItemFreeTxt2( xidb.getClmn("�y���׏��z����02�f�[�^") );
			rec.setItemFreeTxtTitle3( xidb.getClmn("�y���׏��z����03�^�C�g��") );
			rec.setItemFreeTxt3( xidb.getClmn("�y���׏��z����03�f�[�^") );
			rec.setItemFreeTxtTitle4( xidb.getClmn("�y���׏��z����04�^�C�g��") );
			rec.setItemFreeTxt4( xidb.getClmn("�y���׏��z����04�f�[�^") );
			rec.setItemFreeTxtTitle5( xidb.getClmn("�y���׏��z����05�^�C�g��") );
			rec.setItemFreeTxt5( xidb.getClmn("�y���׏��z����05�f�[�^") );
			rec.setItemFreeTxtTitle6( xidb.getClmn("�y���׏��z����06�^�C�g��") );
			rec.setItemFreeTxt6( xidb.getClmn("�y���׏��z����06�f�[�^") );
			rec.setItemFreeTxtTitle7( xidb.getClmn("�y���׏��z����07�^�C�g��") );
			rec.setItemFreeTxt7( xidb.getClmn("�y���׏��z����07�f�[�^") );
			rec.setItemFreeTxtTitle8( xidb.getClmn("�y���׏��z����08�^�C�g��") );
			rec.setItemFreeTxt8( xidb.getClmn("�y���׏��z����08�f�[�^") );
			rec.setItemFreeTxtTitle9( xidb.getClmn("�y���׏��z����09�^�C�g��") );
			rec.setItemFreeTxt9( xidb.getClmn("�y���׏��z����09�f�[�^") );
			rec.setItemFreeTxtTitle10( xidb.getClmn("�y���׏��z����10�^�C�g��") );
			rec.setItemFreeTxt10( xidb.getClmn("�y���׏��z����10�f�[�^") );
			rec.setItemFreeTxtLTitle( xidb.getClmn("�y���׏��z����11�^�C�g��") );
			rec.setItemFreeTxtL( xidb.getClmn("�y���׏��z����11�f�[�^") );
			rec.setItemMemo1( xidb.getClmn("�y���׏��z����1") );
			rec.setItemMemo2( xidb.getClmn("�y���׏��z����2") );
			rec.setDetailSummary( xidb.getClmn("�y�d����z�E�v") );
			rec.setDetailSeq( xidb.getClmnAsInt("�y���׏��z���טA��") );
			rec.setStatus( xidb.getClmn("�y�ǉ����z�X�e�[�^�X") );
			rec.setCheckPattern( xidb.getClmn("�y�ǉ����z�`�F�b�N�p�^�[��") );
			rec.setMeisaiPattern( xidb.getClmn("�y�ǉ����z���׃p�^�[��") );
			rec.setKenmeiNo( xidb.getClmnAsLong("�y�ǉ����z�����Ǘ��ԍ�") );
			rec.setKenmeiNo( xidb.getClmnAsLong("�y�ǉ����z���׊Ǘ��ԍ�") );
			rec.setRirekiNo( xidb.getClmnAsInt("�y�ǉ����z����ԍ�") );

			tbllst.add( rec );
		}

		xidb.close();
		XIBBCsv[] rc = new XIBBCsv[ tbllst.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = tbllst.get( i );
		}

		return( rc );
	}

	public static void checkAitesaki() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBBCSV SET �y�ǉ����z�X�e�[�^�X = '60'"
						+ " WHERE �y�ǉ����z�X�e�[�^�X = '10'"
						+ "   AND �y�����ď��z������ IN ( SELECT ������ FROM �yXI�zVBB�������s�� )";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckAitesaki() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBBCSV SET �y�ǉ����z�X�e�[�^�X = '10'"
						+ " WHERE �y�ǉ����z�X�e�[�^�X = '60'"
						+ "   AND �y�����ď��z������ IN ( SELECT ������ FROM �yXI�zBB�������}�X�^ )";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmei() throws Exception
	{
		XIBBCsvAcc.checkKenmeiA();
		XIBBCsvAcc.checkKenmeiB();
		XIBBCsvAcc.checkKenmeiC();
		XIBBCsvAcc.checkKenmeiJ();
		XIBBCsvAcc.checkKenmeiK();
		XIBBCsvAcc.checkKenmeiL();

		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBBCSV SET �y�ǉ����z�X�e�[�^�X = '70'"
						+ " WHERE �y�ǉ����z�X�e�[�^�X = '10'"
						+ " AND �y�ǉ����z�`�F�b�N�p�^�[�� != 'A'"
						+ " AND �y�ǉ����z�`�F�b�N�p�^�[�� != 'B'"
						+ " AND �y�ǉ����z�`�F�b�N�p�^�[�� != 'C'";
		xidb.setUpdate( sqlstr );
		xidb.close();

		XIBBCsvAcc.reCheckKenmeiJ();
		XIBBCsvAcc.reCheckKenmeiK();
		XIBBCsvAcc.reCheckKenmeiL();
		XIBBCsvAcc.checkMeisaiP();
		XIBBCsvAcc.checkMeisaiQ();
		XIBBCsvAcc.checkMeisai();
	}

	public static void checkKenmeiA() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z���� = B.����"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'A'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'A' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '20'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z���� = B.����"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'A'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiA() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z���� = B.����"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'A'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'A' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '20'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z���� = B.����"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'A'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiB() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z���� LIKE B.����"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'B'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'B' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '20'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z���� LIKE B.����"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'B'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiB() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z���� LIKE B.����"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'B'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'B' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '20'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z���� LIKE CONCAT( B.���� , '%' )"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'B'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiC() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'C'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'C' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '20'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'C'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiC() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'C'";
		xidb.setUpdate( sqlstr );
		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'C' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '20'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'C'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiJ() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z���� = B.����"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'J'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'J' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '71'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z���� = B.����"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'J'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiJ() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z���� = B.����"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'J'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'J' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '71'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z���� = B.����"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'J'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiK() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z���� LIKE B.����"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'K'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'K' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '71'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z���� LIKE B.����"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'K'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiK() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z���� LIKE B.����"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'K'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'K' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '71'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z���� LIKE B.����"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'K'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiL() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'L'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'L' ,"
						+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
						+ " �y�ǉ����z�X�e�[�^�X = '71'"
						+ " FROM �yXI�zBB�����挏���}�X�^ B"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '10'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'L'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiL() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����挏���}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  A.�y�����ď��z������ = B.������"
						+ "  AND  B.�`�F�b�N�p�^�[�� = 'L'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z�`�F�b�N�p�^�[�� = 'L' ,"
				+ " �y�ǉ����z�����Ǘ��ԍ� = B.�����Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '71'"
				+ " FROM �yXI�zBB�����挏���}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '70'"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  A.�y�����ď��z������ = B.������"
				+ "  AND  B.�`�F�b�N�p�^�[�� = 'L'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkMeisaiP() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����斾�׃}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '71'"
						+ "  AND  A.�y���׏��z���׍��� = B.���׍���"
						+ "  AND  A.�y���׏��z���喼 = B.���ו��喼"
						+ "  AND  B.���׃p�^�[�� = 'P'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z���׃p�^�[�� = 'P' ,"
				+ " �y�ǉ����z���׊Ǘ��ԍ� = B.���׊Ǘ��ԍ� ,"
				+ " �y�ǉ����z�X�e�[�^�X = '72'"
				+ " FROM �yXI�zBB�����斾�׃}�X�^ B"
				+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '71'"
				+ "  AND  A.�y���׏��z���׍��� = B.���׍���"
				+ "  AND  A.�y���׏��z���喼 = B.���ו��喼"
				+ "  AND  B.���׃p�^�[�� = 'P'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkMeisaiQ() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBB�����斾�׃}�X�^ B"
						+ " SET �ŏI�}�b�`�� = CURRENT_TIMESTAMP"
						+ " FROM �yXI�zBBCSV A"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '71'"
						+ "  AND  A.�y���׏��z���׍��� = B.���׍���"
						+ "  AND  A.�y���׏��z���喼 LIKE B.���ו��喼"
						+ "  AND  B.���׃p�^�[�� = 'Q'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE �yXI�zBBCSV A SET �y�ǉ����z���׃p�^�[�� = 'Q' ,"
						+ " �y�ǉ����z���׊Ǘ��ԍ� = B.���׊Ǘ��ԍ� ,"
						+ " �y�ǉ����z�X�e�[�^�X = '72'"
						+ " FROM �yXI�zBB�����斾�׃}�X�^ B"
						+ " WHERE A.�y�ǉ����z�X�e�[�^�X = '71'"
						+ "  AND  A.�y���׏��z���׍��� = B.���׍���"
						+ "  AND  A.�y���׏��z���喼 LIKE B.���ו��喼"
						+ "  AND  B.���׃p�^�[�� = 'Q'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkMeisai() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT COUNT(*) AS CNT  FROM �yXI�zVBB���׃}�b�`��"
						+ " WHERE ���ב��� = ���׃}�b�`��";
		xidb.setSQL( sqlstr );
		xidb.getRow();
		int cnt = xidb.getClmnAsInt("CNT");

		long[] kanricd = new long[cnt];
		sqlstr = "SELECT * FROM �yXI�zVBB���׃}�b�`�� WHERE ���ב��� = ���׃}�b�`��";
		xidb.setSQL( sqlstr );
		for ( int i = 0 ; i < kanricd.length ; i++ )
		{
			xidb.getRow();
			kanricd[i] = xidb.getClmnAsLong("�������Ǘ��R�[�h");
		}

		for ( int i = 0 ; i < kanricd.length ; i++ )
		{
			sqlstr = "UPDATE �yXI�zBBCsv SET �y�ǉ����z�X�e�[�^�X = '20'"
					+ " WHERE �y�S�̏��z�������Ǘ��R�[�h = " + kanricd[i];
			xidb.setUpdate( sqlstr );
		}

		xidb.close();
	}

	public static String[] status60Seikyuumoto() throws Exception
	{
		List<String> list = new ArrayList<String>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT �y�����ď��z������ FROM �yXI�zBBCsv"
						+ " WHERE �y�ǉ����z�X�e�[�^�X = '60'"
						+ " GROUP BY �y�����ď��z������"
						+ " ORDER BY �y�����ď��z������ ASC";
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			list.add( xidb.getClmn("�y�����ď��z������") );
		}
		xidb.close();

		String[] rc = new String[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get(i);
		}
		return( rc );
	}

	public static String[][] status70Kenmei() throws Exception
	{
		List<String[]> list = new ArrayList<String[]>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT �y�S�̏��z�������Ǘ��R�[�h , �y�����ď��z������ ,"
						+ "�y�����ď��z������ , �y�����ď��z����"
						+ " FROM �yXI�zBBCsv"
						+ " WHERE �y�ǉ����z�X�e�[�^�X = '70'"
						+ " GROUP BY �y�S�̏��z�������Ǘ��R�[�h , �y�����ď��z������ ,"
						+ " �y�����ď��z������ , �y�����ď��z����"
						+ " ORDER BY �y�S�̏��z�������Ǘ��R�[�h ASC , �y�����ď��z������ ASC ,"
						+ " �y�����ď��z������ ASC , �y�����ď��z���� ASC";
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			String[] rec = {
								xidb.getClmn("�y�S�̏��z�������Ǘ��R�[�h") ,
								xidb.getClmn("�y�����ď��z������") ,
								xidb.getClmn("�y�����ď��z������") ,
								xidb.getClmn("�y�����ď��z����") ,
							};
			list.add( rec );
		}
		xidb.close();

		String[][] rc = new String[ list.size() ][4];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get(i);
		}
		return( rc );
	}

	public static String[][] status71Kenmei() throws Exception
	{
		List<String[]> list = new ArrayList<String[]>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT �y�S�̏��z�������Ǘ��R�[�h , �y�����ď��z������ ,"
						+ "�y�����ď��z������ , �y�����ď��z����"
						+ " FROM �yXI�zBBCsv"
						+ " WHERE �y�ǉ����z�X�e�[�^�X = '71'"
						+ " GROUP BY �y�S�̏��z�������Ǘ��R�[�h , �y�����ď��z������ ,"
						+ " �y�����ď��z������ , �y�����ď��z����"
						+ " ORDER BY �y�S�̏��z�������Ǘ��R�[�h ASC , �y�����ď��z������ ASC ,"
						+ " �y�����ď��z������ ASC , �y�����ď��z���� ASC";
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			String[] rec = {
								xidb.getClmn("�y�S�̏��z�������Ǘ��R�[�h") ,
								xidb.getClmn("�y�����ď��z������") ,
								xidb.getClmn("�y�����ď��z������") ,
								xidb.getClmn("�y�����ď��z����") ,
							};
			list.add( rec );
		}
		xidb.close();

		String[][] rc = new String[ list.size() ][4];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get(i);
		}
		return( rc );
	}

	public static String[][] getMeisaiByCode( String code ) throws Exception
	{
		List<String[]> list = new ArrayList<String[]>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT �y���׏��z���׍��� AS ���׍��� ,"
						+ " �y���׏��z���喼 AS ���喼 ,"
						+ " �y���׏��z���ה��l AS ���ה��l ,"
						+ " �y���׏��z���z AS ���z ,"
						+ " �y���׏��z����Ŋz AS ����Ŋz,"
						+ " �y���׏��z���טA�� AS ���טA��,"
						+ " �y�ǉ����z�X�e�[�^�X AS �X�e�[�^�X,"
						+ " �y�ǉ����z�`�F�b�N�p�^�[�� AS �`�F�b�N�p�^�[��,"
						+ " �y�ǉ����z���׃p�^�[�� AS ���׃p�^�[��,"
						+ " �y�ǉ����z�����Ǘ��ԍ� AS �����Ǘ��ԍ�,"
						+ " �y�ǉ����z���׊Ǘ��ԍ� AS ���׊Ǘ��ԍ�"
						+ " FROM �yXI�zBBCsv"
						+ " WHERE �y�S�̏��z�������Ǘ��R�[�h = '" + code + "'"
						+ "  AND �y���׏��z���ד��t IS NOT NULL"
						+ " ORDER BY �y�S�̏��z�������Ǘ��R�[�h ASC , �y���׏��z���טA��";

		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			String[] rec = {
								xidb.getClmn("���׍���") ,
								xidb.getClmn("���喼") ,
								xidb.getClmn("���ה��l") ,
								xidb.getClmn("���z") ,
								xidb.getClmn("����Ŋz") ,
								xidb.getClmn("���טA��") ,
								xidb.getClmn("�X�e�[�^�X") ,
								xidb.getClmn("�`�F�b�N�p�^�[��"),
								xidb.getClmn("���׃p�^�[��"),
								xidb.getClmn("�����Ǘ��ԍ�"),
								xidb.getClmn("���׊Ǘ��ԍ�")

							};
			list.add( rec );
		}
		xidb.close();

		String[][] rc = new String[ list.size() ][3];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get(i);
		}
		return( rc );
	}

	public static void updateAllMatched() throws Exception
	{
		List<String> list = new ArrayList<String>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT * FROM �yXI�zVBB���׃}�b�`��";
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			String code = xidb.getClmn("�������Ǘ��R�[�h");
			int sousuu = xidb.getClmnAsInt("���ב���");
			int matchsuu = xidb.getClmnAsInt("���׃}�b�`��");
			if ( sousuu == matchsuu ) list.add( code );
		}

		for ( int i = 0 ; i < list.size() ; i++ )
		{
			String code = list.get( i );
			sqlstr = "UPDATE �yXI�zBBCsv SET �y�ǉ����z�X�e�[�^�X = '20'"
					+ " WHERE �y�S�̏��z�������Ǘ��R�[�h = " + code;
			xidb.setUpdate( sqlstr );
		}
		xidb.close();
	}

	public static void afterCheck() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBBCsv"
						+ " SET �y�ǉ����z�X�e�[�^�X = '20'"
						+ " WHERE �y�ǉ����z�X�e�[�^�X = '10'"
						+ " AND �y�ǉ����z�`�F�b�N�p�^�[�� != ''";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void updateStatus( String code , String sts ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE �yXI�zBBCsv"
						+ " SET �y�ǉ����z�X�e�[�^�X = '" + sts + "'"
						+ " WHERE �y�S�̏��z�������Ǘ��R�[�h = '" + code + "'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void deleteByCode( String code ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "DELETE FROM �yXI�zBBCsv"
						+ " WHERE �y�S�̏��z�������Ǘ��R�[�h = '" + code + "'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void deleteByStatus( String sts ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "DELETE FROM �yXI�zBBCsv"
						+ " WHERE �y�ǉ����z�X�e�[�^�X = '" + sts + "'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static long copyInFromArray( String[][] outrecs ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE �yXI�zBBCSV";
		xidb.setUpdate( sqlstr );

		String tblnm = "ikou.�yXI�zBBCSV";
		String[] cols = XIBBCsvAcc.getFields();
		long rc = xidb.copyInFromStringArray( tblnm , cols , outrecs );

		xidb.close();

		return( rc );
	}

	public static long copyIn( String inf ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE �yXI�zBBCSVTEMP";
		xidb.setUpdate( sqlstr );

		String tblnm = "�yXI�zBBCSVTEMP";
		String[] colmns = XIBBCsvAcc.getFields();
		long rc = xidb.copyInSJIS( tblnm , colmns , inf );
		xidb.close();

		XIBBTorikomiRireki xitr = new XIBBTorikomiRireki();
		xitr.setOperationDate( new Date() );
		int ix = inf.lastIndexOf("\\") + 1;
		String fname = inf.substring( ix );
		xitr.setFileName( fname );
		xitr.setKensuu( rc );
		XIBBTorikomiRirekiAcc.insert( xitr );

		xidb = new XIDBAccess();
		sqlstr = "INSERT INTO �yXI�zBBCSV SELECT * FROM �yXI�zVBBCSVCAST";
		xidb.setUpdate( sqlstr );
		xidb.close();

		return( rc );
	}

	public static String[] getFields()
	{
		String[] rc = {
						"�y�S�̏��z�쐬���@",
						"�y�S�̏��z�Y�t�t�@�C���L���t���O",
						"�y�S�̏��z�t�@�C���o�͓���",
						"�y�S�̏��z�˗���",
						"�y�S�̏��z�Ñ���",
						"�y�S�̏��z���",
						"�y�S�̏��z����",
						"�y�S�̏��z�������S����",
						"�y�S�̏��z���F�˗���",
						"�y�S�̏��z�o���O���[�v",
						"�y�S�̏��z��vDL",
						"�y�S�̏��z�x��DL",
						"�y�S�̏��zConcur�A�g",
						"�y�S�̏��z�Z���R�[�h",
						"�y�S�̏��z�������Ǘ��R�[�h",
						"�y�����ď��z���������s��",
						"�y�����ď��z����",
						"�y�����ď��z�x������",
						"�y�����ď��z���Ўx������",
						"�y�����ď��z�ۑ�����",
						"�y�����ď��z�ǋL",
						"�y�����ď��z�ېŒP��",
						"�y�����ď��z�x�����@",
						"�y�����ď��z�w�����",
						"�y�����ď��z�U�������1",
						"�y�����ď��z�U�������2",
						"�y�����ď��z�U�������3",
						"�y�����ď��z�U�������4",
						"�y�����ď��z�U�������5",
						"�y�����ď��z�U�������6",
						"�y�����ď��z�U�������7",
						"�y�����ď��z�U�������8",
						"�y�����ď��z�U�������9",
						"�y�����ď��z�U�������10",
						"�y�����ď��z���ʕ\��",
						"�y�����ď��z�ڋq�R�[�h�P",
						"�y�����ď��z�ڋq�R�[�h�Q",
						"�y�����ď��zEDI���",
						"�y�����ď��z�x����R�[�h",
						"�y�����ď��z������",
						"�y�����ď��z�������d�b�ԍ�",
						"�y�����ď��z���Ǝҋ敪",
						"�y�����ď��z���Ǝғo�^�ԍ�",
						"�y�����ď��z���Ǝғo�^�ԍ���������",
						"�y�����ď��z�m���Œ��n�o�^�N����",
						"�y�����ď��z�m���Œ��n���Ǝҏ����敪",
						"�y�����ď��z�m���Œ��n�������͖���",
						"�y�����ď��z�m���Œ��n�s���{��",
						"�y�����ď��z�m���Œ��n�Z��",
						"�y�����ď��z�m���Œ��n�X�V�N����",
						"�y�����ď��z�m���Œ��n�傽�鉮��",
						"�y�����ď��z�m���Œ��n�ʏ́E����",
						"�y�����ď��z�m���Œ��n����N����",
						"�y�����ď��z�m���Œ��n�����N����",
						"�y�����ď��z���s��R�[�h",
						"�y�����ď��z������",
						"�y�����ď��z������d�b�ԍ�",
						"�y�����ď��z���s��S����",
						"�y�����ď��z����R�[�h",
						"�y�����ď��z���於",
						"�y�����ď��z�������ԍ�",
						"�y�����ď��z�������^�C�g��",
						"�y�����ď��z����",
						"�y�����ď��z���ВS����",
						"�y�����ď��z�O�񐿋����z",
						"�y�����ď��z�����z",
						"�y�����ď��z�������z",
						"�y�����ď��z�J�z���z",
						"�y�����ď��z���񐿋����z���Ŕ�",
						"�y�����ď��z�������Ŋz",
						"�y�����ď��z���񐿋����z���ō�",
						"�y�����ď��z�����Ă̐������z",
						"�y�����ď��z10���������z���Ŕ�",
						"�y�����ď��z10������Ŋz",
						"�y�����ď��z10���������z���ō�",
						"�y�����ď��z�y��8���������z���Ŕ�",
						"�y�����ď��z�y��8������Ŋz",
						"�y�����ď��z�y��8���������z���ō�",
						"�y�����ď��z8���������z���Ŕ�",
						"�y�����ď��z8������Ŋz",
						"�y�����ď��z8���������z���ō�",
						"�y�����ď��z5���������z���Ŕ�",
						"�y�����ď��z5������Ŋz",
						"�y�����ď��z5���������z���ō�",
						"�y�����ď��z0���������z���Ŕ�",
						"�y�����ď��z0������Ŋz",
						"�y�����ď��z0���������z���ō�",
						"�y�����ď��z��ېŐ������z���Ŕ�",
						"�y�����ď��z��ېŏ���Ŋz",
						"�y�����ď��z��ېŐ������z���ō�",
						"�y�����ď��z�ƐŐ������z���Ŕ�",
						"�y�����ď��z�Ɛŏ���Ŋz",
						"�y�����ď��z�ƐŐ������z���ō�",
						"�y�����ď��z�s�ېŐ������z���Ŕ�",
						"�y�����ď��z�s�ېŏ���Ŋz",
						"�y�����ď��z�s�ېŐ������z���ō�",
						"�y�����ď��z���l",
						"�y�����ď��z������A1�^�C�g��",
						"�y�����ď��z������A1�f�[�^",
						"�y�����ď��z������A2�^�C�g��",
						"�y�����ď��z������A2�f�[�^",
						"�y�����ď��z������A3�^�C�g��",
						"�y�����ď��z������A3�f�[�^",
						"�y�����ď��z������B1�^�C�g��",
						"�y�����ď��z������B1�f�[�^",
						"�y�����ď��z������B2�^�C�g��",
						"�y�����ď��z������B2�f�[�^",
						"�y�����ď��z������B3�^�C�g��",
						"�y�����ď��z������B3�f�[�^",
						"�y�����ď��z������B4�^�C�g��",
						"�y�����ď��z������B4�f�[�^",
						"�y�����ď��z������B5�^�C�g��",
						"�y�����ď��z������B5�f�[�^",
						"�y�����ď��z������B6�^�C�g��",
						"�y�����ď��z������B6�f�[�^",
						"�y�����ď��z������B7�^�C�g��",
						"�y�����ď��z������B7�f�[�^",
						"�y�����ď��z�ǉ����R���ڂP�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂP",
						"�y�����ď��z�ǉ����R���ڂQ�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂQ",
						"�y�����ď��z�ǉ����R���ڂR�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂR",
						"�y�����ď��z�ǉ����R���ڂS�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂS",
						"�y�����ď��z�ǉ����R���ڂT�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂT",
						"�y�����ď��z�ǉ����R���ڂU�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂU",
						"�y�����ď��z�ǉ����R���ڂV�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂV",
						"�y�����ď��z�ǉ����R���ڂW�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂW",
						"�y�����ď��z�ǉ����R���ڂX�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂX",
						"�y�����ď��z�ǉ����R���ڂP�O�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂP�O",
						"�y�����ď��z�ǉ����R���ڂP�P�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂP�P",
						"�y�����ď��z�ǉ����R���ڂP�Q�^�C�g��",
						"�y�����ď��z�ǉ����R���ڂP�Q",
						"�y�����ď��z�ۑ������̕⑫����",
						"�y���׏��z���ד��t",
						"�y���׏��z���הԍ�",
						"�y���׏��z���i�R�[�h",
						"�y���׏��z���׍���",
						"�y���׏��z�P��",
						"�y���׏��z�P��",
						"�y���׏��z����",
						"�y���׏��z�ŋ敪",
						"�y���׏��z�ŗ�",
						"�y���׏��z�y���ŗ�",
						"�y���׏��z���z",
						"�y���׏��z����Ŋz",
						"�y���׏��z�������z",
						"�y���׏��z����R�[�h",
						"�y���׏��z���喼",
						"�y���׏��z���ה��l",
						"�y���׏��z����01�^�C�g��",
						"�y���׏��z����01�f�[�^",
						"�y���׏��z����02�^�C�g��",
						"�y���׏��z����02�f�[�^",
						"�y���׏��z����03�^�C�g��",
						"�y���׏��z����03�f�[�^",
						"�y���׏��z����04�^�C�g��",
						"�y���׏��z����04�f�[�^",
						"�y���׏��z����05�^�C�g��",
						"�y���׏��z����05�f�[�^",
						"�y���׏��z����06�^�C�g��",
						"�y���׏��z����06�f�[�^",
						"�y���׏��z����07�^�C�g��",
						"�y���׏��z����07�f�[�^",
						"�y���׏��z����08�^�C�g��",
						"�y���׏��z����08�f�[�^",
						"�y���׏��z����09�^�C�g��",
						"�y���׏��z����09�f�[�^",
						"�y���׏��z����10�^�C�g��",
						"�y���׏��z����10�f�[�^",
						"�y���׏��z����11�^�C�g��",
						"�y���׏��z����11�f�[�^",
						"�y���׏��z����1",
						"�y���׏��z����2",
						"�y�d����z��v�`�[���t",
						"�y�d����z�ؕ����S����",
						"�y�d����z�ؕ��Ȗ�",
						"�y�d����z�ؕ��⏕�Ȗ�",
						"�y�d����z�ݕ����S����",
						"�y�d����z�ݕ��Ȗ�",
						"�y�d����z�ݕ��⏕�Ȗ�",
						"�y�d����z�E�v",
						"�y�d����z�d�󎩗R����1",
						"�y�d����z�d��⏕1",
						"�y�d����z�d�󎩗R����2",
						"�y�d����z�d��⏕2",
						"�y�d����z�d�󎩗R����3",
						"�y�d����z�d��⏕3",
						"�y�d����z�d�󎩗R����4",
						"�y�d����z�d��⏕4",
						"�y�d����z�d�󎩗R����5",
						"�y�d����z�d��⏕5",
						"�y�d����z�d�󎩗R����6",
						"�y�d����z�d��⏕6",
						"�y�d����z�d�󎩗R����7",
						"�y�d����z�d��⏕7",
						"�y�d����z�d�󎩗R����8",
						"�y�d����z�d��⏕8",
						"�y�d����z�d�󎩗R����9",
						"�y�d����z�d�󎩗R����9�e�L�X�g",
						"�y�d����z�d�󎩗R����10",
						"�y�d����z�d�󎩗R����10�e�L�X�g",
						"�y�d����z�d�󎩗R����11",
						"�y�d����z�d�󎩗R����11�e�L�X�g",
						"�y�d����z�d�󎩗R����12",
						"�y�d����z�d�󎩗R����12�e�L�X�g",
						"�y�`�[���z�`�[�ԍ�",
						"�y�`�[���z�`�[���l",
						"�y�`�[���z�`�[���z",
						"�y�`�[���z�`�[����Ŋz",
						"�y�`�[���z�`�[�������z",
						"�y�`�[���z�`�[10�����v���z���Ŕ�",
						"�y�`�[���z�`�[10������Ŋz",
						"�y�`�[���z�`�[10�����v���z���ō�",
						"�y�`�[���z�`�[�y��8�����v���z���Ŕ�",
						"�y�`�[���z�`�[�y��8������Ŋz",
						"�y�`�[���z�`�[�y��8�����v���z���ō�",
						"�y�`�[���z�`�[8�����v���z���Ŕ�",
						"�y�`�[���z�`�[8������Ŋz",
						"�y�`�[���z�`�[8�����v���z���ō�",
						"�y�`�[���z�`�[5�����v���z���Ŕ�",
						"�y�`�[���z�`�[5������Ŋz",
						"�y�`�[���z�`�[5�����v���z���ō�",
						"�y�`�[���z�`�[0�����v���z���Ŕ�",
						"�y�`�[���z�`�[0������Ŋz",
						"�y�`�[���z�`�[0�����v���z���ō�",
						"�y�`�[���z�`�[��ېō��v���z���Ŕ�",
						"�y�`�[���z�`�[��ېŏ���Ŋz",
						"�y�`�[���z�`�[��ېō��v���z���ō�",
						"�y�`�[���z�`�[�Ɛō��v���z���Ŕ�",
						"�y�`�[���z�`�[�Ɛŏ���Ŋz",
						"�y�`�[���z�`�[�Ɛō��v���z���ō�",
						"�y�`�[���z�`�[�s�ېō��v���z���Ŕ�",
						"�y�`�[���z�`�[�s�ېŏ���Ŋz",
						"�y�`�[���z�`�[�s�ېō��v���z���ō�",
						"�y�S�̏��z�������Ǘ��ԍ�",
						"�y�S�̏��z�ԑ��@�\�g�p�L��",
						"�y�S�̏��z���Ѝ쐬�������쐬��",
						"�y���׏��z���טA��",
						"�y�����ď��z��\�Җ�E",
						"�y�����ď��z��\�Җ�",
						"�y���׏��z�Ŕ��ō�"
					  };
		return( rc );
	}

}
