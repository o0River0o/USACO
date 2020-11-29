#include <iostream>
#include <fstream>
#include <math.h>

using namespace std;
using ll = long long;

ifstream fin("lostcow.in");
ofstream fout("lostcow.out");

ll x, y;

int main()
{
  fin >> x >> y;

  ll ans = 0, by = 1, dir = 1;
  while (1)
  {
    // dir == 1 moving to the right
    // dir == -1 moving to the left.
    if ((dir == 1 && x <= y && y <= x + by) || (dir == -1 && x - by <= y && y <= x))
    {
      // We found Bessie!
      ans += abs(y - x);
      fout << ans << endl;
      break;
    }
    else
    {
      // Didn't find Bessie! Add to our running total the cost of
      // moving 'by' units away from the start and back again.
      // Then multiply our next move's length by 2 and switch direction.
      ans += by * 2;
      by *= 2;
      dir *= -1;
    }
  }
}