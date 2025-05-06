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

	String no = request.getParameter("no");
	long lno = Long.parseLong( no );
	String chkptn = request.getParameter("ptn");
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
	xisaki.setNo( lno );
	xisaki.setCheckPattern( chkptn );
	xisaki.setSeikyuuMoto( moto );
	xisaki.setSeikyuuSaki( saki );
	xisaki.setKenmei( kenmei );
	xisaki.setKihyou( meado );
	xisaki.setKihyouName( shimei );
	xisaki.setHiyouCode( hiyou );
	String hiyounm = "工事原価";
	if ( hiyou.equals("02") ) hiyounm = "工事原価以外";
	xisaki.setHiyouName( hiyounm );
	xisaki.setKoujiCode( kouji1 );
	xisaki.setKoujiSyousaiCode( kouji2 );
	xisaki.setKoujiMeisyou( koujinm );
	xisaki.setBumonCode( bumon );
	xisaki.setBumonMeisyou( bumonnm );
	XIBBSeikyuusakiAcc.update(  lno , xisaki );

	String chktxt = "請求元・請求先・件名の完全一致";
	if ( chkptn.equals("B") ) chktxt = "請求元・請求先の完全一致 と 件名の部分一致";
	if ( chkptn.equals("C") ) chktxt = "請求元・請求先の完全一致";

%>
<HEAD>
	<TITLE>パターン変更済【xi1370】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="1024>
		<TR>
			<TD align="center"><P class="title01">パターン内容</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1310.jsp?kwd1=<%=kwd1 %>&kwd2=<%=kwd2 %>&kwd3=<%=kwd3 %>">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD class="text02">
				パターンが以下の内容で修正されました。
			</TD>
	</TABLE>
	<TABLE width="1024"  class="tbl01">
		<TR height="60">
			<TD  width="15%" class="header01">変更済</TD>
			<TD  width="85%" class="row01">&nbsp;<%=chkptn %>&nbsp;<%=chktxt %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">請求元</TD>
			<TD class="row01">&nbsp;<%=moto %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">請求先</TD>
			<TD class="row01">&nbsp;<%=saki %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">件名</TD>
			<TD class="row01">&nbsp;<%=kenmei %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">起票者</TD>
			<TD class="row01">&nbsp;<%=shimei %>&nbsp;：&nbsp;<%=meado %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">費用区分</TD>
			<TD class="row01">&nbsp;<%=hiyou %>&nbsp;：&nbsp;<%=hiyounm %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">工事コード</TD>
			<TD class="row01">&nbsp;<%=kouji1 %>-<%=kouji2 %>：<%=koujinm %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">部門コード</TD>
			<TD class="row01">&nbsp;<%=bumon %>：<%=bumonnm %></TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
