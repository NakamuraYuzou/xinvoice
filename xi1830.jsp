<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String prevkwd = request.getParameter("prevkwd");
	String kwd = request.getParameter("kwd");
	if ( kwd == null ) kwd = "";
	if ( prevkwd == null ) prevkwd = "";
	String e_kwd = URLEncoder.encode( kwd , "UTF-8" );
	String e_name = URLEncoder.encode( name , "UTF-8" );
	String e_prevkwd = URLEncoder.encode( prevkwd , "UTF-8" );

	String[][] kouholist = XIKeihiPatternAcc.getKouhoList( code , name , kwd );

	XIBBSeikyuumoto moto = XIBBSeikyuumotoAcc.getByCdName( code , name );
	String expname08 = moto.getExpenseTypeName08();
	String expname10 = moto.getExpenseTypeName10();
%>
<HEAD>
	<TITLE>明細パターン登録【xi1830】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">未登録一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1820.jsp?code=<%=code %>&name=<%=e_name %>&kwd=<%=e_prevkwd %>">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<FORM name="kensaku01" method="post" action="./xi1830.jsp" >
	<TABLE width="800" class="tbl02">
		<TR>
			<TH width="5%"></TH>
			<TH width="45%"></TH>
			<TH width="45%"></TH>
			<TH width="5%"></TH>
		</TR>
		<TR>
			<TD></TD>
			<TD colspan="2" class="text02">
				<%=code %>：<%=name %>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD colspan="2" class="text02">
				&nbsp;&nbsp;&nbsp;&nbsp;経費タイプ(8%)：	<%=expname08 %>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD colspan="2" class="text02">
				&nbsp;&nbsp;&nbsp;&nbsp;経費タイプ(10%)：	<%=expname10 %>
			</TD>
			<TD></TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD></TD>
			<TD align="center">
				<INPUT name="kwd" type="text" value="<%=kwd %>" size="10"  placeholder="キーワード" class="input01"/>
				<INPUT name="code" type="hidden" value="<%=code %>" />
				<INPUT name="name" type="hidden" value="<%=name %>" />
			</TD>
			<TD colspan="5" align="center">
				<A href="javascript:document.kensaku01.submit()">
					<IMG src="../image/kensaku01.png" onmouseover="this.src='../image/kensaku02.png'"
						 onmouseout="this.src='../image/kensaku01.png'" class="img" />
				</A>
			</TD>
			<TD></TD>
		</TR>
	</TABLE>
	</FORM>
	<TABLE width="640">
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<P class="text01">
					未登録の請求書明細です。「登録」ボタンでパタンを登録します。
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="800"  class="tbl01">
		<TR class="header01">
			<TH width="90%">請求元</TH>
			<TH width="10%">&nbsp;</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < kouholist.length ; i++ )
	{
		String clm1 = kouholist[i][6];
		String e_meis = URLEncoder.encode( clm1 , "UTF-8" );

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="left"><%=clm1 %></TD>
			<TD align="center">
				<A href="./xi1840.jsp?code=<%=code %>&name=<%=e_name %>&meisai=<%=e_meis %>&kwd=<%=e_kwd %>">
					<IMG src="../image/touroku01.png" onmouseover="this.src='../image/touroku02.png'"
						 onmouseout="this.src='../image/touroku01.png'" class="img" />
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
