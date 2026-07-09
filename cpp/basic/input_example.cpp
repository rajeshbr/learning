#include <iostream>

using namespace std;

int main() {

  float num1, num2, sum, avg;

  cout << "Enter two integers" << endl;
  cin >> num1 >> num2;

  sum = num1 + num2;

  avg = sum / 2;

  cout << "Sum = " << sum << endl << "Avg = " << avg << endl;

  char16_t fox_emoji = u'₹';

  cout << "Utf16 characted: " << fox_emoji << endl;

  return 0;
}
