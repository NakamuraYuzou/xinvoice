package xinvoice;

public class XIKouji
{
	public String koujicd;
	public String syousaicd;
	public String meisyou;
	public String ryakusyou;
	public String bumoncd;
	public String bumonnm;

	public XIKouji()
	{
		koujicd = "";
		syousaicd = "";
		meisyou = "";
		ryakusyou = "";
	}

	public String getKoujiCode()
	{
		return( koujicd );
	}

	public String getKoujiSyousaiCode()
	{
		return( syousaicd );
	}

	public String getKoujiMeisyou()
	{
		return( meisyou );
	}

	public String getKoujiRyakusyou()
	{
		return( ryakusyou );
	}

	public String getBumonCode()
	{
		return( bumoncd );
	}

	public String getBumonMeisyou()
	{
		return( bumonnm );
	}

	public void setKoujiCode( String arg )
	{
		koujicd = arg;
	}

	public void setKoujiSyousaiCode( String arg )
	{
		syousaicd = arg;
	}

	public void setKoujiMeisyou( String arg )
	{
		meisyou = arg;
	}

	public void setKoujiRyakusyou( String arg )
	{
		ryakusyou = arg;
	}

	public void setBumonCode( String arg )
	{
		bumoncd = arg;
	}

	public void setBumonMeisyou( String arg )
	{
		bumonnm = arg;
	}

}
