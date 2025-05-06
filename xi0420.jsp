<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String listid = request.getParameter("listid");
	String listno = request.getParameter("listno");
	String listname = request.getParameter("listname");
	XICCListItem[] cclist = XICCListItemAcc.getRoot( listid );

	XISession xiss = new XISession( request , response );
	if ( !xiss.confirmSession() ) response.sendRedirect("../sessionerr.jsp");
	xiss.setListID( listid );
	xiss.setListNo( listno );
	xiss.setListName( listname );
%>
<HEAD>
	<TITLE>ルート一覧【xi0420】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">ルート一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi0410.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<TABLE width="640"  class="tbl01">
					<TR>
						<TD class="row01">
							&nbsp;&nbsp;<%=listno %>&nbsp;&nbsp;:&nbsp;&nbsp;<%=listname %>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR>
			<TD>
				<P class="text01">
					最新情報の取り込みは、取込ボタンから!<BR/>
					レベル2の内容は詳細ボタンから！
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
		<TR>
			<TD>
				<A href="./xi0430.jsp?listid=<%=listid %>">
					<IMG src="../image/torikomi01.png" onmouseover="this.src='../image/torikomi02.png'"
						 onmouseout="this.src='../image/torikomi01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="640"  class="tbl01">
		<TR class="header01">
			<TH width="70%">名称</TH>
			<TH width="20%">レベル1</TH>
			<TH width="10%"></TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < cclist.length ; i++ )
	{
		String clm1 = cclist[i].getName();
		String clm2 = cclist[i].getLevel1Code();
		String lv1id = cclist[i].getID();
		String e_name = URLEncoder.encode( clm1 , "UTF-8" );
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="left">&nbsp;<%=clm1 %></TD>
			<TD align="left">&nbsp;<%=clm2 %></TD>
			<TD align="right">
				<A href="./xi0421.jsp?lv1id=<%=lv1id %>&lv1code=<%=clm2 %>&lv1name=<%=e_name %>">
					<IMG src="../image/syousai01.png" onmouseover="this.src='../image/syousai02.png'"
						 onmouseout="this.src='../image/syousai01.png'" class="img" />
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
