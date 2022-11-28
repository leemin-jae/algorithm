import java.util.*;
class Solution {
    	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	static int N;
	static int[] parents;
	static Edge[] edgeList;
	
	public static void makeSet() {
		parents = new int[N];
		for(int i = 0 ; i < N ; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
		
	}
    public int solution(int n, int[][] costs) {
        N = n;
		edgeList = new Edge[costs.length];
		
		for (int i = 0; i < costs.length; i++) {
			edgeList[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]); 
		}
        
        Arrays.sort(edgeList);
        
        makeSet();
		
		int result = 0 , cnt = 0;
		
		for(Edge edge: edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == N-1) break;
			}
		}

        return result;
    }
}