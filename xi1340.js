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

	if ( document.touroku01.hiyou.value == "01" && document.touroku01.kouji1.value == "" ) 
	{
		alert("工事コードを入れてください。");
		document.touroku01.kouji1.focus();
		return;
	}

	if ( document.touroku01.bumon.value == "" )
	{
		alert("部門コードを入れてください。");
		document.touroku01.kouji1.focus();
		return;
	}

	document.touroku01.submit();
}

function ptn_msg()
{
	if ( document.touroku01.ptn.value == "A" )
	{
		document.touroku01.msg.value='';
		document.touroku01.msg.type='hidden';
	}
	if ( document.touroku01.ptn.value == "B" )
	{
		document.touroku01.msg.value='↑可変部分は「%」にしてください。';
		document.touroku01.msg.type='text';
	}
	if ( document.touroku01.ptn.value == "C" )
	{
		document.touroku01.msg.value='↑この項目は無視されます。';
		document.touroku01.msg.type='text';
	}
}

function hiyou_msg()
{
	if ( document.touroku01.hiyou.value == "01" )
	{
		document.touroku01.hiyoumsg.value='工事コードと部門コードは必須です！';
	}
	if ( document.touroku01.hiyou.value == "02" )
	{
		document.touroku01.hiyoumsg.value='部門コードは必須です！';
	}
}


function sansyou1()
{
	window.open( '../master/xi0090.jsp' , null , 'width=840 , height=1800 , left=1000 , toolbar=no' );
}

function sansyou2()
{
	window.open( '../master/xi0290.jsp' , null , 'width=840 , height=1800 , left=1000 , toolbar=no' );
}

function sansyou3()
{
	window.open( '../master/xi0190.jsp' , null , 'width=840 , height=1800 , left=1000 , toolbar=no' );
}

function kaisetsu01()
{
	window.open( '../kaisetsu/kaisetsu01.jsp' , null , 'width=840 , height=1800 , left=1000 , toolbar=no' );
}