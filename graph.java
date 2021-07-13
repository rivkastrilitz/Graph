
package ex0;
import java.util.Collection;

/**
 * This interface represents an undirectional unweighted graph.
 * It should support a large number of nodes (over 10^6, with average degree of 10).
 * The implementation should be based on an efficient compact representation 
 * (should NOT be based on a n*n matrix).
 *
 */

public interface graph {
    /**
     * return the node_data by the node_id,
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
    node_data getNode(int key);
    /**
     * return true iff (if and only if) there is an edge between node1 and node2
     * Note: this method should run in O(1) time.
     * @param node1
     * @param node2
     * @return
     */
    boolean hasEdge(int node1, int node2);
    /**
     * add a new node to the graph with the given node_data.
     * Note: this method should run in O(1) time.
     * @param n
     */
    void addNode(node_data n);
    /**
     * Connect an edge with weight w between node src to node dest.
     * Connect an edge between node1 and node2.
     * Note: this method should run in O(1) time.
     * Note2: if the edge node1-node2 already exists - the the method simply does nothing.
     * Note2: if the edge node1-node2 already exists - the method simply does nothing.
     */
    void connect(int node1, int node2);
    /**
     * This method return a pointer (shallow copy) for the
     * collection representing all the nodes in the graph.
     * Note: this method should run in O(1) time.
     * @return Collection<node_data>
     */
    Collection<node_data> getV();
    /**
     * This method return a collection of  the
     * collection representing all the nodes connected to node_id
     * Note: this method should run in O(1) time.
     * @return Collection<node_data>
     */
    Collection<node_data> getV(int node_id);
    /**
     * Delete the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     * This method should run in O(n), |V|=n, as all the edges should be removed.
     * @return the data of the removed node (null if none).
     * @param key
     */
    node_data removeNode(int key);
    /**
     * Delete the edge from the graph,
     * Note: this method should run in O(1) time.
     * @param node1
     * @param node2
     */
    void removeEdge(int node1, int node2);
    /** return the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     * @return
     */
    int nodeSize();
    /**
     * return the number of edges (undirectional graph).
     * Note: this method should run in O(1) time.
     * @return
     */
    int edgeSize();
    /**
     * return the Mode Count - for testing changes in the graph.
     * Any change in the inner state of the graph should cause an increment in the ModeCount
     * @return
     */
    int getMC();
}