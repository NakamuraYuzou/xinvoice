<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
%>
<HEAD>
	<TITLE>コンカー連携メニュー</TITLE>
	<LINK rel="stylesheet" type="text/css" href="./css/style01.css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800">
		<TR>
			<TD align="center"><P class="title01">コンカー連携メニュー</P></TD>
		</TR>
		<TR height="20"><TD></TD></TR>
		<TR>
			<TD>
				<SPAN class="text01">
					矢印をクリックして進んで下さい。
				</SPAN>
			</TD>
		</TR>
	<TABLE>
	<TABLE width="800" class="tbl01">
		<TR height="60" class="tr01">
			<TD class="text02" align="left" width="20%">
				マスターメンテ
			</TD>
			<TD class="text02" align="left" width="70%">
				社員マスター等の入替えを行います。
			</TD>
			<TD width="10%" align="center">
				<A href="./master/submenu0.jsp">
					<IMG src="./image/yajirushi01.png" onmouseover="this.src='./image/yajirushi02.png'"
						 onmouseout="this.src='./image/yajirushi01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR height="60" class="tr01">
			<TD class="text02" align="left" width="20%">
				コンカー参照
			</TD>
			<TD class="text02" align="left" width="70%">
				コンカーの情報を参照します。
			</TD>
			<TD width="10%" align="center">
				<A href="./cc/submenu9.jsp">
					<IMG src="./image/yajirushi01.png" onmouseover="this.src='./image/yajirushi02.png'"
						 onmouseout="this.src='./image/yajirushi01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR height="60" class="tr01">
			<TD class="text02" align="left" width="20%">
				BtoB請求書取込
			</TD>
			<TD class="text02" align="left" width="70%">
				BtoBプラットフォームで出力した請求書CSVを取り込みます。
			</TD>
			<TD width="10%" align="center">
				<A href="./btob/submenu1.jsp">
					<IMG src="./image/yajirushi01.png" onmouseover="this.src='./image/yajirushi02.png'"
						 onmouseout="this.src='./image/yajirushi01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>