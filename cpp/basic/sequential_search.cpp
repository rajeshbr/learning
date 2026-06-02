/**
 * Returns the index of the number to search if found
 * otherwise returns -1
 *
 * */


#include <iostream>

using namespace std;

int sequential_search(int number, int array[], size_t size);

int main(){

  int array[] = {3,6,7,1,9};
  int number = 7;
  cout << sequential_search(number,array, sizeof(array)/sizeof(array[0]))<<endl;
}


int sequential_search(int number, int array[],size_t size){
  for(int i=0;i<size;i++){
    if(number == array[i]){
      return i;
    }
  }
  return -1;
}
