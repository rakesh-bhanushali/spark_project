package spark;

import java.text.SimpleDateFormat;
import java.util.Date;

public class striings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	String name="Rakesh";
	 char[] namechar=name.toCharArray();
System.out.println(namechar.length);
for(int i=namechar.length-1;i>=0;i--) {
	System.out.print(namechar[i]);
     }
System.out.println(" ");
String temp="";
//Palindrone
	for(int i=name.length()-1;i>=0;i--)
	{
		
		temp=temp+name.charAt(i);
	}	
	System.out.println(temp);
	
	if(name==temp) {
		System.out.println( "\"" +name +"\"" + " is palindrone");
	}
	else {
		System.out.println( "\"" +name +"\"" + " is not palindrone");
	}
//Date format
	Date d=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("H:mm:ss dd/MM/yyy");
	System.out.println(sdf.format(d));
	
	String f= "₹56,327.11";
	String ff=f.replaceAll("[₹,]","");
	
	System.out.println(f);
	System.out.println(ff);
	
	
	
	
	}	
}