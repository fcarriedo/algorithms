#include<stdio.h>

int binarySearch(int *, int, int, int);

/**
 * Returns the index of the searched element or -1 if not
 * existent.
 */
int binarySearch(int *array, int initIx, int endIx, int elemToSearch) {
  int rangeLength = endIx - initIx;
  //printf("a[%d]=%d, a[%d]=%d, rangeLength: %d\n", initIx, array[initIx], endIx, array[endIx], rangeLength);
  if(rangeLength <= 1) {
    return array[initIx] == elemToSearch ? initIx : -1;
  } else {
    int halfIx = rangeLength/2;
    if(array[initIx] == elemToSearch) {
      return initIx;
    } else if(array[endIx] == elemToSearch) {
      return endIx;
    } else if(elemToSearch < array[halfIx]) {
      return binarySearch(array, initIx, halfIx, elemToSearch);
    } else {
      return binarySearch(array, halfIx+initIx, endIx, elemToSearch);
    }
  }
}

int main() {
  int sortedArray[] = {-3,-1,0,9,49,52,89,92,93,98,113};
  int length = sizeof(sortedArray)/sizeof(int);

  int elemToSearch = 98;
  int ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  elemToSearch = 60;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  elemToSearch = 0;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  elemToSearch = 9;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  elemToSearch = 23;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  elemToSearch = 92;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  elemToSearch = 93;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  // Testing values on the edges
  elemToSearch = -3;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);

  elemToSearch = 113;
  ix = binarySearch(sortedArray, 0, length-1, elemToSearch);
  printf("Index of searched elem %d = %d\n", elemToSearch, ix);
}
