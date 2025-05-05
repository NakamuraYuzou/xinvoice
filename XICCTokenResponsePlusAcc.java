package xinvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XICCTokenResponsePlusAcc
{
	public static XICCTokenResponsePlus getFromDB() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT * FROM 【XI】CCTokenResponse";
		xidb.setSQL( sqlstr );
		xidb.getRow();

		XICCTokenResponse xitr = new XICCTokenResponse();
		xitr.setExpiresIn( xidb.getClmn("expires_in") );
		xitr.setScope( xidb.getClmn("scope") );
		xitr.setTokenType( xidb.getClmn("token_type") );
		xitr.setAccessToken( xidb.getClmn("access_token") );
		xitr.setRefreshToken( xidb.getClmn("refresh_token") );
		xitr.setRefreshExpiresIn( xidb.getClmn("refresh_expires_in") );
		xitr.setIdToken( xidb.getClmn("id_token") );
		xitr.setGeolocation( xidb.getClmn("geolocation") );

		XICCTokenResponsePlus rc = new XICCTokenResponsePlus();
		rc.setEICCTokenResponse( xitr );
		rc.setLastUpdate( xidb.getClmnAsDate("最終更新") );
		rc.setExpiration( xidb.getClmnAsDate("有効期限") );

		return( rc );
	}

	public static void setToDB( XICCTokenResponse xitr ) throws Exception
	{
		String expires_in = xitr.getExpiresIn();
		String scope = xitr.getScope();
		String token_type = xitr.getTokenType();
		String access_token = xitr.getAccessToken();
		String refresh_token = xitr.getRefreshToken();
		String refresh_expires_in = xitr.getRefreshExpiresIn();
		String id_token = xitr.getIdToken();
		String geolocation = xitr.getGeolocation();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date last = new Date();
		long lexp = last.getTime() + 3000000;
		Date exp = new Date( lexp );
		String laststr = sdf.format( last );
		String expstr = sdf.format( exp );

		String tblnm = "【XI】CCTokenResponse";
		String[] fldtbl = { "expires_in" , "scope" , "token_type" , "access_token" ,
							"refresh_token" , "refresh_expires_in" , "id_token" , "geolocation" ,
							"最終更新" , "有効期限" };
		String[] vltbl = new String[10];
		vltbl[0] = "'" + expires_in + "'";
		vltbl[1] = "'" + scope + "'";
		vltbl[2] = "'" + token_type + "'";
		vltbl[3] = "'" + access_token + "'";
		vltbl[4] = "'" + refresh_token + "'";
		vltbl[5] = "'" + refresh_expires_in + "'";
		vltbl[6] = "'" + id_token + "'";
		vltbl[7] = "'" + geolocation + "'";
		vltbl[8] = "'" + laststr + "'";
		vltbl[9] = "'" + expstr + "'";

		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE " + tblnm;
		xidb.setUpdate( sqlstr );
		xidb.insert(tblnm, fldtbl, vltbl);
		xidb.close();

	}

}
