import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

# start: 시작 노드
# visited: 인덱스 번호와 일치하는 노드를 방문했는지 여부
def dfs(graph, start, visited):
    visited[start] = visited[0]
    visited[0] += 1
    for node in graph[start]:
        if not visited[node]:
            dfs(graph, node, visited)

n, m, r = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)
visited[0] = 1  # 순서 count

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(len(graph)):
    graph[i].sort()

# print(graph)
dfs(graph, r, visited)
for i in range(1, len(visited)):
    print(visited[i])