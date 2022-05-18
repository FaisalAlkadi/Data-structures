
import java.io.File;
import java.util.Scanner;

public class Recommender {

    // Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
    public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
        if (g.isNode(i)) {
            List<K> nodeNe = g.neighb(i);
            List<K> allNodes = g.getNodes();
            List<K> recPopNodes = new ListImp<K>();
            allNodes.findFirst();
            while (true) {
                K nk = allNodes.retrieve();
                if (!(nk.equals(i) || nodeNe.exists(nk))) {
                    recPopNodes.insert(nk);
                }
                if (allNodes.last()) {
                    break;
                }
                allNodes.findNext();
            }
            PQK<Double, K> rPopQ = new PQKImp<Double, K>(k);
            if (!recPopNodes.empty()) {
                recPopNodes.findFirst();
                while (true) {
                    K nk = recPopNodes.retrieve();
                    rPopQ.enqueue(g.deg(nk) / 1.0, nk);
                    if (recPopNodes.last()) {
                        break;
                    }
                    recPopNodes.findNext();
                }
            }
            return rPopQ;
        }
        return null;
    }

    // Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
    public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
        if (g.isNode(i)) {
            List<K> nodeNe = g.neighb(i);
            List<K> allNodes = g.getNodes();
            List<K> recCnNodes = new ListImp<K>();
            allNodes.findFirst();
            while (true) {
                K nk = allNodes.retrieve();
                if (!(nk.equals(i) || nodeNe.exists(nk))) {
                    recCnNodes.insert(nk);
                }
                if (allNodes.last()) {
                    break;
                }
                allNodes.findNext();
            }
            PQK<Double, K> rCnQ = new PQKImp<Double, K>(k);
            if (!recCnNodes.empty()) {
                recCnNodes.findFirst();
                while (true) {
                    K firstN = recCnNodes.retrieve();
                    double comFriends = 0.0;
                    if (!nodeNe.empty()) {
                        nodeNe.findFirst();
                        while (true) {
                            K secondN = nodeNe.retrieve();
                            if (g.isEdge(firstN, secondN)) {
                                comFriends++;
                            }
                            if (nodeNe.last()) {
                                break;
                            }
                            nodeNe.findNext();
                        }
                    }
                    rCnQ.enqueue(comFriends, firstN);
                    if (recCnNodes.last()) {
                        break;
                    }
                    recCnNodes.findNext();
                }
            }
            return rCnQ;
        }
        return null;
    }

    // Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
    public static Graph<Integer> read(String fileName) {

        try {
            Graph<Integer> g = new MGraph<Integer>();
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                g.addNode(i);
                int j = scanner.nextInt();
                g.addNode(j);
                g.addEdge(i, j);
            }
            scanner.close();
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
