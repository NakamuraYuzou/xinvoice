<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	XIKouji[] kjlist = XIKoujiAcc.getAll();
%>
<HEAD>
	<TITLE>工事情報取込【xi0210】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800">
		<TR>
			<TD align="center"><P class="title01">工事一覧</P></TD>
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
					工事マスタCSV取込は、「取り込み」ボタンから!
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<A href="./xi0220.jsp">
					<IMG src="../image/torikomi01.png" onmouseover="this.src='../image/torikomi02.png'"
						 onmouseout="this.src='../image/torikomi01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="800"  class="tbl01">
		<TR class="header01">
			<TH width="15%">工事CD</TH>
			<TH width="85%">工事名</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < kjlist.length ; i++ )
	{
		String clm1 = kjlist[i].getKoujiCode();
		String clm2 = kjlist[i].getKoujiMeisyou();
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="left">
				<SPAN title="<%=clm2 %>" >
					&nbsp;<INPUT class="input91" value="<%=clm2 %>" size="62" readonly />
				</SPAN>
			</TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
