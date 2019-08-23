/**
功能描述：请自己定义一个链表结构，并进行数值插入（form "m" to "n"）,"m"与"n"分别从键盘录入；
*/
import java.util.Scanner;
public class LinkedList{

	public static void main(String[] args){		
		System.out.println("------------您想在链表中添加数据form 'm=?'------------");
		Scanner input_m = new Scanner(System.in);
		int m = input_m.nextInt();
		
		System.out.println("------------您想在链表中添加数据to 'n=?'------------");
		Scanner input_n = new Scanner(System.in);
		int n = input_n.nextInt();
		
		cycAddNum(m,n);		
	}
	//循环添加数据的方法
	public static void cycAddNum(int m,int n){
		MyLinkedList myList = new MyLinkedList();
		if(m<=n){
			for(int i=m;i<=n;i++){
				myList.add(i);
			}
			myList.print();
		}else{
			for(int i=m;i>=n;i--){
				myList.add(i);
			}
			myList.print();
		}
	}
	
}

//链表类
class MyLinkedList{
	private Node root;//表示链表的根节点
	//添加
	public void add(int data){
		if(root==null){
			root = new Node(data);//为什么是根节点？因为是第一个，程序运行到此处还没有进行递归算法的next……
		}else{
			root.addNode(data);	
		}
	}
	//打印
	public void print(){
		if(root!=null){
			System.out.print(root.getData()+"->");
			root.printNode();//打印根节点下的其他节点
			System.out.println();//换行
		}
	}
	
	//内部类，实现功能封装，注意，在程序结构中虽然放在最后，但此代码应首先进行设计
	//设计完成后再实现上面外部类设计，继而在主函数或其他方法调用外部类
	//外部类调用内部类属于一种“绑定”关系
	private class Node{
		private int data;//链表中存储的数据
		private Node next;//把当前自己的类型作为属性（此处是关键，需要反复体会，此next的作用域应在内部类中）
			
		public Node(int data){
			this.data = data;//其实Node中当前只有一个data参数，并且需要提供给外部类传参使用，而next只是用来形成“链条”的
		}
		public void setData(int data){
			this.data = data;
		}
		public int getData(){
			return data;
		}
		
		//添加节点（在链表的最后添加）
		public void addNode(int data){
			if(this.next==null){
				this.next = new Node(data);
			}else{
				this.next.addNode(data);
			}
		}
		//print all
		public void printNode(){
			if(this.next!=null){
				//输出当前节点的下一个节点
				System.out.print(this.next.data+"->");//注意：data与next.data与next.next.data表示的是不同“位置”的data
				this.next.printNode();
			}
		}		
	}
}