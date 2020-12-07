#include <iostream>
#include <fstream>
#include <string>
#include <array>

constexpr int nb_letter = 26;

using namespace std;

using ll = long long;
using arr = array<int, nb_letter>;

ifstream fin("blocks.in");
ofstream fout("blocks.out");

void count_freq(const string &s, arr &freq) {
    for (char c: s) {
        freq[c - 'a']++;
    }
}

int main() {

  ll n;
  fin >> n;
  // cout << n;

  arr ans{};
    while (n--) {
        string s1, s2;
        fin >> s1 >> s2;
        arr freq1{}, freq2{};
        count_freq(s1, freq1); count_freq(s2, freq2);
        for (int i = 0; i < nb_letter; i++) {
            ans[i] += max(freq1[i], freq2[i]);
        }
    } 
    for (int i: ans) {
        fout << i << '\n';
    }

  return 0;
}