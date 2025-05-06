<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String kwd1 = request.getParameter("kwd1");
	String kwd2 = request.getParameter("kwd2");
	String kwd3 = request.getParameter("kwd3");
	if ( kwd1 == null ) kwd1 = "";
	if ( kwd2 == null ) kwd2 = "";
	if ( kwd3 == null ) kwd3 = "";
	String e_kwd1 = URLEncoder.encode( kwd1 , "UTF-8" );
	String e_kwd2 = URLEncoder.encode( kwd2 , "UTF-8" );
	String e_kwd3 = URLEncoder.encode( kwd3 , "UTF-8" );

	String ptn = request.getParameter("ptn");
	String moto = request.getParameter("moto");
	String saki = request.getParameter("saki");
	String kenmei = request.getParameter("kenmei");
	String shimei = request.getParameter("shimei");
	String meado = request.getParameter("meado");
	XIBBSeikyuusaki xisaki = new XIBBSeikyuusaki();
	xisaki.setCheckPattern( ptn );
	xisaki.setSeikyuuMoto( moto );
	xisaki.setSeikyuuSaki( saki );
	xisaki.setKenmei( kenmei );
	xisaki.setKihyou( meado );
	xisaki.setKihyouName( shimei );
	XIBBSeikyuusakiAcc.insert( xisaki );

	if ( ptn.equals("J") ) XIBBCsvAcc.reCheckKenmeiJ();
	if ( ptn.equals("K") ) XIBBCsvAcc.reCheckKenmeiK();
	if ( ptn.equals("L") ) XIBBCsvAcc.reCheckKenmeiL();
%>
	<META http-equiv="refresh" content="0; URL=./xi1430.jsp?kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>" />
</HTML>
