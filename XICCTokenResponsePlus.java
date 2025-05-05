package xinvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XICCTokenResponsePlus
{
	public XICCTokenResponse eitr;
	public Date lastupdate;
	public Date expiration;
	public SimpleDateFormat sdf;

	public XICCTokenResponsePlus()
	{
		eitr = new XICCTokenResponse();
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	public XICCTokenResponse getXICCTokenResponse()
	{
		return( eitr );
	}

	public Date getLastUpdate()
	{
		return( lastupdate );
	}

	public String getLastUpdateStr()
	{
		String rc = "";
		if ( lastupdate != null ) rc = sdf.format( lastupdate );
		return( rc );
	}

	public Date getExpiration()
	{
		return( expiration );
	}

	public String getExpirationStr()
	{
		String rc = "";
		if ( expiration != null ) rc = sdf.format( expiration );
		return( rc );
	}

	public void setEICCTokenResponse( XICCTokenResponse arg )
	{
		eitr = arg;
	}

	public void setLastUpdate( Date arg )
	{
		lastupdate = arg;
	}

	public void setExpiration( Date arg )
	{
		expiration = arg;
	}

}
