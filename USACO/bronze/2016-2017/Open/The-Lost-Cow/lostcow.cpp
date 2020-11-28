#include <iostream>
#include <fstream>
#include <math.h>

using namespace std;
using ll = long long;

ifstream fin("lostcow.in");
ofstream fout("lostcow.out");

ll x, y;

int main() {
  fin >> x >> y;
  fout << abs(x + y) << endl;
}