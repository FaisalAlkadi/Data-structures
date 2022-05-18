public class LinkedList <T> implements List<T> {
	
	private Node<T> head;
	private Node<T> current;

	
	public LinkedList () {
		head = current = null;
	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void findFirst() {
		current = head;

		// TODO Auto-generated method stub
		
	}

	@Override
	public void findNext() {
		current = current.next;

		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean last() {
		return current.next == null;
	}

	@Override
	public T retrieve() {
		// TODO Auto-generated method stub
		return current.data;

	}

	@Override
	public void update(T e) {
		current.data = e;

		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(T e) {
		
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T> (e);
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (e);
			current = current.next;
			current.next = tmp;
		}

		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}

		// TODO Auto-generated method stub
		
	

	@Override
	public boolean findFirstEle(Cond<T> cnd) {
		if(head==null)
			return false;
		Node<T> cur=head;
		while(cur!=null) {
			if(cnd.test(cur.data)) {
				current=cur;
				return true;
				}
			cur=cur.next;
		}
		return false;
	}

	@Override
	public List<T> findAllEle(Cond<T> cnd) {
		List<T> new_Node =new LinkedList<>();
		Node<T> cur=head;
		if(head==null)
			return new_Node;
		while (cur!=null) {
			if(cnd.test(cur.data))
				new_Node.insert(cur.data);
			cur=cur.next;
			
		}
		// TODO Auto-generated method stub
		return new_Node;
	}
	
}