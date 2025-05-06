<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	String no = request.getParameter("no");
	long lno = Long.parseLong( no );

	XIBBSeikyuuMeisaiAcc.delete( lno , code );

%>
		<META http-equiv="refresh" content="0; URL=./xi1520.jsp?code=<%=code %>" />
</HTML>
