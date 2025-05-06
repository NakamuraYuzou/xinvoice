<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String kwd1 = request.getParameter("kwd1");
	String kwd2 = request.getParameter("kwd2");
	String kwd3 = request.getParameter("kwd3");
	if ( kwd1 == null ) kwd1 = "";
	if ( kwd2 == null ) kwd2 = "";
	if ( kwd3 == null ) kwd3 = "";
	String e_kwd1 = URLEncoder.encode( kwd1 , "UTF-8" );
	String e_kwd2 = URLEncoder.encode( kwd2 , "UTF-8" );
	String e_kwd3 = URLEncoder.encode( kwd3 , "UTF-8" );

	String base = "チェックパターン IN ( 'A' , 'B' , 'C' )";
	XIBBSeikyuusaki[] seiklist = XIBBSeikyuusakiAcc.getByKeyword( base , kwd1 , kwd2 , kwd3 );
%>
<HEAD>
	<TITLE>パターン一覧【xi1310】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1310.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="1024">
		<TR>
			<TD align="center"><P class="title01">パターン一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./submenu1.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<FORM name="kensaku01" method="post" action="./xi1310.jsp" >
	<TABLE width="1024" class="tbl02">
		<TR>
			<TH width="5%"></TH>
			<TH width="30%"></TH>
			<TH width="30%"></TH>
			<TH width="30%"></TH>
			<TH width="5%"></TH>
		</TR>
		<TR>
			<TD></TD>
			<TD colspan="3" class="text02">
				請求元・請求先・件名の他、起票者名や工事名・部門名も検索します。
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD align="center">
				<INPUT name="kwd1" type="text" value="<%=kwd1 %>" size="8"  placeholder="キーワード1" class="input01"/>
			</TD>
			<TD align="center">
				<INPUT name="kwd2" type="text" value="<%=kwd2 %>" size="8"  placeholder="キーワード2" class="input01"/>
			</TD>
			<TD align="center">
				<INPUT name="kwd3" type="text" value="<%=kwd3 %>" size="8"  placeholder="キーワード3" class="input01"/>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD colspan="5" align="center">
				<A href="javascript:document.kensaku01.submit()">
					<IMG src="../image/kensaku01.png" onmouseover="this.src='../image/kensaku02.png'"
						 onmouseout="this.src='../image/kensaku01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	</FORM>
	<TABLE width="1024">
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<P class="text01">
					誤ったパタンを登録した場合は一旦削除して再登録します。<BR/>
					起票者や工事コードの訂正は編集から。
				</P>
			</TD>
		</TR>
		<TR>
			<TD align="left">
				<A href="./xi1330.jsp?kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>">
					<IMG src="../image/shinki01.png" onmouseover="this.src='../image/shinki02.png'"
						 onmouseout="this.src='../image/shinki01.png'" class="img" />
				</A>
				&nbsp;&nbsp;&nbsp;<IMG src="../image/hidari.png" class="img" />
				<SPAN class="text04">
					パターン登録はこちらから！！
				</SPAN>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="1024"  class="tbl01">
		<TR class="header01">
			<TH width="05%">No</TH>
			<TH width="07%">パタン</TH>
			<TH width="74%">請求書情報</TH>
			<TH width="07%">&nbsp;</TH>
			<TH width="07%">&nbsp;</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < seiklist.length ; i++ )
	{
		String no = String.valueOf( seiklist[i].getNo() );
		String ptn = seiklist[i].getCheckPattern();
		String moto = seiklist[i].getSeikyuuMoto();
		String saki = seiklist[i].getSeikyuuSaki();
		String kenmei = seiklist[i].getKenmei();

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR height="60" class="<%=row_cls %>">
			<TD align="center">
				<A href="./xi1320.jsp?no=<%=no %>&kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>" >
					<%=no %>
				</A>
			</TD>
			<TD align="center"><%=ptn %></TD>
			<TD align="left">
				<TABLE>
					<TR><TD class="text02">請求元：</TD><TD><%=moto %></TD></TR>
					<TR><TD class="text02">請求先：</TD><TD><%=saki %></TD></TR>
					<TR><TD class="text02">件名：</TD><TD><%=kenmei %></TD></TR>
				</TABLE>
			</TD>
			<TD align="center">
				<A href="./xi1360.jsp?no=<%=no %>&kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>">
					<IMG src="../image/hensyuu01.png" onmouseover="this.src='../image/hensyuu02.png'"
						 onmouseout="this.src='../image/hensyuu01.png'" class="img" />
				</A>
			</TD>
			<TD align="center">
				<A href="javascript:sakujyo( '<%=no %>' );">
					<IMG src="../image/sakujyo01.png" onmouseover="this.src='../image/sakujyo02.png'"
						 onmouseout="this.src='../image/sakujyo01.png'" class="img" />
				</A>
			</TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
