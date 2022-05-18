
public class ArrayList <T> implements List<T> {
	private int maxsize;
	private int size;
	private int current;
	private T[] nodes;
	public ArrayList(int n) {
		maxsize = n;
		size = 0;
		current = -1;
		nodes = (T[]) new Object[n];
	}


	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return size == maxsize;
	}

	@Override
	public void findFirst() {
		// TODO Auto-generated method stub
		current = 0;

	}

	@Override
	public void findNext() {
		// TODO Auto-generated method stub
		current++;
	}

	@Override
	public boolean last() {
		// TODO Auto-generated method stub
		return current == size - 1;

	}

	@Override
	public T retrieve () {
		return nodes[current];
	}

	public void update (T val) {
		nodes[current] = val;
	}

	public void insert (T val) {
		for (int i = size-1; i > current; --i) {
			nodes[i+1] = nodes[i];
		}
		current++;
		nodes[current] = val;
		size++;
	}

	@Override
	public void remove () {
		for (int i = current + 1; i < size; i++) {
			nodes[i-1] = nodes[i];
		}
		size--;
		if (size == 0)
			current = -1;
		else if (current == size)
			current = 0;
	}


	@Override
	public boolean findFirstEle(Cond<T> cnd) {
		for(int i=0;i<size;i++) 
			if(cnd.test(nodes[i])) {
				current = i;
				return true;}
		return false;
	}

	@Override
	public List<T> findAllEle(Cond<T> cnd) {
		List<T> f=new ArrayList(size);
		for(int i=0;i<size;i++)
			if(cnd.test(nodes[i]))
				f.insert(nodes[i]);
		
		return f;
	}

}
