package xinvoice;

public class XICommon
{
	static String formatJson( String jsonstr )
	{
		String rc = jsonstr.replaceAll( "," , ",\n").replaceAll( "}" , "}\n" );
		return( rc );
	}
}
