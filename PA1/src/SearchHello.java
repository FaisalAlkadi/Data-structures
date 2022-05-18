public class SearchHello {
	public static void main(String[] args) {
		List<String> l = new LinkedList<String>();
		l.insert("cat");
		l.insert("hello");
		l.insert("dog");
		StringEqualCond cnd = new StringEqualCond("hello");
		System.out.println(l.findFirstEle(cnd)); // prints true
	}
}
