public class IntList{
	public int first;
	public IntList rest;

	public IntList(int f, IntList r){
		first = f;
		rest = r;
	}

	/** create two new pointers
	 *  implement the method by destructively changing the ordering of a
	 * given IntList so that even indexed links precede odd inedxed links.
	 */
	public static void evenOdd(IntList lst){
		if(lst.rest.rest == null){
			return ;
		}
		IntList seconds = lst.rest;
		IntList odds = lst.rest;
		while(lst.rest != null && odds.rest != null){
			lst.rest = lst.rest.rest;
			odds.rest = odds.rest.rest;
			lst = lst.rest;
			odds = odds.rest;
		}
		lst.rest = seconds;
		
	}
}
