<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String expcode08 = request.getParameter("expcode08");
	String expname08 = request.getParameter("expname08");
	String expcode10 = request.getParameter("expcode10");
	String expname10 = request.getParameter("expname10");

	XIBBSeikyuumoto moto = new XIBBSeikyuumoto();
	moto.setTorihikisakiCode( code );
	moto.setSeikyuumotoName( name );
	moto.setExpenseTypeCode08( expcode08 );
	moto.setExpenseTypeName08( expname08 );
	moto.setExpenseTypeCode10( expcode10 );
	moto.setExpenseTypeName10( expname10 );

	XIBBSeikyuumotoAcc.update( code , name , moto );
%>
	<META http-equiv="refresh" content="0; URL=./xi1250.jsp" />
</HTML>
