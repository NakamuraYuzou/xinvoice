package xinvoice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class XIStub
{
	public static String getJsonFromFile( String infname ) throws Exception
	{
		File inf = new File( infname );
		FileReader fr = new FileReader( inf );
		BufferedReader br = new BufferedReader( fr );

		String jsonstr = "";
		String line;
		while ( ( line = br.readLine() ) != null )
		{
			jsonstr = jsonstr + line;
		}
		br.close();
		fr.close();

		return( jsonstr );
	}

	public static void setJsonToFile( String jsonstr , String outfname ) throws Exception
	{
		File outf = new File( outfname );
		FileWriter fw = new FileWriter( outf );
		BufferedWriter bw = new BufferedWriter( fw );

		bw.write( jsonstr );

		bw.close();
		fw.close();

	}

}
