#include <iostream>
#include <fstream>
#include <string>

using namespace std;
using ll = long long;

ifstream fin("cowsignal.in");
ofstream fout("cowsignal.out");

int main() {
  ll m, n, k;
  fin >> m >> n >> k;
  
  for (int i = 0; i < m; i++) {
    string signal;
    fin >> signal;
    for (int it = 0; it < k; it++) {
      for (int j = 0; j < n; j++) {
        for (int x = 0; x < k; x++) {
          fout << signal[j];
        }
      }
      fout << endl;
    }
  }
  

  return 0;
}