<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
	String kanrino = request.getParameter("kanrino");
	String ptn = request.getParameter("ptn");
	String koumoku = request.getParameter("koumoku");
	String mbumon = request.getParameter("mbumon");
	String bikou = request.getParameter("bikou");

	String shimei = request.getParameter("shimei");
	if ( shimei == null ) shimei = "";
	String meado = request.getParameter("meado"); 
	if ( meado == null ) meado = "";
%>
<HEAD>
	<TITLE>明細パタン登録【xi1530】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1530.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">明細パタン登録</P></TD>
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
					「登録」ボタンで請求元を登録してください。
				</P>
			</TD>
		</TR>
	</TABLE>
	<FORM name="touroku01"  action="xi1540.jsp" method="post" >
	<TABLE width="800"  class="tbl01">
		<TR height="100">
			<TD  width="20%" class="header01">チェックパターン</TD>
			<TD  width="80%" class="row01">
				<TABLE width="620">
					<TR>
						<TD>
							<INPUT name="mptn" type="radio" value="P" class="input01" onchange="ptn_msg()" checked="checked">P</INPUT>
						</TD>
						<TD>
							明細項目・明細部門の完全一致
						</TD>
					</TR>
					<TR>
						<TD>
							<INPUT name="mptn" type="radio" value="Q" class="input01" onchange="ptn_msg()">Q</INPUT>
						</TD>
						<TD>
							明細項目の完全一致 と 明細部門の部分一致
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">明細項目</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="koumoku" type="text" size="56" value="<%=koumoku %>" class="input01"/>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">明細部門</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="mbumon" type="text" size="56" value="<%=mbumon %>" class="input01"/>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">明細備考</TD>
			<TD class="row01">
				<BR/>
				&nbsp;
				<INPUT name="bikou" type="text" size="56" value="<%=bikou %>" class="input01"/>
				<BR/>&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT name="msg" type="hidden" class="input92" size="50" readonly />
			</TD>
		</TR>
		<TR height="100">
			<TD width="20%" class="header01">工事番号<BR/>&nbsp;&nbsp;または<BR/>部門コード</TD>
			<TD width="80%" class="row01">
				&nbsp;
				<INPUT name="hiyou" type="radio" value="01" checked="checked" onchange="hiyou_msg()">工事原価</INPUT>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<INPUT name="hiyou" type="radio" value="02" onchange="hiyou_msg()">工事原価以外</INPUT>
				<INPUT name="hiyoumsg" type="text" class="input92" size="25" value="工事コードと部門コードは必須です！" readonly /><BR/>
				&nbsp;<INPUT name="kouji1" type="text" size="6"  placeholder="工事コード" class="input01"/>
				－
				<INPUT name="kouji2" type="text" size="2"  placeholder="詳細コード" class="input01"/>
				<A href="javascript:sansyou2();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				&nbsp;<INPUT class="input91" name="koujinm" size="24" readonly />
				<BR/>
				<BR/>
				&nbsp;
				<INPUT name="bumon" type="text" size="10"  placeholder="部門コード" class="input01"/>
				<A href="javascript:sansyou3();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				&nbsp;<INPUT class="input91" name="bumonnm" size="24" readonly />
				<INPUT type="hidden" name="code" value="<%=code %>" />
				<INPUT type="hidden" name="kanrino" value="<%=kanrino %>" />
				<INPUT type="hidden" name="ptn" value="<%=ptn %>" />
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
