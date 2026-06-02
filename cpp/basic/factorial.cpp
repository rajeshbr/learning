#include<iostream>

using namespace std;

int main() {

  int num=0;
  cout << "Enter a number: "<<endl;
  cin >> num;
  int factorial =1;
  for (int i = 1; i <=num; i++){
    factorial*=i;
  }
  cout << "Factorial of "<<num<< " is "<< factorial<<endl;
}
