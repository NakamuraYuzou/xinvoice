function touroku()
{
	if ( document.touroku01.torcode.value == "" )
	{
		alert("相手先コードを入れてください。");
		document.touroku01.moto.focus();
		return;
	}

	if ( document.touroku01.torname.value == "" )
	{
		alert("請求元名を入れてください。");
		document.touroku01.moto.focus();
		return;
	}

	if ( document.touroku01.expcode10.value == "" )
	{
		alert("消費税10%の経費タイプを入れてください。");
		document.touroku01.moto.focus();
		return;
	}

	document.touroku01.submit();
}

function sansyou40()
{
	window.open( '../master/xi0390.jsp' , null , 'width=840 , height=1800 , left=1000 , toolbar=no' );
}

function sansyou41()
{
	window.open( '../master/xi0391.jsp' , null , 'width=840 , height=1800 , left=1000 , toolbar=no' );
}
