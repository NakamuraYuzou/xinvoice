<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String url = "/api/v3.0/invoice/paymentrequest/" + id;
	XICCAPIAccess ccapi = new XICCAPIAccess( url , "GET" );
	String res = ccapi.connect();
	int code = ccapi.getResopnseCode();
	String msg = ccapi.getResponseMessage();
	ccapi.close();
%>
<HEAD>
	<TITLE>請求書【xi9020】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi9010.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">請求書</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi9010.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="640">
		<TR><TD class="text01"><%=code %></TD></TR>
		<TR><TD class="text01"><%=msg %></TD></TR>
		<TR>
			<TD align="left" class="text02">
				<TEXTAREA rows="40" cols="90">
<%=res %>
				</TEXTAREA>
			</TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
