
/**
* @author Jinho D. Choi ({@code jinho.choi@emory.edu})
*/
public class RLCS extends AbstractLCS
{
@Override
protected String get(char[] c, char[] d, int i, int j)
{
	
	
	
if (i > c.length-1  || j > d.length-1)
return "";

if (c[i] == d[j])
return get(c, d, i+1, j+1) + c[i];

String c1 = get(c, d, i+1, j);
String d1 = get(c, d, i, j+1);
return (c1.length() > d1.length()) ? c1 : d1;
}
}


