<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String lv2id = request.getParameter("lv2id");
	String lv2code = request.getParameter("lv2code");
	String lv2name = request.getParameter("lv2name");
	XICCListItem[] cclist = XICCListItemAcc.getByParentID( lv2id );

	String listid = "";
	String listno = "";
	String listname = "";
	String lv1id = "";
	String lv1code = "";
	String lv1name = "";
	String e_lv1name = "";
	XISession xiss = new XISession( request , response );
	if ( !xiss.confirmSession() )
	{
		response.sendRedirect("../sessionerr.jsp");
		return;
	}
	else
	{
		xiss.setLV2ID( lv2id );
		xiss.setLV2Code( lv2code );
		xiss.setLV2Name( lv2name );
		listid = xiss.getListID();
		listno = xiss.getListNo();
		listname = xiss.getListName();
		lv1id = xiss.getLV1ID();
		lv1code = xiss.getLV1Code();
		lv1name = xiss.getLV1Name();
		e_lv1name = URLEncoder.encode( lv1name , "UTF-8");
	}
%>
<HEAD>
	<TITLE>レベル3一覧【xi0422】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">レベル3一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi0421.jsp?lv1id=<%=lv1id %>&lv1code=<%=lv1code %>&&lv1name=<%=e_lv1name %>">
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
					<TR>
						<TD width="15%" align="center" class="header01">
							レベル2
						</TD>
						<TD width="20%" class="row01">
							<%=lv2code %>
						</TD>
						<TD width="65%" class="row01">
							<%=lv2name %>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR>
			<TD>
				<P class="text01">
					レベル4は詳細ボタンから!
				</P>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="640"  class="tbl01">
		<TR class="header01">
			<TH width="70%">名称</TH>
			<TH width="20%">レベル3</TH>
			<TH width="10%"></TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < cclist.length ; i++ )
	{
		String clm1 = cclist[i].getName();
		String clm2 = cclist[i].getLevel3Code();
		String lv3id = cclist[i].getID();
		String e_name = URLEncoder.encode( clm1 , "UTF-8" );
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="left">&nbsp;<%=clm1 %></TD>
			<TD align="left">&nbsp;<%=clm2 %></TD>
			<TD align="right">
				<A href="./xi0423.jsp?lv3id=<%=lv3id %>&lv3code=<%=clm2 %>&lv3name=<%=e_name %>">
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
