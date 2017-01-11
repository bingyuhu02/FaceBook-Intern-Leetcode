public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if( node == null ) return null;
        // use a queue to help BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        // use a map to save cloned node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        // clone the root
        map.put(node, new UndirectedGraphNode(node.label));
        
        while( !queue.isEmpty() ){
            UndirectedGraphNode cur = queue.poll();
            // handle the neighors
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if( !map.containsKey(neighbor)){
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}