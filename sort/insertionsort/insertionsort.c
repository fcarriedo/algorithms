#include<stdio.h>

void insertionSort(int *, int);
void printArray(int *, int);

/**
 * Implementation of insertion sort.
 */
void insertionSort(int *array, int length){
  int i;
  for(i=0; i<length-1; i++) {
    if(array[i+1] < array[i]) {
      int j=i+1;
      int tmp = array[j];
      while(array[j-1] > tmp && j>0) {
        array[j] = array[j-1];
        j--;
      }
      array[j] = tmp;
    }
  }
}

int main() {
  int array[] = {5,19,34,8,5,90,0,12,0,-4,1,-6,13};
  int length = sizeof(array)/sizeof(int);

  puts("Original array: ");
  printArray(array, length);

  insertionSort(array, length);

  puts("Sorted array: ");
  printArray(array, length);
}

void printArray(int *array, int length){
  printf("[");
  int i;
  for(i=0; i<length; i++) {
    printf("%d, ", array[i]);
  }
  printf("]\n");
}
