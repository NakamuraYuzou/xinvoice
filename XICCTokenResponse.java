package xinvoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties( ignoreUnknown = true )
public class XICCTokenResponse
{
	public String expires_in;
	public String scope;
	public String token_type;
	public String access_token;
	public String refresh_token;
	public String refresh_expires_in;
	public String id_token;
	public String geolocation;

	public XICCTokenResponse()
	{
		expires_in = "";
		scope = "";
		token_type = "";
		access_token = "";
		refresh_token = "";
		refresh_expires_in = "";
		id_token = "";
		geolocation = "";
	}

	public String getExpiresIn()
	{
		return( expires_in );
	}

	public String getScope()
	{
		return( scope );
	}

	public String getTokenType()
	{
		return( token_type );
	}

	public String getAccessToken()
	{
		return( access_token );
	}

	public String getRefreshToken()
	{
		return( refresh_token );
	}

	public String getRefreshExpiresIn()
	{
		return( refresh_expires_in );
	}

	public String getIdToken()
	{
		return( id_token );
	}

	public String getGeolocation()
	{
		return( geolocation );
	}

	public void setExpiresIn( String arg )
	{
		expires_in = arg;
	}

	public void setScope( String arg )
	{
		scope = arg;
	}

	public void setTokenType( String arg )
	{
		token_type = arg;
	}

	public void setAccessToken( String arg )
	{
		access_token = arg;
	}

	public void setRefreshToken( String arg )
	{
		refresh_token = arg;
	}

	public void setRefreshExpiresIn( String arg )
	{
		refresh_expires_in = arg;
	}

	public void setIdToken( String arg )
	{
		id_token = arg;
	}

	public void setGeolocation( String arg )
	{
		geolocation = arg;
	}

}
