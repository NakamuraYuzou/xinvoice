<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String kwd = request.getParameter("kwd");
	if ( kwd == null ) kwd = "";
	XIBumon[] bmnlst = XIBumonAcc.getByKeyword( kwd );
%>
<HEAD>
	<TITLE>部門選択【xi0190】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi0190.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center" class="back01">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">部門検索</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="javascript:window.close();">
					<IMG src="../image/tojiru01.png" onmouseover="this.src='../image/tojiru02.png'"
						 onmouseout="this.src='../image/tojiru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<FORM name="kensaku01" method="post" action="./xi0190.jsp" >
	<TABLE width="640" class="tbl02">
		<TR>
			<TH width="5%"></TH>
			<TH width="15%"></TH>
			<TH width="75%"></TH>
			<TH width="5%"></TH>
		</TR>
		<TR>
			<TD></TD>
			<TD class="text02">キーワード</TD>
			<TD class="text02">
				<INPUT name="kwd" value="<%=kwd %>" size="10" class="input01" />
				<SPAN class="text01">を含む部門を検索します</SPAN>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD colspan="4" align="center">
				<A href="javascript:document.kensaku01.submit()">
					<IMG src="../image/kensaku01.png" onmouseover="this.src='../image/kensaku02.png'"
						 onmouseout="this.src='../image/kensaku01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	</FORM>
	<TABLE>
		<TR><TD>&nbsp;</TD></TR>
	</TABLE>
	<TABLE width="640" class="tbl01">
		<TR class="header01">
			<TH width="15%">部門CD</TH>
			<TH width="75%">部門名</TH>
			<TH width="10%"></TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < bmnlst.length ; i++ )
	{
		String clm1 = bmnlst[i].getBumonCode();
		String clm2 = bmnlst[i].getBumonMeisyou();

		String e_syainnm = URLEncoder.encode( clm2 , "utf-8" );

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR height="20" class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="left"><%=clm2 %></TD>
			<TD align="center">
				<A href="javascript:set_values( '<%=clm1 %>' , '<%=clm2 %>' );">
					<IMG src="../image/sentaku01.png" onmouseover="this.src='../image/sentaku02.png'"
						 onmouseout="this.src='../image/sentaku01.png'" class="img" />
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
