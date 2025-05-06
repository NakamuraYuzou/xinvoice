<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	XIKeihiType[] sylist = XIKeihiTypeAcc.getAll();
%>
<HEAD>
	<TITLE>経費取込【xi0310】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">経費タイプ</P></TD>
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
				<A href="./xi0320.jsp">
					<IMG src="../image/torikomi01.png" onmouseover="this.src='../image/torikomi02.png'"
						 onmouseout="this.src='../image/torikomi01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="640"  class="tbl01">
		<TR class="header01">
			<TH width="20%">コード</TH>
			<TH width="80%">経費タイプ</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < sylist.length ; i++ )
	{
		String clm1 = sylist[i].getExpenseTypeCode();
		String clm2 = sylist[i].getExpenseTypeName();
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="left">&nbsp;<%=clm2 %></TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
