<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String kwd = request.getParameter("kwd");
	if ( kwd == null ) kwd = "";
	XISyain[] sylst = XISyainAcc.getByKeyword( kwd );
%>
<HEAD>
	<TITLE>解説</TITLE>
	<LINK rel="stylesheet" href="../css/style01.css" type="text/css" />
</HEAD>
<BODY>
<DIV align="center" class="back01">
	<TABLE width="800>
		<TR>
			<TD align="center"><P class="title01">部分一致</P></TD>
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
	<TABLE width="800" class="tbl02">
		<TR>
			<TH width="5%"></TH>
			<TH width="90%"></TH>
			<TH width="5%"></TH>
		</TR>
		<TR>
			<TD></TD>
			<TD class="text02">
				この画面は、BtoBプラットフォームの請求書に工事コード・起票者の情報・経費タイ
				プ・相手先情報を紐づけて、コンカーに登録します。<BR/><BR/>
				工事コードなどの情報は、請求書の相手先や件名の情報をもとにパタンマッチングで
				自動登録します。<BR/>
				パタンにマッチしない請求書、例えば新規工事の最初の請求書などはエラーになりま
				す。　エラー請求書をこの画面でパタン登録することで、次月以降自動登録が開始さ
				れます。<BR/><BR/>
				パタンは「請求書単位」と「明細単位」の2種類があります。請求書全体を同じ工事コ
				ードで起票する場合が「請求書単位」で、メニューの③件名未登録から「工事登録」へ
				すすみます。<BR/>
				1つの請求書の明細毎に工事コードを設定する場合が「明細単位」で、③件名未登録から
				「未明細未登録へ」をクリックして一旦④明細未登録に送り込んだ後に、明細単位の
				パタン設定を行います。
			</TD>
			<TD></TD>
		</TR>
	</TABLE>
</DIV>
</BODY>
</HTML>
