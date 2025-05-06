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

	String moto = request.getParameter("moto");
	String saki = request.getParameter("saki");
	String kenmei = request.getParameter("kenmei");

	String shimei = request.getParameter("shimei");
	if ( shimei == null ) shimei = "";
	String meado = request.getParameter("meado"); 
	if ( meado == null ) meado = "";
%>
<HEAD>
	<TITLE>BtoB件名登録【xi1340】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1340.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">パターン登録</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1330.jsp?kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR>
			<TD>
				<P class="text01">
					この内容と工事コード(または部門コード)をパターン登録してください。
				</P>
			</TD>
		</TR>
	</TABLE>
	<FORM name="touroku01"  action="xi1350.jsp" method="post" >
	<TABLE width="800"  class="tbl01">
		<TR height="100">
			<TD  width="20%" class="header01">チェックパターン</TD>
			<TD  width="80%" class="row01">
				<TABLE width="620">
					<TR>
						<TD>
							<INPUT name="ptn" type="radio" value="A" class="input01" onchange="ptn_msg()" checked="checked">A</INPUT>
						</TD>
						<TD>
							請求元・請求先・件名の完全一致
						</TD>
					</TR>
					<TR>
						<TD>
							<INPUT name="ptn" type="radio" value="B" class="input01" onchange="ptn_msg()">B</INPUT>
						</TD>
						<TD>
							請求元・請求先の完全一致 と 件名の部分一致
							&nbsp;&nbsp;<A href="javascript:kaisetsu01();">解説＞＞</A>
						</TD>
					</TR>
					<TR>
						<TD>
							<INPUT name="ptn" type="radio" value="C" class="input01" onchange="ptn_msg()">C</INPUT>
						</TD>
						<TD>
							請求元・請求先の完全一致
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">請求元</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="moto" type="text" size="56" value="<%=moto %>" class="input01"/>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">請求先</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="saki" type="text" size="56" value="<%=saki %>" class="input01"/>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">件名</TD>
			<TD class="row01">
				<BR/>
				&nbsp;
				<INPUT name="kenmei" type="text" size="56" value="<%=kenmei %>" class="input01"/>
				<BR/>&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT name="msg" type="hidden" class="input92" size="50" readonly />
				<INPUT name="kwd1" type="hidden" value="<%=kwd1 %>" />
				<INPUT name="kwd2" type="hidden" value="<%=kwd2 %>" />
				<INPUT name="kwd3" type="hidden" value="<%=kwd3 %>" />
			</TD>
		</TR>
		<TR height="100">
			<TD class="header01">起票者<BR/>&nbsp;&nbsp;&nbsp;氏名とメアド</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="shimei" type="text" size="10"  value="<%=shimei %>" placeholder="千代田　姉" class="input01"/>
				<A href="javascript:sansyou1();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				<BR/>
				<SPAN class="line01" >&nbsp;</SPAN>
				<INPUT name="meado" type="text" size="30"  value="<%=meado %>" placeholder="a-aaaa@sadenko.co.jp" class="input01"/>
				<SPAN class="text02">←コンカーのログインID</SPAN>
			</TD>
		</TR>
		<TR height="160">
			<TD width="20%" class="header01">工事番号<BR/>&nbsp;&nbsp;または<BR/>部門コード</TD>
			<TD width="80%" class="row01">
				&nbsp;
				<INPUT name="hiyou" type="radio" value="01" checked="checked" onchange="hiyou_msg()">工事原価</INPUT>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT name="hiyou" type="radio" value="02" onchange="hiyou_msg()">工事原価以外</INPUT>
				<INPUT name="hiyoumsg" type="text" class="input92" size="24" value="工事コードと部門コードは必須です！" readonly /><BR/>
				&nbsp;&nbsp;<INPUT name="kouji1" type="text" size="6"  placeholder="工事コード" class="input01"/>
				－
				<INPUT name="kouji2" type="text" size="2"  placeholder="詳細コード" class="input01"/>
				<A href="javascript:sansyou2();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				&nbsp;<INPUT class="input91" name="koujinm" size="28" readonly />
				<BR/><BR/>
				&nbsp;
				<INPUT name="bumon" type="text" size="10"  placeholder="部門コード" class="input01"/>
				<A href="javascript:sansyou3();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				&nbsp;<INPUT class="input91" name="bumonnm" size="24" readonly />
			</TD>
		</TR>
		<TR height="60">
			<TD colspan="2" align="center" class="header01">
				<A href="javascript:touroku();">
					<IMG src="../image/touroku11.png" onmouseover="this.src='../image/touroku12.png'"
						 onmouseout="this.src='../image/touroku11.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	</FORM>
</DIV>
</BODY>
</HTML>
