#include<iostream>
#include<unordered_map>

using namespace std;


int main() {

  int list[] = {4, 5, 6, 7};
  int target = 11;

  unordered_map<int,int> mymap;
  int complement;
  for(int i=0; i<sizeof(list)/sizeof(list[0]);i++) {
    complement = target-list[i];
    if (mymap[complement]) {
        
    }else{
      mymap[list[i]] = i;
    }
  }
  return 0;
}
