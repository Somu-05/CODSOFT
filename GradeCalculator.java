package Task2;
import java.util.Scanner;
public class GradeCalculator {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Student's Mark List");
		System.out.println("Enter your Tamil mark : ");
		int m1=s.nextInt();
		System.out.println("Enter your English mark : ");
		int m2=s.nextInt();
		System.out.println("Enter your Maths mark : ");
		int m3=s.nextInt();
		System.out.println("Enter your Science mark : ");
		int m4=s.nextInt();
		System.out.println("Enter your Social mark : ");
		int m5=s.nextInt();
		grade(m1,m2,m3,m4,m5);
		
	}
	static void grade(int n1,int n2,int n3,int n4,int n5) {
		int res=n1+n2+n3+n4+n5;
		int avg=(n1+n2+n3+n4+n5)/5;
		System.out.println("Total marks: " + res );
		System.out.println("Average Percentage: "+ avg+"%");
		if(avg >=90 && avg <100)
			System.out.println("Grade: S");
		else if(avg>=80 && avg<90)
			System.out.println("Grade: A");
		else if(avg>=70 && avg<80)
			System.out.println("Grade: B");
		else if(avg>=60 && avg<70)
			System.out.println("Grade: C");
		else
			System.out.print("Grade: F");
	}

}
