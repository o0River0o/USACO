#include <iostream>
#include <fstream>
#include <math.h>

using namespace std;
using ll = long long;

ifstream fin("paint.in");
ofstream fout("paint.out");

int a, b, c, d, fj_dist, bs_dist;
  
int main() {
  fin >> a >> b >> c >> d;

  int ans = 0;
  ans += b-a;
  ans += d-c;
  ans -= max(min(b,d)-max(a, c), 0);

  fout << ans << endl;


  // cout << fj_dist << ":" << bs_dist << endl;
}