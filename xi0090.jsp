<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String kwd = request.getParameter("kwd");
	if ( kwd == null ) kwd = "";
	XISyain[] sylst = XISyainAcc.getByKeyword( kwd );
%>
<HEAD>
	<TITLE>社員選択【xi0090】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi0090.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center" class="back01">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">社員検索</P></TD>
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
	<FORM name="kensaku01" method="post" action="./xi0090.jsp" >
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
				<SPAN class="text01">を含む氏名と部署を検索します</SPAN>
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
			<TH width="15%">社員CD</TH>
			<TH width="25%">社員名</TH>
			<TH width="50%">部署</TH>
			<TH width="10%"></TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < sylst.length ; i++ )
	{
		String clm1 = sylst[i].getSyainCode();
		String clm2 = sylst[i].getSyainName();
		String clm3 = sylst[i].getBusyoName();
		String meado = sylst[i].getMailAddress();

		String e_syainnm = URLEncoder.encode( clm2 , "utf-8" );

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR height="20" class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="left"><%=clm2 %></TD>
			<TD align="left">
				<SPAN title="<%=clm3 %>" >
					<INPUT class="input91" value="<%=clm3 %>" size="26" readonly />
				</SPAN>
			</TD>
			<TD align="center">
				<A href="javascript:set_values( '<%=clm2 %>' , '<%=meado %>' );">
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
