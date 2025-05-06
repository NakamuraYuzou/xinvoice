<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
%>
<HEAD>
	<TITLE>請求書CSV【ix1020】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800">
		<TR>
			<TD align="center"><P class="title01">CSVファイル指定</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1010.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
<BR/>
	<FORM name="syokuseki" method="POST" enctype="multipart/form-data" action="../XIFileUpload" >
	<TABLE width="800"  class="tbl02">
		<TR>
			<TH width="10%"></TH>
			<TH width="30%"></TH>
			<TH width="50%"></TH>
			<TH width="10%"></TH>
		<TR>
		<TR height="70">
			<TD></TD>
			<TD colspan="2"  class="text04">
				CSVファイルを指定してください。
			</TD>
			<TD></TD>
		</TR>
		<TR height="50">
			<TD></TD>
			<TD  class="text04">ファイル名</TD>
			<TD>
				<INPUT type="file" name="file" class="input01"/>
				<INPUT type="hidden" name="next" value="btob/xi1030.jsp" />
			</TD>
			<TD></TD>
		</TR>
		<TR height="50">
			<TD></TD>
			<TD colspan="2" align="center" >
				<A href="javascript:document.syokuseki.submit();">
					<IMG src="../image/torikomi01.png" onmouseover="this.src='../image/torikomi02.png'"
						 onmouseout="this.src='../image/torikomi01.png'" class="img" />
				</A>
			</TD>
			<TD></TD>
		</TR>
	</TABLE>
	</FORM>
</DIV>
</BODY>
</HTML>
