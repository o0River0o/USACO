inp = open("socdist1.in").read().strip().split("\n")

f = open("socdist1.out", "w")

n = int(inp[0])
cowinds = []
for i in range(n):
  if inp[1][i] == "1":
    cowinds.append(i)

if len(cowinds) == 0:
  f.write(str(n-1))
else:
  d = 1000000000
  gapsingle = [cowinds[0], n-1-cowinds[-1]]
  gapdouble = [cowinds[0]//2, (n-1-cowinds[-1])//2]

  for i in range(len(cowinds)-1):
    gaplength = cowinds[i+1] - cowinds[i]
    d = min(d, gaplength)
    gapsingle.append(gaplength//2)
    gapdouble.append(gaplength//3)

  gapsingle.sort()
  gapdouble.sort()
  f.write(str(min(max(min(gapsingle[-1], gapsingle[-2]), gapdouble[-1]), d)))
f.close()
