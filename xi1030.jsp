<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	String fname = request.getParameter("fname");
	String fpath = application.getRealPath("upload");
	String inf = fpath + "\\" + fname;

	long cnt = XIBBCsvAcc.copyIn( inf );
	String cntstr = String.format( "%,d" , cnt );

%>
<HEAD>
	<TITLE>取込完了【xi1030】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="800">
		<TR>
			<TD align="center"><P class="title01">取込完了</P></TD>
		</TR>
	</TABLE>
<BR/>
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
				■取込完了
			</TD>
			<TD></TD>
		</TR>
		<TR height="50">
			<TD></TD>
			<TD  colspan="2" class="text04">
				<BR/>
				<%=cntstr %>明細取込みました。(伝票数ではありません)<BR/><BR/>
				「戻る」ボタンで一覧画面に移ってください。<BR/>
			</TD>
			<TD></TD>
		</TR>
		<TR height="50"><TD colspan="4"></TD></TR>
		<TR height="50">
			<TD></TD>
			<TD colspan="2" align="center" >
				<A href="./xi1010.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
			<TD></TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
