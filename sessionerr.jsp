<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<HEAD>
	<TITLE>タイムアウト</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800">
		<TR>
			<TD align="center"><P class="title01">タイムアウト</P></TD>
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
		<TR height="50">
			<TD></TD>
			<TD  colspan="2" class="text04">
				一定時間操作が無いためタイムアウトになりました。<BR/>
				メニューに戻ります。
			</TD>
			<TD></TD>
		</TR>
		<TR height="50"><TD colspan="4"></TD></TR>
		<TR height="50">
			<TD></TD>
			<TD colspan="2" align="center" >
				<A href="./menu.jsp">
					<IMG src="./image/modoru01.png" onmouseover="this.src='./image/modoru02.png'"
						 onmouseout="this.src='./image/modoru01.png'" class="img" />
				</A>
			</TD>
			<TD></TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
