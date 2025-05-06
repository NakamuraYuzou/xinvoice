<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String kanricd = request.getParameter("code");

	XIBBVBBtoCCTop top = XIBBVBBtoCCTopAcc.getByKanriCode( kanricd );

	String koujicd = top.getKoujiCode();
	String syousaicd = top.getKoujiSyousaiCode();
	String title = "工事コード";
	String value1 = koujicd + " - " + syousaicd;
	String value2 = top.getKoujiName();
	if ( koujicd == null )
	{
		title = "部門コード";
		value1 = top.getBumonCode();
		value2 = top.getBumonName();
	}
	else if ( koujicd.equals("") )
	{
		title = "部門コード";
		value1 = top.getBumonCode();
		value2 = top.getBumonName();
	}
%>
<HEAD>
	<TITLE>BtoB請求内容【xi1920】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="900>
		<TR>
			<TD align="center"><P class="title01">BtoB請求内容</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi1910.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="900"  class="tbl01">
		<TR height="40">
			<TD  width="20%" class="header01">&nbsp;管理コード</TD>
			<TD  width="30%" class="row01">&nbsp;<%=kanricd %></TD>
			<TD  width="20%" class="header01">&nbsp;請求書番号</TD>
			<TD  width="30%" class="row01">&nbsp;<%=top.getSeikyuusyoBangou() %></TD>
		</TR>
		<TR height="40">
			<TD class="header01">&nbsp;請求元</TD>
			<TD colspan="3" class="row01">&nbsp;<%=top.getSeikyuumoto() %></TD>
		</TR>
		<TR height="40">
			<TD class="header01">&nbsp;請求先</TD>
			<TD colspan="3" class="row01">&nbsp;<%=top.getSeikyuusaki() %></TD>
		</TR>
		<TR height="60">
			<TD class="header01">&nbsp;件名</TD>
			<TD colspan="3" class="row01">&nbsp;<%=top.getKenmei() %></TD>
		</TR>
		<TR height="40">
			<TD class="header01">&nbsp;起票者</TD>
			<TD colspan="3" class="row01">
				&nbsp;<%=top.getKihyousyaName() %>&nbsp;<%=top.getMailAddress() %>
			</TD>
		</TR>
		<TR height="40">
			<TD class="header01">&nbsp;<%=title %></TD>
			<TD colspan="3" width="80%" class="row01">
				&nbsp;<%=value1 %>
				<SPAN title="<%=value2 %>">
					&nbsp;<INPUT class="input91" value="<%=value2 %>" size="48" readonly />
				</SPAN>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="900">
		<TR><TD align="center"><P class="title01">■■明細■■</P></TD></TR>
	</TABLE>
	<TABLE width="900"  class="tbl01">
		<TR class="header01">
			<TH  width="6%">No</TH>
			<TH  width="84%">項目名／経費タイプ</TH>
			<TH  width="10%">金額</TH>
		</TR>
<%
	XIBBVBBtoCCLine[] line = XIBBVBBtoCCLineAcc.getByKanriCode( kanricd );
	
	int line_cnt = 0;
	for ( int i = 0 ; i < line.length ; i++ )
	{
		String clm1 = String.valueOf( line[i].getMeisaiRenban() );
		String clm2 = line[i].getMeisaiKoumoku();
		String clm3 = String.format( "%,d" , line[i].getMeisaiKingaku() );
		String clm4 = line[i].getExpenseTypeName08();
		String clm5 = line[i].getExpenseTypeName10();
		String toricd = line[i].getTorihikisakiCode();
		String name = line[i].getSeikyuumoto();
		String ptntoricd = line[i].getPatternTorihikisakiCode();

		String e_name = URLEncoder.encode( name , "UTF-8" );
		String e_meisai = URLEncoder.encode( clm2 , "UTF-8" );

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";

		String bangou = line[i].getMeisaiBangou();
		if ( bangou.length() == 0 ) row_cls = "row03"; 
%>
		<TR class="row02">
			<TD align="center" valign="middle"><%=clm1 %></TD>
			<TD align="left">
				<TABLE>
					<TR>
						<TD colspan="2"><%=clm2 %></TD>
					</TR>
<%
		if ( ptntoricd == null )
		{
%>
					<TR>
						<TD width="378" class="text05">
							<A href="./xi1950.jsp?code=<%=kanricd %>&toricode=<%=toricd %>&name=<%=e_name %>&meisai=<%=e_meisai %>" >
								<%=clm4 %>
							</A>
						</TD>
						<TD width="378" class="text05">
							<A href="./xi1950.jsp?code=<%=kanricd %>&toricode=<%=toricd %>&name=<%=e_name %>&meisai=<%=e_meisai %>" >
								<%=clm5 %>
							</A>
						</TD>
					</TR>
<%
		}
		else
		{
%>
					<TR>
						<TD width="378" class="text05"><%=clm4 %></TD>
						<TD width="378" class="text05"><%=clm5 %></TD>
					</TR>
<%
		}
%>
				</TABLE>
			</TD>
			<TD align="center" valign="middle"><%=clm3 %></TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
