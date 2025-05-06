<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
%>
<HEAD>
	<TITLE>送信エラー【xi1931】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="500>
		<TR>
			<TD align="center"><P class="title01">コンカー送信エラー</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1910.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="500"  class="tblerror">
		<TR height="200" >
			<TD align="center" valign="middle">
				コンカー送信エラーが発生しました。<BR/>
				エラーログを確認してください。
			</TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
