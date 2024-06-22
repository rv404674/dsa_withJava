package graphs.dfsPractice;

import java.util.*;

/*
will work for integers and alpabets as well
 */
class GeneralGraph{
    private int V;
    private HashMap<String, LinkedList<String>> hashMap;

    public GeneralGraph(int v, LinkedList<String> nodes){
        V = v;
        hashMap = new HashMap<>();
        for(String x: nodes){
            hashMap.put(x, new LinkedList<>());
        }
    }

    public void addEdge(String x, String y){
        hashMap.get(x).add(y);
    }

    public void printGraph(){
        Iterator<String> i = hashMap.keySet().iterator();
        while(i.hasNext()){
            String cur = i.next();
            System.out.println("Node: " + cur + " Values:" + hashMap.get(cur));
        }
    }
}

public class DfsForAlphabeticalGraph {
    public static void main(String[] args) {
        LinkedList<String> nodes = new LinkedList<>(List.of("A", "B", "C", "D", "E"));

        GeneralGraph generalGraph = new GeneralGraph(5, nodes);
        generalGraph.addEdge("A", "B");
        generalGraph.addEdge("A", "E");
        generalGraph.addEdge("B", "C");
        generalGraph.addEdge("D", "C");
        generalGraph.addEdge("E", "D");
        generalGraph.addEdge("E", "B");

        generalGraph.printGraph();
    }


}
