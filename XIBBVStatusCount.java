package xinvoice;

public class XIBBVStatusCount
{
	public String status;
	public int cnt;

	public XIBBVStatusCount()
	{
		status = "";
	}

	public String getStatus()
	{
		return( status );
	}

	public int getCount()
	{
		return( cnt );
	}

	public void setStatus( String arg )
	{
		status = arg;
	}

	public void setCount( int arg )
	{
		cnt = arg;
	}
}
