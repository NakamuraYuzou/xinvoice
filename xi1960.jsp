<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");

	String code = request.getParameter("code");
	String toricode = request.getParameter("toricode");
	String name = request.getParameter("name");
	String pattern = request.getParameter("pattern");
	String expcode08 = request.getParameter("expcode08");
	String expname08 = request.getParameter("expname08");
	String expcode10 = request.getParameter("expcode10");
	String expname10 = request.getParameter("expname10");
	if ( name == null ) name = "";
	String e_name = URLEncoder.encode( name , "UTF-8" );

	XIKeihiPattern xikp = new XIKeihiPattern();
	xikp.setTorihikisakiCode( toricode );
	xikp.setSeikyuumoto( name );
	xikp.setExpenseTypePattern( pattern );
	xikp.setExpenseTypeCode08( expcode08 );
	xikp.setExpenseTypeName08( expname08 );
	xikp.setExpenseTypeCode10( expcode10 );
	xikp.setExpenseTypeName10( expname10 );
	XIKeihiPatternAcc.insert( xikp );
%>
	<META http-equiv="refresh" content="0; URL=./xi1920.jsp?code=<%=code %>" />
</HTML>
