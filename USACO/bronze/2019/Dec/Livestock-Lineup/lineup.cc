#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;
 
vector<string> cows, beside_a, beside_b;
ll N;
ifstream fin ("lineup.in");
ofstream fout ("lineup.out");
 
int where(string c)
{
  for (ll i=0; i<8; i++)
    if (cows[i]==c) return i;
  return -1;
}
 
bool satisfies_constraints(void)
{
  for (ll i=0; i<N; i++)
    if (abs(where(beside_a[i]) - where(beside_b[i])) != 1) return false;
  return true;
}
 
int main()
{
  fin >> N;
  cows.push_back("Beatrice");
  cows.push_back("Belinda");
  cows.push_back("Bella");
  cows.push_back("Bessie");
  cows.push_back("Betsy");
  cows.push_back("Blue");
  cows.push_back("Buttercup");
  cows.push_back("Sue");
  string a, b, t;
  for (ll i=0; i<N; i++) {
    fin >> a;
    fin >> t; // must
    fin >> t; // be
    fin >> t; // milked
    fin >> t; // beside
    fin >> b;
    beside_a.push_back(a);
    beside_b.push_back(b);
  }
  do {
    if (satisfies_constraints()) {
      for (ll i=0; i<8; i++) fout << cows[i] << "\n";
      break;
    }
  } while (next_permutation(cows.begin(), cows.end()));
  return 0;
}