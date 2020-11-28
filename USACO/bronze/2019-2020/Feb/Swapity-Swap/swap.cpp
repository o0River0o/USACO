#include <iostream>
#include <fstream>

using namespace std;
using ll = long long;

ifstream fin("swap.in");
ofstream fout("swap.out");

int N, K, A1, A2, B1, B2, res[101];

int nex(int x)
{
  if (A1 <= x && x <= A2)
    x = A1 + A2 - x;
  if (B1 <= x && x <= B2)
    x = B1 + B2 - x;
  return x;
}

int main()
{
  fin >> N >> K >> A1 >> A2 >> B1 >> B2;

  for (ll i = 1; i <= N; ++i)
  {
    ll p = 1, cur = nex(i);
    while (cur != i)
    {
      p++;
      cur = nex(cur);
    }
    ll k = K % p;
    for (ll j = 0; j < k; ++j)
      cur = nex(cur);
    res[cur] = i; // position of cow i after k steps is cur
  }

  for (ll i = 1; i < N + 1; i++)
    fout << res[i] << "\n";
}