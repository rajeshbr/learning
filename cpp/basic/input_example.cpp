#include <iostream>

using namespace std; 

int main(){

  float num1, num2, sum, avg;
  
  cout << "Enter two integers" << endl;
  cin >> num1 >> num2;

  sum = num1+num2;

  avg = sum/2;

  cout << "Sum = " << sum << endl << "Avg = " << avg << endl;

  return 0;
}
