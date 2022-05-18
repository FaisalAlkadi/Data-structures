public interface List<T> {
//	private Cond<T> cnd=new Cond<T>();
	boolean empty();
	boolean full();
	void findFirst();
	void findNext();
	boolean last();
	T retrieve();
	void update(T e);
	void insert(T e);
	void remove();
	// Searches for the first element that satisfies a condition. If found, it is set as current and true is returned, otherwise current remains unchanged and false is returned. The condition is tested using cnd.
	boolean findFirstEle(Cond<T> cnd);
	// Searches and returns all elements that satisfy a condition. If none is found, the empty list is returned. This method does not change current. The condition is tested using cnd.
	List<T> findAllEle(Cond<T> cnd);
	
}
