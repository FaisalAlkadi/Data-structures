class ListElem<T> {

    public T elem;
    public ListElem<T> nextElem;

    public ListElem() {
        elem = null;
        nextElem = null;
    }

    public ListElem(T e) {
        elem = e;
        nextElem = null;
    }
}
public class LinkedList <T> implements List<T> {

    private ListElem<T> fir;
    private ListElem<T> cN;

     public LinkedList(){
		// TODO Auto-generated constructor stub 
        fir = null;
        cN = null;
    }

    @Override
    public boolean empty() {
        if (fir == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void findFirst() {
        cN = fir;
    }

    @Override
    public void findNext() {
        cN = cN.nextElem;
    }

    @Override
    public boolean last() {
        if (cN.nextElem == null) {
            return true;
        }
        return false;
    }

    @Override
    public T retrieve() {
        T data = cN.elem;
        return data;
    }

    @Override
    public void update(T e) {
        cN.elem = e;
    }

    @Override
    public void insert(T e) {
        if (!empty()) {
            ListElem<T> n;
            n = cN.nextElem;
            cN.nextElem = new ListElem<T>(e);
            cN = cN.nextElem;
            cN.nextElem = n;
        } else {
            fir = new ListElem<T>(e);
            cN = fir;
        }
    }

    @Override
    public void remove() {
        if (cN == fir) {
            fir = fir.nextElem;
        } else {
            ListElem<T> n;
            for (n = fir; n.nextElem != cN; n = n.nextElem) {
            }
            n.nextElem = cN.nextElem;
        }
        cN = (cN.nextElem == null) ? fir : cN.nextElem;
    }

    @Override
    public int size() {
        int s = 0;
        if (fir != null) {
            ListElem<T> t = fir;
            while (t != null) {
                s++;
                t = t.nextElem;
            }
        }
        return s;
    }

    private boolean recExists(T e, ListElem<T> n) {
        if (n == null) {
            return false;
        } else if (e.equals(n.elem)) {
            return true;
        } else {
            return recExists(e, n.nextElem);
        }
    }

    @Override
    public boolean exists(T e) {
        if (empty()) {
            return false;
        }
        return recExists(e, fir);
    }

}
