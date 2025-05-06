<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("UTF-8");
	String lv3id = request.getParameter("lv3id");
	String lv3code = request.getParameter("lv3code");
	String lv3name = request.getParameter("lv3name");
	XICCListItem[] cclist = XICCListItemAcc.getByParentID( lv3id );

	String listid = "";
	String listno = "";
	String listname = "";
	String lv1id = "";
	String lv1code = "";
	String lv1name = "";
	String lv2id = "";
	String lv2code = "";
	String lv2name = "";
	String e_lv2name = "";
	XISession xiss = new XISession( request , response );
	if ( !xiss.confirmSession() )
	{
		response.sendRedirect("../sessionerr.jsp");
		return;
	}
	else
	{
		xiss.setLV3ID( lv3id );
		xiss.setLV3Code( lv3code );
		xiss.setLV3Name( lv3name );
		listid = xiss.getListID();
		listno = xiss.getListNo();
		listname = xiss.getListName();
		lv1id = xiss.getLV1ID();
		lv1code = xiss.getLV1Code();
		lv1name = xiss.getLV1Name();
		lv2id = xiss.getLV2ID();
		lv2code = xiss.getLV2Code();
		lv2name = xiss.getLV2Name();
		e_lv2name = URLEncoder.encode( lv2name , "UTF-8");
	}
%>
<HEAD>
	<TITLE>レベル4一覧【xi0423】</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width="640">
		<TR>
			<TD align="center"><P class="title01">レベル4一覧</P></TD>
		</TR>
		<TR>
			<TD align="right">
				<A href="./xi0422.jsp?lv2id=<%=lv2id %>&lv2code=<%=lv2code %>&&lv2name=<%=e_lv2name %>">
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
					<TR>
						<TD width="15%" align="center" class="header01">
							レベル3
						</TD>
						<TD width="20%" class="row01">
							<%=lv3code %>
						</TD>
						<TD width="65%" class="row01">
							<%=lv3name %>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
		<TR><TD></TD></TR>
	</TABLE>
	<TABLE width="640"  class="tbl01">
		<TR class="header01">
			<TH width="80%">名称</TH>
			<TH width="20%">レベル4</TH>
		</TR>
<%
	int line_cnt = 0;
	for ( int i = 0 ; i < cclist.length ; i++ )
	{
		String clm1 = cclist[i].getName();
		String clm2 = cclist[i].getLevel4Code();
		line_cnt++;
		String row_cls = "row01";
		if ( (line_cnt % 2) == 0 ) row_cls = "row02";
%>
		<TR class="<%=row_cls %>">
			<TD align="left">&nbsp;<%=clm1 %></TD>
			<TD align="left">&nbsp;<%=clm2 %></TD>
		</TR>
<%
	}
%>
	</TABLE>
</DIV>
</BODY>
</HTML>
