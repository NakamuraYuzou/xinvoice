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
	XIBBSeikyuusaki seik = XIBBSeikyuusakiAcc.getByNo( lno );

	String chkptn = seik.getCheckPattern();
	String moto = seik.getSeikyuuMoto();
	String saki = seik.getSeikyuuSaki();
	String kenmei = seik.getKenmei();
	String meado = seik.getKihyou();
	String shimei = seik.getKihyouName();

	String chktxt = "請求元・請求先・件名の完全一致";
	if ( chkptn.equals("B") ) chktxt = "請求元・請求先の完全一致 と 件名の前方一致";
	if ( chkptn.equals("C") ) chktxt = "請求元・請求先の完全一致";

	String hiyou = seik.getHiyouCode();
	String hiyounm = seik.getHiyouName();
	String koujicd = seik.getKoujiCode();
	String syousaicd = seik.getKoujiSyousaiCode();
	String koujinm = seik.getKoujiMeisyou();
	String bumoncd = seik.getBumonCode();
	String bumonnm = seik.getBumonMeisyou();
%>
<HEAD>
	<TITLE>パターン登録内容【xi1320】</TITLE>
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
				<A href="./xi1310.jsp?kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="1024"  class="tbl01">
		<TR height="60">
			<TD  width="15%" class="header01">パターン番号</TD>
			<TD  width="85%" class="row01">&nbsp;&nbsp;<%=no %></TD>
		</TR>
		<TR height="60">
			<TD  width="15%" class="header01">チェックパターン</TD>
			<TD  width="85%" class="row01">&nbsp;&nbsp;<%=chkptn %>&nbsp;<%=chktxt %></TD>
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
			<TD class="row01">&nbsp;<%=koujicd %>-<%=syousaicd %>&nbsp;：&nbsp;<%=koujinm %>
		</TR>
		<TR height="60">
			<TD class="header01">部門コード</TD>
			<TD class="row01">&nbsp;<%=bumoncd %>&nbsp;：&nbsp;<%=bumonnm %>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
