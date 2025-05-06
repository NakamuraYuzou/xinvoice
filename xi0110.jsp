<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	XIBumon[] bmnlist = XIBumonAcc.getAll();
%>
<HEAD>
	<TITLE>部門情報取込【xi1110】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="480">
		<TR>
			<TD align="center"><P class="title01">部門一覧</P></TD>
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
					部門マスタCSV取込は、「取り込み」ボタンから!
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<A href="./xi0120.jsp">
					<IMG src="../image/torikomi01.png" onmouseover="this.src='../image/torikomi02.png'"
						 onmouseout="this.src='../image/torikomi01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="480"  class="tbl01">
		<TR class="header01">
			<TH width="20%">部門CD</TH>
			<TH width="80%">部門名</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < bmnlist.length ; i++ )
	{
		String clm1 = bmnlist[i].getBumonCode();
		String clm2 = bmnlist[i].getBumonMeisyou();
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
