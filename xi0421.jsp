<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String lv1id = request.getParameter("lv1id");
	String lv1code = request.getParameter("lv1code");
	String lv1name = request.getParameter("lv1name");
	XICCListItem[] cclist = XICCListItemAcc.getByParentID( lv1id );

	String listid = "";
	String listno = "";
	String listname = "";
	String e_listname = "";
	XISession xiss = new XISession( request , response );
	if ( !xiss.confirmSession() )
	{
		response.sendRedirect("../sessionerr.jsp");
		return;
	}
	else
	{
		xiss.setLV1ID( lv1id );
		xiss.setLV1Code( lv1code );
		xiss.setLV1Name( lv1name );
		listid = xiss.getListID();
		listno = xiss.getListNo();
		listname = xiss.getListName();
		e_listname = URLEncoder.encode( listname , "UTF-8");
	}
%>
<HEAD>
	<TITLE>レベル2一覧【xi0421】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">レベル2一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi0420.jsp?listid=<%=listid %>&listno=<%=listno %>&&listname=<%=e_listname %>">
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
				<TABLE width="640"  class="tbl01">
					<TR>
						<TD width="15%" align="center" class="header01">
							レベル1
						</TD>
						<TD width="20%" class="row01">
							<%=lv1code %>
						</TD>
						<TD width="65%" class="row01">
							<%=lv1name %>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR>
			<TD>
				<P class="text01">
					レベル3は詳細ボタンから!
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="640"  class="tbl01">
		<TR class="header01">
			<TH width="70%">名称</TH>
			<TH width="20%">レベル2</TH>
			<TH width="10%"></TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < cclist.length ; i++ )
	{
		String clm1 = cclist[i].getName();
		String clm2 = cclist[i].getLevel2Code();
		String lv2id = cclist[i].getID();
		String e_name = URLEncoder.encode( clm1 , "UTF-8" );
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="left">&nbsp;<%=clm1 %></TD>
			<TD align="left">&nbsp;<%=clm2 %></TD>
			<TD align="right">
				<A href="./xi0422.jsp?lv2id=<%=lv2id %>&lv2code=<%=clm2 %>&lv2name=<%=e_name %>">
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
