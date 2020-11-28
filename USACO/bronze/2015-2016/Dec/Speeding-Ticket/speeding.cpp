#include <iostream>
#include <fstream>
#include <math.h>

using namespace std;
using ll = long long;

ifstream fin("speeding.in");
ofstream fout("speeding.out");

int main() {
  ll N, M;
  fin >> N >> M;

  /*
  * ans: long long | final answer
  * ptr: long long | pointer
  * road_segements: pair<ll, ll>[] | set of record of each segement's length and limit
  * bessie_journey: pair<ll, ll>[] | set of record of Bessie's each segment's length and limit
  */
  ll ans = 0, ptr = 1;
  pair<ll, ll> road_segements[N], bessie_journey[M];

  for (ll counter=1; counter<=N; counter++) {
    //.first is segment, .second is speed
    fin >> road_segements[counter].first >> road_segements[counter].second;
    
    road_segements[counter].first += road_segements[counter-1].first;
  }
  for (ll counter = 1; counter <= M; counter++) {
    //.first is segment, .second is speed
    fin >> bessie_journey[counter].first >> bessie_journey[counter].second;
     
    bessie_journey[counter].first += bessie_journey[counter-1].first;
  }

  for (int it = 1; it <= M; it++) {
    while ((road_segements[ptr].first <= bessie_journey[it].first) && (ptr<=N)) {
      ll diff = bessie_journey[it].second - road_segements[ptr].second;
      ans= max(ans, max(diff,(ll)0));
      ptr++;
    }

    /* Requirements:
    * - pointer <= N
    * - bessie's current journey length is over the last road segement
    * - bessie's current journey length is still in the current road segement
    */
    bool check = (ptr <= N) && (bessie_journey[it].first > road_segements[ptr-1].first) && (bessie_journey[it].first <= road_segements[ptr].first);

    if (check) {
      ll d = bessie_journey[it].second - road_segements[ptr].second;
      ans= max(ans, max(d,(ll)0));
    }
  }
  
  fout << ans << endl;
  return 0;

}