
public class random
{

	static class Node{
		static int value;
		static Node next;
		
		public Node() {
			this.value = 0;
			this.next = null;
		}
	}
	public static int sumOdd(Node node) {
		if(Node.next == null){
			if(Node.value%2 == 1)
				return Node.value;
			else
				return 0;
		}
		if(Node.value%2 == 1){
			return Node.value + sumOdd(Node.next);
		}
		if(Node.value%2 == 0){
			return sumOdd(Node.next);
		}
		return 0;
	}


	public static void main(String[] args) {

		Node one = new Node();
		Node two = new Node();
		Node three = new Node();
		Node four = new Node();
		one.value = 4;
		one.next = two;
		two.value = 1;
		two.next = three;
		three.value = 5;
		three.next = four;
		four.value = 2;
		four.next = null;

		System.out.println(sumOdd(one));
	}

}
