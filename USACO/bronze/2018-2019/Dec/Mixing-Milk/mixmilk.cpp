#include <iostream>
#include <fstream>

using namespace std;
using ll = long long;

ifstream fin("mixmilk.in");
ofstream fout("mixmilk.out");

void pour(ll &c1, ll &m1, ll &c2, ll &m2) {
  int amt = min(m1, c2 - m2);
  m1 -= amt;
  m2 += amt;
}

int main() {
  //c1 -> c2
  //c2 -> c3
  //c3 -> c1
  //Puor until either one bucket is empty or another one is full
  /*
  10 3
  11 4
  12 5

  1st cycle
  10 0
  11 10
  12 2
  */

  ll c1, c2, c3;
  ll m1, m2, m3;
  fin >> c1 >> m1;
  fin >> c2 >> m2;
  fin >> c3 >> m3;

  //Cycle 99 pour
  for (ll i = 0; i < 33; i++) {
    pour(c1, m1, c2, m2);
    pour(c2, m2, c3, m3);
    pour(c3, m3, c1, m1);
  }
  // Do the 100th Pour
  pour(c1, m1, c2, m2);

  fout << m1 << endl;
  fout << m2 << endl;
  fout << m3 << endl;
}