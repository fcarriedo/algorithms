#include<stdio.h>

void swap(int *, int, int);
void insertionSort(int *, int);
void printArray(int *, int);

void insertionSort(int *array, int length){
}

int main() {
  int array[] = {5,19,34,8,5,90,-4,1,-6,13};
  //int array[] = {-6,-4,1,5,5,8,13,19,34,90};
  //int array[] = {-4,-6,1,5,5,8,13,19,34,90};
  int length = sizeof(array)/sizeof(int);

  printf("Original array: ");
  printArray(array, length);

  insertionSort(array, length);

  printf("Sorted array: ");
  printArray(array, length);
}


void swap(int *array, int indexA, int indexB) {
  int tmp = array[indexA];
  array[indexA] = array[indexB];
  array[indexB] = tmp;
}

void printArray(int *array, int length){
  printf("\n[");
  int i;
  for(i=0; i<length; i++) {
    printf("%d, ", array[i]);
  }
  printf("]\n");
}
