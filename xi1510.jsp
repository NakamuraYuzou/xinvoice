<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");

	String[][] seiklist = XIBBCsvAcc.status71Kenmei();
%>
<HEAD>
	<TITLE>パターン一覧【xi1510】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1510.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="1024">
		<TR>
			<TD align="center"><P class="title01">明細アンマッチ請求書</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./submenu1.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="1024">
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<P class="text01">
					一覧の請求書は、パターンがマッチしない明細行を含んでします。<BR/>
					明細ボタンから明細パターンを登録してください。
				</P>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="1024"  class="tbl01">
		<TR class="header01">
			<TH width="15%">請求書管理CD</TH>
			<TH width="75%">請求書情報</TH>
			<TH width="10%">&nbsp;</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < seiklist.length ; i++ )
	{
		String code = seiklist[i][0];
		String moto = seiklist[i][1];
		String saki = seiklist[i][2];
		String kenmei = seiklist[i][3];

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR height="60" class="<%=row_cls %>">
			<TD align="center"><%=code %></TD>
			<TD align="left">
				<TABLE>
					<TR><TD class="text02">請求元：</TD><TD><%=moto %></TD></TR>
					<TR><TD class="text02">請求先：</TD><TD><%=saki %></TD></TR>
					<TR><TD class="text02">件名：</TD><TD><%=kenmei %></TD></TR>
				</TABLE>
			</TD>
			<TD align="center">
				<A href="./xi1520.jsp?code=<%=code %>">
					<IMG src="../image/meisai01.png" onmouseover="this.src='../image/meisai02.png'"
						 onmouseout="this.src='../image/meisai01.png'" class="img" />
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
