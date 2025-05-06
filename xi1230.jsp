<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("torcode");
	String name = request.getParameter("torname");
	String expcode08 = request.getParameter("expcode08");
	String expname08 = request.getParameter("expname08");
	String expcode10 = request.getParameter("expcode10");
	String expname10 = request.getParameter("expname10");
	XIBBSeikyuumoto ximoto = new XIBBSeikyuumoto();
	ximoto.setTorihikisakiCode( code );
	ximoto.setSeikyuumotoName( name );
	ximoto.setExpenseTypeCode08( expcode08 );
	ximoto.setExpenseTypeName08( expname08 );
	ximoto.setExpenseTypeCode10( expcode10 );
	ximoto.setExpenseTypeName10( expname10 );
	XIBBSeikyuumotoAcc.insert( ximoto );

	XIBBCsvAcc.reCheckAitesaki();
%>
	<META http-equiv="refresh" content="0; URL=./xi1210.jsp" />
</HTML>
