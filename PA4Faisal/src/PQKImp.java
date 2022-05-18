
class QueueElem<P extends Comparable<P>, T> {

    public Pair<P, T> elem;
    public QueueElem<P, T> nextElem;

    public QueueElem() {
        nextElem = null;
    }

    public QueueElem(P p, T e) {
        elem =new Pair<P,T>(p,e);
        nextElem=null;
    }
}

public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {

    private int maxNum;
    private QueueElem<P, T> first;

    public PQKImp(int k) {
        maxNum = k;
        first = null;
    }

    @Override
    public int length() {
        int s = 0;
        if (first != null) {
            QueueElem<P, T> t = first;
            while (t != null) {
                s++;
                t = t.nextElem;
            }
        }
        return s;
    }

    @Override
    public void enqueue(P pr, T e) {
        if (maxNum > 0) {
            QueueElem<P, T> qe = new QueueElem<P, T>(pr, e);
            if ((first == null) || (pr.compareTo(first.elem.first) > 0)) {
                qe.nextElem = first;
                first = qe;
            } else {
                QueueElem<P, T> next, prev;
                for (next = first, prev = null; ((next != null) && (pr.compareTo(next.elem.first) <= 0)); next = next.nextElem) {
                    prev = next;
                }
                qe.nextElem = next;
                prev.nextElem = qe;
            }
            if (length() > maxNum) {
                QueueElem<P, T> c = first;
                int index = 1;
                while (index < maxNum) {
                    c = c.nextElem;
                    index++;
                }
                c.nextElem = null;
            }
        }
    }

    @Override
    public Pair<P, T> serve() {
        if (length() != 0) {
            Pair<P, T> p = first.elem;
            first = first.nextElem;
            return p;
        }
        return null;
    }
}
