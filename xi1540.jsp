<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
	String ptn = request.getParameter("ptn");
	String mptn = request.getParameter("mptn");
	String kanrino = request.getParameter("kanrino");
	String koumoku = request.getParameter("koumoku");
	String mbumon = request.getParameter("mbumon");
	String hiyou = request.getParameter("hiyou");
	String bikou = request.getParameter("bikou");
	String kouji1 = request.getParameter("kouji1");
	String kouji2 = request.getParameter("kouji2");
	String koujinm = request.getParameter("koujinm");
	String bumoncd = request.getParameter("bumon");
	String bumonnm = request.getParameter("bumonnm");
	Long lkanrino = Long.parseLong( kanrino );
	String hiyounm = "工事原価";
	if ( hiyou.equals("02") ) hiyounm = "工事原価以外";

	XIBBSeikyuuMeisai ximeis = new XIBBSeikyuuMeisai();
	ximeis.setKenmeiKanriNo( lkanrino );
	ximeis.setCheckPattern( ptn );
	ximeis.setMeisaiPattern( mptn );
	ximeis.setMeisaiKoumoku( koumoku );
	ximeis.setMeisaiBumon( mbumon );
	ximeis.setMeisaiBikou( bikou );
	ximeis.setHiyouCode( hiyou );
	ximeis.setHiyouName( hiyounm );
	ximeis.setKoujiCode( kouji1 );
	ximeis.setKoujiSyousaiCode( kouji2 );
	ximeis.setKoujiMeisyou( koujinm );
	ximeis.setBumonCode( bumoncd );
	ximeis.setBumonMeisyou( bumonnm );
	XIBBSeikyuuMeisaiAcc.insert( ximeis );

	if ( mptn.equals("P") ) XIBBCsvAcc.checkMeisaiP();
	if ( mptn.equals("Q") ) XIBBCsvAcc.checkMeisaiQ();
	XIBBCsvAcc.updateAllMatched();
%>
	<META http-equiv="refresh" content="0; URL=./xi1520.jsp?code=<%=code %>" />
</HTML>
