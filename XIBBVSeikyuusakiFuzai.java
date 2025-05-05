package xinvoice;

public class XIBBVSeikyuusakiFuzai
{
	public String seikmoto;
	public String seiksaki;
	public String kenmei;

	public XIBBVSeikyuusakiFuzai()
	{
		seikmoto = "";
		seiksaki = "";
		kenmei = "";
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

}
