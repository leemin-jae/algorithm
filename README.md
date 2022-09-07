# algorithm
알고리즘 스터디

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





### Collections 정렬 Comparator 사용법

```
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
