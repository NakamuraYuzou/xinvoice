<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
%>
<HEAD>
	<TITLE>コンカー参照　メニュー</TITLE>
	<LINK rel="stylesheet" type="text/css" href="../css/style01.css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">コンカー参照　メニュー</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="../menu.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD align="left" class="text01">
			下のポチをクリックしてください。
			</TD>
		</TR>
	<TABLE>
<BR/>
	<TABLE width="640">
		<TR height="40">
			<TD width="5%">
				<A href="./xi9010.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text01" align="left">
				請求書IDを元にPaymentRequestを出力します。
			</TD>
		</TR>
		<TR height="40">
			<TD width="5%">
				<A href="./xi9030.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text01" align="left">
				メールアドレスを元に利用者情報を出力します。
			</TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>