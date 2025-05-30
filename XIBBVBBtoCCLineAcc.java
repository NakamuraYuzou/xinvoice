package xinvoice;

import java.util.ArrayList;
import java.util.List;

public class XIBBVBBtoCCLineAcc
{
	public static XIBBVBBtoCCLine[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzVBBtoCCLine";
		XIBBVBBtoCCLine[] rc = XIBBVBBtoCCLineAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBVBBtoCCLine[] getByKanriCode( String code ) throws Exception
	{
		String sqlstr = "SELECT * FROM yXIzVBBtoCCLine WHERE ΏΗR[h = '" + code + "'";
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
			rec.setKanriCode( xidb.getClmn("ΏΗR[h") );
			rec.setKanriNo( xidb.getClmnAsLong("ΏΗΤ") );
			rec.setSeikyuuNo( xidb.getClmn("ΏΤ") );
			rec.setZeinukiSeikyuugaku( xidb.getClmnAsLong("Ε²Ώΰz") );
			rec.setTorihikisakiCode( xidb.getClmn("ζψζR[h") );
			rec.setSeikyuumoto( xidb.getClmn("Ώ³") );
			rec.setPatternTorihikisakiCode( xidb.getClmn("p^[ζψζR[h") );
			rec.setExpenseTypeCode08( xidb.getClmn("oο^CvR[h08") );
			rec.setExpenseTypeName08( xidb.getClmn("oο^CvΌΜ08") );
			rec.setExpenseTypeCode10( xidb.getClmn("oο^CvR[h10") );
			rec.setExpenseTypeName10( xidb.getClmn("oο^CvΌΜ10") );
			rec.setHiyouKubun( xidb.getClmn("οpζͺ") );
			rec.setKoujiCode( xidb.getClmn("HR[h") );
			rec.setKoujiSyousaiCode( xidb.getClmn("HΪΧR[h") );
			rec.setBumonCode( xidb.getClmn("εR[h") );
			rec.setMeisaiRenban( xidb.getClmnAsInt("ΎΧAΤ") );
			rec.setMeisaiBangou( xidb.getClmn("ΎΧΤ") );
			rec.setMeisaiKoumoku( xidb.getClmn("ΎΧΪ") );
			rec.setMeisaiBumon( xidb.getClmn("ΎΧεΌ") );
			rec.setMeisaiTanka( xidb.getClmnAsLong("PΏ") );
			rec.setMeisaiTani( xidb.getClmn("PΚ") );
			rec.setMeisaiSuuryou( xidb.getClmnAsLong("Κ") );
			rec.setMeisaiZeiritsu( xidb.getClmn("Ε¦") );
			rec.setMeisaiKingaku( xidb.getClmnAsLong("ΰz") );
			rec.setMeisaiSyouhizeiGaku( xidb.getClmnAsLong("ΑοΕz"));
			rec.setMeisaiSeikyuuGaku( xidb.getClmnAsLong("Ώΰz"));
			rec.setMeisaiBikou( xidb.getClmn("ΎΧυl") );
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
