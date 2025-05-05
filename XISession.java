package xinvoice;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class XISession
{
	public HttpServletRequest req;
	public HttpServletResponse res;
	public HttpSession sess;
	public String confstr;

	public XISession( HttpServletRequest arg1 , HttpServletResponse arg2 ) throws Exception
	{
		req = arg1;
		res = arg2;
		sess = req.getSession();
		confstr = "xinvoice";
	}

	public void clearSession()
	{
//セッションクリア
		Enumeration<String> en = sess.getAttributeNames();
		String ename;
		while( en.hasMoreElements() )
		{
			ename = en.nextElement();
			sess.removeAttribute( ename );
		}
	}

	public void setSession()
	{
		sess.setAttribute( "CONFSTR" , confstr );
	}

	public boolean confirmSession() throws Exception
	{
		boolean rc = true;
		sess = req.getSession();
		if ( sess == null )
		{
			rc = false;
			return( rc );
		}
		String wstr = (String) sess.getAttribute("CONFSTR");
		if ( wstr == null )
		{
			rc = false;
			return( rc );
		}
		if ( !wstr.equals( confstr ) )
		{
			rc = false;
			return( rc );
		}
		return( rc );
	}

	public String getListID()
	{
		String rc = (String) sess.getAttribute( "LISTID" );
		return( rc );
	}

	public String getListNo()
	{
		String rc = (String) sess.getAttribute( "LISTNO" );
		return( rc );
	}

	public String getListName()
	{
		String rc = (String) sess.getAttribute( "LISTNAME" );
		return( rc );
	}

	public String getLV1ID()
	{
		String rc = (String) sess.getAttribute( "LV1ID" );
		return( rc );
	}

	public String getLV1Name()
	{
		String rc = (String) sess.getAttribute( "LV1NAME" );
		return( rc );
	}

	public String getLV1Code()
	{
		String rc = (String) sess.getAttribute( "LV1CODE" );
		return( rc );
	}

	public String getLV2ID()
	{
		String rc = (String) sess.getAttribute( "LV2ID" );
		return( rc );
	}

	public String getLV2Name()
	{
		String rc = (String) sess.getAttribute( "LV2NAME" );
		return( rc );
	}

	public String getLV2Code()
	{
		String rc = (String) sess.getAttribute( "LV2CODE" );
		return( rc );
	}

	public String getLV3ID()
	{
		String rc = (String) sess.getAttribute( "LV3ID" );
		return( rc );
	}

	public String getLV3Name()
	{
		String rc = (String) sess.getAttribute( "LV3NAME" );
		return( rc );
	}

	public String getLV3Code()
	{
		String rc = (String) sess.getAttribute( "LV3CODE" );
		return( rc );
	}

	public String getLV4ID()
	{
		String rc = (String) sess.getAttribute( "LV4ID" );
		return( rc );
	}

	public String getLV4Name()
	{
		String rc = (String) sess.getAttribute( "LV4NAME" );
		return( rc );
	}

	public String getLV4Code()
	{
		String rc = (String) sess.getAttribute( "LV4CODE" );
		return( rc );
	}

	public void setListID( String arg )
	{
		sess.setAttribute( "LISTID" , arg );
	}

	public void setListNo( String arg )
	{
		sess.setAttribute( "LISTNO" , arg );
	}

	public void setListName( String arg )
	{
		sess.setAttribute( "LISTNAME" , arg );
	}

	public void setLV1ID( String arg )
	{
		sess.setAttribute( "LV1ID" , arg );
	}

	public void setLV1Name( String arg )
	{
		sess.setAttribute( "LV1NAME" , arg );
	}

	public void setLV1Code( String arg )
	{
		sess.setAttribute( "LV1CODE" , arg );
	}

	public void setLV2ID( String arg )
	{
		sess.setAttribute( "LV2ID" , arg );
	}

	public void setLV2Name( String arg )
	{
		sess.setAttribute( "LV2NAME" , arg );
	}

	public void setLV2Code( String arg )
	{
		sess.setAttribute( "LV2CODE" , arg );
	}

	public void setLV3ID( String arg )
	{
		sess.setAttribute( "LV3ID" , arg );
	}

	public void setLV3Name( String arg )
	{
		sess.setAttribute( "LV3NAME" , arg );
	}

	public void setLV3Code( String arg )
	{
		sess.setAttribute( "LV3CODE" , arg );
	}

	public void setLV4ID( String arg )
	{
		sess.setAttribute( "LV4ID" , arg );
	}

	public void setLV4Name( String arg )
	{
		sess.setAttribute( "LV4NAME" , arg );
	}

	public void setLV4Code( String arg )
	{
		sess.setAttribute( "LV4CODE" , arg );
	}
}
