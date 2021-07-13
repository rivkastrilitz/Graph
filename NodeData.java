package ex0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * each node that we create contains
 * "tag" and "info" both ara data of the node that will be relevant in algorithms
 * key -unique to each node
 * a neighbors collection of the node **/
public class NodeData implements node_data{
    private int key=counter;
    private String info="";
    private int tag=-1;
    private HashMap<Integer,node_data> neighbors = new HashMap<>();
    private  static int counter=0 ;


    public NodeData(){
        this.key=key;
       counter++;


    }
    public NodeData(int key) {
        this.key=key;
        counter++;
    }

    /**
     * Return the key -id of this node.
     * Note: each node_data should have a unique key.
     * @return
     */
    public int getKey() {
        return this.key;

    }


    /**
     * This method returns a collection with all the Neighbor nodes of this node_data
     * @return*/
    public Collection<node_data> getNi() {

    return neighbors.values();
    }

    /**
     * This method returns true if a given node have a neighbor-->if tow nodes have an edge between them
     * false other
     * @return*/
    public boolean hasNi(int key) {
    return neighbors.containsKey(key);

    }

    /** This method adds the node_data (t) to this node_data collection of neighbors .*/
    public void addNi(node_data t) {

        neighbors.put(t.getKey(),t);

    }

    /**
     * Removes the edge this-key,
     * @param node
     */
    public void removeNode(node_data node) {
        neighbors.remove(node.getKey(),node);

    }

    /**
     * return the remark associated with this node.
     * default info=" "
     * @return
     */
    public String getInfo() {
        return this.info;
    }

    /**
     * Allows changing the remark  associated with this node.
     * @param s
     */
    public void setInfo(String s) {
        this.info=s;
    }

    /**
     * return the  Temporal marked  data of given  node
     * which can be used by algorithms
     * @return
     */
    public int getTag() {
        return this.tag;
    }


    /**
     * Allow setting the "tag" value for temporal marking an node
     * @param t - the new value of the tag
     */
    public void setTag(int t) {
        this.tag=t;
    }
}
