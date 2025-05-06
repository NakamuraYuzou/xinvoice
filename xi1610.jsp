<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	XIBBVBBtoCCTop[] list = XIBBVBBtoCCTopAcc.getByStatus("30");
%>
<HEAD>
	<TITLE>保留一覧【xi1610】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi1610.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="960">
		<TR>
			<TD align="center"><P class="title01">保留一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./submenu1.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<P class="text01">
					「復帰」で「コンカー連携へ」に戻ります。<BR/>
					「削除」は完全削除です。　戻すには、CSVの再取込が必要です。
				</P>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="960"  class="tbl01">
		<TR class="header01">
			<TH width="12%">管理コード</TH>
			<TH width="80%">請求書</TH>
			<TH width="8%">&nbsp;</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < list.length ; i++ )
	{
		String code = list[i].getKanriCode();
		String moto = list[i].getSeikyuumoto();
		String kenmei = list[i].getKenmei();
		String meado = list[i].getMailAddress();
		String kihyou = list[i].getKihyousyaName();

		String chkptn = list[i].getCheckPattern();
		String hiyoucd = list[i].getHiyouCode();
		String koujicd = list[i].getKoujiCode();
		String koujiscd = list[i].getKoujiSyousaiCode();
		String koujinm = list[i].getKoujiName();
		String bumoncd = list[i].getBumonCode();
		String bumonnm = list[i].getBumonName();
		String line3 = "　";
		if ( chkptn.equals("J") || chkptn.equals("K") || chkptn.equals("L") )
		{
			line3 = "工事コード(部門コード)は明細単位";
		}
		else
		{
			if ( hiyoucd.equals("01") ) line3 = koujicd + "-" + koujiscd + " : " + koujinm;
			if ( hiyoucd.equals("02") ) line3 = bumoncd + " : " + bumonnm;
		}

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="center">
				<A href="./xi1620.jsp?code=<%=code %>" >
					<%=code %>
				</A>
			</TD>
			<TD align="left">
				<TABLE width="768">
					<TR>
						<TD>
							<SPAN title="<%=moto %>" >
								<INPUT class="input91" value="<%=moto %>" size="71" readonly />
							</SPAN>
						</TD>
					</TR>
					<TR><TD><%=kenmei %></TD></TR>
					<TR>
						<TD>
							<SPAN title="<%=line3 %>" >
								<INPUT class="input91" value="<%=line3 %>" size="71" readonly />
							</SPAN>
						</TD>
					</TR>
					<TR><TD><%=meado %>&nbsp;:&nbsp;<%=kihyou %></TD></TR>
				</TABLE>
			</TD>
			<TD align="center" height="40">
				<A href="./xi1630.jsp?code=<%=code %>">
					<IMG src="../image/fukki01.png" onmouseover="this.src='../image/fukki02.png'"
						 onmouseout="this.src='../image/fukki01.png'" class="img" />
				</A>
				<BR/><BR/>
				<A href="javascript:sakujyo( '<%=code %>' );">
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
