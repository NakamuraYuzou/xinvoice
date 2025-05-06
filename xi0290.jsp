<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String nm = request.getParameter("nm");
	if ( nm == null ) nm = "";
	String[] bumon = request.getParameterValues("bumon");
	String[] chk = new String[18];
	for ( int i = 0 ; i < chk.length ; i++ ) chk[i] = "";
	if ( bumon != null )
	{
		for ( int i = 0 ; i < bumon.length ; i++ )
		{
			if ( bumon[i].equals("1101") ) chk[0] = "checked=\"chedked\"";
			if ( bumon[i].equals("1201") ) chk[1] = "checked=\"chedked\"";
			if ( bumon[i].equals("2309") ) chk[2] = "checked=\"chedked\"";
			if ( bumon[i].equals("2209") ) chk[3] = "checked=\"chedked\"";
			if ( bumon[i].equals("3101") ) chk[4] = "checked=\"chedked\"";
			if ( bumon[i].equals("3102") ) chk[5] = "checked=\"chedked\"";
			if ( bumon[i].equals("3103") ) chk[6] = "checked=\"chedked\"";
			if ( bumon[i].equals("3104") ) chk[7] = "checked=\"chedked\"";
			if ( bumon[i].equals("3105") ) chk[8] = "checked=\"chedked\"";
			if ( bumon[i].equals("3301") ) chk[9] = "checked=\"chedked\"";
			if ( bumon[i].equals("3302") ) chk[10] = "checked=\"chedked\"";
			if ( bumon[i].equals("3304") ) chk[11] = "checked=\"chedked\"";
			if ( bumon[i].equals("3305") ) chk[12] = "checked=\"chedked\"";
			if ( bumon[i].equals("3307") ) chk[13] = "checked=\"chedked\"";
			if ( bumon[i].equals("2101") ) chk[14] = "checked=\"chedked\"";
			if ( bumon[i].equals("2102") ) chk[15] = "checked=\"chedked\"";
			if ( bumon[i].equals("2105") ) chk[16] = "checked=\"chedked\"";
			if ( bumon[i].equals("1409") ) chk[17] = "checked=\"chedked\"";
		}
	}
	XIKouji[] kjlst = XIKoujiAcc.getByRequestParameter( request );

%>
<HEAD>
	<TITLE>工事選択【xi0290】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
	<SCRIPT type="text/javascript" src="../js/xi0290.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center" class="back01">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">工事検索</P></TD>
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
	<FORM name="kensaku01" method="post" action="./xi0290.jsp" >
	<TABLE width="640" class="tbl02">
		<TR>
			<TH width="5%"></TH>
			<TH width="15%"></TH>
			<TH width="15%"></TH>
			<TH width="15%"></TH>
			<TH width="15%"></TH>
			<TH width="15%"></TH>
			<TH width="15%"></TH>
			<TH width="5%"></TH>
		</TR>
		<TR>
			<TD></TD>
			<TD class="text02">部署</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="1101" class="input01" <%=chk[0] %>>工事課</INPUT>
			</TD>
			<TD colspan="2">
				<INPUT type="checkbox" name="bumon" value="1201" class="input01" <%=chk[1] %>>設備工事課</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="2309" class="input01" <%=chk[2] %>>通信部</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="2209" class="input01" <%=chk[3] %>>送電部</INPUT>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3101" class="input01" <%=chk[4] %>>鳥栖</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3102" class="input01" <%=chk[5] %>>武雄</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3103" class="input01" <%=chk[6] %>>伊万里</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3104" class="input01" <%=chk[7] %>>唐津</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3105" class="input01" <%=chk[8] %>>長崎</INPUT>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3301" class="input01" <%=chk[9] %>>東京</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3302" class="input01" <%=chk[10] %>>福岡工</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3304" class="input01" <%=chk[11] %>>熊本</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3305" class="input01" <%=chk[12] %>>鹿児島</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="3307" class="input01" <%=chk[13] %>>沖縄</INPUT>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD></TD>
			<TD></TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="2101" class="input01" <%=chk[14] %>>佐賀事</INPUT>
			</TD>
			<TD>
				<INPUT type="checkbox" name="bumon" value="2102" class="input01" <%=chk[15] %>>東部事</INPUT>
			</TD>
			<TD colspan="2">
				<INPUT type="checkbox" name="bumon" value="2105" class="input01" <%=chk[16] %>>インフラネット</INPUT>
			</TD>
			<TD colspan="2">
				<INPUT type="checkbox" name="bumon" value="1409" class="input01" <%=chk[17] %>>カスタマー</INPUT>
			</TD>
		</TR>
		<TR>
			<TD></TD>
			<TD class="text02">キーワード</TD>
			<TD colspan="5" class="text02">
				&nbsp;&nbsp;
				<INPUT name="nm" value="<%=nm %>" size="10" class="input01" />
				<SPAN class="text01">を含む工事を検索します</SPAN>
			</TD>
			<TD></TD>
		</TR>
		<TR>
			<TD colspan="8" align="center">
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
			<TH width="20%">工事CD</TH>
			<TH width="10%">詳細CD</TH>
			<TH width="60%">工事名</TH>
			<TH width="10%"></TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < kjlst.length ; i++ )
	{
		String clm1 = kjlst[i].getKoujiCode();
		String clm2 = kjlst[i].getKoujiSyousaiCode();
		String clm3 = kjlst[i].getKoujiMeisyou();
		String bumoncd = kjlst[i].getBumonCode();
		String bumonnm = kjlst[i].getBumonMeisyou();

		String e_syainnm = URLEncoder.encode( clm2 , "utf-8" );

		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR height="20" class="<%=row_cls %>">
			<TD align="center"><%=clm1 %></TD>
			<TD align="center"><%=clm2 %></TD>
			<TD align="left">
				<SPAN title="<%=clm3 %>" >
					&nbsp;<INPUT class="input91" value="<%=clm3 %>" size="32" readonly />
				</SPAN>
			</TD>
			<TD align="center">
				<A href="javascript:set_values( '<%=clm1 %>' , '<%=clm2 %>'  , '<%=clm3 %>' , '<%=bumoncd %>' , '<%=bumonnm %>' );">
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
