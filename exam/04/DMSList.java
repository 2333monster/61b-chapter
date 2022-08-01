/** Dynamic Method Selection
 * Modify the code below so that the max method of DMSList works properly.
 * Assume all numbers inserted into DMSList are positive, 
 * and we only insert using insertFront.
 */

public class DMSList{
	private Intnode sentinel;
	public DMSList(){
		sentinel = new Intnode(-1000,new LastIntnode());
	}
	public class Intnode{
		public int item;
		public Intnode next;
		public Intnode(int i, Intnode h){
			item = i;
			next = h;
		}
		public int max(){
			return Math.max(item,next.max());
		}
	}
	public class LastIntnode extends Intnode{
		public LastIntnode(){
			super(0,null);
		}
		@Override
		public int max(){
			return 0;
		}
	}
	/* returns 0 if list is empty. Otherwise,returns the max element*/
	public int max(){
		return sentinel.next.max();
	}
	public void insertFront(int x){
		sentinel.next = new Intnode(x,sentinel.next);
	}
	public static void main(String[] args) {
		DMSList s = new DMSList();
		int max = s.max();
		System.out.print(s.max());
	}
}

/** if new DMSList is empty , the sentinel.next is Lastintnode, use overide method return 0;
 * else return the max method of intnode.
 */