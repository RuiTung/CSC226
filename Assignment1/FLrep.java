class FLrep extends TreeAndRepresentation {

	// VARIABLES, IF ANY NEEDED
	private int rootIndex = -1;
	private int leftRootIndex = -1;
	private int rightRootIndex = -1;
	//private int leftDepth = 0;
	//private int rightDepth = 0;
	private int bounds = 0;
	// given sequence build tree
	FLrep(int m,int[] b) { 
	// YOU FILL IN THE CODE
		super(m, b);
		N = (M-1)/2;
		//t = build();
		
		
	}

	// given tree build sequence
	FLrep(int n,BT t) { 
	// YOU FILL IN THE CODE
		super(n,t);
	}
	public void findRootIndex() {
		for(int i = 0; i < N; i++) {
			if(a[i] == 0) {
				rootIndex = i;
				break;
			}
		}
	}
	
	// ANY ADDITIONAL METHODS GO HERE
	public void findLeftRootIndex () {
		//int leftRootIndex = -1;
		for(int i = 0; i < rootIndex - 1; i ++) {
			if(a[i] == a[rootIndex] + 1) {
				leftRootIndex = i;
				bounds++;
				break;
			}
		}
	}
	
	public void findRightRootIndex() {
		
		for(int i = rootIndex + 1; i < N; i ++) {
			if(a[i] == a[leftRootIndex]) {
				rightRootIndex = i;
				bounds++;
				break;
			}
		}
	}

}
