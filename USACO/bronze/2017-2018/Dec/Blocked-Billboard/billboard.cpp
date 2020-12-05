#include <iostream>
#include <fstream>
#include <math.h>

using namespace std;
using ll = long long;

ifstream fin("billboard.in");
ofstream fout("billboard.out");

struct Rectangle {
  ll x1, x2, y1, y2;
  int area() { return (y2-y1) * (x2-x1); }
};

int intersect(Rectangle p, Rectangle q)
{
  int xOverlap = max((ll)0, min(p.x2, q.x2) - max(p.x1, q.x1));
  int yOverlap = max((ll)0, min(p.y2, q.y2) - max(p.y1, q.y1));
  return xOverlap * yOverlap;
}

int main() {
  Rectangle a, b, truck;
  fin >> a.x1 >> a.y1 >> a.x2 >> a.y2;
  fin >> b.x1 >> b.y1 >> b.x2 >> b.y2;
  fin >> truck.x1 >> truck.y1 >> truck.x2 >> truck.y2;
  fout << a.area() + b.area() - intersect(a, truck) - intersect(b, truck) << endl;
}