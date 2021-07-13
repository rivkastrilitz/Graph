package ex0;

import java.util.*;


 public class Graph_Algo implements graph_algorithms {
    graph gp;
    int  pathNodesCounter=0;

    public Graph_Algo() {
        gp = new Graph_DS();

    }
     public Graph_Algo(graph g){
        this.gp=g;
     }

   /**
    * Init the graph on which this set of algorithms operates on--
    *shallow copy of the graph
    *  **/
    @Override
    public void init(graph g) {

        this.gp = g;
    }
    /**
     @return   copy of the graph   **/
    @Override
    public graph copy() {

        graph gp2 = new Graph_DS();


        node_data nodeGp2j=null;
        node_data nodeGP2i=null;
        for (node_data i : gp.getV()) {

            if (gp2.getNode(i.getKey()) == null) {
                 nodeGP2i = new NodeData(i.getKey());
                gp2.addNode(nodeGP2i);
            }
            for (node_data j : i.getNi()) {
                if (gp2.getNode(j.getKey()) == null) {
                     nodeGp2j = new NodeData(j.getKey());
                    gp2.addNode(nodeGp2j);
                }
                if(nodeGP2i!=null&& nodeGp2j!=null) {
                    gp2.connect(nodeGP2i.getKey(), nodeGp2j.getKey());
                }
            }
        }

        return gp2;
    }

/**
 * @return true if all the nodes in the graph are connected
 * false otherwise
 *
 * **/
    @Override
    public boolean isConnected() {
        if(gp.nodeSize()==0||gp.nodeSize()==1)return true;
        Iterator<node_data> startNode = gp.getV().iterator();
        node_data nodeOne = startNode.next();

        BFS(nodeOne.getKey());
        for (node_data v : gp.getV()) {
            if (v.getTag() == -1) {
                return false;
            }
        }
        return true;
    }
/**
 * @param src - start node
 * @param dest - target node
 * @return the length of the shortest path between src to dest
 * **/
    @Override
    public int shortestPathDist(int src, int dest) {
        if (src==dest )return 0;
        if (gp.getNode(src)==null || gp.getNode(dest)==null )return -1;


        List<node_data> path = shortestPath(src, dest);

        if(gp.getNode(dest).getInfo()=="")return -1;
        int ans=(path.size()-1);
         return ans;
    }
     /**
      * @param src - start node
      * @param dest - end (target) node
      * @return the the shortest path between src to dest - as an ordered List of nodes
      */
    @Override
    public List<node_data> shortestPath(int src, int dest) {
        List<node_data>ans=new ArrayList<>() ;


        if(gp.getNode(dest)==null)return null;
        if(gp.getNode(dest)==gp.getNode(src)){
          ans.add(gp.getNode(dest));
          return ans;
        }
        ans=BFSf2(src, dest);
        return ans;

    }


     /**
      this method marking all the nodes that has been visited
      @param src-start node
      */
     public void BFS(int src){
         initializeNode(gp);

         LinkedList<node_data> queue=new LinkedList<node_data>();
         queue.add(gp.getNode(src));

         node_data currentNode= null;
         while (!queue.isEmpty()){
             currentNode=queue.removeFirst();
             Collection<node_data>neighbors=currentNode.getNi();

             for ( node_data next:neighbors) {
                 if(next.getTag()==-1){
                     queue.add(next);
                     next.setTag(0);

                 }
             }

         }
     }



     /**
     this method marking all the nodes that has been visited
      saving each nodes father in node "info"
      and creating the shortest path between two given nodes
      @param  src-start node
      @param  dest-end node
      @return the shortest path between the src and dest
      */
        public List<node_data> BFSf2 (int src, int dest) {

            initializeNode(gp);

            LinkedList<node_data> queue = new LinkedList<node_data>();
            queue.add(gp.getNode(src));
            gp.getNode(src).setTag(0);


            while (!queue.isEmpty()) {
              node_data  currentNode = queue.removeFirst();
                Collection<node_data> neighbors = currentNode.getNi();

                for (node_data next : neighbors) {


                    if (next.getTag() == -1) {
                        queue.add(next);
                        next.setTag(0);

                        next.setInfo(String.valueOf(currentNode.getKey()));
                        if (next == gp.getNode(dest)) break;
                    }
                }

            }

            List<node_data> path = new ArrayList<>();

            node_data node = gp.getNode(dest);
            while (node.getInfo() != "") {


                path.add(node);
                node = gp.getNode(Integer.parseInt(node.getInfo()));

            }
            path.add(gp.getNode(src));
            Collections.reverse(path);
            return path;
        }

         /**
          * this method initialize the "info" and  "tag" on each node in the graph
          * **/
            public void initializeNode (graph g){
                for (node_data curr : g.getV()) {
                    curr.setTag(-1);
                    curr.setInfo("");

                }
            }

}