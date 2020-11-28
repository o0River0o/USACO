#include <iostream>
#include <fstream>
#include <vector>

using namespace std;
using ll = long long;

ifstream fin("photo.in");
ofstream fout("photo.out");
int N;

int main() {
  fin >> N;
  vector<ll> B(N-1, -1);
  for (ll i = 0; i < N-1; i++) {
    fin >> B[i];
    B[i] -= 2;
  }

  for (ll a0 = 0; a0 < N; a0++) {
    bool bad = false;
    vector<ll> A(N, 0);
    vector<int> S(N, false);
    S[a0] = true;
    A[0] = a0;

    ll prev = a0;
    for (ll i = 1; i < N; i++) {
      ll ai = B[i-1] - prev;
      if (!(0 <= ai && ai < N)) {
        bad = true;
        break;
      }
      if(S[ai]) {
        bad = true;
        break;
      }
      S[ai] = true;
      A[i] = ai;
      prev = ai;
    }
    if (bad) continue;
    for (ll i = 0; i < N; i++) {
      fout << A[i]+1;
      if (i+1 < N)
        fout << " ";
      else
        fout << endl;
    }
  }
}