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
	XIBBSeikyuuMeisai rec = XIBBSeikyuuMeisaiAcc.getByNo( lno );

	String chkptn = rec.getCheckPattern();
	String chktxt = "請求元・請求先・件名の完全一致";
	if ( chkptn.equals("P") ) chktxt = "請求元・請求先の完全一致 と 件名の部分一致";
	if ( chkptn.equals("Q") ) chktxt = "請求元・請求先の完全一致";

	String kouji1 = rec.getKoujiCode();
	String kouji2 = rec.getKoujiSyousaiCode();
	String koujinm = rec.getKoujiMeisyou();
	String bumoncd = rec.getBumonCode();
	String bumonnm = rec.getBumonMeisyou();

	String hiyou = rec.getHiyouCode();
	String chked1 = "checked=\"checked\"";
	String chked2 = "";
	String hiyoumsg = "工事コードは必須です！";
	if ( hiyou.equals("02") )
	{
		chked1 = "";
		chked2 = "checked=\"checked\"";
		hiyoumsg = "部門コードは必須です！";
	}

%>
<HEAD>
	<TITLE>明細パターン修正【xi1550】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1550.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">明細パターン修正</P></TD>
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
			<TD>
				<P class="text01">
					修正後「登録」ボタンを押してください。
				</P>
			</TD>
		</TR>
	</TABLE>
	<FORM name="touroku01"  action="xi1560.jsp" method="post" >
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
			<TD class="header01">明細項目</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="moto" type="text" size="56" value="<%=rec.getMeisaiKoumoku() %>" class="input91 radonly"/>
			</TD>
		</TR>
		<TR height="40">
			<TD class="header01">請求部門</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="saki" type="text" size="56" value="<%=rec.getMeisaiBumon() %>" class="input91" readonly />
			</TD>
		</TR>
		<TR height="40">
			<TD class="header01">明細備考</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="kenmei" type="text" size="56" value="<%=rec.getMeisaiBikou() %>" class="input91" readonly />
			</TD>
		</TR>
		<TR height="100">
			<TD width="20%" class="header01">工事番号<BR/>&nbsp;&nbsp;または<BR/>部門コード</TD>
			<TD width="80%" class="row01">
				&nbsp;
				<INPUT name="hiyou" type="radio" value="01" <%=chked1 %> onchange="hiyou_msg()">工事原価</INPUT>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT name="hiyou" type="radio" value="02" <%=chked2 %> onchange="hiyou_msg()">工事原価以外</INPUT>
				<INPUT name="hiyoumsg" type="text" class="input92" size="25" value="<%=hiyoumsg %>" readonly />
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
					または
					<BR/>
				</SPAN>
				&nbsp;<INPUT name="bumon" type="text" size="10"  value="<%=bumoncd %>" placeholder="部門コード" class="input01"/>
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
				<INPUT type="hidden" name="code" value="<%=code %>" />
			</TD>
		</TR>
	</TABLE>
	</FORM>
</DIV>
</BODY>
</HTML>
