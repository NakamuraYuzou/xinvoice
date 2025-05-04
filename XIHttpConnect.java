package xinvoice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class XIHttpConnect
{
	public URL url;
	public HttpURLConnection con;
	public InputStream is;
	public InputStreamReader isr;
	public OutputStream os;
	public OutputStreamWriter osw;
	public BufferedReader br;
	public BufferedWriter bw;

	public String body;

	public XIHttpConnect( String host ) throws Exception
	{
		body = "";

		url = new URL( host );
		con = ( HttpURLConnection ) url.openConnection();
		con.setDoOutput( true );
	}

	public void setRequestMethod( String method ) throws Exception
	{
		con.setRequestMethod( method );
	}

	public void setRequestBody( String arg )
	{
		body = arg;
	}

	public void setQueryString( String arg )
	{
		body = arg;
	}

	public void setHeaderProperty( String key , String value ) throws Exception
	{
		con.setRequestProperty( key , value );
	}

	public String getHeaderString() throws Exception
	{
		Map headers = con.getHeaderFields();
		Iterator headerIt = headers.keySet().iterator();
		String header = null;
		while(headerIt.hasNext())
		{
			String headerKey = (String)headerIt.next();
			header += headerKey + " F" + headers.get(headerKey) + "\r\n";
		}

		header = con.getHeaderField(0) + "\n" + header;

		return(header);
	}

	public int getResponseCode() throws Exception
	{
		return( con.getResponseCode() );
	}

	public String getResponseMessage() throws Exception
	{
		return( con.getResponseMessage() );
	}

	public String connect() throws Exception
	{
		con.connect();

		String rc = "";
		int code = con.getResponseCode();
		if ( code == 200 )
		{
			is = con.getInputStream();
		}
		else
		{
			is = con.getErrorStream();
		}

		if ( is != null )
		{
			isr = new InputStreamReader( is , "UTF-8" );
			br = new BufferedReader( isr );
			String line;

			StringBuffer buf = new StringBuffer();
			while( ( line = br.readLine() ) != null )
			{
				buf.append( line );
			}
			br.close();
			isr.close();
			is.close();

			rc = buf.toString();
		}
		return( rc );
	}

	public String submit() throws Exception
	{
		os = con.getOutputStream();
		osw = new OutputStreamWriter( os , "UTF-8" );
		bw = new BufferedWriter( osw );
		bw.write( body );
		bw.flush();
		bw.close();
		os.close();

		String rc = "";
		int code = con.getResponseCode();
		if ( code == 200 )
		{
			is = con.getInputStream();
		}
		else
		{
			is = con.getErrorStream();
		}

		if ( is != null )
		{
			StringBuffer buf = new StringBuffer();
			isr = new InputStreamReader( is , "UTF-8" );
			br = new BufferedReader( isr );
			String line;
			while( ( line = br.readLine() ) != null )
			{
				buf.append( line );
			}
			br.close();
			isr.close();
			is.close();

			rc = buf.toString();
		}
		return( rc );
	}

	public void disconnect()
	{
		con.disconnect();
	}
}
