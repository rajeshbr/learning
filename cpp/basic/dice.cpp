#include <iostream>
#include<cstdlib>
#include<ctime>

using namespace std;

int main(){
  srand(time(0));
  const short minValue = 1;
  const short maxValue = 6;
  short dice1 = (rand() % (maxValue - minValue + 1)) + minValue; 
  short dice2 = (rand() % (maxValue - minValue + 1)) + minValue;
  cout << dice1 << " " <<dice2 <<endl;
}
