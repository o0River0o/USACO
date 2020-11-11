#include <iostream>
#include <fstream>
#include <string>
#include <cstring>

using namespace std;
using ll = long long;

ifstream fin("breedflip.in");
ofstream fout("breedflip.out");

int main()
{
  ll n;
  fin >> n;

  char a[n], b[n];
  string A, B;
  fin >> A >> B;

  bool mismatch = false;
  ll res = 0;
  for (ll i = 0; i < n; i++)
  {
    if (A[i] != B[i])
    {
      if (!mismatch)
      {
        res++;
        mismatch = true;
      }
    }
    else
    {
      mismatch = false;
    }
  }

  fout << res;
}