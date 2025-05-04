package xinvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XIBBSeikyuuMeisai
{
	public long no;
	public long ken_no;
	public String chk_ptn;
	public String meisai_ptn;
	public String koumoku;
	public String meisai_bumon;
	public String bikou;
	public String hiyoucd;
	public String hiyounm;
	public String koujicd;
	public String koujisycd;
	public String koujinm;
	public String bumoncd;
	public String bumonnm;
	public Date lastmatch;
	public SimpleDateFormat sdf;

	public XIBBSeikyuuMeisai()
	{
		chk_ptn = "";
		meisai_ptn = "";
		koumoku = "";
		meisai_bumon = "";
		bikou = "";
		hiyoucd = "";
		hiyounm = "";
		koujicd = "";
		koujisycd = "";
		koujinm = "";
		bumoncd = "";
		bumonnm = "";

		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public long getNo()
	{
		return( no );
	}

	public long getKenmeiKanriNo()
	{
		return( ken_no );
	}

	public String getCheckPattern()
	{
		return( chk_ptn );
	}

	public String getMeisaiPattern()
	{
		return( meisai_ptn );
	}

	public String getMeisaiKoumoku()
	{
		return( koumoku );
	}

	public String getMeisaiBumon()
	{
		return( meisai_bumon );
	}

	public String getMeisaiBikou()
	{
		return( bikou );
	}

	public String getHiyouCode()
	{
		return( hiyoucd );
	}

	public String getHiyouName()
	{
		return( hiyounm );
	}

	public String getKoujiCode()
	{
		return( koujicd );
	}

	public String getKoujiSyousaiCode()
	{
		return( koujisycd );
	}

	public String getKoujiMeisyou()
	{
		return( koujinm );
	}

	public String getBumonCode()
	{
		return( bumoncd );
	}

	public String getBumonMeisyou()
	{
		return( bumonnm );
	}

	public Date getLastMatchDate()
	{
		return( lastmatch );
	}

	public String getLastMatchDateStr()
	{
		String rc = "";
		if ( lastmatch != null ) rc = sdf.format( lastmatch );
		return( rc );
	}

	public void setNo( long arg )
	{
		no = arg;
	}

	public void setKenmeiKanriNo( long arg )
	{
		ken_no = arg;
	}

	public void setCheckPattern( String arg )
	{
		chk_ptn = arg;
	}

	public void setMeisaiPattern( String arg )
	{
		meisai_ptn = arg;
	}

	public void setMeisaiKoumoku( String arg )
	{
		koumoku = arg;
	}

	public void setMeisaiBumon( String arg )
	{
		meisai_bumon = arg;
	}

	public void setMeisaiBikou( String arg )
	{
		bikou = arg;
	}

	public void setHiyouCode( String arg )
	{
		hiyoucd = arg;
	}

	public void setHiyouName( String arg )
	{
		hiyounm = arg;
	}

	public void setKoujiCode( String arg )
	{
		koujicd = arg;
	}

	public void setKoujiSyousaiCode( String arg )
	{
		koujisycd = arg;
	}

	public void setKoujiMeisyou( String arg )
	{
		koujinm = arg;
	}

	public void setBumonCode( String arg )
	{
		bumoncd = arg;
	}

	public void setBumonMeisyou( String arg )
	{
		bumonnm = arg;
	}

	public void setLastMatchDate( Date arg )
	{
		lastmatch = arg;
	}

}
