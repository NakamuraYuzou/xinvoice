package xinvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XIBBTorikomiRireki
{
	public long no;
	public Date opdate;
	public String filename;
	public long kensuu;
	public SimpleDateFormat sdf;

	public XIBBTorikomiRireki()
	{
		filename = "";
		sdf = new SimpleDateFormat("yyyy/M/d H:mm:ss.SSS");
	}

	public long getNo()
	{
		return( no );
	}

	public Date getOperationDate()
	{
		return( opdate );
	}

	public String getOperationDateStr()
	{
		String rc = "";
		if ( opdate != null )
		{
			rc = sdf.format( opdate );
		}
		return( rc );
	}

	public String getFileName()
	{
		return( filename );
	}

	public long getKensuu()
	{
		return( kensuu );
	}

	public void setNo( long arg )
	{
		no = arg;
	}

	public void setOperationDate( Date arg )
	{
		opdate = arg;
	}

	public void setFileName( String arg )
	{
		filename = arg;
	}

	public void setKensuu( long arg )
	{
		kensuu = arg;
	}

}
