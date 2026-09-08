/*Performs in-place string reversal*/
#include <stdio.h>

int main() {

  char str[] = "ab";
  int len = 0;
  for (len = 0; str[len] != '\0'; len++)
    ;

  int i = 0;
  int j = len-1;
  for (; i < j; i++, j--) {

    str[i] = str[i]+str[j];
    str[j] = str[i]-str[j];
    str[i]= str[i]-str[j];
  }

  printf("%s\n", str);
}
