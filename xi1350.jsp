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
	String hiyou = request.getParameter("hiyou");
	String kouji1 = request.getParameter("kouji1");
	String kouji2 = request.getParameter("kouji2");
	String koujinm = request.getParameter("koujinm");
	String bumon = request.getParameter("bumon");
	String bumonnm = request.getParameter("bumonnm");
	XIBBSeikyuusaki xisaki = new XIBBSeikyuusaki();
	xisaki.setCheckPattern( ptn );
	xisaki.setSeikyuuMoto( moto );
	xisaki.setSeikyuuSaki( saki );
	xisaki.setKenmei( kenmei );
	xisaki.setKihyou( meado );
	xisaki.setHiyouCode( hiyou );
	String hiyounm = "工事原価";
	if ( hiyou.equals("02") ) hiyounm = "工事原価以外";
	xisaki.setHiyouName( hiyounm );
	xisaki.setKihyouName( shimei );
	xisaki.setKoujiCode( kouji1 );
	xisaki.setKoujiSyousaiCode( kouji2 );
	xisaki.setKoujiMeisyou( koujinm );
	xisaki.setBumonCode( bumon );
	xisaki.setBumonMeisyou( bumonnm );
	XIBBSeikyuusakiAcc.insert( xisaki );

	if ( ptn.equals("A") ) XIBBCsvAcc.reCheckKenmeiA();
	if ( ptn.equals("B") ) XIBBCsvAcc.reCheckKenmeiB();
	if ( ptn.equals("C") ) XIBBCsvAcc.reCheckKenmeiC();
%>
	<META http-equiv="refresh" content="0; URL=./xi1330.jsp?kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>" />
</HTML>
