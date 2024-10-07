import queue

cards = queue.Queue()

n = int(input())
for i in range(1, n+1):
    cards.put(i)

while cards.qsize() > 1:
    cards.get()
    temp = cards.get()
    cards.put(temp)

print(cards.get())