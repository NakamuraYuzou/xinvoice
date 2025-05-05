package xinvoice;

public class XIBumon
{
	public String bumoncd;
	public String meisyou;
	public String ryakusyou;

	public XIBumon()
	{
		bumoncd = "";
		meisyou = "";
		ryakusyou = "";
	}

	public String getBumonCode()
	{
		return( bumoncd );
	}

	public String getBumonMeisyou()
	{
		return( meisyou );
	}

	public String getBumonRyakusyou()
	{
		return( ryakusyou );
	}

	public void setBumonCode( String arg )
	{
		bumoncd = arg;
	}

	public void setBumonMeisyou( String arg )
	{
		meisyou = arg;
	}

	public void setBumonRyakusyou( String arg )
	{
		ryakusyou = arg;
	}

}
