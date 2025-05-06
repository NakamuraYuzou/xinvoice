<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	String[][] meislist = XIBBCsvAcc.getMeisaiByCode( code );
%>
<HEAD>
	<TITLE>アンマッチ明細【xi1520】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1520.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="1024">
		<TR>
			<TD align="center"><P class="title01">アンマッチ明細</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1510.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="1024">
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<P class="text01">
					グレーアウト行はパータン登録済の明細行です。<BR/>
					パターン登録は「登録」ボタンから！
				</P>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="1024"  class="tbl01">
		<TR class="header01">
			<TH width="05%">No</TH>
			<TH width="74%">請求書情報</TH>
			<TH width="07%">状態</TH>
			<TH width="07%">パタン</TH>
			<TH width="07%">&nbsp;</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < meislist.length ; i++ )
	{
		String koumoku = meislist[i][0];
		String bumon = meislist[i][1];
		String bikou = meislist[i][2];
		String gyouno = meislist[i][5];
		String status = meislist[i][6];
		String ptn = meislist[i][7];
		String kanrino = meislist[i][9];
		String meisaino = meislist[i][10];

		String e_koumoku = URLEncoder.encode( koumoku , "UTF-8" );
		String e_bumon = URLEncoder.encode( bumon , "UTF-8" );
		String e_bikou = URLEncoder.encode( bikou , "UTF-8" );

		String row_cls = "row02";
		if ( status.equals("72") || status.equals("20") ) row_cls = "row09";
%>
		<TR height="60" class="<%=row_cls %>">
			<TD align="center"><%=gyouno %></TD>
			<TD align="left">
				<TABLE>
					<TR><TD class="text02">明細内容：</TD><TD><%=koumoku %></TD></TR>
					<TR><TD class="text02">部門名：</TD><TD><%=bumon %></TD></TR>
					<TR><TD class="text02">備考：</TD><TD><%=bikou %></TD></TR>
				</TABLE>
			</TD>
			<TD align="center"><%=status %></TD>
			<TD align="center"><%=ptn %></TD>
<%
		if ( status.equals("72") || status.equals("20") )
		{
%>
			<TD align="center">
				<A href="./xi1550.jsp?no=<%=meisaino %>&code=<%=code %>">
					<IMG src="../image/hensyuu01.png" onmouseover="this.src='../image/hensyuu02.png'"
						 onmouseout="this.src='../image/hensyuu01.png'" class="img" />
				</A>
				<P></P>
				<A href="javascript:sakujyo( '<%=meisaino %>' , '<%=code %>' , '<%=gyouno %>' );">
					<IMG src="../image/sakujyo01.png" onmouseover="this.src='../image/sakujyo02.png'"
						 onmouseout="this.src='../image/sakujyo01.png'" class="img" />
				</A>
			</TD>
<%
		}
		else
		{
%>
			<TD align="center">
				<A href="./xi1530.jsp?code=<%=code %>&ptn=<%=ptn %>&kanrino=<%=kanrino %>&koumoku=<%=e_koumoku %>&mbumon=<%=e_bumon %>&bikou=<%=e_bikou %>">
					<IMG src="../image/touroku01.png" onmouseover="this.src='../image/touroku02.png'"
						 onmouseout="this.src='../image/touroku01.png'" class="img" />
				</A>
			</TD>
<%
		}
%>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
