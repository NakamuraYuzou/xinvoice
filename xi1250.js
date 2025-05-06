function sakujyo( cd , nm )
{
	if ( confirm( nm + "を削除します。　よろしいですか?") )
	{
		enm = encodeURI(nm)
		window.location.href = './xi1280.jsp?code=' + cd + '&name=' + enm;
	}
	else
	{
		return;
	}
}
