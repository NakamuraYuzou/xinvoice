<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	XISyain[] sylist = XISyainAcc.getAll();
%>
<HEAD>
	<TITLE>社員情報取込【xi1010】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800">
		<TR>
			<TD align="center"><P class="title01">社員一覧</P></TD>
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
					社員マスタCSV取込は、「取り込み」ボタンから!
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<A href="./xi0020.jsp">
					<IMG src="../image/torikomi01.png" onmouseover="this.src='../image/torikomi02.png'"
						 onmouseout="this.src='../image/torikomi01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="800"  class="tbl01">
		<TR class="header01">
			<TH width="10%">社員CD</TH>
			<TH width="15%">社員名</TH>
			<TH width="40%">部署</TH>
			<TH width="35%">メアド</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < sylist.length ; i++ )
	{
		String clm1 = sylist[i].getSyainCode();
		String clm2 = sylist[i].getSyainName();
		String clm3 = sylist[i].getBusyoName();
		String clm4 = sylist[i].getMailAddress();
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="center"><%=clm2 %></TD>
			<TD align="center">
				<SPAN title="<%=clm3 %>" >
					<INPUT class="input91" value="<%=clm3 %>" size="26" readonly />
				</SPAN>
			</TD>
			<TD align="center"><%=clm4 %></TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
