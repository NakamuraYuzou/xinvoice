<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String seikyuumoto = request.getParameter("seikyuumoto");
%>
<HEAD>
	<TITLE>BtoB請求元登録【xi1220】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1220.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">請求元登録</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1210.jsp">
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
	<FORM name="touroku01"  action="xi1230.jsp" method="post" >
	<TABLE width="800"  class="tbl01">
		<TR height="100">
			<TD width="20%" class="header01">相手先コード</TD>
			<TD width="80%" class="row01">
				&nbsp;
				<INPUT name="torcode" type="text" size="10" class="input01"/>
				<SPAN class="text02">←コンカーに登録された相手先コード</SPAN>
			</TD>
		</TR>
		<TR height="100">
			<TD class="header01">請求元名</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="torname" type="text" size="56" value="<%=seikyuumoto %>" class="input01"/>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">経費タイプ<BR/>(消費税8%)</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="expcode08" type="text" size="4" class="input01"/>
				<A href="javascript:sansyou40();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				<SPAN class="text02">←8% 10%の区別が無い場合は10%と同じコード。</SPAN>
				<BR/>&nbsp;<INPUT class="input91" name="expname08" size="50" readonly />
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">経費タイプ<BR/>(消費税10%)</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="expcode10" type="text" size="4" class="input01"/>
				<A href="javascript:sansyou41();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				<BR/>&nbsp;<INPUT class="input91" name="expname10" size="50" readonly />
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
