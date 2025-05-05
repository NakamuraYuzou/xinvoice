package xinvoice;

import java.util.Date;

public class XIBBVBBtoCCTop
{
	public String kanricd;
	public String bangou;
	public Date hakkou;
	public Date kigen;
	public String kenmei;
	public long amount;
	public String moto;
	public String saki;
	public String status;
	public String torihikicd;
	public String chkptn;
	public String hiyoucd;
	public String hiyounm;
	public String meado;
	public String kihyousya;
	public String koujicd;
	public String koujiscd;
	public String koujinm;
	public String bumoncd;
	public String bumonnm;

	public XIBBVBBtoCCTop()
	{
		kanricd = "";
		bangou = "";
		kenmei = "";
		torihikicd = "";
		meado = "";
	}

	public String getKanriCode()
	{
		return( kanricd );
	}

	public String getSeikyuusyoBangou()
	{
		return( bangou );
	}

	public Date getHakkouDate()
	{
		return( hakkou );
	}

	public Date getKigenDate()
	{
		return( kigen );
	}

	public String getKenmei()
	{
		return( kenmei );
	}

	public long getAmount()
	{
		return( amount );
	}

	public String getSeikyuumoto()
	{
		return( moto );
	}

	public String getSeikyuusaki()
	{
		return( saki );
	}

	public String getStatus()
	{
		return( status );
	}

	public String getTorihikisakiCode()
	{
		return( torihikicd );
	}

	public String getCheckPattern()
	{
		return( chkptn );
	}

	public String getHiyouCode()
	{
		return( hiyoucd );
	}

	public String getHiyouName()
	{
		return( hiyounm );
	}

	public String getMailAddress()
	{
		return( meado );
	}

	public String getKihyousyaName()
	{
		return( kihyousya );
	}

	public String getKoujiCode()
	{
		return( koujicd );
	}

	public String getKoujiSyousaiCode()
	{
		return( koujiscd );
	}

	public String getKoujiName()
	{
		return( koujinm );
	}

	public String getBumonCode()
	{
		return( bumoncd );
	}

	public String getBumonName()
	{
		return( bumonnm );
	}

	public void setKanriCode( String arg )
	{
		kanricd = arg;
	}

	public void setSeikyuusyoBangou( String arg )
	{
		bangou = arg;
	}

	public void setHakkouDate( Date arg )
	{
		hakkou = arg;
	}

	public void setKigenDate( Date arg )
	{
		kigen = arg;
	}

	public void setKenmei( String arg )
	{
		kenmei = arg;
	}

	public void setAmount( long arg )
	{
		amount = arg;
	}

	public void setSeikyuumoto( String arg )
	{
		moto = arg;
	}

	public void setSeikyuusaki( String arg )
	{
		saki = arg;
	}

	public void setStatus( String arg )
	{
		status = arg;
	}

	public void setTorihikisakiCode( String arg )
	{
		torihikicd = arg;
	}

	public void setCheckPattern( String arg )
	{
		chkptn = arg;
	}

	public void setHiyouCode( String arg )
	{
		hiyoucd = arg;
	}

	public void setHiyouName( String arg )
	{
		hiyounm = arg;
	}

	public void setMailAddress( String arg )
	{
		meado = arg;
	}

	public void setKihyousyaName( String arg )
	{
		kihyousya = arg;
	}

	public void setKoujiCode( String arg )
	{
		koujicd = arg;
	}

	public void setKoujiSyousaiCode( String arg )
	{
		koujiscd = arg;
	}

	public void setKoujiName( String arg )
	{
		koujinm = arg;
	}

	public void setBumonCode( String arg )
	{
		bumoncd = arg;
	}

	public void setBumonName( String arg )
	{
		bumonnm = arg;
	}

}
