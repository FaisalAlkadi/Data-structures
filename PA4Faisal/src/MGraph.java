
public class MGraph<K extends Comparable<K>> implements Graph<K> {

    public Map<K, List<K>> adj; // Do not change this

    public MGraph() {
        adj = new BSTMap<K, List<K>>();
    }

    @Override
    public boolean addNode(K i) {
        List<K> listOfEdges = new LinkedList<K>();
        boolean isAdded = adj.insert(i, listOfEdges);
        return isAdded;
    }

    @Override
    public boolean isNode(K i) {
        Pair<Boolean,List<K>> pa1=adj.retrieve(i);
        return pa1.first;
    }

    @Override
    public boolean addEdge(K i, K j) {
        if (!(isNode(i) && isNode(j))) {
            return false;
        }
        if (isEdge(i, j)) {
            return false;
        }
        adj.retrieve(i).second.insert(j);
        adj.retrieve(j).second.insert(i);
        return true;
    }

    @Override
    public boolean isEdge(K i, K j) {
        if (!(isNode(i) && isNode(j))) {
            return false;
        }
        return adj.retrieve(i).second.exists(j);
    }

    @Override
    public List<K> neighb(K i) {
        if (isNode(i)) {
        return adj.retrieve(i).second;
        }
        return null;
    }

    @Override
    public int deg(K i) {
        if (isNode(i)) {
            int nodeDegree = neighb(i).size();
            return nodeDegree;
        }
        return -1;
    }

    @Override
    public List<K> getNodes() {
        List<K> kel=adj.getKeys();
        return kel;
    }

}
