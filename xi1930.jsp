<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="xinvoice.*" %>
<!DOCTYPE HTML>
<HTML>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");

	String nextpgm = "./xi1910.jsp";
	int rc = XICCPaymentRequestAcc.putPaymentRequest( code );
	if ( rc == 200 )
	{
		XIBBCsvAcc.updateStatus( code , "90" );
	}
	else
	{
		XIBBCsvAcc.updateStatus( code , "91" );
		nextpgm = "./xi1931.jsp";
	}

%>
		<META http-equiv="refresh" content="0; URL=<%=nextpgm%>" />
</HTML>
