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

	String[][] kenlist = XIBBCsvAcc.status70Kenmei();
%>
<HEAD>
	<TITLE>BtoB件名登録【xi1330】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="1024">
		<TR>
			<TD align="center"><P class="title01">アンマッチ一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1310.jsp?kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<P class="text01">
					対象アンマッチの「登録」ボタンでパタンを登録します。
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="1024"  class="tbl01">
		<TR class="header01">
			<TH width="30%">請求元</TH>
			<TH width="30%">請求先</TH>
			<TH width="35%">件名</TH>
			<TH width="05%">&nbsp;</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < kenlist.length ; i++ )
	{
		String clm1 = kenlist[i][1];
		String clm2 = kenlist[i][2];
		String clm3 = kenlist[i][3];
		String e_clm1 = URLEncoder.encode( clm1 , "UTF-8" );
		String e_clm2 = URLEncoder.encode( clm2 , "UTF-8" );
		String e_clm3 = URLEncoder.encode( clm3 , "UTF-8" );

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR height="60" class="<%=row_cls %>">
			<TD align="left"><%=clm1 %></TD>
			<TD align="left"><%=clm2 %></TD>
			<TD align="left"><%=clm3 %></TD>
			<TD align="center">
				<A href="./xi1340.jsp?moto=<%=e_clm1 %>&saki=<%=e_clm2 %>&kenmei=<%=e_clm3 %>&kwd1=<%=e_kwd1 %>&kwd2=<%=e_kwd2 %>&kwd3=<%=e_kwd3 %>">
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
