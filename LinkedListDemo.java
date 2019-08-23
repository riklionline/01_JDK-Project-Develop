public class LinkedListDemo{
	public static void main(String[] args){
		//对此类来说，完全隐藏Node
		MyLinkedList list = new MyLinkedList();
		System.out.println("------添加----------");
		list.add(10);
		list.add(20);
		list.add(15);
		list.add(5);
		list.add(80);
		list.print();
		System.out.println("------删除----------");
		list.delete(15);
		list.print();
		System.out.println("------查找----------");
		boolean b1 = list.find(15);
		System.out.println(b1);
		System.out.println("------修改----------");
		list.update(80,100);
		list.print();
		System.out.println("------插入----------");
		System.out.println(list.insert(2,200));
		list.print();
	}
}

//表示一个链表类（真正提供给外部使用的）
class MyLinkedList{
	
	private Node root; //表示链表的根节点
	private int currentNodeIndex = 0; //表示节点的序号，从0开始
	//添加
	public void add(int data){
		if(root==null){
			root = new Node(data);
		}else{
			root.addNode(data);
		}
	}
	//删除 
	public void delete(int data){
		if(root==null)return; //表示结束方法
		
		if(root.data==data) root = root.next; //表示要删除的节点是根节点
		else{
			root.delNode(data);
		}
	}
	//查找
	public boolean find(int data){
		if(root==null)return false;
		if(root.data==data){
			return true;
		}else{
			return root.findNode(data);
		}
	}
	//打印
	public void print(){
		if(root!=null){
			System.out.print(root.getData()+"->");//打印根节点
			root.printNode(); //打印根节点下的其他节点
			System.out.println();//换行
		}
	}
	
	//修改
	public boolean update(int oldData,int newData){
		if(root!=null){
			if(root.getData()==oldData){
				root.setData(newData);
				return true;
			}else{
				return root.updateNode(oldData,newData);
			}
			
		}
		return false;
	}
	//前插入
	public boolean insert(int index,int newData){
		if(index<0)return false; //要插入的位置不能小于0
		currentNodeIndex = 0;
		if(currentNodeIndex == index){//表示要插入的位置是根节点
			Node newNode = new Node(newData);
			newNode.next = root;
			root = newNode;
			return true;
		}else{
			return root.insertNode(index,newData);
		}
	}
	
	

	//tab
	//定义一个链表的节点对象
	//对节点的操作如何实现？
	//说白了就是对Node对象的添加，删除，查找，修改，插入。。。
	//对节点的操作，那么数据在哪里
	//谁有数据，谁来提供方法
	//使用内部类的写法实现节点类(内部类的使用其实就是一种功能的封装)
	//只有内部类才可以声明为private
	private class Node{
		//private Person person(id,name,age,sex...);
		private int data; //链表中存储存数据
		private Node next; //把当前自己的类型作为属性
		public Node(int data){
			this.data = data;
		}
		public void setData(int data){
			this.data = data;
		}
		public int getData(){
			return data;
		}
		//添加节点(往链表的最后添加)
		public void addNode(int data){
			if(this.next==null){
				this.next = new Node(data);
			}else{
				this.next.addNode(data);
			}
		}
		//删除节点(逻辑是删除当前节点的下一个节点)
		public void delNode(int data){
			if(this.next!=null){
				if(this.next.data==data){//表示已经找到了要删除的节点
					this.next = this.next.next;
				}else{
					this.next.delNode(data);
				}
			}
		}
		//查找节点
		public boolean findNode(int data){
			if(this.next!=null){
				if(this.next.data==data){
					return true;
				}else{
					return this.next.findNode(data);
				}
			}
			return false;
		}
		//修改节点
		public boolean updateNode(int oldData,int newData){
			if(this.next!=null){
				if(this.next.data==oldData){
					this.next.data = newData;
					return true;
				}else{
					//递归修改
					return this.next.updateNode(oldData,newData);
				}
			}
			return false;
		}
		//插入节点(前插)
		public boolean insertNode(int index,int data){
			if(this.next!=null){
				//表示从根节点的下一个节点开始（从1开始）
				//每次递归会+1，用于表示递归到第几个节点
				currentNodeIndex++;  
				if(index==currentNodeIndex){
					Node newNode = new Node(data);
					newNode.next = this.next;
					this.next = newNode;
					return true;
				}else{
					return this.next.insertNode(index,data);
				}
			}
			return false;
		}
		//所有节点的输出 
		public void printNode(){
			if(this.next!=null){
				//输出当前节点的下一个节点
				System.out.print(this.next.data+"->");
				//递归输出当前节点的下一个节点的下一个节点
				this.next.printNode();
			}
		}
	}
}








