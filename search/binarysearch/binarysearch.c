#include<stdio.h>

int binarySearch(int *, int, int, int);

/**
 * Returns the index of the searched element or -1 if not
 * existent.
 */
int binarySearch(int *array, int initIx, int endIx, int elemToSearch) {
  return 0;
}

int main() {
  int sortedArray[] = {-3,-1,0,9,23,49,52,89,92,93,98,113};
  int length = sizeof(sortedArray)/sizeof(int);

  int elemToSearch = 98;
  int ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  elemToSearch = 60;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);
}
