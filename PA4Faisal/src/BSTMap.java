
class BW {

    public boolean value;

    public BW(boolean val) {
        value = val;
    }
}

public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {

    public BSTNode<K, T> root; // Do not change this

    public BSTMap() {
        root = null;
    }

    private int reSize(BSTNode<K, T> el) {
        if (el == null) {
            return 0;
        } else {
            return 1 + reSize(el.left) + reSize(el.right);
        }
    }

    @Override
    public int size() {
        return reSize(root);
    }

    @Override
    public boolean full() {
        return false;
    }

    @Override
    public void clear() {
        root = null;
    }

    private BSTNode<K, T> reFindK(K elKey, BSTNode<K, T> el) {
        if (el != null) {
            if (el.key.equals(elKey)) {
                return el;
            } else if (elKey.compareTo(el.key) < 0) {
                return reFindK(elKey, el.left);
            } else {
                return reFindK(elKey, el.right);
            }
        } else {
            return null;
        }
    }

    private BSTNode<K, T> searForKey(K elKey) {
        if (root == null) {
            return null;
        }
        return reFindK(elKey, root);
    }

    @Override
    public boolean update(K k, T e) {
        BSTNode<K, T> curK = searForKey(k);
        if (curK != null) {
            curK.data = e;
            return true;
        }
        return false;
    }

    @Override
    public Pair<Boolean, T> retrieve(K k) {
        BSTNode<K, T> curK = searForKey(k);
        if (curK != null) {
            return new Pair<Boolean, T>(true, curK.data);
        }
        return new Pair<Boolean, T>(false, null);
    }

    private void insRec(K elKey, T data, BSTNode<K, T> el) {
        if (elKey.compareTo(el.key) < 0) {
            if (el.left == null) {
                el.left = new BSTNode<K, T>(elKey, data);
            } else {
                insRec(elKey, data, el.left);
            }
        } else {
            if (el.right == null) {
                el.right = new BSTNode<K, T>(elKey, data);
            } else {
                insRec(elKey, data, el.right);
            }
        }
    }

    @Override
    public boolean insert(K k, T e) {
        BSTNode<K, T> curK = searForKey(k);

        if (curK != null) {
            return false;
        }
        if (root == null) {
            root = new BSTNode<K, T>(k, e);
        } else {
            insRec(k, e, root);
        }
        return true;
    }

    private BSTNode<K, T> remRec(K elKey, BSTNode<K, T> el, BW f) {

        if (el == null) {
            return null;
        }
        if (elKey.equals(el.key)) {
            f.value = true;
            if (el.left != null && el.right != null) {
                BSTNode<K, T> min = el.right;
                while (min.left != null) {
                    min = min.left;
                }
                el.key = min.key;
                el.data = min.data;
                el.right = remRec(min.key, el.right, f);
            } else {
                BSTNode<K, T> son = null;
                if (el.right == null) {
                    son = el.left;
                } else if (el.left == null) {
                    son = el.right;
                }
                return son;
            }
        } else if (elKey.compareTo(el.key) < 0) {
            el.left = remRec(elKey, el.left, f);
        } else {
            el.right = remRec(elKey, el.right, f);
        }
        return el;
    }

    @Override
    public boolean remove(K k) {
        BW remDone = new BW(false);
        BSTNode<K, T> el = remRec(k, root, remDone);
        root = el;
        return remDone.value;
    }

    private void fillQue(PQK<K, T> que, BSTNode<K, T> el) {
        if (el != null) {
            fillQue(que, el.left);
            fillQue(que, el.right);
            que.enqueue(el.key, el.data);
        }
    }
    
    private Pair<K,PQK<K, T>> getMin(PQK<K, T> que){
        PQK<K, T> q=new PQKImp<K,T>(que.length()-1);
        while(que.length()>1){
            Pair<K,T> p1=que.serve();
            q.enqueue(p1.first, p1.second);
        }
        K m=que.serve().first;
        return new Pair<K,PQK<K, T>>(m,q);
    }

    @Override
    public List<K> getKeys() {
        PQK<K, T> que = new PQKImp<K, T>(size());
        fillQue(que, root);
        List<K> kel = new LinkedList<K>();
        while(que.length() > 0) {
            Pair<K,PQK<K, T>> p1=getMin(que);
            kel.insert(p1.first);
            que=p1.second;            
        }
        return kel;
    }
}
