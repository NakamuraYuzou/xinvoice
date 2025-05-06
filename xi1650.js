function sakujyo( code )
{
	if ( confirm( code + "番を削除します。　よろしいですか?") )
	{
		window.location.href = './xi1670.jsp?code=' + code;
	}
	else
	{
		return;
	}
}
