/**
	模拟双色球综合案例
	1、准备相关的变量N个
	2、用户选择是机选还是手选号码
	3、接收用户选号（6红1蓝）
	4、系统生成号码（6红1蓝）
	5、验证系统号码和用户号码，记录选中的号
	6、验证是否中奖
	7、把号码排序
	8、公布结果
*/
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class DoubleBall{
	public static void main(String[] args){
		
		int[] userRedBall = new int[6];//用户选择的红球号码
		int[] sysRedBall = new int[6];
		int userBlueBall = 0;
		int sysBlueBall = 0;
		int redBallCount = 0;
		int blueBallCount = 0;
		
		//[1,2,3,4,5,6,7,8,9,10,11,12,13....]
		int[] redBalls = new int[33];
		for(int i=0;i<redBalls.length;i++){
			redBalls[i] = i+1;
		}
		
		//第二步
		//游戏开始
		System.out.println("双色球游戏开始，祝你好运！");
		//用户选择是机选还是手选号码
		System.out.println("请问您是要机选或手选号码（1,机选，2,手选）");
		Scanner input = new Scanner(System.in);
		Random r = new Random();//生成随机数工具
		boolean flag = true;//标记
		while(flag){
			int isAuto = input.nextInt();
			switch(isAuto){
			
				case 1://1,机选
					computerSelection(redBalls,userRedBall);
					userBlueBall = r.nextInt(16)+1;
					flag = false;
					break;
					
				case 2://2,手选
					System.out.println("请选择6个红球号码（1-33）：");
					for(int i=0;i<userRedBall.length;i++){
						userRedBall[i] = input.nextInt();//阻塞
					}
					System.out.println("请选择1个蓝球号码（1-16）：");
					userBlueBall = input.nextInt();
					flag = false;
					break;
				default:
					System.out.println("请问您是要机选或手选号码（1,机选，2,手选）");
					break;
	
			}
		}
		
		//生成系统号码：
		//红球 
		computerSelection(redBalls,sysRedBall);
		//蓝球
		sysBlueBall = r.nextInt(16)+1;
		
		//统计结果
		//统计红球
		for(int i=0;i<userRedBall.length;i++){
			for(int j=0;j<sysRedBall.length-redBallCount;j++){
				if(userRedBall[i]==sysRedBall[j]){
					int temp = sysRedBall[j];
					sysRedBall[j] = sysRedBall[sysRedBall.length-1-redBallCount];
					sysRedBall[sysRedBall.length-1-redBallCount] = temp;
					redBallCount++;
					break;
				}
			}
		}
		
		//统计蓝球
		if(userBlueBall==sysBlueBall){
			blueBallCount = 1;
		}
		
		//验证是否中奖
		//
		if(blueBallCount==0 && redBallCount <=3){
			System.out.println("革命尚未成功，同志还需努力！再下一注");
		}else if(blueBallCount==1 && redBallCount<3){
			System.out.println("恭喜你！中了六等奖，5块钱带回家");
		}else if((blueBallCount==1 && redBallCount==3) || (blueBallCount==0 && redBallCount==4)){
			System.out.println("恭喜你！中了五等奖，10块钱带回家");
		}else if((blueBallCount==1 && redBallCount==4) || (blueBallCount==0 && redBallCount==5)){
			System.out.println("恭喜你！中了四等奖，200块钱带回家");
		}else if(blueBallCount==1 && redBallCount==5){
			System.out.println("恭喜你！中了三等奖，3000块钱带回家");
		}else if(blueBallCount==0 && redBallCount==6){
			System.out.println("恭喜你！中了二等奖，可以买辆车取媳妇啦");
		}else if(blueBallCount==1 && redBallCount==6){
			System.out.println("恭喜你！中了一等奖，500W，想干嘛就干嘛");
		}else{
			System.out.println("风里雨里，工地等你！");
		}
		
		//公布系统号码
		System.out.println("本期中奖红球号码为：");
		Arrays.sort(sysRedBall);
		System.out.println(Arrays.toString(sysRedBall));
		System.out.println("本期中奖蓝球号码为："+sysBlueBall);
		
		//公布用户选码
		System.out.println("您选择的红球号码为：");
		Arrays.sort(userRedBall);
		System.out.println(Arrays.toString(userRedBall));
		System.out.println("您选择的蓝球号码为："+userBlueBall);
		
		System.out.println("-----------买双色球，造福你我他！感谢您------------");
	}
	
	//冒泡排序
	
	
	//用于在指定数列中，随机生成多个不重复的数算法
	public static void computerSelection(int[] redBalls,int[] userRedBall){
		//随机生成多个不重复的数，我们不知道每次随机生成的数是不是一样的，
		//只要是生成一样的数，那么这次循环就是无效
		//随机生成6个数，最优的算法应该是6次循环
		//1,2,3,4,5,6,7,8,9
		//1,2,9,4,5,6,7,8,3
		//下标2
		//3
		Random r = new Random();
		int index = -1;//随机生成数组的下标
		//
		for(int i=0;i<userRedBall.length;i++){
			index = r.nextInt(userRedBall.length-i); //userRedBall数组长度为6，限定了index的数值范围1~6
			userRedBall[i] = redBalls[index];        //redBalls数组长度为33，使用index下标则限定了数组的使用范围，所以每次随机取号都从前6/33个中取
			int temp = redBalls[index];
			redBalls[index] = redBalls[redBalls.length-1-i];
			redBalls[redBalls.length-1-i] = temp;
		}
	}
	
}