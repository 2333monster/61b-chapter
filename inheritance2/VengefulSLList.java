public class VengefulSLList<item> extends SLList<item>{
	SLList<item> deletedItems;

	public VengefulSLList(){
		super();
		deletedItems = new SLList<>();
	}

	public VengefulSLList(item x){
		super(x);
		deletedItems = new SLList<>();
	}

	public void printLostItems(){
		deletedItems.print();
	}

	@Override
	public item removeLast(){
		item x = super.removeLast();
		deletedItems.addLast(x);
		return x;
	}

	public static void main(String[] args) {
		VengefulSLList<Integer> s = new VengefulSLList<>(2);
		s.addFirst(5);
		s.addFirst(1);
		s.addFirst(2);
		s.addFirst(3);
		s.addFirst(4);
		s.removeLast();
		s.printLostItems();
		}
	}