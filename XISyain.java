package xinvoice;

public class XISyain
{
	public String syaincd;
	public String syainnm;
	public String busyonm;
	public String meado;

	public XISyain()
	{
		syaincd = "";
		syainnm = "";
		busyonm = "";
		meado = "";
	}

	public String getSyainCode()
	{
		return( syaincd );
	}

	public String getSyainName()
	{
		return( syainnm );
	}

	public String getBusyoName()
	{
		return( busyonm );
	}

	public String getMailAddress()
	{
		return( meado );
	}

	public void setSyainCode( String arg )
	{
		syaincd = arg;
	}

	public void setSyainName( String arg )
	{
		syainnm = arg;
	}

	public void setBusyoName( String arg )
	{
		busyonm = arg;
	}

	public void setMailAddress( String arg )
	{
		meado = arg;
	}

}
