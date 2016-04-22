

class MinMax {
//	static boolean firstTimeMmA = true;
//	static int comparisonA = 0;
//	static Pair comparedMmA;
//	static Pair latestCompared;
	
//	static boolean firstTimeMmB = true;
//	static Pair comparedMmB;
//	static Pair compared1;
//	static Pair compared2;
//	static Pair leftCompared;
//	static int left;
//	static int right;
//	static int comparisonB = 0;
	
	public static Pair mmA( int lb, int ub, int[] a ) {
		Pair result = new Pair(0,0);
		Pair leftMmA = new Pair(0,0);
		Pair rightMmA = new Pair(0,0);
		if(lb == ub) {
			result.alpha = a[lb];
			//System.out.println("a[lb] 111 is " + a[lb]);
			//System.out.println("result.alpha 111 is " + result.alpha);
			
			result.omega = a[lb];
			//System.out.println("a[lb] 111 is " + a[lb]);
			//System.out.println("result.omega 111 is " + result.omega);
			
			return result;
		}
		
		if(ub - 1 == lb) {
			if(a[lb] <= a[ub]) {
				result.omega = a[ub];
				//System.out.println("a[ub] 333 is " + a[ub]);
				//System.out.println("result.omega 333 is " + result.omega);
				result.alpha = a[lb];
				//System.out.println("a[lb] 444 is " + a[lb]);
				//System.out.println("result.alpha 444 is " + result.alpha);
				
			} else {
				result.omega = a[lb];
				//System.out.println("a[lb] 222 is " + a[lb]);
				//System.out.println("result.omega 222 is " + result.omega);
				result.alpha = a[ub];
				//System.out.println("a[ub] 222 is " + a[lb]);
				//System.out.println("result.alpha 222 is " + result.alpha);
			}
			return result;
		}
		int mid = (int) Math.round((lb + ub) / 2.0);
		leftMmA = mmA(lb, mid - 1, a);
		rightMmA = mmA(mid, ub, a);
		//System.out.println("last left.alpha is " + left.alpha);
		//System.out.println("last right.alpha is " + right.alpha);
		if(leftMmA.alpha >= rightMmA.alpha) {
			result.alpha = rightMmA.alpha;
			//System.out.println("last result.alpha is right.alpha" + result.alpha);
		} else {
			result.alpha = leftMmA.alpha;
			//System.out.println("last result.alpha is left.alpha " + result.alpha);
		}
		
		//System.out.println("last last left.omega is " + left.omega);
		//System.out.println("last last reft.omega is " + right.omega);
		if(leftMmA.omega <= rightMmA.omega) {
			result.omega = rightMmA.omega;
			//System.out.println("last last result.alpha is right.omega " + result.omega);
			
		} else {
			result.omega = leftMmA.omega;
			//System.out.println("last last result.alpha is left.omega " + result.omega);
		}
		
		//System.out.println("\nreturn result alpha is " + result.alpha + ", 	omega is " + result.omega +"\n");
		return result;
		
		
		
//		if(firstTimeMmA == true) {
//			comparedMmA = new Pair(a[lb], a[lb]);
//			firstTimeMmA = false;
//		}
//		
//		if(lb == ub) {
//			if(a[lb] < comparedMmA.alpha) {
//				comparisonA++;
//				comparedMmA.alpha = a[lb];
//			} else {
//				comparisonA++;
//			}
//			
//			if (a[lb] > comparedMmA.omega) {
//				comparisonA++;
//				comparedMmA.omega = a[lb];	
//			} else {
//				comparisonA++;
//			}
//			return comparedMmA;
//		}
//		
//		System.out.println("A is " + comparisonA);
//		comparedMmA = mmA(lb, (ub + lb)/2 , a);
//		return mmA((ub + lb)/2 + 1, ub, a);
	}

	public static Pair mmB( int lb, int ub, int[] a ) {
		//System.out.println("beginning B is " + comparisonB);
//		if(firstTimeMmB == true) {
//			compared1 = new Pair(a[lb], a[lb]);
//			compared2 = new Pair(a[lb], a[lb]);
//			comparedMmB = new Pair(a[lb], a[lb]);
//			leftCompared = new Pair(a[lb], a[lb]);
//			firstTimeMmB = false;
//			left = 0;
//			comparisonB = 0;
//			
//			right = (int)Math.round(3 / 2.0 * (ub - lb + 1)  - 4);
//			if((ub - lb + 1) % 4 == 2) {
//				left = (int) Math.round(3 / 2.0 * ((ub - lb + 1) / 2.0 + 1) - 2);
//			} else {
//				left =(int) Math.round(3 / 2.0 * ((ub - lb + 1)  / 2.0) - 2);
//			}
//			//System.out.println(left);
//			//System.out.println(right);
//			firstTimeMmB = false;
//		}
		Pair lbUb = new Pair(a[lb], a[lb]);
		Pair leftMmB = new Pair(a[lb], a[lb]);
		Pair rightMmB = new Pair(a[lb], a[lb]);
		
		if((ub - lb) == 0) {
			//return new Pair(a[lb], a[lb]);
			lbUb.alpha = a[lb];
			lbUb.omega = a[lb];
			return lbUb;
		} 
		
		if((ub - lb) == 1) {
			//System.out.println("==1 a[ub] " + a[ub] + " a[lb] " + a[lb]);
			//comparisonB++;
			if(a[lb] < a[ub]) {
				//comparisonB++;
				//return new Pair(a[lb],a[ub]);
				lbUb.alpha = a[lb];
				lbUb.omega = a[ub];
				return lbUb;
			} else {
				//comparisonB++;
				//return  new Pair(a[ub], a[lb]);
				lbUb.alpha = a[ub];
				lbUb.omega = a[lb];
				return lbUb;
			}
		}
		
		if((ub - lb > 1)) {
			if((ub - lb + 1) % 4 == 2) {
				leftMmB = mmB(lb, (ub + lb) / 2 + 1, a);
				rightMmB = mmB((lb + ub) / 2 + 2, ub, a);	
			} else {	
					leftMmB = mmB(lb, (ub + lb) / 2, a);
					rightMmB= mmB((lb + ub) / 2 + 1, ub, a);	
			}
		}
		
		if(leftMmB.alpha > rightMmB.alpha) {
			lbUb.alpha = rightMmB.alpha;
		} else {
			lbUb.alpha = leftMmB.alpha;
		}
		
		if(leftMmB.omega > rightMmB.alpha) {
			lbUb.omega = leftMmB.omega;
		} else {
			lbUb.omega = rightMmB.omega;
		}
		
		return lbUb;
//		if(right != comparisonB) {
//			if(compared1.alpha >= compared2.alpha) {
//				comparedMmB.alpha = compared2.alpha;
//				comparisonB++;
//			} else {
//				comparedMmB.alpha = compared1.alpha;
//				comparisonB++;
//			}
//			
//			if(compared1.omega <= compared2.omega) {
//				comparedMmB.omega = compared2.omega;
//				comparisonB++;
//			} else {
//				comparedMmB.omega = compared1.omega;
//				comparisonB++;
//			}
//		} else {
//			if(leftCompared.alpha >= compared2.alpha) {
//				comparedMmB.alpha = compared2.alpha;
//				comparisonB++;
//			} else {
//				comparedMmB.alpha = leftCompared.alpha;
//				comparisonB++;
//			}
//			
//			if(leftCompared.omega <= compared2.omega) {
//				comparedMmB.omega = compared2.omega;
//				comparisonB++;
//			} else {
//				comparedMmB.omega = leftCompared.omega;
//				comparisonB++;
//			}
//		}
//		
//		if(left == comparisonB) {
//			leftCompared.alpha = comparedMmB.alpha;
//			leftCompared.omega = comparedMmB.omega;
//		}
//		return comparedMmB;
		
//		if(compared1.omega <= compared2.omega) {
//			//System.out.println("82 " + compared1.omega + " compared2.omega " + compared2.omega);
//			//comparisonB++;
//			comparedMmB.omega = compared2.omega;
//		} else {
//			//System.out.println("86 " + compared1.omega + " compared2.omega " + compared2.omega);
//			//comparisonB++;
//			comparedMmB.omega = compared1.omega;
//		}
//		
//		if(compared1.alpha <= compared2.alpha) {
//			//System.out.println("92 " + compared1.alpha + " compared2.alpha " + compared2.alpha);
//			//comparisonB++;
//			comparedMmB.alpha = compared1.alpha;
//		} else {
//			//System.out.println("96 " + compared1.alpha + " compared2.alpha " + compared2.alpha);
//			//comparisonB++;
//			comparedMmB.alpha = compared2.alpha;
//		}
//		
//		if(latestCompared.alpha > comparedMmB.alpha) {
//			//System.out.println("102 " + latestCompared.alpha + " comparedMmB.alpha " + comparedMmB.alpha);
//			comparisonB++;
//			latestCompared.alpha = comparedMmB.alpha;
//		} else {
//			//System.out.println("106 " + latestCompared.alpha + " comparedMmB.alpha " + comparedMmB.alpha);
//			comparisonB++;
//			int specialCase = 0;
//		}
//		
//		if(latestCompared.omega < comparedMmB.omega) {
//			//System.out.println("112 " + latestCompared.omega + " comparedMmB.omega  " + comparedMmB.omega);
//			comparisonB++;
//			latestCompared.omega = comparedMmB.omega;
//		} else {
//			//System.out.println("116 " + latestCompared.omega + " comparedMmB.omega  " + comparedMmB.omega);
//			comparisonB++;
//			int specialCase = 0;
//		}
//		//System.out.println("B is " + comparisonB);
		
	}
}