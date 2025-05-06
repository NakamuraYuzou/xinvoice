<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
	String no = request.getParameter("no");
	long lno = Long.parseLong( no );
	String hiyou = request.getParameter("hiyou");
	String kouji1 = request.getParameter("kouji1");
	String kouji2 = request.getParameter("kouji2");
	String koujinm = request.getParameter("koujinm");
	String bumon = request.getParameter("bumon");
	String bumonnm = request.getParameter("bumonnm");
	XIBBSeikyuuMeisai meisai = XIBBSeikyuuMeisaiAcc.getByNo( lno );
	meisai.setHiyouCode( hiyou );
	String hiyounm = "工事原価";
	if ( hiyou.equals("02") ) hiyounm = "工事原価以外";
	meisai.setHiyouName( hiyounm );
	meisai.setKoujiCode( kouji1 );
	meisai.setKoujiSyousaiCode( kouji2 );
	meisai.setKoujiMeisyou( koujinm );
	meisai.setBumonCode( bumon );
	meisai.setBumonMeisyou( bumonnm );
	XIBBSeikyuuMeisaiAcc.update(  lno , meisai );

	String meistxt = "明細項目・部門名の完全一致";
	String meisptn = meisai.getMeisaiPattern();
	if ( meisptn.equals("Q") ) meistxt = "明細項目の完全一致 と 部門名の部分一致";

	String koumoku = meisai.getMeisaiKoumoku();
	String mbumon = meisai.getMeisaiBumon();
	String bikou = meisai.getMeisaiBikou();
%>
<HEAD>
	<TITLE>パターン変更済【xi1560】</TITLE>
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
				<A href="./xi1520.jsp?code=<%=code %>">
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
			<TD  width="85%" class="row01">&nbsp;<%=meisptn %>&nbsp;<%=meistxt %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">明細項目</TD>
			<TD class="row01">&nbsp;<%=koumoku %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">部門名</TD>
			<TD class="row01">&nbsp;<%=mbumon %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">明細備考</TD>
			<TD class="row01">&nbsp;<%=bikou %></TD>
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
