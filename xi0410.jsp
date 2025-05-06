<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	XICCList[] cclist = XICCListAcc.getAll();

	XISession xiss = new XISession( request , response );
	xiss.setSession();
%>
<HEAD>
	<TITLE>コンカーマスター【xi0410】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">コンカーマスター一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./submenu0.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<P class="text01">
					マスターの内容表示は「選択」ボタンから!
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="640"  class="tbl01">
		<TR class="header01">
			<TH width="10%">No</TH>
			<TH width="80%">マスター名</TH>
			<TH width="10%"></TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < cclist.length ; i++ )
	{
		String clm1 = String.valueOf( cclist[i].getNo() );
		String clm2 = cclist[i].getName();
		String listid = cclist[i].getListID();
		String e_name = URLEncoder.encode( clm2 , "UTF-8" );
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="left">&nbsp;<%=clm2 %></TD>
			<TD align="right">
				<A href="./xi0420.jsp?listid=<%=listid %>&listno=<%=clm1 %>&listname=<%=e_name %>">
					<IMG src="../image/sentaku01.png" onmouseover="this.src='../image/sentaku02.png'"
						 onmouseout="this.src='../image/sentaku01.png'" class="img" />
				</A>
			</TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
