/**
1 项目名称：车牌摇号器
2 用户故事描述：使用随机不重复算法，实现一个车牌摇号器，本期参与摇号人员共1000（编号1-1000）人，从中抽取10人，获得购买车牌资格
3 设计思路：
  3.1 创建一个10个元素的数组，用来存放10个人的编号；
  3.2 编号从1-1000随机产生，需要算法；
*/

import java.util.Random;
import java.util.Arrays;

public class licensePlateSystem{
	public static void main(String[] args){
		//开始定义变量
		int[] userSerialNumber = new int[10];//定义用户编号数组
		
		//定义一个数据集合[1,2,3,4,5,6…………1000]，准备从中取数据
		int[]numberGather = new int[1000];
		for(int i=0;i<numberGather.length;i++){ //for循环为数组按顺序为其对应下标赋值{[0](1),[1](2)…………[999](1000)}
			numberGather[i]=i+1;
		}
		randomSelection(numberGather,userSerialNumber);
		System.out.println(Arrays.toString(userSerialNumber));
	}
	
	
	public static void randomSelection(int[]numberGather,int[]userSerialNumber){
		//如果连续随机生成的数字有重复的，则此次循环无效
		Random r = new Random();
		int index = -1;//随机生成数组的下标
		
		for(int i=0;i<userSerialNumber.length;i++){
			index = r.nextInt(numberGather.length-i);//从10~1中随机抽数（包含0但不包含N）为index赋值，一个循环赋一个值
			userSerialNumber[i]=numberGather[index];//此处依次产生10组用户编号数据
			//注意：在一个循环中，将已经抽出的数字放到数组最后（与末端地址交换数值），下一个循环则不再抽取该数值
			int temp = numberGather[index];
			numberGather[index] = numberGather[numberGather.length-1-i];
			numberGather[numberGather.length-1-i] = temp;
			
		}
	}	
}