import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

class MyKruskal {

   private long weight;                              // weight of MST
   private Queue <MyEdge> mst = new Queue <MyEdge>();  // edges in MST
   private static long totalWeightInclude = 0;
   private static long totalWeightExclude = 0;

   public long weight() { 
	   return weight; 
	}

   public Iterable <MyEdge> edges() { 
	   return mst;
   }

   public MyKruskal ( MyEdgeWeightedGraph G ) {
      // FOR YOU TO FILL IN
	   MinPQ<MyEdge> pq = new MinPQ<MyEdge>();
	   UF uf = new UF(G.V());

       for (MyEdge edge : G.edges()) {
           pq.insert(edge);
       }

       // run greedy algorithm
       while (!pq.isEmpty() && mst.size() < G.V() - 1) {
    	   MyEdge edge = pq.delMin();

           if (!uf.connected(edge.minv(), edge.maxv())) { // v-w does not create a cycle
               uf.union(edge.minv(), edge.maxv());  // merge v and w components
               mst.enqueue(edge);  // add edge e to mst
               weight += edge.weight();
           }
       }
       
    // check that it is acyclic
       for (MyEdge edge : edges()) {
           if (!uf.connected(edge.minv(), edge.maxv())) {
               weight = -99;
               break;
           }
           uf.union(edge.minv(), edge.maxv());
       }
       
       if(uf.count() > 1) {
		   weight = -99;
		   return;
	   }
	   
   }

   public static long include (MyEdgeWeightedGraph G ) {
	   
	   MinPQ<MyEdge> pq = new MinPQ<MyEdge>();
	   
	   // build MST according to union find
       for (MyEdge edge : G.edges()) {
    	   Queue<MyEdge> queue = new Queue<MyEdge>();
    	   UF uf = new UF(G.V());
    	   uf.union(edge.minv(), edge.maxv());
    	   queue.enqueue(edge);
    	   totalWeightInclude += edge.weight();
    	   
    	   // store edge into MinPQ
    	   for (MyEdge edge1 : G.edges()) {
    		   pq.insert(edge1);
    	   }
    	   
    	   // run greedy algorithm
    	   while (!pq.isEmpty() && queue.size() < G.V() - 1) {
    		   MyEdge edge1 = pq.delMin();
    		   
               if (!uf.connected(edge1.minv(), edge1.maxv())) { // v-w does not create a cycle
                   uf.union(edge1.minv(), edge1.maxv());  // merge v and w components
                   queue.enqueue(edge1);  // add edge e to mst
                   totalWeightInclude += edge1.weight();
               }
           }
    	   if(uf.count() > 1) {
    		   return -99;
    	   }
       } 
       
	   return totalWeightInclude;
   }
   
   public static long exclude (MyEdgeWeightedGraph G ) {
	   
	   MinPQ<MyEdge> pq = new MinPQ<MyEdge>();  
	   
	   for (MyEdge edge : G.edges()) {
    	   Queue<MyEdge> queue = new Queue<MyEdge>();
    	   UF uf = new UF(G.V());
    	   
    	   for (MyEdge edge1 : G.edges()) {
    		   pq.insert(edge1);
    	   }  
    	   
    	   while (!pq.isEmpty() && queue.size() < G.V() - 1) {
    	    	MyEdge edge1 = pq.delMin();
    	    	if(edge != edge1) {
	    	         if (!uf.connected(edge1.minv(), edge1.maxv())) { // v-w does not create a cycle
	    	             uf.union(edge1.minv(), edge1.maxv());  // merge v and w components
	    	              queue.enqueue(edge1);  // add edge e to mst
	    	              totalWeightExclude += edge1.weight();
	    	           }
    	    	 }
    	   }
    	   
    	   for(MyEdge edge1: G.edges()) {
    		   if(!uf.connected(edge1.minv(), edge1.maxv())) {
    			   return -99;
    			   //totalWeightExclude = -99;
    		   }
    	   }
    	   
    	   if(uf.count() > 1) {
    		   return -99;
    	   }
	   }
	
	   return totalWeightExclude;
   }
}