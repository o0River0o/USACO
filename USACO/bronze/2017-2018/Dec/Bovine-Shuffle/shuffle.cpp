#include <iostream>
#include <fstream>
#include <math.h>
#include <vector>

using namespace std;
using ll = long long;

ifstream fin("shuffle.in");
ofstream fout("shuffle.out");

int N;
  
int main() {
  fin >> N;
  int A[N];
  int order[N];
  int original_order[N];

  for (int i = 1; i <= N; i++) 
    fin >> A[i];
  for (int i = 1; i <= N; i++) 
    fin >> order[i];
 
  for (int it = 0; it < 3; it++) {    
    for (int i=1; i<=N; i++) original_order[i] = order[A[i]];
    for (int i=1; i<=N; i++) order[i] = original_order[i];
  }
  
  for (int i = 1; i <= N; i++)
    fout << order[i] << endl;

  return 0;
}
