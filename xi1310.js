function sakujyo( no )
{
	if ( confirm( no + "番を削除します。　よろしいですか?") )
	{
		kwd1 = document.kensaku01.kwd1.value;
		kwd2 = document.kensaku01.kwd2.value;
		kwd3 = document.kensaku01.kwd3.value;
		window.location.href = './xi1380.jsp?no=' + no + '&kwd1=' + kwd1 + '&kwd2=' + kwd2 + '&kwd3=' + kwd3;
	}
	else
	{
		return;
	}
}
