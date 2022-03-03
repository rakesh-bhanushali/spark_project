package spark;

import static org.testng.Assert.assertEquals;

/**
 * Hello world!
 *
 */
public class App 
{
   public static void main(String[] args) {
	int c[]= {2,4,3,5,6,78,9,9,99,9};
	int sum=0;
	for(int i=0;i<c.length;i++)
	{
		sum=sum+c[i];
	}
System.out.println(sum);
   
   int s=9;
   for(int i=0;i<c.length;i++)
	   
   {
if(c[i]==s) {
	System.out.println("present at " +i);
}
   }
   
   
int abcd[][]= {{91,2,3},{5,6,7},{1,2,3},{5,6,7}};
   
   for(int i=0;i<3;i++) {
	for(int j=i;j<3;j++) {
		System.out.println(abcd[i][j]);
	}
	
}
}
	

}
