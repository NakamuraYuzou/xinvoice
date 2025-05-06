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
	<TITLE>解説</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center" class="back01">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">部分一致</P></TD>
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
	<TABLE width="800" class="tbl02">
		<TR>
			<TH width="5%"></TH>
			<TH width="90%"></TH>
			<TH width="5%"></TH>
		</TR>
		<TR>
			<TD></TD>
			<TD class="text02">
				部分一致は、件名の文字列に可変な部分を含む場合、その部分を除いて一致判定を行います。
				例えば、件名の文字が「レンタル料(8月分)」のような場合は、「(8月分)」を除いた
				「レンタル料」の部分が一致すれば一致とみなします。<BR/>
				登録の際は、可変部分を「%」(半角パーセント)に置き換えます。<BR/><BR/>
				例：<BR/>
				件名が「10月分ご請求」の時、「%月分ご請求」で登録。<BR/>
				件名が「ご利用料(202408)」の時、「ご利用料%」で登録。
			</TD>
			<TD></TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
