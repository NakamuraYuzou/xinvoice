<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");

	XIBBCsvAcc.updateStatus( code , "20" );

%>
		<META http-equiv="refresh" content="0; URL=./xi1610.jsp" />
</HTML>
