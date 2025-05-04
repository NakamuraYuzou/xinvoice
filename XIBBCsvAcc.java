package xinvoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XIBBCsvAcc
{
	public static XIBBCsv[] getAll() throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】BBCSV";
		XIBBCsv[] rc = XIBBCsvAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBCsv[] getByKanriCode( String code ) throws Exception
	{
		String sqlstr = "SELECT * FROM 【XI】BBCSV WHERE 【全体情報】請求書管理コード = '" + code + "'";
		XIBBCsv[] rc = XIBBCsvAcc.getBySQL( sqlstr );
		return( rc );
	}

	public static XIBBCsv[] getBySQL( String sqlstr ) throws Exception
	{
		List<XIBBCsv> tbllst = new ArrayList<XIBBCsv>();
		XIDBAccess xidb = new XIDBAccess();
		xidb.setSQL( sqlstr );

		while( xidb.getRow() )
		{
			XIBBCsv rec = new XIBBCsv();
			rec.setOrderDate( xidb.getClmnAsDate("【全体情報】依頼日") );
			rec.setRemindDate( xidb.getClmnAsDate("【全体情報】催促日") );
			rec.setInvoiceMngNum( xidb.getClmnAsLong("【全体情報】請求書管理コード") );
			rec.setSendDate( xidb.getClmnAsDate("【おもて情報】請求書発行日") );
			rec.setCloseDate( xidb.getClmnAsDate("【おもて情報】締日") );
			rec.setPayDueDateS( xidb.getClmnAsDate("【おもて情報】支払期限") );
			rec.setPayDueDate( xidb.getClmnAsDate("【おもて情報】自社支払期限") );
			rec.setCustomerCode1( xidb.getClmn("【おもて情報】顧客コード１") );
			rec.setCustomerCode2( xidb.getClmn("【おもて情報】顧客コード２") );
			rec.setPrivateCustCdS( xidb.getClmn("【おもて情報】支払先コード") );
			rec.setPrivateCustCdB( xidb.getClmn("【おもて情報】発行先コード") );
			rec.setDestinationCode( xidb.getClmn("【おもて情報】宛先コード") );
			rec.setDestinationName( xidb.getClmn("【おもて情報】宛先名") );
			rec.setInvNo( xidb.getClmn("【おもて情報】請求書番号") );
			rec.setInvName( xidb.getClmn("【おもて情報】件名") );
			rec.setInvWithoutTax( xidb.getClmnAsLong("【おもて情報】今回請求金額＃税抜") );
			rec.setInvTax( xidb.getClmnAsLong("【おもて情報】今回消費税額") );
			rec.setInvAmount( xidb.getClmnAsLong("【おもて情報】今回請求金額＃税込") );
			rec.setInvShowAmount( xidb.getClmnAsLong("【おもて情報】おもての請求金額") );
			rec.setRemarks( xidb.getClmn("【おもて情報】備考") );
			rec.setInvFreeTxtTitle1( xidb.getClmn("【おもて情報】おもてA1タイトル") );
			rec.setInvFreeTxt1( xidb.getClmn("【おもて情報】おもてA1データ") );
			rec.setInvFreeTxtTitle2( xidb.getClmn("【おもて情報】おもてA2タイトル") );
			rec.setInvFreeTxt2( xidb.getClmn("【おもて情報】おもてA2データ") );
			rec.setInvFreeTxtTitle3( xidb.getClmn("【おもて情報】おもてA3タイトル") );
			rec.setInvFreeTxt3( xidb.getClmn("【おもて情報】おもてA3データ") );
			rec.setInvFreeNumTitle1( xidb.getClmn("【おもて情報】おもてB1タイトル") );
			rec.setInvFreeTxt4( xidb.getClmnAsLong("【おもて情報】おもてB1データ") );
			rec.setInvFreeNumTitle2( xidb.getClmn("【おもて情報】おもてB2タイトル") );
			rec.setInvFreeTxt5( xidb.getClmnAsLong("【おもて情報】おもてB2データ") );
			rec.setInvFreeNumTitle3( xidb.getClmn("【おもて情報】おもてB3タイトル") );
			rec.setInvFreeTxt6( xidb.getClmnAsLong("【おもて情報】おもてB3データ") );
			rec.setInvFreeNumTitle4( xidb.getClmn("【おもて情報】おもてB4タイトル") );
			rec.setInvFreeTxt7( xidb.getClmnAsLong("【おもて情報】おもてB4データ") );
			rec.setInvFreeNumTitle5( xidb.getClmn("【おもて情報】おもてB5タイトル") );
			rec.setInvFreeNumTitle6( xidb.getClmn("【おもて情報】おもてB6タイトル") );
			rec.setInvFreeNumTitle7( xidb.getClmn("【おもて情報】おもてB7タイトル") );
			rec.setInvOpFreeTxtTitle1( xidb.getClmn("【おもて情報】追加自由項目１タイトル") );
			rec.setInvOpFreeTxt1( xidb.getClmn("【おもて情報】追加自由項目１") );
			rec.setInvOpFreeTxtTitle2( xidb.getClmn("【おもて情報】追加自由項目２タイトル") );
			rec.setInvOpFreeTxt2( xidb.getClmn("【おもて情報】追加自由項目２") );
			rec.setInvOpFreeTxtTitle3( xidb.getClmn("【おもて情報】追加自由項目３タイトル") );
			rec.setInvOpFreeTxt3( xidb.getClmn("【おもて情報】追加自由項目３") );
			rec.setInvOpFreeTxtTitle4( xidb.getClmn("【おもて情報】追加自由項目４タイトル") );
			rec.setInvOpFreeTxt4( xidb.getClmn("【おもて情報】追加自由項目４") );
			rec.setInvOpFreeTxtTitle5( xidb.getClmn("【おもて情報】追加自由項目５タイトル") );
			rec.setInvOpFreeTxt5( xidb.getClmn("【おもて情報】追加自由項目５") );
			rec.setInvOpFreeTxtTitle6( xidb.getClmn("【おもて情報】追加自由項目６タイトル") );
			rec.setInvOpFreeTxt6( xidb.getClmn("【おもて情報】追加自由項目６") );
			rec.setInvOpFreeTxtTitle7( xidb.getClmn("【おもて情報】追加自由項目７タイトル") );
			rec.setInvOpFreeTxt7( xidb.getClmn("【おもて情報】追加自由項目７") );
			rec.setInvOpFreeTxtTitle8( xidb.getClmn("【おもて情報】追加自由項目８タイトル") );
			rec.setInvOpFreeTxt8( xidb.getClmn("【おもて情報】追加自由項目８") );
			rec.setInvOpFreeTxtTitle9( xidb.getClmn("【おもて情報】追加自由項目９タイトル") );
			rec.setInvOpFreeTxt9( xidb.getClmn("【おもて情報】追加自由項目９") );
			rec.setInvOpFreeTxtTitle10( xidb.getClmn("【おもて情報】追加自由項目１０タイトル") );
			rec.setInvOpFreeTxt10( xidb.getClmn("【おもて情報】追加自由項目１０") );
			rec.setInvOpFreeTxtTitle11( xidb.getClmn("【おもて情報】追加自由項目１１タイトル") );
			rec.setInvOpFreeTxt11( xidb.getClmn("【おもて情報】追加自由項目１１") );
			rec.setInvOpFreeTxtTitle12( xidb.getClmn("【おもて情報】追加自由項目１２タイトル") );
			rec.setInvOpFreeTxt12( xidb.getClmn("【おもて情報】追加自由項目１２") );
			rec.setItemSlipDate( xidb.getClmn("【明細情報】明細日付") );
			rec.setItemSlipNo( xidb.getClmn("【明細情報】明細番号") );
			rec.setItemProdCode( xidb.getClmn("【明細情報】商品コード") );
			rec.setItemPrice( xidb.getClmnAsLong("【明細情報】単価") );
			rec.setItemUnit( xidb.getClmn("【明細情報】単位") );
			rec.setItemQty( xidb.getClmnAsLong("【明細情報】数量") );
			rec.setTaxFree( xidb.getClmn("【明細情報】税区分") );
			rec.setTaxRate( xidb.getClmn("【明細情報】税率") );
			rec.setItemWithoutTax( xidb.getClmnAsLong("【明細情報】金額") );
			rec.setItemTax( xidb.getClmnAsLong("【明細情報】消費税額") );
			rec.setItemAmount( xidb.getClmnAsLong("【明細情報】請求金額") );
			rec.setItemSecCode( xidb.getClmn("【明細情報】部門コード") );
			rec.setItemSecName( xidb.getClmn("【明細情報】部門名") );
			rec.setDetailRemarks( xidb.getClmn("【明細情報】明細備考") );
			rec.setItemFreeTxtTitle1( xidb.getClmn("【明細情報】明細01タイトル") );
			rec.setItemFreeTxt1( xidb.getClmn("【明細情報】明細01データ") );
			rec.setItemFreeTxtTitle2( xidb.getClmn("【明細情報】明細02タイトル") );
			rec.setItemFreeTxt2( xidb.getClmn("【明細情報】明細02データ") );
			rec.setItemFreeTxtTitle3( xidb.getClmn("【明細情報】明細03タイトル") );
			rec.setItemFreeTxt3( xidb.getClmn("【明細情報】明細03データ") );
			rec.setItemFreeTxtTitle4( xidb.getClmn("【明細情報】明細04タイトル") );
			rec.setItemFreeTxt4( xidb.getClmn("【明細情報】明細04データ") );
			rec.setItemFreeTxtTitle5( xidb.getClmn("【明細情報】明細05タイトル") );
			rec.setItemFreeTxt5( xidb.getClmn("【明細情報】明細05データ") );
			rec.setItemFreeTxtTitle6( xidb.getClmn("【明細情報】明細06タイトル") );
			rec.setItemFreeTxt6( xidb.getClmn("【明細情報】明細06データ") );
			rec.setItemFreeTxtTitle7( xidb.getClmn("【明細情報】明細07タイトル") );
			rec.setItemFreeTxt7( xidb.getClmn("【明細情報】明細07データ") );
			rec.setItemFreeTxtTitle8( xidb.getClmn("【明細情報】明細08タイトル") );
			rec.setItemFreeTxt8( xidb.getClmn("【明細情報】明細08データ") );
			rec.setItemFreeTxtTitle9( xidb.getClmn("【明細情報】明細09タイトル") );
			rec.setItemFreeTxt9( xidb.getClmn("【明細情報】明細09データ") );
			rec.setItemFreeTxtTitle10( xidb.getClmn("【明細情報】明細10タイトル") );
			rec.setItemFreeTxt10( xidb.getClmn("【明細情報】明細10データ") );
			rec.setItemFreeTxtLTitle( xidb.getClmn("【明細情報】明細11タイトル") );
			rec.setItemFreeTxtL( xidb.getClmn("【明細情報】明細11データ") );
			rec.setItemMemo1( xidb.getClmn("【明細情報】メモ1") );
			rec.setItemMemo2( xidb.getClmn("【明細情報】メモ2") );
			rec.setDetailSummary( xidb.getClmn("【仕訳情報】摘要") );
			rec.setDetailSeq( xidb.getClmnAsInt("【明細情報】明細連番") );
			rec.setStatus( xidb.getClmn("【追加情報】ステータス") );
			rec.setCheckPattern( xidb.getClmn("【追加情報】チェックパターン") );
			rec.setMeisaiPattern( xidb.getClmn("【追加情報】明細パターン") );
			rec.setKenmeiNo( xidb.getClmnAsLong("【追加情報】件名管理番号") );
			rec.setKenmeiNo( xidb.getClmnAsLong("【追加情報】明細管理番号") );
			rec.setRirekiNo( xidb.getClmnAsInt("【追加情報】履歴番号") );

			tbllst.add( rec );
		}

		xidb.close();
		XIBBCsv[] rc = new XIBBCsv[ tbllst.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = tbllst.get( i );
		}

		return( rc );
	}

	public static void checkAitesaki() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BBCSV SET 【追加情報】ステータス = '60'"
						+ " WHERE 【追加情報】ステータス = '10'"
						+ "   AND 【おもて情報】請求元 IN ( SELECT 請求元 FROM 【XI】VBB請求元不在 )";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckAitesaki() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BBCSV SET 【追加情報】ステータス = '10'"
						+ " WHERE 【追加情報】ステータス = '60'"
						+ "   AND 【おもて情報】請求元 IN ( SELECT 請求元 FROM 【XI】BB請求元マスタ )";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmei() throws Exception
	{
		XIBBCsvAcc.checkKenmeiA();
		XIBBCsvAcc.checkKenmeiB();
		XIBBCsvAcc.checkKenmeiC();
		XIBBCsvAcc.checkKenmeiJ();
		XIBBCsvAcc.checkKenmeiK();
		XIBBCsvAcc.checkKenmeiL();

		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BBCSV SET 【追加情報】ステータス = '70'"
						+ " WHERE 【追加情報】ステータス = '10'"
						+ " AND 【追加情報】チェックパターン != 'A'"
						+ " AND 【追加情報】チェックパターン != 'B'"
						+ " AND 【追加情報】チェックパターン != 'C'";
		xidb.setUpdate( sqlstr );
		xidb.close();

		XIBBCsvAcc.reCheckKenmeiJ();
		XIBBCsvAcc.reCheckKenmeiK();
		XIBBCsvAcc.reCheckKenmeiL();
		XIBBCsvAcc.checkMeisaiP();
		XIBBCsvAcc.checkMeisaiQ();
		XIBBCsvAcc.checkMeisai();
	}

	public static void checkKenmeiA() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '10'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  A.【おもて情報】件名 = B.件名"
						+ "  AND  B.チェックパターン = 'A'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'A' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '20'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '10'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  A.【おもて情報】件名 = B.件名"
				+ "  AND  B.チェックパターン = 'A'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiA() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '70'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  A.【おもて情報】件名 = B.件名"
						+ "  AND  B.チェックパターン = 'A'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'A' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '20'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '70'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  A.【おもて情報】件名 = B.件名"
				+ "  AND  B.チェックパターン = 'A'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiB() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '10'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  A.【おもて情報】件名 LIKE B.件名"
						+ "  AND  B.チェックパターン = 'B'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'B' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '20'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '10'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  A.【おもて情報】件名 LIKE B.件名"
				+ "  AND  B.チェックパターン = 'B'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiB() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '70'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  A.【おもて情報】件名 LIKE B.件名"
						+ "  AND  B.チェックパターン = 'B'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'B' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '20'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '70'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  A.【おもて情報】件名 LIKE CONCAT( B.件名 , '%' )"
				+ "  AND  B.チェックパターン = 'B'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiC() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '10'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  B.チェックパターン = 'C'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'C' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '20'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '10'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  B.チェックパターン = 'C'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiC() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '70'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  B.チェックパターン = 'C'";
		xidb.setUpdate( sqlstr );
		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'C' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '20'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '70'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  B.チェックパターン = 'C'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiJ() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '10'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  A.【おもて情報】件名 = B.件名"
						+ "  AND  B.チェックパターン = 'J'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'J' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '71'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '10'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  A.【おもて情報】件名 = B.件名"
				+ "  AND  B.チェックパターン = 'J'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiJ() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '70'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  A.【おもて情報】件名 = B.件名"
						+ "  AND  B.チェックパターン = 'J'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'J' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '71'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '70'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  A.【おもて情報】件名 = B.件名"
				+ "  AND  B.チェックパターン = 'J'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiK() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '10'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  A.【おもて情報】件名 LIKE B.件名"
						+ "  AND  B.チェックパターン = 'K'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'K' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '71'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '10'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  A.【おもて情報】件名 LIKE B.件名"
				+ "  AND  B.チェックパターン = 'K'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiK() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '70'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  A.【おもて情報】件名 LIKE B.件名"
						+ "  AND  B.チェックパターン = 'K'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'K' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '71'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '70'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  A.【おもて情報】件名 LIKE B.件名"
				+ "  AND  B.チェックパターン = 'K'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkKenmeiL() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '10'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  B.チェックパターン = 'L'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'L' ,"
						+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
						+ " 【追加情報】ステータス = '71'"
						+ " FROM 【XI】BB請求先件名マスタ B"
						+ " WHERE A.【追加情報】ステータス = '10'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  B.チェックパターン = 'L'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void reCheckKenmeiL() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先件名マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '70'"
						+ "  AND  A.【おもて情報】請求元 = B.請求元"
						+ "  AND  A.【おもて情報】請求先 = B.請求先"
						+ "  AND  B.チェックパターン = 'L'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】チェックパターン = 'L' ,"
				+ " 【追加情報】件名管理番号 = B.件名管理番号 ,"
				+ " 【追加情報】ステータス = '71'"
				+ " FROM 【XI】BB請求先件名マスタ B"
				+ " WHERE A.【追加情報】ステータス = '70'"
				+ "  AND  A.【おもて情報】請求元 = B.請求元"
				+ "  AND  A.【おもて情報】請求先 = B.請求先"
				+ "  AND  B.チェックパターン = 'L'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkMeisaiP() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先明細マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '71'"
						+ "  AND  A.【明細情報】明細項目 = B.明細項目"
						+ "  AND  A.【明細情報】部門名 = B.明細部門名"
						+ "  AND  B.明細パターン = 'P'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】明細パターン = 'P' ,"
				+ " 【追加情報】明細管理番号 = B.明細管理番号 ,"
				+ " 【追加情報】ステータス = '72'"
				+ " FROM 【XI】BB請求先明細マスタ B"
				+ " WHERE A.【追加情報】ステータス = '71'"
				+ "  AND  A.【明細情報】明細項目 = B.明細項目"
				+ "  AND  A.【明細情報】部門名 = B.明細部門名"
				+ "  AND  B.明細パターン = 'P'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkMeisaiQ() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BB請求先明細マスタ B"
						+ " SET 最終マッチ日 = CURRENT_TIMESTAMP"
						+ " FROM 【XI】BBCSV A"
						+ " WHERE A.【追加情報】ステータス = '71'"
						+ "  AND  A.【明細情報】明細項目 = B.明細項目"
						+ "  AND  A.【明細情報】部門名 LIKE B.明細部門名"
						+ "  AND  B.明細パターン = 'Q'";
		xidb.setUpdate( sqlstr );

		sqlstr = "UPDATE 【XI】BBCSV A SET 【追加情報】明細パターン = 'Q' ,"
						+ " 【追加情報】明細管理番号 = B.明細管理番号 ,"
						+ " 【追加情報】ステータス = '72'"
						+ " FROM 【XI】BB請求先明細マスタ B"
						+ " WHERE A.【追加情報】ステータス = '71'"
						+ "  AND  A.【明細情報】明細項目 = B.明細項目"
						+ "  AND  A.【明細情報】部門名 LIKE B.明細部門名"
						+ "  AND  B.明細パターン = 'Q'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void checkMeisai() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT COUNT(*) AS CNT  FROM 【XI】VBB明細マッチ数"
						+ " WHERE 明細総数 = 明細マッチ数";
		xidb.setSQL( sqlstr );
		xidb.getRow();
		int cnt = xidb.getClmnAsInt("CNT");

		long[] kanricd = new long[cnt];
		sqlstr = "SELECT * FROM 【XI】VBB明細マッチ数 WHERE 明細総数 = 明細マッチ数";
		xidb.setSQL( sqlstr );
		for ( int i = 0 ; i < kanricd.length ; i++ )
		{
			xidb.getRow();
			kanricd[i] = xidb.getClmnAsLong("請求書管理コード");
		}

		for ( int i = 0 ; i < kanricd.length ; i++ )
		{
			sqlstr = "UPDATE 【XI】BBCsv SET 【追加情報】ステータス = '20'"
					+ " WHERE 【全体情報】請求書管理コード = " + kanricd[i];
			xidb.setUpdate( sqlstr );
		}

		xidb.close();
	}

	public static String[] status60Seikyuumoto() throws Exception
	{
		List<String> list = new ArrayList<String>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT 【おもて情報】請求元 FROM 【XI】BBCsv"
						+ " WHERE 【追加情報】ステータス = '60'"
						+ " GROUP BY 【おもて情報】請求元"
						+ " ORDER BY 【おもて情報】請求元 ASC";
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			list.add( xidb.getClmn("【おもて情報】請求元") );
		}
		xidb.close();

		String[] rc = new String[ list.size() ];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get(i);
		}
		return( rc );
	}

	public static String[][] status70Kenmei() throws Exception
	{
		List<String[]> list = new ArrayList<String[]>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT 【全体情報】請求書管理コード , 【おもて情報】請求元 ,"
						+ "【おもて情報】請求先 , 【おもて情報】件名"
						+ " FROM 【XI】BBCsv"
						+ " WHERE 【追加情報】ステータス = '70'"
						+ " GROUP BY 【全体情報】請求書管理コード , 【おもて情報】請求元 ,"
						+ " 【おもて情報】請求先 , 【おもて情報】件名"
						+ " ORDER BY 【全体情報】請求書管理コード ASC , 【おもて情報】請求元 ASC ,"
						+ " 【おもて情報】請求先 ASC , 【おもて情報】件名 ASC";
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			String[] rec = {
								xidb.getClmn("【全体情報】請求書管理コード") ,
								xidb.getClmn("【おもて情報】請求元") ,
								xidb.getClmn("【おもて情報】請求先") ,
								xidb.getClmn("【おもて情報】件名") ,
							};
			list.add( rec );
		}
		xidb.close();

		String[][] rc = new String[ list.size() ][4];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get(i);
		}
		return( rc );
	}

	public static String[][] status71Kenmei() throws Exception
	{
		List<String[]> list = new ArrayList<String[]>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT 【全体情報】請求書管理コード , 【おもて情報】請求元 ,"
						+ "【おもて情報】請求先 , 【おもて情報】件名"
						+ " FROM 【XI】BBCsv"
						+ " WHERE 【追加情報】ステータス = '71'"
						+ " GROUP BY 【全体情報】請求書管理コード , 【おもて情報】請求元 ,"
						+ " 【おもて情報】請求先 , 【おもて情報】件名"
						+ " ORDER BY 【全体情報】請求書管理コード ASC , 【おもて情報】請求元 ASC ,"
						+ " 【おもて情報】請求先 ASC , 【おもて情報】件名 ASC";
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			String[] rec = {
								xidb.getClmn("【全体情報】請求書管理コード") ,
								xidb.getClmn("【おもて情報】請求元") ,
								xidb.getClmn("【おもて情報】請求先") ,
								xidb.getClmn("【おもて情報】件名") ,
							};
			list.add( rec );
		}
		xidb.close();

		String[][] rc = new String[ list.size() ][4];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get(i);
		}
		return( rc );
	}

	public static String[][] getMeisaiByCode( String code ) throws Exception
	{
		List<String[]> list = new ArrayList<String[]>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT 【明細情報】明細項目 AS 明細項目 ,"
						+ " 【明細情報】部門名 AS 部門名 ,"
						+ " 【明細情報】明細備考 AS 明細備考 ,"
						+ " 【明細情報】金額 AS 金額 ,"
						+ " 【明細情報】消費税額 AS 消費税額,"
						+ " 【明細情報】明細連番 AS 明細連番,"
						+ " 【追加情報】ステータス AS ステータス,"
						+ " 【追加情報】チェックパターン AS チェックパターン,"
						+ " 【追加情報】明細パターン AS 明細パターン,"
						+ " 【追加情報】件名管理番号 AS 件名管理番号,"
						+ " 【追加情報】明細管理番号 AS 明細管理番号"
						+ " FROM 【XI】BBCsv"
						+ " WHERE 【全体情報】請求書管理コード = '" + code + "'"
						+ "  AND 【明細情報】明細日付 IS NOT NULL"
						+ " ORDER BY 【全体情報】請求書管理コード ASC , 【明細情報】明細連番";

		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			String[] rec = {
								xidb.getClmn("明細項目") ,
								xidb.getClmn("部門名") ,
								xidb.getClmn("明細備考") ,
								xidb.getClmn("金額") ,
								xidb.getClmn("消費税額") ,
								xidb.getClmn("明細連番") ,
								xidb.getClmn("ステータス") ,
								xidb.getClmn("チェックパターン"),
								xidb.getClmn("明細パターン"),
								xidb.getClmn("件名管理番号"),
								xidb.getClmn("明細管理番号")

							};
			list.add( rec );
		}
		xidb.close();

		String[][] rc = new String[ list.size() ][3];
		for ( int i = 0 ; i < rc.length ; i++ )
		{
			rc[i] = list.get(i);
		}
		return( rc );
	}

	public static void updateAllMatched() throws Exception
	{
		List<String> list = new ArrayList<String>();
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "SELECT * FROM 【XI】VBB明細マッチ数";
		xidb.setSQL( sqlstr );
		while ( xidb.getRow() )
		{
			String code = xidb.getClmn("請求書管理コード");
			int sousuu = xidb.getClmnAsInt("明細総数");
			int matchsuu = xidb.getClmnAsInt("明細マッチ数");
			if ( sousuu == matchsuu ) list.add( code );
		}

		for ( int i = 0 ; i < list.size() ; i++ )
		{
			String code = list.get( i );
			sqlstr = "UPDATE 【XI】BBCsv SET 【追加情報】ステータス = '20'"
					+ " WHERE 【全体情報】請求書管理コード = " + code;
			xidb.setUpdate( sqlstr );
		}
		xidb.close();
	}

	public static void afterCheck() throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BBCsv"
						+ " SET 【追加情報】ステータス = '20'"
						+ " WHERE 【追加情報】ステータス = '10'"
						+ " AND 【追加情報】チェックパターン != ''";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void updateStatus( String code , String sts ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "UPDATE 【XI】BBCsv"
						+ " SET 【追加情報】ステータス = '" + sts + "'"
						+ " WHERE 【全体情報】請求書管理コード = '" + code + "'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void deleteByCode( String code ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "DELETE FROM 【XI】BBCsv"
						+ " WHERE 【全体情報】請求書管理コード = '" + code + "'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static void deleteByStatus( String sts ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "DELETE FROM 【XI】BBCsv"
						+ " WHERE 【追加情報】ステータス = '" + sts + "'";
		xidb.setUpdate( sqlstr );
		xidb.close();
	}

	public static long copyInFromArray( String[][] outrecs ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE 【XI】BBCSV";
		xidb.setUpdate( sqlstr );

		String tblnm = "ikou.【XI】BBCSV";
		String[] cols = XIBBCsvAcc.getFields();
		long rc = xidb.copyInFromStringArray( tblnm , cols , outrecs );

		xidb.close();

		return( rc );
	}

	public static long copyIn( String inf ) throws Exception
	{
		XIDBAccess xidb = new XIDBAccess();
		String sqlstr = "TRUNCATE TABLE 【XI】BBCSVTEMP";
		xidb.setUpdate( sqlstr );

		String tblnm = "【XI】BBCSVTEMP";
		String[] colmns = XIBBCsvAcc.getFields();
		long rc = xidb.copyInSJIS( tblnm , colmns , inf );
		xidb.close();

		XIBBTorikomiRireki xitr = new XIBBTorikomiRireki();
		xitr.setOperationDate( new Date() );
		int ix = inf.lastIndexOf("\\") + 1;
		String fname = inf.substring( ix );
		xitr.setFileName( fname );
		xitr.setKensuu( rc );
		XIBBTorikomiRirekiAcc.insert( xitr );

		xidb = new XIDBAccess();
		sqlstr = "INSERT INTO 【XI】BBCSV SELECT * FROM 【XI】VBBCSVCAST";
		xidb.setUpdate( sqlstr );
		xidb.close();

		return( rc );
	}

	public static String[] getFields()
	{
		String[] rc = {
						"【全体情報】作成方法",
						"【全体情報】添付ファイル有無フラグ",
						"【全体情報】ファイル出力日時",
						"【全体情報】依頼日",
						"【全体情報】催促日",
						"【全体情報】状態",
						"【全体情報】部署",
						"【全体情報】処理中担当者",
						"【全体情報】承認依頼者",
						"【全体情報】経理グループ",
						"【全体情報】会計DL",
						"【全体情報】支払DL",
						"【全体情報】Concur連携",
						"【全体情報】住所コード",
						"【全体情報】請求書管理コード",
						"【おもて情報】請求書発行日",
						"【おもて情報】締日",
						"【おもて情報】支払期限",
						"【おもて情報】自社支払期限",
						"【おもて情報】保存方式",
						"【おもて情報】追記",
						"【おもて情報】課税単位",
						"【おもて情報】支払方法",
						"【おもて情報】指定口座",
						"【おもて情報】振込先口座1",
						"【おもて情報】振込先口座2",
						"【おもて情報】振込先口座3",
						"【おもて情報】振込先口座4",
						"【おもて情報】振込先口座5",
						"【おもて情報】振込先口座6",
						"【おもて情報】振込先口座7",
						"【おもて情報】振込先口座8",
						"【おもて情報】振込先口座9",
						"【おもて情報】振込先口座10",
						"【おもて情報】識別表示",
						"【おもて情報】顧客コード１",
						"【おもて情報】顧客コード２",
						"【おもて情報】EDI情報",
						"【おもて情報】支払先コード",
						"【おもて情報】請求元",
						"【おもて情報】請求元電話番号",
						"【おもて情報】事業者区分",
						"【おもて情報】事業者登録番号",
						"【おもて情報】事業者登録番号検索結果",
						"【おもて情報】［国税庁］登録年月日",
						"【おもて情報】［国税庁］事業者処理区分",
						"【おもて情報】［国税庁］氏名又は名称",
						"【おもて情報】［国税庁］都道府県",
						"【おもて情報】［国税庁］住所",
						"【おもて情報】［国税庁］更新年月日",
						"【おもて情報】［国税庁］主たる屋号",
						"【おもて情報】［国税庁］通称・旧姓",
						"【おもて情報】［国税庁］取消年月日",
						"【おもて情報】［国税庁］失効年月日",
						"【おもて情報】発行先コード",
						"【おもて情報】請求先",
						"【おもて情報】請求先電話番号",
						"【おもて情報】発行先担当者",
						"【おもて情報】宛先コード",
						"【おもて情報】宛先名",
						"【おもて情報】請求書番号",
						"【おもて情報】請求書タイトル",
						"【おもて情報】件名",
						"【おもて情報】自社担当者",
						"【おもて情報】前回請求金額",
						"【おもて情報】入金額",
						"【おもて情報】調整金額",
						"【おもて情報】繰越金額",
						"【おもて情報】今回請求金額＃税抜",
						"【おもて情報】今回消費税額",
						"【おもて情報】今回請求金額＃税込",
						"【おもて情報】おもての請求金額",
						"【おもて情報】10％請求金額＃税抜",
						"【おもて情報】10％消費税額",
						"【おもて情報】10％請求金額＃税込",
						"【おもて情報】軽減8％請求金額＃税抜",
						"【おもて情報】軽減8％消費税額",
						"【おもて情報】軽減8％請求金額＃税込",
						"【おもて情報】8％請求金額＃税抜",
						"【おもて情報】8％消費税額",
						"【おもて情報】8％請求金額＃税込",
						"【おもて情報】5％請求金額＃税抜",
						"【おもて情報】5％消費税額",
						"【おもて情報】5％請求金額＃税込",
						"【おもて情報】0％請求金額＃税抜",
						"【おもて情報】0％消費税額",
						"【おもて情報】0％請求金額＃税込",
						"【おもて情報】非課税請求金額＃税抜",
						"【おもて情報】非課税消費税額",
						"【おもて情報】非課税請求金額＃税込",
						"【おもて情報】免税請求金額＃税抜",
						"【おもて情報】免税消費税額",
						"【おもて情報】免税請求金額＃税込",
						"【おもて情報】不課税請求金額＃税抜",
						"【おもて情報】不課税消費税額",
						"【おもて情報】不課税請求金額＃税込",
						"【おもて情報】備考",
						"【おもて情報】おもてA1タイトル",
						"【おもて情報】おもてA1データ",
						"【おもて情報】おもてA2タイトル",
						"【おもて情報】おもてA2データ",
						"【おもて情報】おもてA3タイトル",
						"【おもて情報】おもてA3データ",
						"【おもて情報】おもてB1タイトル",
						"【おもて情報】おもてB1データ",
						"【おもて情報】おもてB2タイトル",
						"【おもて情報】おもてB2データ",
						"【おもて情報】おもてB3タイトル",
						"【おもて情報】おもてB3データ",
						"【おもて情報】おもてB4タイトル",
						"【おもて情報】おもてB4データ",
						"【おもて情報】おもてB5タイトル",
						"【おもて情報】おもてB5データ",
						"【おもて情報】おもてB6タイトル",
						"【おもて情報】おもてB6データ",
						"【おもて情報】おもてB7タイトル",
						"【おもて情報】おもてB7データ",
						"【おもて情報】追加自由項目１タイトル",
						"【おもて情報】追加自由項目１",
						"【おもて情報】追加自由項目２タイトル",
						"【おもて情報】追加自由項目２",
						"【おもて情報】追加自由項目３タイトル",
						"【おもて情報】追加自由項目３",
						"【おもて情報】追加自由項目４タイトル",
						"【おもて情報】追加自由項目４",
						"【おもて情報】追加自由項目５タイトル",
						"【おもて情報】追加自由項目５",
						"【おもて情報】追加自由項目６タイトル",
						"【おもて情報】追加自由項目６",
						"【おもて情報】追加自由項目７タイトル",
						"【おもて情報】追加自由項目７",
						"【おもて情報】追加自由項目８タイトル",
						"【おもて情報】追加自由項目８",
						"【おもて情報】追加自由項目９タイトル",
						"【おもて情報】追加自由項目９",
						"【おもて情報】追加自由項目１０タイトル",
						"【おもて情報】追加自由項目１０",
						"【おもて情報】追加自由項目１１タイトル",
						"【おもて情報】追加自由項目１１",
						"【おもて情報】追加自由項目１２タイトル",
						"【おもて情報】追加自由項目１２",
						"【おもて情報】保存方式の補足文言",
						"【明細情報】明細日付",
						"【明細情報】明細番号",
						"【明細情報】商品コード",
						"【明細情報】明細項目",
						"【明細情報】単価",
						"【明細情報】単位",
						"【明細情報】数量",
						"【明細情報】税区分",
						"【明細情報】税率",
						"【明細情報】軽減税率",
						"【明細情報】金額",
						"【明細情報】消費税額",
						"【明細情報】請求金額",
						"【明細情報】部門コード",
						"【明細情報】部門名",
						"【明細情報】明細備考",
						"【明細情報】明細01タイトル",
						"【明細情報】明細01データ",
						"【明細情報】明細02タイトル",
						"【明細情報】明細02データ",
						"【明細情報】明細03タイトル",
						"【明細情報】明細03データ",
						"【明細情報】明細04タイトル",
						"【明細情報】明細04データ",
						"【明細情報】明細05タイトル",
						"【明細情報】明細05データ",
						"【明細情報】明細06タイトル",
						"【明細情報】明細06データ",
						"【明細情報】明細07タイトル",
						"【明細情報】明細07データ",
						"【明細情報】明細08タイトル",
						"【明細情報】明細08データ",
						"【明細情報】明細09タイトル",
						"【明細情報】明細09データ",
						"【明細情報】明細10タイトル",
						"【明細情報】明細10データ",
						"【明細情報】明細11タイトル",
						"【明細情報】明細11データ",
						"【明細情報】メモ1",
						"【明細情報】メモ2",
						"【仕訳情報】会計伝票日付",
						"【仕訳情報】借方負担部門",
						"【仕訳情報】借方科目",
						"【仕訳情報】借方補助科目",
						"【仕訳情報】貸方負担部門",
						"【仕訳情報】貸方科目",
						"【仕訳情報】貸方補助科目",
						"【仕訳情報】摘要",
						"【仕訳情報】仕訳自由項目1",
						"【仕訳情報】仕訳補助1",
						"【仕訳情報】仕訳自由項目2",
						"【仕訳情報】仕訳補助2",
						"【仕訳情報】仕訳自由項目3",
						"【仕訳情報】仕訳補助3",
						"【仕訳情報】仕訳自由項目4",
						"【仕訳情報】仕訳補助4",
						"【仕訳情報】仕訳自由項目5",
						"【仕訳情報】仕訳補助5",
						"【仕訳情報】仕訳自由項目6",
						"【仕訳情報】仕訳補助6",
						"【仕訳情報】仕訳自由項目7",
						"【仕訳情報】仕訳補助7",
						"【仕訳情報】仕訳自由項目8",
						"【仕訳情報】仕訳補助8",
						"【仕訳情報】仕訳自由項目9",
						"【仕訳情報】仕訳自由項目9テキスト",
						"【仕訳情報】仕訳自由項目10",
						"【仕訳情報】仕訳自由項目10テキスト",
						"【仕訳情報】仕訳自由項目11",
						"【仕訳情報】仕訳自由項目11テキスト",
						"【仕訳情報】仕訳自由項目12",
						"【仕訳情報】仕訳自由項目12テキスト",
						"【伝票情報】伝票番号",
						"【伝票情報】伝票備考",
						"【伝票情報】伝票金額",
						"【伝票情報】伝票消費税額",
						"【伝票情報】伝票請求金額",
						"【伝票情報】伝票10％合計金額＃税抜",
						"【伝票情報】伝票10％消費税額",
						"【伝票情報】伝票10％合計金額＃税込",
						"【伝票情報】伝票軽減8％合計金額＃税抜",
						"【伝票情報】伝票軽減8％消費税額",
						"【伝票情報】伝票軽減8％合計金額＃税込",
						"【伝票情報】伝票8％合計金額＃税抜",
						"【伝票情報】伝票8％消費税額",
						"【伝票情報】伝票8％合計金額＃税込",
						"【伝票情報】伝票5％合計金額＃税抜",
						"【伝票情報】伝票5％消費税額",
						"【伝票情報】伝票5％合計金額＃税込",
						"【伝票情報】伝票0％合計金額＃税抜",
						"【伝票情報】伝票0％消費税額",
						"【伝票情報】伝票0％合計金額＃税込",
						"【伝票情報】伝票非課税合計金額＃税抜",
						"【伝票情報】伝票非課税消費税額",
						"【伝票情報】伝票非課税合計金額＃税込",
						"【伝票情報】伝票免税合計金額＃税抜",
						"【伝票情報】伝票免税消費税額",
						"【伝票情報】伝票免税合計金額＃税込",
						"【伝票情報】伝票不課税合計金額＃税抜",
						"【伝票情報】伝票不課税消費税額",
						"【伝票情報】伝票不課税合計金額＃税込",
						"【全体情報】請求書管理番号",
						"【全体情報】返送機能使用有無",
						"【全体情報】自社作成請求書作成者",
						"【明細情報】明細連番",
						"【おもて情報】代表者役職",
						"【おもて情報】代表者名",
						"【明細情報】税抜税込"
					  };
		return( rc );
	}

}
