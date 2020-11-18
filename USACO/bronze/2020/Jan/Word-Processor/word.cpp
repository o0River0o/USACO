#include <iostream>
#include <fstream>
#include <string>

using namespace std;
using ll = long long;

ifstream fin("word.in");
ofstream fout("word.out");

int N, K;

int main() {

  fin >> N >> K;

  int current;
  for (ll i = 0; i < N; i++) {
    string word;
    fin >> word;

    if(current == 0) {
      fout << word;
      current += word.size();
    }

    else if (current + word.size() <= K) {
      fout << " " + word;
      current += word.size();
    } else if (current + word.size() > K) {
      fout << "\n" + word;
      current = word.size();
      // cout << "NEXT LINE" << endl;
    }

    // cout << word << " " << current << endl;
  }
}