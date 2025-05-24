package xinvoice;

import java.net.URLEncoder;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;

public class XICCTokenResponseAcc
{

	public static XICCTokenResponse getTokenResponse() throws Exception
	{
		XICCTokenResponsePlus xitrp = XICCTokenResponsePlusAcc.getFromDB();
		XICCTokenResponse xitr = xitrp.getXICCTokenResponse();
		Date now = new Date();
		Date exp = xitrp.getExpiration();
		if ( now.after( exp ) )
		{
			xitr = XICCTokenResponseAcc.getResponseFromApi( xitr );
			XICCTokenResponsePlusAcc.setToDB( xitr );
		}

		return( xitr );
	}

	public static String getJson( XICCTokenResponse arg ) throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy( PropertyNamingStrategies.SNAKE_CASE ) ;
		mapper.enable( SerializationFeature.INDENT_OUTPUT );
		String rc = mapper.writeValueAsString( arg );
		return( rc );
	}

	public static XICCTokenResponse getResponseFromJson( String jsonstr ) throws Exception
	{
		XICCTokenResponse rc = new XICCTokenResponse();
		ObjectMapper mapper = new ObjectMapper();
		rc = mapper.readValue( jsonstr , XICCTokenResponse.class );
		return( rc );
	}

	public static XICCTokenResponse getResponseFromApi( XICCTokenResponse oldtoken ) throws Exception
	{
		String client_id = URLEncoder.encode( "81aee099-f255-4814-87fb-1fc5aae102f6" , "utf-8" );
		String client_secret = URLEncoder.encode( "c9a67e10-9858-4893-b078-763afc3b85dc" , "utf-8" );

		String host = oldtoken.getGeolocation() + "/oauth2/v0/token";
		String reftoken = URLEncoder.encode( oldtoken.getRefreshToken() , "utf-8" );
		String scope = URLEncoder.encode( oldtoken.getScope() , "utf-8" );

		XIHttpConnect con = new XIHttpConnect( host );
		con.setRequestMethod("POST");
		String prm = "client_id=" + client_id
					+ "&client_secret=" + client_secret
					+ "&grant_type=refresh_token"
					+ "&refresh_token=" + reftoken
					+ "&scope=" + scope;
		con.setQueryString( prm );
		String resp = con.submit();
		con.disconnect();

		ObjectMapper mapper = new ObjectMapper();
		XICCTokenResponse rc = mapper.readValue( resp , XICCTokenResponse.class );
		return( rc );

	}

	public static XICCTokenResponse getInitialToken() throws Exception
	{
		String host = "https://us2.api.concursolutions.com/oauth2/v0/token";
		XIHttpConnect con = new XIHttpConnect( host );

		con.setRequestMethod("POST");
		String client_id = URLEncoder.encode( "xxxxxxxxxxxxxxx" , "utf-8" );
		String client_secret = URLEncoder.encode( "xxxxxxxxxxx" , "utf-8" );
		String username = URLEncoder.encode( "xxxxxxxxxxx" , "utf-8" );
		String password = URLEncoder.encode( "xxxxxxxxxxxxxxx" , "utf-8" );
		String prm = "client_id=" + client_id
					+ "&client_secret=" + client_secret
					+ "&grant_type=password"
					+ "&username=" + username
					+ "&password=" + password;
		con.setQueryString( prm );
		String resp = con.submit();
		con.disconnect();

		XICCTokenResponse rc = XICCTokenResponseAcc.getResponseFromJson( resp );
		return( rc );

	}
}
