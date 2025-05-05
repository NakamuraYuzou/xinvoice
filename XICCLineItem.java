package xinvoice;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude( JsonInclude.Include.NON_NULL )
public class XICCLineItem
{
	public XICCAllocation[] Allocations;
	public String Custom1;
	public String Custom2;
	public String Custom3;
	public String Custom4;
	public String Custom5;
	public String Custom7;
	public String Description;
	public String ExpenseTypeCode;
	public String Quantity;
	public String UnitPrice;

	public XICCLineItem()
	{
		Custom1 = "SADENKO";
		Custom2 = "01";			//費用区分
		Custom3 = "";			//部署コード
		Custom4 = "";			//工事コード
		Custom5 = "";			//工事詳細コード
		Custom7 = "";			//給与相殺
		Description = "";
		ExpenseTypeCode = "";
		Quantity = "";
		UnitPrice = "";
	}

	public XICCAllocation[] getAllocations()
	{
		return( Allocations );
	}

	public String getCustom1()
	{
		return( Custom1 );
	}

	public String getCustom2()
	{
		return( Custom2 );
	}

	public String getCustom3()
	{
		return( Custom3 );
	}

	public String getCustom4()
	{
		return( Custom4 );
	}

	public String getCustom5()
	{
		return( Custom5 );
	}

	public String getCustom7()
	{
		return( Custom7 );
	}


	public String getDescription()
	{
		return( Description );
	}

	public String getExpenseTypeCode()
	{
		return( ExpenseTypeCode );
	}

	public String getQuantity()
	{
		return( Quantity );
	}

	public String getUnitPrice()
	{
		return( UnitPrice );
	}

	public void setAllocations( XICCAllocation[] arg )
	{
		Allocations = arg;
	}

	public void setCustom1( String arg )
	{
		Custom1 = arg;
	}

	public void setCustom2( String arg )
	{
		Custom2 = arg;
	}

	public void setCustom3( String arg )
	{
		Custom3 = arg;
	}

	public void setCustom4( String arg )
	{
		Custom4 = arg;
	}

	public void setCustom5( String arg )
	{
		Custom5 = arg;
	}

	public void setCustom7( String arg )
	{
		Custom7 = arg;
	}

	public void setDescription( String arg )
	{
		Description = arg;
	}

	public void setExpenseTypeCode( String arg )
	{
		ExpenseTypeCode = arg;
	}

	public void setQuantity( String arg )
	{
		Quantity = arg;
	}

	public void setTaxCode( String arg )
	{
		Quantity = arg;
	}

	public void setTotalPrice( String arg )
	{
		Quantity = arg;
	}
	public void setUnitPrice( String arg )
	{
		UnitPrice = arg;
	}

}
