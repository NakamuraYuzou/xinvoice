package xinvoice;

public class XICCList
{
	public long no;
	public String ListID;
	public String Name;

	public XICCList()
	{
		ListID = "";
		Name = "";
	}

	public long getNo()
	{
		return( no );
	}

	public String getListID()
	{
		return( ListID );
	}

	public String getName()
	{
		return( Name );
	}

	public void setNo( long arg )
	{
		no = arg;
	}

	public void setListID( String arg )
	{
		ListID = arg;
	}

	public void setName( String arg )
	{
		Name = arg;
	}
}
