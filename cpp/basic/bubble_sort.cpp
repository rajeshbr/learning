#include <iostream>

using namespace std;

void bubble_sort(int numbers[], int size);

int main() {

  int numbers[] = {4, 2, 9, 0, 7, 1, 3};
  int size = sizeof(numbers) / sizeof(numbers[0]);
  bubble_sort(numbers, size);
  for (int num : numbers) {
    cout << num << endl;
  }
  return 0;
}

void bubble_sort(int numbers[], int size) {
  for (int i = 0; i < size;) {
    int swap = false;
    for (int j = i + 1; j < (size - 1); j++) {
      if (numbers[i] > numbers[j]) {
        int temp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = temp;
        swap = true;
      }
    }
    if (!swap) {
      break;
    }
  }
}
