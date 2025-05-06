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
	String e_kwd1 = URLEncoder.encode( kwd1 , "Utf-8" );
	String e_kwd2 = URLEncoder.encode( kwd2 , "Utf-8" );
	String e_kwd3 = URLEncoder.encode( kwd3 , "Utf-8" );

	String no = request.getParameter("no");
	long lno = Long.parseLong( no );
	XIBBSeikyuusaki ptn = XIBBSeikyuusakiAcc.getByNo( lno );

	String chkptn = ptn.getCheckPattern();
	String chktxt = "請求元・請求先・件名の完全一致";
	if ( chkptn.equals("B") ) chktxt = "請求元・請求先の完全一致 と 件名の部分一致";
	if ( chkptn.equals("C") ) chktxt = "請求元・請求先の完全一致";

	String hiyou = ptn.getHiyouCode();
	String kouji1 = ptn.getKoujiCode();
	String kouji2 = ptn.getKoujiSyousaiCode();
	String koujinm = ptn.getKoujiMeisyou();
	String bumoncd = ptn.getBumonCode();
	String bumonnm = ptn.getBumonMeisyou();

	String chkd1 = "";
	String chkd2 = "";
	String hiyoumsg = "";
	if ( hiyou.equals("01") )
	{
		chkd1 = "checked=\"checked\"";
		hiyoumsg = "工事コードと部門コードは必須です！";
	}
	if ( hiyou.equals("02") )
	{
		chkd2 = "checked=\"checked\"";
		hiyoumsg = "部門コードは必須です！";
	}
%>
<HEAD>
	<TITLE>パターン修正【xi1460】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1360.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">パターン修正</P></TD>
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
			<TD>
				<P class="text01">
					修正後「登録」ボタンを押してください。
				</P>
			</TD>
		</TR>
	</TABLE>
	<FORM name="touroku01"  action="xi1370.jsp" method="post" >
	<TABLE width="800"  class="tbl01">
		<TR height="40">
			<TD  width="20%" class="header01">パターン番号</TD>
			<TD  width="80%" class="row01">&nbsp;&nbsp;<%=no %></TD>
		</TR>
		<TR height="40">
			<TD  width="20%" class="header01">チェックパターン</TD>
			<TD  width="80%" class="row01">&nbsp;&nbsp;<%=chkptn %>&nbsp;<%=chktxt %></TD>
			<INPUT type="hidden" name="ptn" value="<%=chkptn %>" />
		</TR>
		<TR height="40">
			<TD class="header01">請求元</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="moto" type="text" size="56" value="<%=ptn.getSeikyuuMoto() %>" class="input91 radonly"/>
			</TD>
		</TR>
		<TR height="40">
			<TD class="header01">請求先</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="saki" type="text" size="56" value="<%=ptn.getSeikyuuSaki() %>" class="input91" readonly />
			</TD>
		</TR>
		<TR height="40">
			<TD class="header01">件名</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="kenmei" type="text" size="56" value="<%=ptn.getKenmei() %>" class="input91" readonly />
			</TD>
		</TR>
		<TR height="100">
			<TD class="header01">起票者<BR/>&nbsp;&nbsp;&nbsp;氏名とメアド</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="shimei" type="text" size="10"  value="<%=ptn.getKihyouName() %>" placeholder="本庄 宮" class="input01"/>
				<A href="javascript:sansyou1();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				<BR/>
				<SPAN class="line01" >&nbsp;</SPAN>
				<INPUT name="meado" type="text" size="30"  value="<%=ptn.getKihyou() %>" placeholder="a-aaaa@sadenko.co.jp" class="input01"/>
				<SPAN class="text02">←コンカーのログインID</SPAN>
			</TD>
		</TR>
		<TR height="100">
			<TD width="20%" class="header01">工事番号<BR/>&nbsp;&nbsp;または<BR/>部門コード</TD>
			<TD width="80%" class="row01">
				&nbsp;
				<INPUT name="hiyou" type="radio" value="01" <%=chkd1 %> onchange="hiyou_msg()">工事原価</INPUT>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT name="hiyou" type="radio" value="02" <%=chkd2 %> onchange="hiyou_msg()">工事原価以外</INPUT>
				<INPUT name="hiyoumsg" type="text" class="input92" size="25" value="<%=hiyoumsg %>" readonly /><BR/>
				&nbsp;
				<INPUT name="kouji1" type="text" size="6"  value="<%=kouji1 %>" placeholder="工事コード" class="input01"/>
				－
				<INPUT name="kouji2" type="text" size="2"  value="<%=kouji2 %>" placeholder="詳細コード" class="input01"/>
				<A href="javascript:sansyou2();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				<SPAN title="<%=koujinm %>">
					&nbsp;<INPUT class="input91" name="koujinm" value="<%=koujinm %>" size="24" readonly />
					<BR/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</SPAN>
				<BR/>
				&nbsp;
				<INPUT name="bumon" type="text" size="10"  value="<%=bumoncd %>" placeholder="部門コード" class="input01"/>
				<A href="javascript:sansyou3();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				<SPAN title="<%=bumonnm %>">
					&nbsp;<INPUT class="input91" name="bumonnm" value="<%=bumonnm %>" size="24" readonly />
				</SPAN>
			</TD>
		</TR>
		<TR height="60">
			<TD colspan="2" align="center" class="header01">
				<A href="javascript:touroku();">
					<IMG src="../image/touroku11.png" onmouseover="this.src='../image/touroku12.png'"
						 onmouseout="this.src='../image/touroku11.png'" class="img" />
				</A>
				<INPUT type="hidden" name="no" value="<%=no %>" />
				<INPUT type="hidden" name="kwd1" value="<%=kwd1 %>" />
				<INPUT type="hidden" name="kwd2" value="<%=kwd2 %>" />
				<INPUT type="hidden" name="kwd3" value="<%=kwd3 %>" />
			</TD>
		</TR>
	</TABLE>
	</FORM>
</DIV>
</BODY>
</HTML>
