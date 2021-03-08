public class WeightedQuickUnion{
	
	private int[] ids;
	private int[] size;
	
	
	public WeightedQuickUnion(int N){
		ids = new int[N];
		size = new int[N];
		for(int i=0;i<N;i++){
			ids[i]=i;
			size[i]=i;
		}
	}
	
	public boolean connected(int p,int q){
		return root(p) == root(q);
	}
	
	private int root(int i){
		while(ids[i]!=i){
			i = ids[i];
		}
		return i;
	}
	
	public void union(int p,int q){
		int rootP = root(p);
		int rootQ = root(q);
		
		if(size[rootP] > size[rootQ]){
			ids[rootQ]=rootP;
			size[rootP]+=size[rootQ];
		}else{
			ids[rootP] = rootQ;
			size[rootQ]+= size[rootP];
		}
	}
}