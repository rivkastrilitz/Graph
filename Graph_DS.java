package ex0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class Graph_DS implements graph {

private HashMap<Integer,node_data> gr=new HashMap<>();
private  int nodeCounter;
private  int edgeCounter;
private int modeCounter;

 public Graph_DS(){

     this.nodeCounter=0;
     this.edgeCounter=0;
     this.modeCounter=0;

 }


    /**
     * return the node_data by the node_id,
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
    @Override
    public node_data getNode(int key) {
       return gr.get(key);
    }



    /**
     * return true iff there is an edge between node1 and node2
     * @param node1
     * @param node2
     * @return
     */
    @Override
    public boolean hasEdge(int node1, int node2) {
     if(getNode(node1)!=null && getNode(node2)!=null) {
         if (getNode(node1).hasNi(node2)) {

             return true;
         }
     }
        return false;
    }




    /**
     * add a new node to the graph with the given node_data.
     * @param n
     */
    @Override
    public void addNode(node_data n) {

     if(getNode(n.getKey())==null) {

         gr.put(n.getKey(), n);
         nodeCounter++;
         modeCounter++;
     }

    }


    /**
     * Connect an edge between node1 and node2.
     * @param key1,key2
     */
    @Override
    public void connect(int key1, int key2) {

        node_data node1 = getNode(key1);
        node_data node2 = getNode(key2);

        if(node1!=null && node2!=null) {
            if (!node1.hasNi(key2) && key1 != key2) {
                node2.addNi(node1);
                node1.addNi(node2);

                edgeCounter++;
                modeCounter++;
            }
        }
    }

    /**
     *  return a pointer  for the collection representing
     *  all the nodes in the graph.
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_data> getV() {
        return gr.values();
    }

    /**
     * This method return a collection of  the
     * collection representing all the nodes connected to node_id
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_data> getV(int node_id) {
        return getNode(node_id).getNi();
    }

    /**
     * Delete the node with the given ID from the graph
     * and removes all edges which starts or ends at this node.
     * @return the data of the removed node (null if none).
     * @param key
     */
    @Override
    public node_data removeNode(int key) {
        if (gr!=null) {
            node_data nodeToDelete = gr.get(key);
            if (nodeToDelete != null) {

                for (node_data ni : nodeToDelete.getNi()) {
                    ni.removeNode(nodeToDelete);
                    edgeCounter--;
                    modeCounter++;
                }
                nodeCounter--;
                return gr.remove(key);
            }
        }
return null;
    }

    /**
     * Delete given edge from the graph,
     * @param node1
     * @param node2
     */
    @Override
    public void removeEdge(int node1, int node2) {
        if (getNode(node1) != null && getNode(node2) != null) {
            if (getNode(node1).hasNi(node2)) {
                getNode(node1).removeNode(getNode(node2));
                getNode(node2).removeNode(getNode(node1));
                modeCounter++;
                edgeCounter--;
            }
        }
    }


/**
 * return the number of nodes in the graph
 * */
    @Override
    public int nodeSize() {
        return this.nodeCounter;
    }
    /**
     * return the number of edges in the graph
     * */
    @Override
    public int edgeSize() {
        return this.edgeCounter;
    }
    /**
     * return the number of changes made on the graph
     * */
    @Override
    public int getMC() {
        return this.modeCounter;
    }
}
