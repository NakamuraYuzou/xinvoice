package xinvoice;

public class XICCListItems
{
	public XICCListItem[] Items;
	public String NextPage;

	public XICCListItems()
	{
		NextPage = "";
	}

	public XICCListItem[] getItems()
	{
		return( Items );
	}

	public String getNextPage()
	{
		return( NextPage );
	}

	public void setItems( XICCListItem[] arg )
	{
		Items = arg;
	}

	public void setNextPage( String arg )
	{
		NextPage = arg;
	}
}
