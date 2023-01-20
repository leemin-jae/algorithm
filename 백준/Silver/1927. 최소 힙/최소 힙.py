from queue import PriorityQueue
import sys

que = PriorityQueue()

input = sys.stdin.readline

for i in range(int(input())):
    n = int(input())
    if n == 0:
        if que.qsize() == 0:
            print(0)
        else:
            print(que.get())
    else:
        que.put(n)