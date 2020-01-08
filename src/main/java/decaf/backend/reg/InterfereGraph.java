package decaf.backend.reg;

import decaf.lowlevel.instr.Reg;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class InterfereGraph {

    static class Edge {
        Edge nextEdge;
        Integer from, to;
        Edge(Integer f, Integer t, Edge n) {
            nextEdge = n;
            from = f;
            to = t;
        }
    }

    public InterfereGraph(Reg[] regs) {
        for (int i = 0; i < regs.length; i++) {
            mapping.put(regs[i].index, i);
        }
    }

    public void addEdge(Integer a, Integer b) {
        addNode(a); addNode(b);
        if (a.equals(b)) return;
        links.get(a).add(b);
        links.get(b).add(a);
        degree.put(a, links.get(a).size());
        degree.put(b, links.get(b).size());
    }

    public void addNode(Integer n) {
        nodes.add(n);
        links.putIfAbsent(n, new TreeSet<>());
    }

    public TreeMap<Integer, Integer> colorWith(int colorNum) {
        int N = nodes.size();
        ArrayList<Integer> queue = new ArrayList<>();
        TreeMap<Integer, Integer> indexes = new TreeMap<>();
        for (int ind = 0; ind < nodes.size(); ind++) {
            boolean succ = false;
            for (var n : nodes) {
                int deg = degree.getOrDefault(n, 0);
                if (deg >= 0 && deg < colorNum && deg != N) {
                    if (n < 0) {
                        indexes.put(n, mapping.get(n));
                    } else queue.add(n);
                    degree.put(n, N); // deg = N means 'visited'
                    for (var to : links.get(n)) {
//                        if (e.to == n) throw new RuntimeException("Not enough registers");
                        int d = degree.getOrDefault(to, 0);
                        if (d < N)
                            degree.put(to, d - 1);
                    }
                    succ = true;
                    break;
                }
            }
            if (!succ) {
                throw new RuntimeException("Not enough registers");
            }
        }
        for (int i = queue.size() - 1; i >= 0; i--) {
            var node = queue.get(i);
            BitSet bitSet = new BitSet(colorNum);
            for (var to : links.get(node)) {
                if (indexes.containsKey(to)) {
                    bitSet.set(indexes.get(to));
                }
            }
            int newColor = bitSet.nextClearBit(0);
            indexes.put(node, newColor);
        }
        // check
        for (var x : nodes) {
            for (var y : links.get(x)) {
                assert !(indexes.get(x).equals(indexes.get(y))) : "Conflict register!";
            }
        }
        return indexes;
    }

    private TreeSet<Integer> nodes = new TreeSet<>();

    private TreeMap<Integer, TreeSet<Integer>> links = new TreeMap<>();

    private TreeMap<Integer, Integer> degree = new TreeMap<>();

    private TreeMap<Integer, Integer> mapping = new TreeMap<>();
}
