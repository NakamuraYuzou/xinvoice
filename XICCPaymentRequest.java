package xinvoice;

public class XICCPaymentRequest
{
	public String CountryCode;
	public String CurrencyCode;
	public String InvoiceAmount;
	public String Name;
	public String Description;
	public String InvoiceDate;
	public String PaymentDueDate;
	public String InvoiceNumber;
	public String Custom9;
	public String Custom11;
	public String Custom12;
	public String EmployeeLoginId;
	public String ExternalPolicyId;
	public String LedgerCode;
	public String CreatedByUsername;
	public XICCVendorRemitToIdentifier VendorRemitToIdentifier;
	public XICCLineItem[] LineItems;

	public XICCPaymentRequest()
	{
		CountryCode = "JP";
		CurrencyCode = "JPY";
		InvoiceAmount = "";
		Name = "";
		Description = "";
		InvoiceDate = "";
		PaymentDueDate = "";
		InvoiceNumber = "";
		Custom9 = "100";		//現金比率　100%
		Custom11 = "01";		//支払方法　定時払い
		Custom12 = "03";		//入金元分類　BtoB
		EmployeeLoginId = "";
//		ExternalPolicyId = "E62714487C394CBD970E";
		ExternalPolicyId = "C30FA6F078F84AFF9396";
		LedgerCode = "SADENKO";
		CreatedByUsername = "";
	}

	public String getCountryCode()
	{
		return( CountryCode );
	}

	public String getCurrencyCode()
	{
		return( CurrencyCode );
	}

	public String getInvoiceAmount()
	{
		return( InvoiceAmount );
	}

	public String getName()
	{
		return( Name );
	}

	public String getDescription()
	{
		return( Description );
	}

	public String getInvoiceDate()
	{
		return( InvoiceDate );
	}

	public String getPaymentDueDate()
	{
		return( PaymentDueDate );
	}

	public String getInvoiceNumber()
	{
		return( InvoiceNumber );
	}

	public String getCustom9()
	{
		return( Custom9 );
	}

	public String getCustom11()
	{
		return( Custom11 );
	}

	public String getCustom12()
	{
		return( Custom12 );
	}

	public String getEmployeeLoginId()
	{
		return( EmployeeLoginId );
	}

	public String ExternalPolicyId()
	{
		return( ExternalPolicyId );
	}

	public String getLedgerCode()
	{
		return( LedgerCode );
	}

	public String getCreatedByUsername()
	{
		return( CreatedByUsername );
	}

	public XICCVendorRemitToIdentifier getVendorRemitToIdentifier()
	{
		return( VendorRemitToIdentifier );
	}

	public XICCLineItem[] getLinItems()
	{
		return( LineItems );
	}

	public void setCountrycode( String arg )
	{
		CountryCode = arg;
	}

	public void setCurrencyCode( String arg )
	{
		CurrencyCode = arg;
	}

	public void setInvoiceAmount( String arg )
	{
		InvoiceAmount = arg;
	}

	public void setName( String arg )
	{
		Name = arg;
	}

	public void setDescription( String arg )
	{
		Description = arg;
	}

	public void setInvoiceDate( String arg )
	{
		InvoiceDate = arg;
	}

	public void setPaymentDueDate( String arg )
	{
		PaymentDueDate = arg;
	}

	public void setInvoiceNumber( String arg )
	{
		InvoiceNumber = arg;
	}

	public void setCustom9( String arg )
	{
		Custom9 = arg;
	}

	public void setCustom11( String arg )
	{
		Custom11 = arg;
	}

	public void setCustom12( String arg )
	{
		Custom12 = arg;
	}

	public void setEmployeeLoginId( String arg )
	{
		EmployeeLoginId = arg;
	}

	public void setExternalPolicyId( String arg )
	{
		ExternalPolicyId = arg;
	}

	public void setLedgerCode( String arg )
	{
		LedgerCode = arg;
	}

	public void setCreatedByUsername( String arg )
	{
		CreatedByUsername = arg;
	}

	public void setVendorRemitToIdetifier( XICCVendorRemitToIdentifier arg )
	{
		VendorRemitToIdentifier = arg;
	}

	public void setLineItems( XICCLineItem[] arg )
	{
		LineItems = arg;
	}

}
