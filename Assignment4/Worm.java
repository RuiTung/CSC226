import edu.princeton.cs.algs4.AdjMatrixEdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.FloydWarshall;
import edu.princeton.cs.algs4.In;

public class Worm {
// PUT YOUR CLASS VARIABLE HERE
	
	int planetNum;
	String[] planetName;
	int[][] planetCords;
	int wormHole;
	FloydWarshall FW;
	AdjMatrixEdgeWeightedDigraph AMEW;
	int[][] edges;
	
	public Worm( In in ) {
	// Create a new problem instance.
		planetNum = in.readInt();
		planetName = new String[planetNum];
		planetCords = new int[planetNum][3];
		
		int i = 0;
		while(i < planetNum) {
			planetName[i] = in.readString();
			//System.out.println(planetName[i]);
			int j = 0;
			while(j < 3) {
				planetCords[i][j] = in.readInt();
				//System.out.println(planetCords[i][j]);
				j++;
			}
			i++;
		}
		
		AMEW = new AdjMatrixEdgeWeightedDigraph(planetNum);	
		//System.out.println("distance over");
		wormHole = in.readInt();
		 edges = new int[wormHole][2];
		int z = 0;
		while(z < wormHole) {
			int k = 0;
			String place1 = in.readString();
			String place2 = in.readString();
			while(k < planetNum) {
				if(planetName[k].equals(place1)) {
					//System.out.println(planetName[k]);
					//v = planetName[k];
					int l = 0;
					while(l < planetNum) {
						//w = planetName[l];
						if(planetName[l].equals(place2)) {
							//System.out.println(planetName[l]);
							DirectedEdge dE = new DirectedEdge(k,l,0.00);
							AMEW.addEdge(dE);	
							edges[z][0] = k;
							edges[z][1] = l;
						}
						l++;
					}
				}
				k++;
			}
			z++;
		}
		
		double distance = 0.0;
		int m = 0;
		while(m < planetNum) {
			int n = 0;
			while(n < planetNum) {
					if(m != n) {
						distance = dist(planetName[m], planetName[n]);
						//System.out.println(distance);
						DirectedEdge dE = new DirectedEdge(m,n,distance);
						AMEW.addEdge(dE);
					}
					n++;
			}
			m++;
		}
		//System.out.println(AMEW.toString());
		FW= new FloydWarshall(AMEW);
	}

	public double dist( String origP, String destP ) {
	// return the distance from origP to destP
		double distance = 0.0;
		int i = 0;
		while(i < planetNum) {
			if(origP.equals(planetName[i])) {
				int j = 0;
				while(j < planetNum) {
					if(destP.equals(planetName[j]) && i != j) {
						int k = 0;
						while(k < 3) {
							distance += Math.pow((planetCords[i][k] - planetCords[j][k]), 2);
							k++;
						}
					}
					j++;
				}
			}
		i++;	
		}
		
		return (Math.sqrt(distance));
	}
	
	public int worms( String origP, String destP ) {
	// least number of wormholes in any shortest path from origP to destP
		int worms = 0;

		int OP = 0;
		int DP = 0;
		
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < planetNum; i++) {
			if(planetName[i].equals(origP)) {
				OP = i;
			}
			for(int j = 0; j < planetNum; j++) {
				if(planetName[j].equals(destP)) {
					DP = j;
				}
			}
		}
		
		for(int m = 0; m < wormHole; m ++) {
			for(DirectedEdge DE :  FW.path(OP, DP)){
				start = DE.from();
				end = DE.to();
				if(edges[m][0] == DE.from()) {
					if(edges[m][1] == DE.to()) {
						worms++;
					}
				}
			}
	}
		return worms;
	}
	
	public String query( String origP, String destP ) {
	// Output the "The distance from ... wormholes." string.
		int p1 = 0;
		int p2 = 0;
		
		int i = 0;
		while(i < planetNum) {
				if(planetName[i].equals(origP)) {
					p1 = i;
					
					int j = 0;
					while(j < planetNum) {
						if(planetName[j].equals(destP)) {
							p2 = j;
						}
						j++;
					}
				}
				i++;
		}
		return ("The distance from " + origP + " to " + destP+ " is " + (int)FW.dist (p1,p2)+ " parsecs using " + worms(origP,destP) + " wormholes.");
	}
}