import heapq

N = int(input())
deck = []
for _ in range(N):
    deck.append(int(input()))

result = 0
# 가장 적은 묶음부터 합치기
heapq.heapify(deck)
while len(deck) > 1:
    deck1 = heapq.heappop(deck)
    deck2 = heapq.heappop(deck)
    merged = deck1 + deck2

    result += merged
    heapq.heappush(deck, merged)

print(result)