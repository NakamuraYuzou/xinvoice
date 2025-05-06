<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String kwd = request.getParameter("kwd");
	if ( kwd == null ) kwd = "";
	String e_kwd = URLEncoder.encode( kwd , "UTF-8" );

	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String pattern = request.getParameter("pattern");
	if ( name == null ) name = "";
	String e_name = URLEncoder.encode( name , "UTF-8" );

	XIKeihiPatternAcc.delete( code , name , pattern );
%>
	<META http-equiv="refresh" content="0; URL=./xi1820.jsp?code=<%=code %>&name=<%=e_name %>&kwd=<%=e_kwd %>" />
</HTML>
