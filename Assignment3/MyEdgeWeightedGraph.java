import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

class MyEdgeWeightedGraph {
    private final int V;
    private final int E;
    private Bag <MyEdge> edges;

    public int V() { 
    	return V; 
    }
    
    public int E() { 
    	return E; 
    }

    public Iterable<MyEdge> edges() {
    	return edges; 
    }

    public MyEdgeWeightedGraph(In in) {
        // FOR YOU TO FILL IN
    	
    	edges = new Bag<MyEdge>();
    	V = in.readInt();
    	E = in.readInt();
    	
    	while(in.hasNextLine()) {
    		edges.add(new MyEdge(in.readInt(), in.readInt(), in.readLong()));
    	}
    }
}