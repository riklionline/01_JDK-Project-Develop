/**
1 从键盘读入n个数，使用动态数组存储所读入的数据；
2 计算它们的和与平均值分别输出；
3 平均值为小数的只保留其整数部分；
4 使用函数实现程序代码；
*/
import java.util.Scanner;
import java.util.Arrays;
public class dynamicArea{
	public static void main (String[] args){
		System.out.println("您需要录入的数据个数为:");
		Scanner input = new Scanner(System.in);//阻塞，等待键盘录入数据
		int n =input.nextInt();
		numManager nm = new numManager(n);
		System.out.println("您此次准备录入"+n+"个数");
		
		for(int i=0;i<n;i++){
			System.out.println("请开始录入第"+(i+1)+"个数:");
			Scanner sc = new Scanner(System.in);//阻塞，等待键盘录入数据
			double m = sc.nextDouble();//连续输入n个数据
			nm.add(new num(m));
		}
		
		System.out.println("当前数组长度为:"+nm.length());
		System.out.println("————————————————————————————————");
		nm.printAll();
		nm.sum();
	}
}

//数据管理类
class numManager{
	private num [] cn = null;//新建对象数组，初始为null
	private int count = 0;//记录当前数组元素个数，初始为0
	public numManager(int size){ //构造方法
		if(size>0){
			cn = new num[size];
		}else{
			cn = new num[5];
		}
	}
	public int length(){
		return cn.length;
	}
	
	//添加:实现动态数组
	public void add(num number){
		if(count>=cn.length){//数组已满，需要扩充
			//算法：扩充原来数组的一倍  cs.length*2
			int newLen = cn.length*2;
			cn = Arrays.copyOf(cn,newLen);			
		}
		cn[count] = number;	
		count++;
	}
	//输出所有
	public void printAll(){
		for(int i=0;i<count;i++){
			cn[i].print();
			
		}
	}
	//数组求和及平均值（注意对象数组的取值方式（类的get、set方法））
	public void sum(){	
		double cnSum=0;
		int cnAverage=0;
		for(int i=0;i<count;i++){
			cnSum=cnSum+cn[i].getValue();
		}
		
		cnAverage=(int)(cnSum/count);		
		System.out.print("\n"+"\n"+"和:"+cnSum+"\t");		
		System.out.print("平均值:"+cnAverage+"\n");
	}	
}

//对象数据类
class num{
	private double value;
	
	public num(){};//空参构造方法
	public num(double value){
		this.value=value;
	}
	public void setValue(double value){
		this.value=value;
	}
	public double getValue(){
		return value;
	}
	public void print(){
		System.out.print(value+"\t");
	}
}