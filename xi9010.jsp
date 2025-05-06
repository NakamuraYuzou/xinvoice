<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
%>
<HEAD>
	<TITLE>請求書ID指定【xi9010】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi9010.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">請求書ID指定</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./submenu9.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<FORM name="kensaku01" method="post" action="./xi9020.jsp" >
	<TABLE width="640" class="tbl02">
		<TR>
			<TH width="5%"></TH>
			<TH width="90%"></TH>
			<TH width="5%"></TH>
		</TR>
		<TR height="60">
			<TD></TD>
			<TD align="center" class="text02">
				請求書ID：
				<INPUT type="text" name="id" class="input01" />
			</TD>
			<TD></TD>
		</TR>
		<TR height="60">
			<TD></TD>
			<TD align="center">
				<A href="javascript:document.kensaku01.submit()">
					<IMG src="../image/kensaku01.png" onmouseover="this.src='../image/kensaku02.png'"
						 onmouseout="this.src='../image/kensaku01.png'" class="img" />
				</A>
			</TD>
			<TD></TD>
		</TR>
	</TABLE>
	</FORM>
</DIV>
</BODY>
</HTML>
