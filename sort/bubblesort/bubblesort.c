#include<stdio.h>

void swap(int *, int, int);
void bubbleSort(int *, int);
void printArray(int *, int);

void bubbleSort(int *array, int length){
  int i = 0;
  int tmp_length = length-1;
  int swapped = 0; // For optimizations
  while(tmp_length > 0) {
    if(array[i] > array[i+1]) {
      swap(array, i, i+1);
      swapped = 1;
    }

    if(++i >= tmp_length) {
      i = 0;
      tmp_length--;

      // Optimization: If after finishing the round it didn't have
      // to do any 'swaps', it means that it is already sorted.
      if(!swapped) break;
      else swapped = 0;
    }
  }
}

int main() {
  int array[] = {5,19,34,8,5,90,-4,1,-6,13};
  //int array[] = {-6,-4,1,5,5,8,13,19,34,90};
  //int array[] = {-4,-6,1,5,5,8,13,19,34,90};
  int length = sizeof(array)/sizeof(int);

  printf("Original array: ");
  printArray(array, length);

  bubbleSort(array, length);

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
