package xinvoice;

public class XIBBVBBtoCCLine
{
	public String kanricd;
	public long kanrino;
	public String seikyuuno;
	public long zeinuki;
	public String toricd;
	public String moto;
	public String ptntoricd;
	public String expcode08;
	public String expname08;
	public String expcode10;
	public String expname10;
	public String hiyoukbn;
	public String koujicd;
	public String syousaicd;
	public String bumoncd;
	public int m_renban;
	public String m_bangou;
	public String m_koumoku;
	public String m_bumon;
	public long m_tanka;
	public String m_tani;
	public long m_suu;
	public String m_ritsu;
	public long m_gaku;
	public long m_syouhizei;
	public long m_seikyuugaku;
	public String m_bikou;

	public XIBBVBBtoCCLine()
	{
		kanricd = "";
		seikyuuno = "";
		toricd = "";
		moto = "";
		ptntoricd = "";
		expcode08 = "";
		expname08 = "";
		expcode10 = "";
		expname10 = "";
		koujicd = "";
		syousaicd = "";
		bumoncd = "";
		m_bangou = "";
		m_koumoku = "";
		m_bumon = "";
		m_bikou = "";
	}


	public String getKanriCode()
	{
		return( kanricd );
	}

	public long getKanriNo()
	{
		return( kanrino );
	}

	public String getSeiyuuNo()
	{
		return( seikyuuno );
	}

	public long getZeinukiSeikyuugaku()
	{
		return( zeinuki );
	}

	public String getTorihikisakiCode()
	{
		return( toricd );
	}

	public String getSeikyuumoto()
	{
		return( moto );
	}

	public String getPatternTorihikisakiCode()
	{
		return( ptntoricd );
	}

	public String getExpenseTypeCode08()
	{
		return( expcode08 );
	}

	public String getExpenseTypeName08()
	{
		return( expname08 );
	}

	public String getExpenseTypeCode10()
	{
		return( expcode10 );
	}

	public String getExpenseTypeName10()
	{
		return( expname10 );
	}

	public String getHiyouKubun()
	{
		return( hiyoukbn );
	}

	public String getKoujiCode()
	{
		return( koujicd );
	}

	public String getKoujiSyousaiCode()
	{
		return( syousaicd );
	}

	public String getBumonCode()
	{
		return( bumoncd );
	}

	public int getMeisaiRenban()
	{
		return( m_renban );
	}

	public String getMeisaiBangou()
	{
		return( m_bangou );
	}

	public String getMeisaiKoumoku()
	{
		return( m_koumoku );
	}

	public String getMeisaiBumon()
	{
		return( m_bumon );
	}

	public long getMeisaiTanka()
	{
		return( m_tanka );
	}

	public String getMeisaiTani()
	{
		return( m_tani );
	}

	public long getMeisaiSuuryou()
	{
		return( m_suu );
	}

	public String getMeisaiZeiritsu()
	{
		return( m_ritsu );
	}

	public long getMeisaiKingaku()
	{
		return( m_gaku );
	}

	public long getMeisaiSyouhizeiGaku()
	{
		return( m_syouhizei );
	}

	public long getMeisaiSeikyuuGaku()
	{
		return( m_seikyuugaku );
	}

	public String getMeisaiBikou()
	{
		return( m_bikou );
	}


	public void setKanriCode( String arg )
	{
		kanricd = arg;
	}

	public void setKanriNo( long arg )
	{
		kanrino = arg;
	}

	public void setSeikyuuNo( String arg )
	{
		seikyuuno = arg;
	}

	public void setZeinukiSeikyuugaku( long arg )
	{
		zeinuki = arg;
	}

	public void setHiyouKubun( String arg )
	{
		hiyoukbn = arg;
	}

	public void setTorihikisakiCode( String arg )
	{
		toricd = arg;
	}

	public void setSeikyuumoto( String arg )
	{
		moto = arg;
	}

	public void setPatternTorihikisakiCode( String arg )
	{
		ptntoricd = arg;
	}

	public void setExpenseTypeCode08( String arg )
	{
		expcode08 = arg;
	}

	public void setExpenseTypeName08( String arg )
	{
		expname08 = arg;
	}

	public void setExpenseTypeCode10( String arg )
	{
		expcode10 = arg;
	}

	public void setExpenseTypeName10( String arg )
	{
		expname10 = arg;
	}

	public void setKoujiCode( String arg )
	{
		koujicd = arg;
	}

	public void setKoujiSyousaiCode( String arg )
	{
		syousaicd = arg;
	}

	public void setBumonCode( String arg )
	{
		bumoncd = arg;
	}

	public void setMeisaiRenban( int arg )
	{
		m_renban = arg;
	}

	public void setMeisaiBangou( String arg )
	{
		m_bangou = arg;
	}

	public void setMeisaiKoumoku( String arg )
	{
		m_koumoku = arg;
	}

	public void setMeisaiBumon( String arg )
	{
		m_bumon = arg;
	}

	public void setMeisaiTanka( long arg )
	{
		m_tanka = arg;
	}

	public void setMeisaiTani( String arg )
	{
		m_tani = arg;
	}

	public void setMeisaiSuuryou( long arg )
	{
		m_suu = arg;
	}

	public void setMeisaiZeiritsu( String arg )
	{
		m_ritsu = arg;
	}

	public void setMeisaiKingaku( long arg )
	{
		m_gaku = arg;
	}

	public void setMeisaiSyouhizeiGaku( long arg )
	{
		m_syouhizei = arg;
	}

	public void setMeisaiSeikyuuGaku( long arg )
	{
		m_seikyuugaku = arg;
	}

	public void setMeisaiBikou( String arg )
	{
		m_bikou = arg;
	}
}
