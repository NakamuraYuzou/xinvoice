package xinvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XIBBSeikyuusaki
{
	public long no;
	public String chk_ptn;
	public String hiyoucd;
	public String hiyounm;
	public String koujicd;
	public String koujisycd;
	public String koujinm;
	public String bumoncd;
	public String bumonnm;
	public String kihyou;
	public String kihyounm;
	public String seikmoto;
	public String seiksaki;
	public String kenmei;
	public Date lastmatch;
	public SimpleDateFormat sdf;

	public XIBBSeikyuusaki()
	{
		chk_ptn = "";
		hiyoucd = "";
		hiyounm = "";
		koujicd = "";
		koujisycd = "";
		koujinm = "";
		bumoncd = "";
		bumonnm = "";
		kihyou = "";
		kihyounm = "";
		seikmoto = "";
		seiksaki = "";
		kenmei = "";

		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public long getNo()
	{
		return( no );
	}

	public String getCheckPattern()
	{
		return( chk_ptn );
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

	public String getKihyou()
	{
		return( kihyou );
	}

	public String getKihyouName()
	{
		return( kihyounm );
	}

	public String getSeikyuuMoto()
	{
		return( seikmoto );
	}

	public String getSeikyuuSaki()
	{
		return( seiksaki );
	}

	public String getKenmei()
	{
		return( kenmei );
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

	public void setCheckPattern( String arg )
	{
		chk_ptn = arg;
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

	public void setKihyou( String arg )
	{
		kihyou = arg;
	}

	public void setKihyouName( String arg )
	{
		kihyounm = arg;
	}

	public void setSeikyuuMoto( String arg )
	{
		seikmoto = arg;
	}

	public void setSeikyuuSaki( String arg )
	{
		seiksaki = arg;
	}

	public void setKenmei( String arg )
	{
		kenmei = arg;
	}

	public void setLastMatchDate( Date arg )
	{
		lastmatch = arg;
	}
}
