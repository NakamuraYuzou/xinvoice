<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String kwd = request.getParameter("kwd");
	if ( kwd == null ) kwd = "";
	String e_kwd = URLEncoder.encode( kwd , "UTF-8" );

	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String e_name = URLEncoder.encode( name , "UTF-8");
	XIKeihiPattern[] list = XIKeihiPatternAcc.getByKeyword( code , name , kwd );

	XIBBSeikyuumoto moto = XIBBSeikyuumotoAcc.getByCdName( code , name );
	String expname08 = moto.getExpenseTypeName08();
	String expname10 = moto.getExpenseTypeName10();
%>
<HEAD>
	<TITLE>経費タイプパターン一覧【xi1820】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1820.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="1024">
		<TR>
			<TD align="center"><P class="title01">経費タイプ　パターン一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1810.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<FORM name="kensaku01" method="post" action="./xi1820.jsp" >
	<TABLE width="1024" class="tbl02">
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
				<A href="./xi1830.jsp?code=<%=code %>&name=<%=name %>&prevkwd=<%=e_kwd %>">
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
			<TH width="40%">パターン</TH>
			<TH width="25%">8%の経費タイプ</TH>
			<TH width="25%">10%の経費タイプ</TH>
			<TH width="05%">&nbsp;</TH>
			<TH width="05%">&nbsp;</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < list.length ; i++ )
	{
		String clm1 = list[i].getExpenseTypePattern();
		String clm2 = list[i].getExpenseTypeName08();
		String clm3 = list[i].getExpenseTypeName10();
		if ( clm1 == null ) clm1 = "";
		String e_ptn = URLEncoder.encode( clm1 , "UTF-8" );

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="left">
				<A href="./xi1821.jsp?code=<%=code %>&name=<%=e_name %>&ptn=<%=e_ptn %>">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
				<SPAN title="<%=clm1 %>">
					<INPUT class="input91" name="pattern" value="<%=clm1 %>" size="31" readonly />
				</SPAN>
			</TD>
			<TD align="center">
				<SPAN title="<%=clm2 %>">
					<INPUT class="input91" name="expname08" value="<%=clm2 %>" size="20" readonly />
				</SPAN>
			</TD>
			<TD align="center">
				<SPAN title="<%=clm3 %>">
					<INPUT class="input91" name="expname10" value="<%=clm3 %>" size="20" readonly />
				</SPAN>
			</TD>
			<TD align="center">
				<A href="./xi1860.jsp?code=<%=code %>&name=<%=e_name %>&pattern=<%=e_ptn %>&kwd=<%=e_kwd %>">
					<IMG src="../image/hensyuu01.png" onmouseover="this.src='../image/hensyuu02.png'"
						 onmouseout="this.src='../image/hensyuu01.png'" class="img" />
				</A>
			</TD>
			<TD align="center">
				<A href="javascript:sakujyo( '<%=code %>' , '<%=e_name %>' , '<%=clm1 %>' );">
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
