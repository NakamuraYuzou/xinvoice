<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	XIBBVStatusCount[] cnts = XIBBVStatusCountAcc.getAll();
	int cnt10 = XIBBVStatusCountAcc.getCountByStatus( "10" , cnts );
	int cnt20 = XIBBVStatusCountAcc.getCountByStatus( "20" , cnts );
	int cnt30 = XIBBVStatusCountAcc.getCountByStatus( "30" , cnts );
	int cnt60 = XIBBVStatusCountAcc.getCountByStatus( "60" , cnts );
	int cnt70 = XIBBVStatusCountAcc.getCountByStatus( "70" , cnts );
	int cnt71 = XIBBVStatusCountAcc.getCountByStatus( "71" , cnts );
	int cnt90 = XIBBVStatusCountAcc.getCountByStatus( "90" , cnts );
%>
<HEAD>
	<TITLE>BtoB取込メニュー</TITLE>
	<LINK rel="stylesheet" type="text/css" href="../css/style01.css" />
	<SCRIPT type="text/javascript" src="../js/submenu1.js"></SCRIPT>
</HEAD>
<BODY>
<DIV align="center">
	<TABLE width=900">
		<TR>
			<TD colspan="2" align="center"><P class="title01">BtoB取込メニュー</P></TD>
		</TR>
		<TR>
			<TD>
				&nbsp;&nbsp;<A href="javascript:kaisetsu02();">この画面の使い方＞＞</A>
			</TD>
			<TD align="right">
				<A href="../menu.jsp">
					<IMG src="../image/modoru01.png" onmouseover="this.src='../image/modoru02.png'"
						 onmouseout="this.src='../image/modoru01.png'" class="img" />
				</A>
			</TD>
		</TR>
	</TABLE>
	<TABLE width="900">
		<TR>
			<TD>
				<TABLE width="200">
					<TR height="60">
						<TD align="right">
							<A href="./xi1010.jsp">
								<IMG src="../image/frombtob01.png" onmouseover="this.src='../image/frombtob02.png'"
									 onmouseout="this.src='../image/frombtob01.png'" class="img" />
							</A>
						</TD>
					</TR>
					<TR height="60"><TD>　</TD></TR>
					<TR height="120"><TD>　</TD></TR>
					<TR height="60"><TD>　</TD></TR>
					<TR height="60"><TD>　</TD></TR>
					<TR height="60"><TD>　</TD></TR>
					<TR height="60"><TD>　</TD></TR>
				</TABLE>
			</TD>
			<TD>
				<TABLE width="500" class="tbl01">
					<TR height="60" class="row01">
						<TD width="10%" class="header01" align="center">①</TD>
						<TD width="55%">&nbsp;取込後チェック前</TD>
						<TD width="15%" align="center" ><%=cnt10 %>件</TD>
					</TR>
					<TR height="60" class="row03">
						<TD class="header01" align="center">②</TD>
						<TD>&nbsp;取引先未登録</TD>
						<TD align="center" ><%=cnt60 %>件</TD>
					</TR>
					<TR height="120" class="row03">
						<TD class="header01" align="center">③</TD>
						<TD>
							&nbsp;件名未登録<BR/>
							<SPAN class="text05">
								&nbsp;請求書単位の登録は「工事登録」へ<BR/>
								&nbsp;明細単位の登録は「明細未登録へ」へ
							</SPAN>
						</TD>
						<TD align="center" ><%=cnt70 %>件</TD>
					</TR>
					<TR height="60" class="row03">
						<TD class="header01" align="center">④</TD>
						<TD>&nbsp;明細未登録</TD>
						<TD align="center" ><%=cnt71 %>件</TD>
					</TR>
					<TR height="60" class="row01">
						<TD class="header01" align="center">⑤</TD>
						<TD>&nbsp;チェック済　コンカー連携へ</TD>
						<TD align="center" ><%=cnt20 %>件</TD>
					</TR>
					<TR height="60" class="row05">
						<TD class="header01" align="center">⑨</TD>
						<TD>&nbsp;保留中一覧</TD>
						<TD align="center" ><%=cnt30 %>件</TD>
					</TR>
					<TR height="60" class="row05">
						<TD class="header01" align="center">⑩</TD>
						<TD>&nbsp;コンカー送信済</TD>
						<TD align="center" ><%=cnt90 %>件</TD>
					</TR>
				</TABLE>
			</TD>
			<TD>
				<TABLE width="200">
					<TR height="60"						>
						<TD>
							<A href="./xi1100.jsp">
									<IMG src="../image/check01.png" onmouseover="this.src='../image/check02.png'"
									 onmouseout="this.src='../image/check01.png'" class="img" />
							</A>
						</TD>
					</TR>
					<TR height="60"						>
						<TD>
							<A href="./xi1210.jsp">
									<IMG src="../image/aitetouroku01.png" onmouseover="this.src='../image/aitetouroku02.png'"
									 onmouseout="this.src='../image/aitetouroku01.png'" class="img" />
							</A>
						</TD>
					</TR>
					<TR height="120"						>
						<TD>
							<A href="./xi1310.jsp">
									<IMG src="../image/koujitouroku01.png" onmouseover="this.src='../image/koujitouroku02.png'"
									 onmouseout="this.src='../image/koujitouroku01.png'" class="img" />
							</A>
							<BR/>
							<A href="./xi1410.jsp">
									<IMG src="../image/mitouroku01.png" onmouseover="this.src='../image/mitouroku02.png'"
									 onmouseout="this.src='../image/mitouroku01.png'" class="img" />
							</A>
						</TD>
					</TR>
					<TR height="60"						>
						<TD>
							<A href="./xi1510.jsp">
									<IMG src="../image/meisaitouroku01.png" onmouseover="this.src='../image/meisaitouroku02.png'"
									 onmouseout="this.src='../image/meisaitouroku01.png'" class="img" />
							</A>
						</TD>
					</TR>
					<TR height="60"						>
						<TD>
							<A href="./xi1910.jsp">
									<IMG src="../image/toconcur01.png" onmouseover="this.src='../image/toconcur02.png'"
									 onmouseout="this.src='../image/toconcur01.png'" class="img" />
							</A>
						</TD>
					</TR>
					<TR height="60"						>
						<TD>
							<A href="./xi1610.jsp">
									<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
									 onmouseout="this.src='../image/pochi01.png'" class="img" />
							</A>
						</TD>
					</TR>
					<TR height="60"						>
						<TD>
							<A href="./xi1650.jsp">
									<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
									 onmouseout="this.src='../image/pochi01.png'" class="img" />
							</A>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
<BR/>
	<TABLE width="640">
		<TR>
			<TD align="left" class="text01">
			下のポチをクリックしてください。
			</TD>
		</TR>
	</TABLE>
	<TABLE width="640">
		<TR><TD class="text02" colspan="2" align="left">■■番外処理■■</TD><TR>
		<TR height="40">
			<TD width="5%">
				<A href="./xi1710.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text02" align="left">
				番外1　パターンの送信先(メアド)を変更します。
			</TD>
		</TR>
		<TR height="40">
			<TD width="5%">
				<A href="./xi1810.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text02" align="left">
				番外2　明細単位の経費タイプを設定します。
			</TD>
		</TR>
		<TR height="40">
			<TD width="5%">
				<A href="./xi1250.jsp">
					<IMG src="../image/pochi01.png" onmouseover="this.src='../image/pochi02.png'"
						 onmouseout="this.src='../image/pochi01.png'" class="img" />
				</A>
			</TD>
			<TD class="text02" align="left">
				番外3　相手先(請求元)の基本の経費タイプを変更します。
			</TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>