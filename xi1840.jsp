<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String meisai = request.getParameter("meisai");
	String kwd = request.getParameter("kwd");
	if ( kwd == null ) kwd = "";
	String prevkwd = request.getParameter("prevkwd");
	if ( prevkwd == null ) prevkwd = "";
	String e_kwd = URLEncoder.encode( kwd , "UTF-8" );
	String e_name = URLEncoder.encode( name , "UTF-8" );
	String e_prevkwd = URLEncoder.encode( prevkwd , "UTF-8" );

%>
<HEAD>
	<TITLE>明細パターン登録【xi1840】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1840.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">明細パターン登録</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1830.jsp?code=<%=code %>&name=<%=e_name %>&kwd=<%=e_kwd %>&prevkwd=<%=e_prevkwd %>">
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
	<FORM name="touroku01"  action="xi1850.jsp" method="post" >
	<TABLE width="800"  class="tbl01">
		<TR height="80">
			<TD class="header01" width="30%">相手先コード</TD>
			<TD class="row01" width="70%">
				&nbsp;<INPUT name="code" type="text" size="6" value="<%=code %>" readonly class="input01"/>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">請求元</TD>
			<TD class="row01">
				&nbsp;<INPUT name="name" type="text" size="46" value="<%=name %>" readonly class="input01"/>
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">パターン</TD>
			<TD class="row01">
				&nbsp;<INPUT name="pattern" type="text" size="46" value="<%=meisai %>" class="input01"/>
				<BR/><SPAN class="text02">&nbsp;↑個数などの可変部分は%にしてください。</SPAN>
				<INPUT name="kwd" type="hidden" value="<%=kwd %>" />
				<INPUT name="prevkwd" type="hidden" value="<%=prevkwd %>" />
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">消費税8%の経費タイプ</TD>
			<TD class="row01">
				&nbsp;
				<INPUT name="expcode08" type="text" size="4" class="input01"/>
				<A href="javascript:sansyou40();">
					<IMG src="../image/sansyou01.png" onmouseover="this.src='../image/sansyou02.png'"
						 onmouseout="this.src='../image/sansyou01.png'" class="img" />
				</A>
				<SPAN class="text02">←8% 10%の区別が無い場合は10%と同じ。</SPAN>
				<BR/>&nbsp;<INPUT class="input91" name="expname08" size="50" readonly />
			</TD>
		</TR>
		<TR height="80">
			<TD class="header01">消費税10%の経費タイプ</TD>
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
