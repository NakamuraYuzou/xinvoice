package xinvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XICCErrorLog
{
	public long no;
	public int code;
	public String msg;
	public String json;
	public Date stamp;
	public SimpleDateFormat sdf;

	public XICCErrorLog()
	{
		msg = "";
		json = "";
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
	}

	public long getNo()
	{
		return( no );
	}

	public int getCode()
	{
		return( code );
	}

	public String getMessage()
	{
		return( msg );
	}

	public String getJson()
	{
		return( json );
	}

	public Date getTimeStamp()
	{
		return( stamp );
	}

	public String getTimeStampStr()
	{
		String rc = "";
		if ( stamp != null ) rc = sdf.format( stamp );
		return( rc );
	}

	public void setNo( long arg )
	{
		no = arg;
	}

	public void setCode( int arg )
	{
		code = arg;
	}

	public void setMessage( String arg )
	{
		msg = arg;
	}

	public void setJson( String arg )
	{
		json = arg;
	}

	public void setTimeStamp( Date arg )
	{
		stamp = arg;
	}
}
