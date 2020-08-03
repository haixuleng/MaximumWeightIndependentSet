package assignment;

import java.util.ArrayList;

public class Dynamic {
	ArrayList<Integer> vertices;
	ArrayList<Integer> mwis; // it stores the value of mwis at each step
	ArrayList<Boolean> s; // it stores whether the ith element is in the mwis
	public Dynamic(ArrayList<Integer> inputVertices) {
		this.vertices = inputVertices;
		run();
		reconstruct();
	}
	
	public void run() {
		// this method performs the dynamic programming algorithm
		this.mwis = new ArrayList<Integer>(this.vertices.size() + 1);
		this.mwis.add(0);
		this.mwis.add(this.vertices.get(1));
		for(int index = 2; index < this.vertices.size(); index ++) {
			this.mwis.add(Math.max(this.mwis.get(index - 1), this.mwis.get(index - 2) + this.vertices.get(index - 1)));
		}
	}
	
	public void reconstruct() {
		this.s = new ArrayList<Boolean>();
		for(int index = 1; index <= this.mwis.size(); index ++) {
			this.s.add(false); // initialization
		}
		
		int index = this.mwis.size();
		while(index >= 2) {
			if(this.mwis.get(index - 1) >= this.mwis.get(index - 2) + this.vertices.get(index - 1)) {
				// first case, V_index is not in the mwis
				index = index - 1;
			}
			else {
				// second case, V_index is in the mwis, V_index -1 must be not in mwis
				this.s.set(index, true);
				index = index - 2;
			}
		}
		if(!this.s.get(2)) {
			this.s.set(1, true); // The previous loop does not cover ths first element
		}
	}
	
	public boolean check(int index) {
		// check whether specific index is in the mwis 
		return this.s.get(index);
	}
}
