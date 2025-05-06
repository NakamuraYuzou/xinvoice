function touroku()
{
	if ( document.touroku01.moto.value == "" )
	{
		alert("請求元は何か入れてください。");
		document.touroku01.moto.focus();
		return;
	}

	if ( document.touroku01.meado.value == "" )
	{
		alert("起票者のメアドを入れてください。");
		document.touroku01.meado.focus();
		return;
	}

	document.touroku01.submit();
}

function ptn_msg()
{
	if ( document.touroku01.ptn.value == "J" )
	{
		document.touroku01.msg.value='';
		document.touroku01.msg.type='hidden';
	}
	if ( document.touroku01.ptn.value == "K" )
	{
		document.touroku01.msg.value='↑可変部分は%にしてください。';
		document.touroku01.msg.type='text';
	}
	if ( document.touroku01.ptn.value == "L" )
	{
		document.touroku01.msg.value='↑この項目は無視されます。';
		document.touroku01.msg.type='text';
	}
}

function sansyou1()
{
	window.open( '../master/xi0090.jsp' , null , 'width=840 , height=1800 , left=1000 , toolbar=no' );
}
