# algorithm
알고리즘 스터디
####
Collections 정렬 Comparator 사용법

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

#### String.split() 사용 주의

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
