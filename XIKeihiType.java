package xinvoice;

public class XIKeihiType
{
	public String expcode;
	public String expname;

	public XIKeihiType()
	{
		expcode = "";
		expname = "";
	}

	public String getExpenseTypeCode()
	{
		return( expcode );
	}

	public String getExpenseTypeName()
	{
		return( expname );
	}

	public void setExpenseTypeCode( String arg )
	{
		expcode = arg;
	}

	public void setExpenseTypeName( String arg )
	{
		expname = arg;
	}
}
