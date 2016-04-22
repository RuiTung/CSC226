import edu.princeton.cs.algs4.MinPQ;

class MyEdge implements Comparable<MyEdge>{
   private final int v; // NOTE: ensure v < w.
   private final int w;
   private long weight;
   MinPQ<MyEdge> pq = new MinPQ<MyEdge>();

   public int minv() { 
	   return v; 
   }
   public int maxv() { 
	   return w; 
	}
   public long weight() { 
	   return weight; 
   }
   public void changeWeight(long weight) { 
	   this.weight = weight; 
   }
   
   MyEdge ( int v, int w, long weight ) {
      this.v = v < w ? v : w;
      this.w = v < w ? w : v;
      this.weight = weight;
   }

   public String toString() {
      return String.format("%d-%d %d", v, w, weight);
   }
   
   /*
    * It returns 0 if the two edges are equal
    * returns –1 if the current edge is less than the one passed in
		returns +1 if the current edge is greater than the one passed in.
    */
   public int compareTo(MyEdge that) {
      // FOR YOU TO FILL IN
	   int compare = 0;
	   if(this.weight == that.weight) {
		   if(this.v < that.v) {
			   compare = -1;
		   } else if (this.v > that.v) {
			   compare = 1;
		   } else if(this.w < that.w) {
			   compare = -1;
		   } else if(this.w > that.w) {
			   compare = 1;
		   }   
	   } else if(this.weight < that.weight) {
		   compare = -1;
	   } else {
		   compare = 1;
	   }
	   return compare;
   }

}