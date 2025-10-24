#include<iostream>
#include<unordered_map>

using namespace std;


int main() {

  int list[] = {4, 5, 6, 7};
  for(int i=0; i<sizeof(list)/sizeof(list[0]);i++) {
    cout << list[i] << endl;
  }
  return 0;
}
