# algorithm
알고리즘 스터디


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
