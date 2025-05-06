<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	XIBBTorikomiRireki[] trlist = XIBBTorikomiRirekiAcc.getAll();
%>
<HEAD>
	<TITLE>BtoB請求書取込【xi1010】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800">
		<TR>
			<TD align="center"><P class="title01">取込履歴</P></TD>
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
		<TR>
			<TD>
				<P class="text01">
					請求書CSV取込は、「取り込み」ボタンから!
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<A href="./xi1020.jsp">
					<IMG src="../image/torikomi01.png" onmouseover="this.src='../image/torikomi02.png'"
						 onmouseout="this.src='../image/torikomi01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="800"  class="tbl01">
		<TR class="header01">
			<TH width="7%">No</TH>
			<TH width="50%">ファイル名</TH>
			<TH width="33%">取込日時</TH>
			<TH width="10%">明細数</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < trlist.length ; i++ )
	{
		String clm1 = String.valueOf( trlist[i].getNo() );
		String clm2 = trlist[i].getFileName();
		String clm3 = trlist[i].getOperationDateStr();
		String clm4 = String.valueOf( trlist[i].getKensuu() );
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="center"><%=clm2 %></TD>
			<TD align="center"><%=clm3 %></TD>
			<TD align="center"><%=clm4 %></TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
