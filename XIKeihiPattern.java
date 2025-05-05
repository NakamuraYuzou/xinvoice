package xinvoice;

public class XIKeihiPattern
{
	public String torihikicd;
	public String seikyuumoto;
	public String pattern;
	public String expcode08;
	public String expname08;
	public String expcode10;
	public String expname10;

	public XIKeihiPattern()
	{
		torihikicd = "";
		seikyuumoto = "";
		pattern = "";
		expcode08 = "";
		expname08 = "";
		expcode10 = "";
		expname10 = "";
	}

	public String getTorihikisakiCode()
	{
		return( torihikicd );
	}

	public String getSeikyuumoto()
	{
		return( seikyuumoto );
	}

	public String getExpenseTypePattern()
	{
		return( pattern );
	}

	public String getExpenseTypeCode08()
	{
		return( expcode08 );
	}

	public String getExpenseTypeName08()
	{
		return( expname08 );
	}

	public String getExpenseTypeCode10()
	{
		return( expcode10 );
	}

	public String getExpenseTypeName10()
	{
		return( expname10 );
	}

	public void setTorihikisakiCode( String arg )
	{
		torihikicd = arg;
	}

	public void setSeikyuumoto( String arg )
	{
		seikyuumoto = arg;
	}

	public void setExpenseTypePattern( String arg )
	{
		pattern = arg;
	}

	public void setExpenseTypeCode08( String arg )
	{
		expcode08 = arg;
	}

	public void setExpenseTypeName08( String arg )
	{
		expname08 = arg;
	}

	public void setExpenseTypeCode10( String arg )
	{
		expcode10 = arg;
	}

	public void setExpenseTypeName10( String arg )
	{
		expname10 = arg;
	}

}
