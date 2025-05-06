<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");

	String code = request.getParameter("code");
	String name = request.getParameter("name");
	XIBBSeikyuumotoAcc.delete( code , name );
%>
	<META http-equiv="refresh" content="0; URL=./xi1250.jsp" />
</HTML>
