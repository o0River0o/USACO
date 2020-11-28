r = []
b = []
with open("speeding.in", "r") as f:
    n, m = map(int, f.readline().strip().split())
    for _ in range(n):
        length, lim = map(int, f.readline().strip().split()) # length, limit
        r += [lim]*length
    for _ in range(m):
        length, lim = map(int, f.readline().strip().split()) # length, speed
        b += [lim]*length

ans = 0
for i in range(100):
    if r[i] < b[i]:
        ans = max(b[i]-r[i], ans)

with open("speeding.out", "w") as f:
    f.write(str(ans)+"\n")