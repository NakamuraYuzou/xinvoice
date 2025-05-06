function sakujyo( no , code , gyou )
{
	if ( confirm( gyou + "番のパターンを削除します。　よろしいですか?") )
	{
		window.location.href = './xi1570.jsp?no=' + no + '&code=' + code;
	}
	else
	{
		return;
	}
}
