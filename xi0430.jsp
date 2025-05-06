<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String listid = request.getParameter("listid");
	XICCListItemsAcc.delete( listid );

	XISession xiss = new XISession( request , response );
	if ( !xiss.confirmSession() ) response.sendRedirect("../sessionerr.jsp");
	String listno = xiss.getListNo();
	String listname = xiss.getListName();

	String baseurl = "https://us2.api.concursolutions.com";
	String nextpage = "/api/v3.0/common/listitems?limit=100&ListId=" + listid;
	String url = nextpage;
	int cnt = 0;
	while ( nextpage != null )
	{
		XICCListItems items = XICCListItemsAcc.getListItems( url );
		System.out.println( nextpage );
		XICCListItem[] list = items.getItems();
		XICCListItemsAcc.insertBulk( list );
		nextpage = items.getNextPage();
		if( nextpage != null ) url = nextpage.replace( baseurl , "" );

		cnt = cnt + list.length;
	}

	String cntstr = String.format( "%,d" , cnt );

%>
<HEAD>
	<TITLE>取込完了【xi0430】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800">
		<TR>
			<TD align="center"><P class="title01">取込完了</P></TD>
		</TR>
	</TABLE>
<BR/>
	<TABLE width="800"  class="tbl02">
		<TR>
			<TH width="10%"></TH>
			<TH width="30%"></TH>
			<TH width="50%"></TH>
			<TH width="10%"></TH>
		<TR>
		<TR height="70">
			<TD></TD>
			<TD colspan="2"  class="text04">
				■取込完了
			</TD>
			<TD></TD>
		</TR>
		<TR height="50">
			<TD></TD>
			<TD  colspan="2" class="text04">
				<BR/>
				<%=cntstr %>件取込みました。<BR/><BR/>
				「戻る」ボタンで一覧画面に移ってください。<BR/>
			</TD>
			<TD></TD>
		</TR>
		<TR height="50"><TD colspan="4"></TD></TR>
		<TR height="50">
			<TD></TD>
			<TD colspan="2" align="center" >
				<A href="./xi0420.jsp?listid=<%=listid %>&listno=<%=listno %>&listname=<%=listname %>">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
			<TD></TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
