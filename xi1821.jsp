<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String kwd = request.getParameter("kwd");
	if ( kwd == null ) kwd = "";
	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String ptn = request.getParameter("ptn");
	String[] meisai = XIKeihiPatternAcc.getMeisaiByPattern( name , ptn );

	String e_kwd = URLEncoder.encode( kwd , "UTF-8" );
	String e_name = URLEncoder.encode( name , "UTF-8" );
%>
<HEAD>
	<TITLE>明細一覧【xi2010】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">パターンマッチ明細一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1820.jsp?code=<%=code %>&name=<%=e_name %>&kwd=<%=e_kwd %>">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD class="text01">
				パターン<SPAN class="text04">「<%=ptn %>」</SPAN>にマッチした明細です。
			</TD>
		</TR>
		<TR><TD>&nbsp;</TD></TR>
	</TABLE>
	<TABLE width="640"  class="tbl01">
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < meisai.length ; i++ )
	{
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="center"><%=meisai[i] %></TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
