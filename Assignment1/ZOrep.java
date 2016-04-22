/**
 * 	For Assignment of CSC226
 * @author Rui Ma V00800795
 *
 */

class ZOrep extends TreeAndRepresentation {

	private int k;
	String tree;
	
	// given sequence build tree
	ZOrep(int m, int[] b) { 
		super(m, b);
		N = (M-1)/2;
		k = -1;
		t = build();
		
	}
	
	// given tree build sequence
	ZOrep(int n, BT t) { 
	// YOU SHOULD ADD SOME CODE HERE (including a call to super).
		super(n,t);
		//int[] a = new int[n * 2 + 1];
		int[] treeArray = new int[n * 2 + 1];
		if(t != null) {
			tree = "1";
			traverse(t);
		}
		//System.out.println(a.length);
		int i = 0;
		while( i < n * 2) {
			treeArray[i] = (int)tree.charAt(i) - 48;
			//a[i] = (int)tree.charAt(i) - 48;
			i++;
		}
		this.a = treeArray;

	}

	BT build() { 
		
		return(a[++k] == 0 ? null : new BT(build(), build())); 
	}

	void traverse( BT t ) {
	// FOR YOU TO FILL IN
		if(t.L != null) {
			tree += "1";
			traverse(t.L);
		} else {	
			tree += "0";
		}

		if(t.R != null) {		
			tree += "1";
			traverse(t.R);
		} else {	
			tree += "0";
		}
	}
}
