package xinvoice;

public class XICCAPIAccess
{
	public String host;
	XIHttpConnect con;

	public XICCAPIAccess( String url , String method ) throws Exception
	{
		XICCTokenResponse xitr = XICCTokenResponseAcc.getTokenResponse();
		String host = xitr.getGeolocation() + url;
		con = new XIHttpConnect( host );
		con.setRequestMethod( method );
		String accept = "application/json";
		con.setHeaderProperty("Accept", accept );
		String token = "Bearer " + xitr.getAccessToken();
		con.setHeaderProperty( "Authorization", token );
		String content = "application/json; charset=utf-8";
		con.setHeaderProperty( "Content-Type", content );

	}

	public void setRequest( String req )
	{
		con.setRequestBody( req );
	}

	public String connect() throws Exception
	{
		String resp = con.connect();
		return( resp );
	}

	public String submit() throws Exception
	{
		String resp = con.submit();
		return( resp );
	}

	public  int getResopnseCode() throws Exception
	{
		return( con.getResponseCode() );
	}

	public  String getResponseMessage() throws Exception
	{
		return( con.getResponseMessage() );
	}

	public void close()
	{
		con.disconnect();
	}
}
