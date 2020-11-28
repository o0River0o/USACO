#include <iostream>
#include <fstream>
#include <math.h>

using namespace std;
using ll = long long;

ifstream fin("shell.in");
ofstream fout("shell.out");

ll N, A[100], B[100], G[100];

int num_correct(ll starting_shell) {
  int current_shell = starting_shell, correct = 0;
  for (ll i = 0; i < N; i++) {
    if (A[i] == current_shell) current_shell = B[i];
    else if (B[i] == current_shell) current_shell = A[i];
    if (current_shell == G[i]) correct++;
  }
  return correct;
}

int main() {
  fin >> N;
  for (ll i = 0; i < N; i++)
    fin >> A[i] >> B[i] >> G[i];
  
  int best = 0;
  for (ll i = 1; i <= 3; i++)
    best = max(best, num_correct(i));
  fout << best;
}