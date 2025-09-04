num = int(input())
connection = int(input())
graph = {}

for i in range(num):
    graph[i+1] = []

for _ in range(connection):
    a, b = map(int, input().split())
    
    if a not in graph[b]:
        graph[b].append(a)
    if b not in graph[a]:
        graph[a].append(b)

visited = []
# 인접한 노드 중 방문하지 않은 노드가 있는 경우 재귀적으로 호출
def dfs(graph, current_node, visited):
    visited.append(current_node)
    adjacent_nodes = graph[current_node]
    for adjacent_node in adjacent_nodes:
        if adjacent_node not in visited:
            dfs(graph,adjacent_node, visited)

    return

dfs(graph, 1, visited)
print(len(visited) - 1)