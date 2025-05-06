<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
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
	String e_moto = URLEncoder.encode( moto , "UTF-8" ); 
	String e_saki = URLEncoder.encode( moto , "UTF-8" ); 
	String e_kenmei = URLEncoder.encode( kenmei , "UTF-8" );

	String shimei = request.getParameter("shimei");
	if ( shimei == null ) shimei = "";
	String meado = request.getParameter("meado"); 
	if ( meado == null ) meado = "";
%>
<HEAD>
	<TITLE>BtoB件名登録【xi1440】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1440.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">件名(明細単位)登録</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1430.jsp?kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<P class="text01">
					「登録」ボタンで請求元を登録してください。
				</P>
			</TD>
		</TR>
	</TABLE>
	<FORM name="touroku01"  action="xi1450.jsp" method="post" >
	<TABLE width="800"  class="tbl01">
		<TR height="100">
			<TD  width="20%" class="header01">チェックパターン</TD>
			<TD  width="80%" class="row01">
				<TABLE width="620">
					<TR>
						<TD>
							<INPUT name="ptn" type="radio" value="J" class="input01" onchange="ptn_msg()" checked="checked">J</INPUT>
						</TD>
						<TD>
							請求元・請求先・件名の完全一致
						</TD>
					</TR>
					<TR>
						<TD>
							<INPUT name="ptn" type="radio" value="K" class="input01" onchange="ptn_msg()">K</INPUT>
						</TD>
						<TD>
							請求元・請求先の完全一致 と 件名の部分一致
						</TD>
					</TR>
					<TR>
						<TD>
							<INPUT name="ptn" type="radio" value="L" class="input01" onchange="ptn_msg()">L</INPUT>
						</TD>
						<TD>
							請求元・請求先の完全一致
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR height="100">
			<TD class="header01">請求元</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="moto" type="text" size="56" value="<%=moto %>" class="input01"/>
			</TD>
		</TR>
		<TR height="100">
			<TD class="header01">請求先</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="saki" type="text" size="56" value="<%=saki %>" class="input01"/>
			</TD>
		</TR>
		<TR height="100">
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
				<INPUT name="shimei" type="text" size="10"  value="<%=shimei %>" placeholder="みやき　ひまわり" class="input01"/>
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

<BR>
	<TABLE width="1024 class="tbl01">
		<TR>
			<TD align="left" class="title01">■明細</TD>
		</TR>
	</TABLE>
	<TABLE width="1024"  class="tbl01">
		<TR class="header01">
			<TH width="40%">項目</TH>
			<TH width="30%">部門</TH>
			<TH width="15%">金額</TH>
			<TH width="15%">消費税</TH>
		</TR>
<%
	String[][] meislist = XIBBCsvAcc.getMeisaiByCode( code );
	int line_cnt = 0;
	for ( int i = 0 ; i < meislist.length ; i++ )
	{
		String koumoku = meislist[i][0];
		String bumon = meislist[i][1];
		String kingaku = meislist[i][3];
		String zei = meislist[i][4];
		if ( kingaku == null ) kingaku = "";
		if ( zei == null ) zei = "";
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR height="60" class="<%=row_cls %>">
			<TD align="left"><%=koumoku %></TD>
			<TD align="left"><%=bumon %></TD>
			<TD align="center"><%=kingaku %></TD>
			<TD align="center"><%=zei %></TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
