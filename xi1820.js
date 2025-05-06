function sakujyo( cd , name , ptn )
{
	if ( confirm( ptn + "を削除します。　よろしいですか?") )
	{
		kwd = document.kensaku01.kwd.value;
		eptn = encodeURI(ptn)
		window.location.href = './xi1880.jsp?code=' + cd + '&name=' + name + '&pattern=' + eptn + '&kwd=' + kwd;
	}
	else
	{
		return;
	}
}
