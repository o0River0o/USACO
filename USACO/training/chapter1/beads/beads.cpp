/*
ID: gyoushi1
LANG: C++11
TASK: beads
*/
#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

using namespace std;
using ll = long long;

ifstream fin("beads.in");
ofstream fout("beads.out");

int main() {
  ll n, max=0, current, state, j;
  string s;
  char c;
  
  fin >> n >> s;
  s = s+s;
  for (ll i = 0; i < n; i++) {
    c = (char) s[i];
    if(c == 'w')
      state = 0;
    else
      state = 1;
    j = i;
    current = 0;
    while (state <= 2) { 
      while (j<n+i && (s[j] == c || s[j] == 'w')) { 
        current++;
        j++;
      }
      state++;
      c = s[j];
    }
    if (current > max)
      max = current;
  }
    
  fout << max << endl;
}