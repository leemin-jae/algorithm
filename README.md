# algorithm
알고리즘 스터디

## 목차

1. [Floyd Wrshall(플로이드 와셜) 알고리즘](#Floyd-Wrshall(플로이드-와셜)-알고리즘)
2. [다익스트라 알고리즘](#다익스트라-알고리즘)
3. [Collections 정렬 Comparator 사용법](#Collections-정렬-Comparator-사용법)
4. [String.split() 사용 주의](#String.split()-사용-주의)
----------

### Floyd Wrshall(플로이드 와셜) 알고리즘

다익스트라 : 하나의 정점에서 모든 정점으로 가능 최소 경로

플로이드 : 모든 정점에서 모든 정점으로의 최단 경로

```java
int adjMatrix[][] = {
	{0 ,5 ,INF ,8 },
	{7 ,0 , 9 , INF},
	{2, INF, 0 , 4},
	{INF , INF , 3 , 0}
};

for(int k=0; k<N; ++k) {   // k = 거쳐가는 노드 ,  i = 출발 노드, j = 도착 노드
	for(int i=0; i<N; ++i) {
		if(i==k) continue; 

		for(int j=0; j<N; ++j) {
			if(i==j || k==j) continue; 

			if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
				adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
			}
		}
	}
}
/*
출력 결과
0	5	11	8	
7	0	9	13	
2	7	0	4	
5	10	3	0	
*/
```

### 다익스트라 알고리즘

* 음의 가중치(음의 간선, 음의 값)가 없는 그래프의 한 노드에서 각 모든 노드까지의 최단거리를 구하는 알고리즘

* 배열로 구현 : 최악의 경우 모든 노드을 확인해야 하고, 이 것은 V번 반복하기 때문에 O(V^2)의 시간 복잡도
	```java
	int[] distance = new int[V];
	boolean[] visited = new boolean[V];

	Arrays.fill(distance, Integer.MAX_VALUE);
	distance[start] = 0; // 출발 노드 초기화

	for (int i = 0; i < V; i++) {
		
		int min = Integer.MAX_VALUE, current = 0;\

		for (int j = 0; j < V; j++) {						//아직 방문 안한 노드 중에 가장 짧은 거리를 탐색(첫 시작은 출발 노드)			
			if (!visited[j] && min > distance[j]) { 		
				min = distance[j];
				current = j;
			}
		}

		visited[current] = true;

		for (int j = 0; j < V; j++) {
			if (!visited[j] && adjMatrix[current][j] != 0               
					&& distance[j] > distance[current] + adjMatrix[current][j]) {    // 아직 방문 안한 노드 중에 기준 노드랑 연결 되어 있고 
				distance[j] = distance[current] + adjMatrix[current][j];			// 기준노드 + 다음 노드 거리가 노드에 저장된 길이 보다 짧으면 갱신
			}
		}

	}
	```
* 우선 순위 큐 사용
	
	*	다익스트라 알고리즘은 최소 비용을 갖는 노드를 선택하고, 주변 노드의 값을 갱신

	*  비용을 나타내는 배열에서 갱신된 노드를 제외하고는 여전히 INF의 값을 갖기 때문에 굳이 고려해줄 필요가 없음
	
	* 갱신하는 주변 노드의 값에 대해서만 다음 최소 비용을 갖는 노드를 선택해주면 된다

	```java
	class Node implements Comparable<Node> {
		int end; // 다음 노드 인덱스
		int weight; // 가중치
	
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	
	}
	```
	```java
	/*
	*  N = 노드의 개수, M = 간선의 개수
	*/
	static ArrayList<ArrayList<Node>> a = new ArrayList<>();; // 인접리스트.
    static int[] dist =  new int[N + 1]; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] check = new boolean[N + 1]; // 방문 확인.

	Arrays.fill(dist, Integer.MAX_VALUE); 

	for (int i = 0; i <= N; i++) {
        a.add(new ArrayList<>());
	}

	for (int i = 0; i < M; i++) {
		// start에서 end로 가는 weight (가중치)
		a.get(start).add(new Node(end, weight));
	}

	//다익스트라 start == 시작 노드 , end == 도착 노드
	PriorityQueue<Node> pq = new PriorityQueue<>();
	pq.offer(new Node(start, 0));
	dist[start] = 0;

	while (!pq.isEmpty()) {
		Node curNode = pq.poll();
		int cur = curNode.end;

		if (!check[cur]) {  // 아직 방문한 곳이 아니면 방문처리
			check[cur] = true;

			for (Node node : a.get(cur)) {  // 현재 노드의 인접 노드 체크
				if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					pq.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}
	return dist[end];


	```







### Collections 정렬 Comparator 사용법

```java
List<int []> list = new ArrayList<>();
list.add(new int[] {4,1});
list.add(new int[] {3,2});
list.add(new int[] {2,3});
list.add(new int[] {3,6});
list.add(new int[] {2,7});
list.add(new int[] {1,8});

list.sort(new Comparator<int []>() {
	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		if(o1[0] == o2[0]) {
			return o1[1] - o2[1];
		}else {
			return o1[0] - o2[0];
		}
	}
});
```
* 내림차순 정렬
```
Integer[] arr = {1, 26, 17, 25, 99, 44, 303};

Arrays.sort(arr, Collections.reverseOrder());
```

### String.split() 사용 주의

```java
String line = br.readLine();
String number[] = line.split("+");
```
>   Dangling meta character '+' near index 0 오류 발생

?, *, +, [, {, (, }, ^, $ 와 같은 경우 split 사용시 \\을 붙혀 사용해야 함

```java
String line = br.readLine();
String number[] = line.split("\\+");
```
