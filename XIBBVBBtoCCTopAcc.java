package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVBBtoCCTopAcc
{
	public static XIBBVBBtoCCTop[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zVBBtoCCTop";
		XIBBVBBtoCCTop[] rc = XIBBVBBtoCCTopAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCTop[] getByStatus( String sts ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zVBBtoCCTop WHERE �X�e�[�^�X = '" + sts + "'";
		XIBBVBBtoCCTop[] rc = XIBBVBBtoCCTopAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCTop getByKanriCode( String code ) throws Exception
	{
		String sqlstr = "SELECT * FROM �yXI�zVBBtoCCTop WHERE �������Ǘ��R�[�h = '" + code + "'";
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
			rec.setKanriCode( xidb.getClmn("�������Ǘ��R�[�h") );
			rec.setSeikyuusyoBangou( xidb.getClmn("�������ԍ�") );
			rec.setHakkouDate( xidb.getClmnAsDate("���������s��") );
			rec.setKigenDate( xidb.getClmnAsDate("�x������") );
			rec.setKenmei( xidb.getClmn("����") );
			rec.setAmount( xidb.getClmnAsLong("�������z") );
			rec.setSeikyuumoto( xidb.getClmn("������") );
			rec.setSeikyuusaki( xidb.getClmn("������") );
			rec.setStatus( xidb.getClmn("�X�e�[�^�X") );
			rec.setTorihikisakiCode( xidb.getClmn("�����R�[�h") );
			rec.setCheckPattern( xidb.getClmn("�`�F�b�N�p�^�[��") );
			rec.setHiyouCode( xidb.getClmn("��p�敪") );
			rec.setHiyouName( xidb.getClmn("��p�敪��") );
			rec.setMailAddress( xidb.getClmn("���A�h") );
			rec.setKihyousyaName( xidb.getClmn("�N�[�Җ�") );
			rec.setKoujiCode( xidb.getClmn("�H���R�[�h") );
			rec.setKoujiSyousaiCode( xidb.getClmn("�H���ڍ׃R�[�h") );
			rec.setKoujiName( xidb.getClmn("�H����") );
			rec.setBumonCode( xidb.getClmn("����R�[�h") );
			rec.setBumonName( xidb.getClmn("���喼") );
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
