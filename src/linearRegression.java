import java.util.Scanner;
import java.lang.*;
import java.util.*;
import java.text.*;

public class linearRegression {
	public static void main(String args[]){
		
		// * * * * VARIABLE LIST * * * *
				//      S1 - Sum of X values
				//      S2 - Sum of Y values
				//      S3 - Sum of X * Y
				//      S4 - Sum of X * X
				//      S5 - Sum of Y * Y
				//      S - Slope
				//      B - Y-intercept
				//      R - Correlation coefficient
		       // DIMENSION X(50), Y(2,50), LITERL(2)
		       // DOUBLE PRECISION S1,S2,S3,S4,S5,T,S,B, R,BBAR
		double [] X = new double[50];
		double [][] Y = new double[2][50];
		double S1=0; double S2=0; double S3=0; 
		double S4=0; double S5=0; double 
		T=0; double S=0; double B=0; double R=0;
		double BBAR=0;
      char[] literal = new char[2];
      literal[0] = '-';
      literal[1] = '+';
		int a; //Number of pairs
		String b; //choice to print data
		double x, y; //numbers in pair
		String comma;//makes sure user enters comma between number pair
      DecimalFormat df = new DecimalFormat("#0.000000");
		System.out.println("0" + " " + "*  *  *  LINEAR REGRESSION ANALYSIS  *  *  *");
		System.out.println(" " + "HOW MANY PAIRS TO BE ANALYZED?");
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		if(a>50){
			System.out.println(" " + " At present this program can only handle 50 data pairs.");
		}
		else{
			System.out.println(" " + "Enter one pair at a time" + " " + "and separate X from Y with a comma.");
			System.out.println(" " + "Enter pair number one : ");
			 Scanner pair=new Scanner(System.in);
		        String line;
		        String[] pairs;
		        line = pair.nextLine();
		        pairs = line.split(",");
		        x=Double.parseDouble(pairs[0]);
		        y=Double.parseDouble(pairs[1]);
		        System.out.println(x + "," + y);
		        X[0]=x;
		        Y[0][0]=y;
		        int i=1;
		        int k=2;
		        while(i<a){
		        	System.out.println(" " + "Enter pair number " + k + ":");
		        	line = pair.nextLine();
			        pairs = line.split(",");
			        x=Double.parseDouble(pairs[0]);
			        y=Double.parseDouble(pairs[1]);
			        System.out.println(x + "," + y);
			        X[i]=x;
			        Y[0][i]=y;
			        i++;
			        k++;
		        }
		        System.out.println(" " + "Would you like to print the data?");
		        Scanner choice = new Scanner(System.in);
				b = choice.nextLine();
				if(b.equalsIgnoreCase("N")){
					int m=0;				
					while(m<a){
						S1=S1+X[m];
						S2=S2+Y[0][m];
						S3=S3+X[m]*Y[0][m];
						S4=S4+X[m]*X[m];
						S5=S5+Y[0][m]*Y[0][m];
						m++;
					}				
					T=a*S4-S1*S1;
					S=(a*S3-S1*S2)/T;
					B=(S4*S2-S1*S3)/T;
					System.out.println("CHOICE N");
					System.out.println(T + " " + S + " " + B);
				}
				else{
					System.out.println("TEST 1");
					int j=0;
					int l=1;
					while(j<a){
					System.out.println(" " + " DATA PAIR" + " "+ l + " = " + X[j] + "," + Y[0][j]);
					j++;
					l++;
					}
					int n=0;
					while(n<a){
						S1=S1+X[n];
						S2=S2+Y[0][n];
						S3=S3+X[n]*Y[0][n];
						S4=S4+X[n]*X[n];
						S5=S5+Y[0][n]*Y[0][n];
						n++;
					}
					T=a*S4-S1*S1;
					S=(a*S3-S1*S2)/T;
					B=(S4*S2-S1*S3)/T;
					R=(a*S3-S1*S2)/(Math.sqrt(Math.abs(((a*S4-Math.pow(Math.abs(S1), 2)))*(a*S5-Math.pow(Math.abs(S2), 2)))));
					System.out.println(df.format(T) + " " + df.format(S) + " " + df.format(B));
					                                          
					System.out.println(df.format(R)); 
				}	
				System.out.println("SLOPE = " + df.format(S));
				System.out.println("INTERCEPT = " + df.format(B));
				char p = '+';
				if(Math.abs(B)!=B){
					p='-';
				}
				System.out.print(" " + "EQUATION FOR THE BEST LINEAR FIT IS : ");
				BBAR=Math.abs(B);
				System.out.println(" " + "Y(X) =" + df.format(S) + "* X " + p + " " + df.format(BBAR));
				System.out.println(" LINEAR CORRELATION COEFFICIENT = " + R);
				System.out.println("LINEAR... Execution completed");
		}		        
	}
}