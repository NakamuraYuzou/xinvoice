package xinvoice;

import java.util.Date;

public class XIBBCsv
{
	public Date order_date;
	public Date remind_date;
	public long invoice_mng_num;
	public Date send_date;
	public Date close_date;
	public Date pay_due_date_s;
	public Date pay_due_date;
	public String customer_code1;
	public String customer_code2;
	public String private_cust_cd_s;
	public String private_cust_cd_b;
	public String destination_code;
	public String destination_name;
	public String inv_no;
	public String inv_name;
	public long inv_without_tax;
	public long inv_tax;
	public long inv_amount;
	public long inv_show_amount;
	public String remarks;
	public String inv_free_txt_title1;
	public String inv_free_txt1;
	public String inv_free_txt_title2;
	public String inv_free_txt2;
	public String inv_free_txt_title3;
	public String inv_free_txt3;
	public String inv_free_num_title1;
	public long inv_free_txt4;
	public String inv_free_num_title2;
	public long inv_free_txt5;
	public String inv_free_num_title3;
	public long inv_free_txt6;
	public String inv_free_num_title4;
	public long inv_free_txt7;
	public String inv_free_num_title5;
	public String inv_free_num_title6;
	public String inv_free_num_title7;
	public String inv_op_free_txt_title1;
	public String inv_op_free_txt1;
	public String inv_op_free_txt_title2;
	public String inv_op_free_txt2;
	public String inv_op_free_txt_title3;
	public String inv_op_free_txt3;
	public String inv_op_free_txt_title4;
	public String inv_op_free_txt4;
	public String inv_op_free_txt_title5;
	public String inv_op_free_txt5;
	public String inv_op_free_txt_title6;
	public String inv_op_free_txt6;
	public String inv_op_free_txt_title7;
	public String inv_op_free_txt7;
	public String inv_op_free_txt_title8;
	public String inv_op_free_txt8;
	public String inv_op_free_txt_title9;
	public String inv_op_free_txt9;
	public String inv_op_free_txt_title10;
	public String inv_op_free_txt10;
	public String inv_op_free_txt_title11;
	public String inv_op_free_txt11;
	public String inv_op_free_txt_title12;
	public String inv_op_free_txt12;
	public String item_slip_date;
	public String item_slip_no;
	public String item_prod_code;
	public long item_price;
	public String item_unit;
	public long item_qty;
	public String tax_free;
	public String tax_rate;
	public long item_without_tax;
	public long item_tax;
	public long item_amount;
	public String item_sec_code;
	public String item_sec_name;
	public String detail_remarks;
	public String item_free_txt_title1;
	public String item_free_txt1;
	public String item_free_txt_title2;
	public String item_free_txt2;
	public String item_free_txt_title3;
	public String item_free_txt3;
	public String item_free_txt_title4;
	public String item_free_txt4;
	public String item_free_txt_title5;
	public String item_free_txt5;
	public String item_free_txt_title6;
	public String item_free_txt6;
	public String item_free_txt_title7;
	public String item_free_txt7;
	public String item_free_txt_title8;
	public String item_free_txt8;
	public String item_free_txt_title9;
	public String item_free_txt9;
	public String item_free_txt_title10;
	public String item_free_txt10;
	public String item_free_txt_l_title;
	public String item_free_txt_l;
	public String item_memo1;
	public String item_memo2;
	public String detail_summary;
	public int detail_seq;
	public String status;
	public String chk_ptn;
	public String meisai_ptn;
	public long kenmei_no;
	public long meisai_no;
	public int rireki_no;

	public XIBBCsv()
	{
		customer_code1 = "";
		customer_code2 = "";
		private_cust_cd_s = "";
		private_cust_cd_b = "";
		destination_code = "";
		destination_name = "";
		inv_no = "";
		inv_name = "";
		remarks = "";
		inv_free_txt_title1 = "";
		inv_free_txt1 = "";
		inv_free_txt_title2 = "";
		inv_free_txt2 = "";
		inv_free_txt_title3 = "";
		inv_free_txt3 = "";
		inv_free_num_title1 = "";
		inv_free_num_title2 = "";
		inv_free_num_title3 = "";
		inv_free_num_title4 = "";
		inv_free_num_title5 = "";
		inv_free_num_title6 = "";
		inv_free_num_title7 = "";
		inv_op_free_txt_title1 = "";
		inv_op_free_txt1 = "";
		inv_op_free_txt_title2 = "";
		inv_op_free_txt2 = "";
		inv_op_free_txt_title3 = "";
		inv_op_free_txt3 = "";
		inv_op_free_txt_title4 = "";
		inv_op_free_txt4 = "";
		inv_op_free_txt_title5 = "";
		inv_op_free_txt5 = "";
		inv_op_free_txt_title6 = "";
		inv_op_free_txt6 = "";
		inv_op_free_txt_title7 = "";
		inv_op_free_txt7 = "";
		inv_op_free_txt_title8 = "";
		inv_op_free_txt8 = "";
		inv_op_free_txt_title9 = "";
		inv_op_free_txt9 = "";
		inv_op_free_txt_title10 = "";
		inv_op_free_txt10 = "";
		inv_op_free_txt_title11 = "";
		inv_op_free_txt11 = "";
		inv_op_free_txt_title12 = "";
		inv_op_free_txt12 = "";
		item_slip_date = "";
		item_slip_no = "";
		item_prod_code = "";
		item_unit = "";
		tax_free = "";
		item_sec_code = "";
		item_sec_name = "";
		detail_remarks = "";
		item_free_txt_title1 = "";
		item_free_txt1 = "";
		item_free_txt_title2 = "";
		item_free_txt2 = "";
		item_free_txt_title3 = "";
		item_free_txt3 = "";
		item_free_txt_title4 = "";
		item_free_txt4 = "";
		item_free_txt_title5 = "";
		item_free_txt5 = "";
		item_free_txt_title6 = "";
		item_free_txt6 = "";
		item_free_txt_title7 = "";
		item_free_txt7 = "";
		item_free_txt_title8 = "";
		item_free_txt8 = "";
		item_free_txt_title9 = "";
		item_free_txt9 = "";
		item_free_txt_title10 = "";
		item_free_txt10 = "";
		item_free_txt_l_title = "";
		item_free_txt_l = "";
		item_memo1 = "";
		item_memo2 = "";
		detail_summary = "";
		chk_ptn = "";
		meisai_ptn = "";
	}

	public Date getOrderDate()
	{
	return( order_date );
	}

	public Date getRemindDate()
	{
		return( remind_date );
	}

	public long getInvoiceMngNum()
	{
		return( invoice_mng_num );
	}

	public Date getSendDate()
	{
		return( send_date );
	}

	public Date getCloseDate()
	{
		return( close_date );
	}

	public Date getPayDueDateS()
	{
		return( pay_due_date_s );
	}

	public Date getPayDueDate()
	{
		return( pay_due_date );
	}

	public String getCustomerCode1()
	{
		return( customer_code1 );
	}

	public String getCustomerCode2()
	{
		return( customer_code2 );
	}

	public String getPrivateCustCdS()
	{
		return( private_cust_cd_s );
	}

	public String getPrivateCustCdB()
	{
		return( private_cust_cd_b );
	}

	public String getDestinationCode()
	{
		return( destination_code );
	}

	public String getDestinationName()
	{
		return( destination_name );
	}

	public String getInvNo()
	{
		return( inv_no );
	}

	public String getInvName()
	{
		return( inv_name );
	}

	public long getInvWithoutTax()
	{
		return( inv_without_tax );
	}

	public long getInvTax()
	{
		return( inv_tax );
	}

	public long getInvAmount()
	{
		return( inv_amount );
	}

	public long getInvShowAmount()
	{
		return( inv_show_amount );
	}

	public String getRemarks()
	{
		return( remarks );
	}

	public String getInvFreeTxtTitle1()
	{
		return( inv_free_txt_title1 );
	}

	public String getInvFreeTxt1()
	{
		return( inv_free_txt1 );
	}

	public String getInvFreeTxtTitle2()
	{
		return( inv_free_txt_title2 );
	}

	public String getInvFreeTxt2()
	{
		return( inv_free_txt2 );
	}

	public String getInvFreeTxtTitle3()
	{
		return( inv_free_txt_title3 );
	}

	public String getInvFreeTxt3()
	{
		return( inv_free_txt3 );
	}

	public String getInvFreeNumTitle1()
	{
		return( inv_free_num_title1 );
	}

	public long getInvFreeTxt4()
	{
		return( inv_free_txt4 );
	}

	public String getInvFreeNumTitle2()
	{
		return( inv_free_num_title2 );
	}

	public long getInvFreeTxt5()
	{
		return( inv_free_txt5 );
	}

	public String getInvFreeNumTitle3()
	{
		return( inv_free_num_title3 );
	}

	public long getInvFreeTxt6()
	{
		return( inv_free_txt6 );
	}

	public String getInvFreeNumTitle4()
	{
		return( inv_free_num_title4 );
	}

	public long getInvFreeTxt7()
	{
		return( inv_free_txt7 );
	}

	public String getInvFreeNumTitle5()
	{
		return( inv_free_num_title5 );
	}

	public String getInvFreeNumTitle6()
	{
		return( inv_free_num_title6 );
	}

	public String getInvFreeNumTitle7()
	{
		return( inv_free_num_title7 );
	}

	public String getInvOpFreeTxtTitle1()
	{
		return( inv_op_free_txt_title1 );
	}

	public String getInvOpFreeTxt1()
	{
		return( inv_op_free_txt1 );
	}

	public String getInvOpFreeTxtTitle2()
	{
		return( inv_op_free_txt_title2 );
	}

	public String getInvOpFreeTxt2()
	{
		return( inv_op_free_txt2 );
	}

	public String getInvOpFreeTxtTitle3()
	{
		return( inv_op_free_txt_title3 );
	}

	public String getInvOpFreeTxt3()
	{
		return( inv_op_free_txt3 );
	}

	public String getInvOpFreeTxtTitle4()
	{
		return( inv_op_free_txt_title4 );
	}

	public String getInvOpFreeTxt4()
	{
	return( inv_op_free_txt4 );
	}

	public String getInvOpFreeTxtTitle5()
	{
		return( inv_op_free_txt_title5 );
	}

	public String getInvOpFreeTxt5()
	{
		return( inv_op_free_txt5 );
	}

	public String getInvOpFreeTxtTitle6()
	{
		return( inv_op_free_txt_title6 );
	}

	public String getInvOpFreeTxt6()
	{
		return( inv_op_free_txt6 );
	}

	public String getInvOpFreeTxtTitle7()
	{
		return( inv_op_free_txt_title7 );
	}

	public String getInvOpFreeTxt7()
	{
		return( inv_op_free_txt7 );
	}

	public String getInvOpFreeTxtTitle8()
	{
		return( inv_op_free_txt_title8 );
	}

	public String getInvOpFreeTxt8()
	{
		return( inv_op_free_txt8 );
	}

	public String getInvOpFreeTxtTitle9()
	{
		return( inv_op_free_txt_title9 );
	}

	public String getInvOpFreeTxt9()
	{
		return( inv_op_free_txt9 );
	}

	public String getInvOpFreeTxtTitle10()
	{
		return( inv_op_free_txt_title10 );
	}

	public String getInvOpFreeTxt10()
	{
		return( inv_op_free_txt10 );
	}

	public String getInvOpFreeTxtTitle11()
	{
		return( inv_op_free_txt_title11 );
	}

	public String getInvOpFreeTxt11()
	{
		return( inv_op_free_txt11 );
	}

	public String getInvOpFreeTxtTitle12()
	{
		return( inv_op_free_txt_title12 );
	}

	public String getInvOpFreeTxt12()
	{
		return( inv_op_free_txt12 );
	}

	public String getItemSlipDate()
	{
		return( item_slip_date );
	}

	public String getItemSlipNo()
	{
		return( item_slip_no );
	}

	public String getItemProdCode()
	{
		return( item_prod_code );
	}

	public long getItemPrice()
	{
		return( item_price );
	}

	public String getItemUnit()
	{
		return( item_unit );
	}

	public long getItemQty()
	{
		return( item_qty );
	}

	public String getTaxFree()
	{
		return( tax_free );
	}

	public String getTaxRate()
	{
		return( tax_rate );
	}

	public long getItemWithoutTax()
	{
		return( item_without_tax );
	}

	public long getItemTax()
	{
		return( item_tax );
	}

	public long getItemAmount()
	{
		return( item_amount );
	}

	public String getItemSecCode()
	{
		return( item_sec_code );
	}

	public String getItemSecName()
	{
		return( item_sec_name );
	}

	public String getDetailRemarks()
	{
		return( detail_remarks );
	}

	public String getItemFreeTxtTitle1()
	{
		return( item_free_txt_title1 );
	}

	public String getItemFreeTxt1()
	{
		return( item_free_txt1 );
	}

	public String getItemFreeTxtTitle2()
	{
		return( item_free_txt_title2 );
	}

	public String getItemFreeTxt2()
	{
		return( item_free_txt2 );
	}

	public String getItemFreeTxtTitle3()
	{
		return( item_free_txt_title3 );
	}

	public String getItemFreeTxt3()
	{
		return( item_free_txt3 );
	}

	public String getItemFreeTxtTitle4()
	{
		return( item_free_txt_title4 );
	}

	public String getItemFreeTxt4()
	{
		return( item_free_txt4 );
	}

	public String getItemFreeTxtTitle5()
	{
		return( item_free_txt_title5 );
	}

	public String getItemFreeTxt5()
	{
		return( item_free_txt5 );
	}

	public String getItemFreeTxtTitle6()
	{
		return( item_free_txt_title6 );
	}

	public String getItemFreeTxt6()
	{
		return( item_free_txt6 );
	}

	public String getItemFreeTxtTitle7()
	{
		return( item_free_txt_title7 );
	}

	public String getItemFreeTxt7()
	{
		return( item_free_txt7 );
	}

	public String getItemFreeTxtTitle8()
	{
		return( item_free_txt_title8 );
	}

	public String getItemFreeTxt8()
	{
		return( item_free_txt8 );
	}

	public String getItemFreeTxtTitle9()
	{
		return( item_free_txt_title9 );
	}

	public String getItemFreeTxt9()
	{
		return( item_free_txt9 );
	}

	public String getItemFreeTxtTitle10()
	{
		return( item_free_txt_title10 );
	}

	public String getItemFreeTxt10()
	{
		return( item_free_txt10 );
	}

	public String getItemFreeTxtLTitle()
	{
		return( item_free_txt_l_title );
	}

	public String getItemFreeTxtL()
	{
		return( item_free_txt_l );
	}

	public String getItemMemo1()
	{
		return( item_memo1 );
	}

	public String getItemMemo2()
	{
		return( item_memo2 );
	}

	public String getDetailSummary()
	{
		return( detail_summary );
	}

	public int getDetailSeq()
	{
		return( detail_seq );
	}

	public String getStatus()
	{
		return( status );
	}

	public String getCheckPattern()
	{
		return( chk_ptn );
	}

	public String getMeisaiPattern()
	{
		return( meisai_ptn );
	}

	public long getKenmeiNo()
	{
		return( kenmei_no );
	}

	public long getmeisaiNo()
	{
		return( meisai_no );
	}

	public int getRirekiNo()
	{
		return( rireki_no );
	}

	public void setOrderDate( Date arg )
	{
		order_date = arg;
	}

	public void setRemindDate( Date arg )
	{
		remind_date = arg;
	}

	public void setInvoiceMngNum( long arg )
	{
		invoice_mng_num = arg;
	}

	public void setSendDate( Date arg )
	{
		send_date = arg;
	}

	public void setCloseDate( Date arg )
	{
		close_date = arg;
	}

	public void setPayDueDateS( Date arg )
	{
		pay_due_date_s = arg;
	}

	public void setPayDueDate( Date arg )
	{
		pay_due_date = arg;
	}

	public void setCustomerCode1( String arg )
	{
		customer_code1 = arg;
	}

	public void setCustomerCode2( String arg )
	{
		customer_code2 = arg;
	}

	public void setPrivateCustCdS( String arg )
	{
		private_cust_cd_s = arg;
	}

	public void setPrivateCustCdB( String arg )
	{
		private_cust_cd_b = arg;
	}

	public void setDestinationCode( String arg )
	{
		destination_code = arg;
	}

	public void setDestinationName( String arg )
	{
		destination_name = arg;
	}

	public void setInvNo( String arg )
	{
		inv_no = arg;
	}

	public void setInvName( String arg )
	{
		inv_name = arg;
	}

	public void setInvWithoutTax( long arg )
	{
		inv_without_tax = arg;
	}

	public void setInvTax( long arg )
	{
		inv_tax = arg;
	}

	public void setInvAmount( long arg )
	{
		inv_amount = arg;
	}

	public void setInvShowAmount( long arg )
	{
		inv_show_amount = arg;
	}

	public void setRemarks( String arg )
	{
		remarks = arg;
	}

	public void setInvFreeTxtTitle1( String arg )
	{
		inv_free_txt_title1 = arg;
	}

	public void setInvFreeTxt1( String arg )
	{
		inv_free_txt1 = arg;
	}

	public void setInvFreeTxtTitle2( String arg )
	{
		inv_free_txt_title2 = arg;
	}

	public void setInvFreeTxt2( String arg )
	{
		inv_free_txt2 = arg;
	}

	public void setInvFreeTxtTitle3( String arg )
	{
		inv_free_txt_title3 = arg;
	}

	public void setInvFreeTxt3( String arg )
	{
		inv_free_txt3 = arg;
	}

	public void setInvFreeNumTitle1( String arg )
	{
		inv_free_num_title1 = arg;
	}

	public void setInvFreeTxt4( long arg )
	{
		inv_free_txt4 = arg;
	}

	public void setInvFreeNumTitle2( String arg )
	{
		inv_free_num_title2 = arg;
	}

	public void setInvFreeTxt5( long arg )
	{
		inv_free_txt5 = arg;
	}

	public void setInvFreeNumTitle3( String arg )
	{
		inv_free_num_title3 = arg;
	}

	public void setInvFreeTxt6( long arg )
	{
		inv_free_txt6 = arg;
	}

	public void setInvFreeNumTitle4( String arg )
	{
		inv_free_num_title4 = arg;
	}

	public void setInvFreeTxt7( long arg )
	{
		inv_free_txt7 = arg;
	}

	public void setInvFreeNumTitle5( String arg )
	{
		inv_free_num_title5 = arg;
	}

	public void setInvFreeNumTitle6( String arg )
	{
		inv_free_num_title6 = arg;
	}

	public void setInvFreeNumTitle7( String arg )
	{
		inv_free_num_title7 = arg;
	}

	public void setInvOpFreeTxtTitle1( String arg )
	{
		inv_op_free_txt_title1 = arg;
	}

	public void setInvOpFreeTxt1( String arg )
	{
		inv_op_free_txt1 = arg;
	}

	public void setInvOpFreeTxtTitle2( String arg )
	{
		inv_op_free_txt_title2 = arg;
	}

	public void setInvOpFreeTxt2( String arg )
	{
		inv_op_free_txt2 = arg;
	}

	public void setInvOpFreeTxtTitle3( String arg )
	{
		inv_op_free_txt_title3 = arg;
	}

	public void setInvOpFreeTxt3( String arg )
	{
		inv_op_free_txt3 = arg;
	}

	public void setInvOpFreeTxtTitle4( String arg )
	{
		inv_op_free_txt_title4 = arg;
	}

	public void setInvOpFreeTxt4( String arg )
	{
		inv_op_free_txt4 = arg;
	}

	public void setInvOpFreeTxtTitle5( String arg )
	{
		inv_op_free_txt_title5 = arg;
	}

	public void setInvOpFreeTxt5( String arg )
	{
		inv_op_free_txt5 = arg;
	}

	public void setInvOpFreeTxtTitle6( String arg )
	{
		inv_op_free_txt_title6 = arg;
	}

	public void setInvOpFreeTxt6( String arg )
	{
		inv_op_free_txt6 = arg;
	}

	public void setInvOpFreeTxtTitle7( String arg )
	{
		inv_op_free_txt_title7 = arg;
	}

	public void setInvOpFreeTxt7( String arg )
	{
		inv_op_free_txt7 = arg;
	}

	public void setInvOpFreeTxtTitle8( String arg )
	{
		inv_op_free_txt_title8 = arg;
	}

	public void setInvOpFreeTxt8( String arg )
	{
		inv_op_free_txt8 = arg;
	}

	public void setInvOpFreeTxtTitle9( String arg )
	{
		inv_op_free_txt_title9 = arg;
	}

	public void setInvOpFreeTxt9( String arg )
	{
		inv_op_free_txt9 = arg;
	}

	public void setInvOpFreeTxtTitle10( String arg )
	{
		inv_op_free_txt_title10 = arg;
	}

	public void setInvOpFreeTxt10( String arg )
	{
		inv_op_free_txt10 = arg;
	}

	public void setInvOpFreeTxtTitle11( String arg )
	{
		inv_op_free_txt_title11 = arg;
	}

	public void setInvOpFreeTxt11( String arg )
	{
		inv_op_free_txt11 = arg;
	}

	public void setInvOpFreeTxtTitle12( String arg )
	{
		inv_op_free_txt_title12 = arg;
	}

	public void setInvOpFreeTxt12( String arg )
	{
		inv_op_free_txt12 = arg;
	}

	public void setItemSlipDate( String arg )
	{
		item_slip_date = arg;
	}

	public void setItemSlipNo( String arg )
	{
		item_slip_no = arg;
	}

	public void setItemProdCode( String arg )
	{
		item_prod_code = arg;
	}

	public void setItemPrice( long arg )
	{
		item_price = arg;
	}

	public void setItemUnit( String arg )
	{
		item_unit = arg;
	}

	public void setItemQty( long arg )
	{
		item_qty = arg;
	}

	public void setTaxFree( String arg )
	{
		tax_free = arg;
	}

	public void setTaxRate( String arg )
	{
		tax_rate = arg;
	}

	public void setItemWithoutTax( long arg )
	{
		item_without_tax = arg;
	}

	public void setItemTax( long arg )
	{
		item_tax = arg;
	}

	public void setItemAmount( long arg )
	{
		item_amount = arg;
	}

	public void setItemSecCode( String arg )
	{
		item_sec_code = arg;
	}

	public void setItemSecName( String arg )
	{
		item_sec_name = arg;
	}

	public void setDetailRemarks( String arg )
	{
		detail_remarks = arg;
	}

	public void setItemFreeTxtTitle1( String arg )
	{
		item_free_txt_title1 = arg;
	}

	public void setItemFreeTxt1( String arg )
	{
		item_free_txt1 = arg;
	}

	public void setItemFreeTxtTitle2( String arg )
	{
		item_free_txt_title2 = arg;
	}

	public void setItemFreeTxt2( String arg )
	{
		item_free_txt2 = arg;
	}

	public void setItemFreeTxtTitle3( String arg )
	{
		item_free_txt_title3 = arg;
	}

	public void setItemFreeTxt3( String arg )
	{
		item_free_txt3 = arg;
	}

	public void setItemFreeTxtTitle4( String arg )
	{
		item_free_txt_title4 = arg;
	}

	public void setItemFreeTxt4( String arg )
	{
		item_free_txt4 = arg;
	}

	public void setItemFreeTxtTitle5( String arg )
	{
		item_free_txt_title5 = arg;
	}

	public void setItemFreeTxt5( String arg )
	{
		item_free_txt5 = arg;
	}

	public void setItemFreeTxtTitle6( String arg )
	{
		item_free_txt_title6 = arg;
	}

	public void setItemFreeTxt6( String arg )
	{
		item_free_txt6 = arg;
	}

	public void setItemFreeTxtTitle7( String arg )
	{
		item_free_txt_title7 = arg;
	}

	public void setItemFreeTxt7( String arg )
	{
		item_free_txt7 = arg;
	}

	public void setItemFreeTxtTitle8( String arg )
	{
		item_free_txt_title8 = arg;
	}

	public void setItemFreeTxt8( String arg )
	{
		item_free_txt8 = arg;
	}

	public void setItemFreeTxtTitle9( String arg )
	{
		item_free_txt_title9 = arg;
	}

	public void setItemFreeTxt9( String arg )
	{
		item_free_txt9 = arg;
	}

	public void setItemFreeTxtTitle10( String arg )
	{
		item_free_txt_title10 = arg;
	}

	public void setItemFreeTxt10( String arg )
	{
		item_free_txt10 = arg;
	}

	public void setItemFreeTxtLTitle( String arg )
	{
		item_free_txt_l_title = arg;
	}

	public void setItemFreeTxtL( String arg )
	{
		item_free_txt_l = arg;
	}

	public void setItemMemo1( String arg )
	{
		item_memo1 = arg;
	}

	public void setItemMemo2( String arg )
	{
		item_memo2 = arg;
	}

	public void setDetailSummary( String arg )
	{
		detail_summary = arg;
	}

	public void setDetailSeq( int arg )
	{
		detail_seq = arg;
	}

	public void setStatus( String arg )
	{
		status = arg;
	}

	public void setCheckPattern( String arg )
	{
		chk_ptn = arg;
	}

	public void setMeisaiPattern( String arg )
	{
		meisai_ptn = arg;
	}

	public void setKenmeiNo( long arg )
	{
		kenmei_no = arg;
	}

	public void setMeisaiNo( long arg )
	{
		meisai_no = arg;
	}

	public void setRirekiNo( int arg )
	{
		rireki_no = arg;
	}
}
