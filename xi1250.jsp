<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	XIBBSeikyuumoto[] list = XIBBSeikyuumotoAcc.getAll();
%>
<HEAD>
	<TITLE>請求元一覧【xi1250】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1250.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="900">
		<TR>
			<TD align="center"><P class="title01">請求元一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./submenu1.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="900"  class="tbl01">
		<TR class="header01">
			<TH width="10%">取引先CD</TH>
			<TH width="76%">請求元</TH>
			<TH width="07%"></TH>
			<TH width="07%"></TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < list.length ; i++ )
	{
		String clm1 = list[i].getTorihikisakiCode();
		String clm2 = list[i].getSeikyuumotoName();
		String e_name = URLEncoder.encode( clm2 , "UTF-8" );
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="left"><%=clm2 %></TD>
			<TD align="center">
				<A href="./xi1260.jsp?code=<%=clm1 %>&name=<%=e_name %>">
					<IMG src="../image/hensyuu01.png" onmouseover="this.src='../image/hensyuu02.png'"
						 onmouseout="this.src='../image/hensyuu01.png'" class="img" />
				</A>
			</TD>
			<TD align="center">
				<A href="javascript:sakujyo( '<%=clm1 %>' , '<%=e_name %>' );">
					<IMG src="../image/sakujyo01.png" onmouseover="this.src='../image/sakujyo02.png'"
						 onmouseout="this.src='../image/sakujyo01.png'" class="img" />
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
