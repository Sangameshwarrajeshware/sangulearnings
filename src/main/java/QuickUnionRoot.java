public class QuickUnionRoot{
	
	private int[] ids;
	
	public QuickUnionRoot(int N){
		ids = new int[N];
		for(int i=0;i<N;i++){
			ids[i]=i;
		}
	}
	
	private int root(int i){
		while(i!=ids[i]){
			i=ids[i];
		}
		return i;
	}
	
	public boolean connected(int p ,int q){
		return root(p) == root(q);
	}
	
	public void union(int p,int q){
		int rootP = root(p);
		int rootQ = root(q);
		ids[rootP] = rootQ;
	}

	public static void main(String... args){
		QuickUnionRoot quickUnionRoot = new QuickUnionRoot(10);
		quickUnionRoot.union(1,5);
		quickUnionRoot.union(1,6);
		quickUnionRoot.connected(5,6);
		System.out.println("Expected true  and value is: "+ quickUnionRoot.connected(5,6));
	}
}