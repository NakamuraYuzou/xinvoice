package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVBBtoCCLineAcc
{
	public static XIBBVBBtoCCLine[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zVBBtoCCLine";
		XIBBVBBtoCCLine[] rc = XIBBVBBtoCCLineAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCLine[] getByKanriCode( String code ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zVBBtoCCLine WHERE �������Ǘ��R�[�h = '" + code + "'";
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
			rec.setKanriCode( xidb.getClmn("�������Ǘ��R�[�h") );
			rec.setKanriNo( xidb.getClmnAsLong("�������Ǘ��ԍ�") );
			rec.setSeikyuuNo( xidb.getClmn("�������ԍ�") );
			rec.setZeinukiSeikyuugaku( xidb.getClmnAsLong("�Ŕ��������z") );
			rec.setTorihikisakiCode( xidb.getClmn("�����R�[�h") );
			rec.setSeikyuumoto( xidb.getClmn("������") );
			rec.setPatternTorihikisakiCode( xidb.getClmn("�p�^�[�������R�[�h") );
			rec.setExpenseTypeCode08( xidb.getClmn("�o��^�C�v�R�[�h08") );
			rec.setExpenseTypeName08( xidb.getClmn("�o��^�C�v����08") );
			rec.setExpenseTypeCode10( xidb.getClmn("�o��^�C�v�R�[�h10") );
			rec.setExpenseTypeName10( xidb.getClmn("�o��^�C�v����10") );
			rec.setHiyouKubun( xidb.getClmn("��p�敪") );
			rec.setKoujiCode( xidb.getClmn("�H���R�[�h") );
			rec.setKoujiSyousaiCode( xidb.getClmn("�H���ڍ׃R�[�h") );
			rec.setBumonCode( xidb.getClmn("����R�[�h") );
			rec.setMeisaiRenban( xidb.getClmnAsInt("���טA��") );
			rec.setMeisaiBangou( xidb.getClmn("���הԍ�") );
			rec.setMeisaiKoumoku( xidb.getClmn("���׍���") );
			rec.setMeisaiBumon( xidb.getClmn("���ו��喼") );
			rec.setMeisaiTanka( xidb.getClmnAsLong("�P��") );
			rec.setMeisaiTani( xidb.getClmn("�P��") );
			rec.setMeisaiSuuryou( xidb.getClmnAsLong("����") );
			rec.setMeisaiZeiritsu( xidb.getClmn("�ŗ�") );
			rec.setMeisaiKingaku( xidb.getClmnAsLong("���z") );
			rec.setMeisaiSyouhizeiGaku( xidb.getClmnAsLong("����Ŋz"));
			rec.setMeisaiSeikyuuGaku( xidb.getClmnAsLong("�������z"));
			rec.setMeisaiBikou( xidb.getClmn("���ה��l") );
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
