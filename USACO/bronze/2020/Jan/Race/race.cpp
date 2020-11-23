#include <iostream>
#include <fstream>

using namespace std;
using ll = long long;

ifstream fin("race.in");
ofstream fout("race.out");
int K, N;
int current_speed, current_distancee;

int check(ll dist) {
  ll minSpeed;
  fin >> minSpeed;

  ll ltDist = 0, 
    rtDist = 0, 
    time = 0;
    
  for (ll currentSpeed = 1; ; currentSpeed++) {
    ltDist += currentSpeed;
    time++;
    if (ltDist + rtDist >= dist)
      return time;

    if (currentSpeed >= minSpeed) {
      rtDist += currentSpeed;
      time++;
      if (ltDist + rtDist >= dist)
        return time;
    }
  }
}

int main() {
  fin >> K >> N;
  for (ll i = 0; i < N; i++) {
    fout << check(K) << "\n";
  }
}