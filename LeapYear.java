import java.util.Scanner;
public class LeapYear{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter the year");//阻塞，回车消除阻塞，继续执行
			int year=input.nextInt();
				if(year%4==0&&year%100!=0||year%400==0){
					System.out.println("this is the leap year");
				}
				else{
					System.out.println("this is not the leap year");
				}
	}

}