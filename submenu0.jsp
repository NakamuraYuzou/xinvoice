<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
%>
<HEAD>
	<TITLE>マスターメンテ　メニュー</TITLE>
	<LINK rel="stylesheet" type="text/css" href="../css/style01.css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">マスターメンテ　メニュー</P></TD>
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
				<A href="./xi0010.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text01" align="left">
				社員マスターのCSVを取り込みます。
			</TD>
		</TR>
		<TR height="40">
			<TD width="5%">
				<A href="./xi0110.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text01" align="left">
				部門マスターのCSVを取り込みます。
			</TD>
		</TR>
		<TR height="40">
			<TD width="5%">
				<A href="./xi0210.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text01" align="left">
				工事マスターのCSVを取り込みます。
			</TD>
		</TR>
		<TR height="40">
			<TD width="5%">
				<A href="./xi0310.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text01" align="left">
				経費タイプのCSVを取り込みます。
			</TD>
		</TR>
		<TR height="40">
			<TD width="5%">
				<A href="./xi0410.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text01" align="left">
				コンカーのマスターを表示します。
			</TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>