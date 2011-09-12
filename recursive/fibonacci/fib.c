#include<stdio.h>

int fib(int);

int main(int argc, char *argv[]) {
  if(argc <= 1) {
    printf("Usage: \n\t./fib my_number\n");
    return 0;
  }

  int number = atoi(argv[1]);
  if(!number) {
    printf("'my_number' has to be an integer.\n");
    return -1;
  }

  printf("\nFibonacci # of %d: %d\n", number, fib(number));
}

/**
 * Method that performs the fibonacci number calculation.
 *
 * Note: Its implementation is a beautiful recursive oneliner
 * based on the ternary operator BUT a very naive approach since
 * its complexity grows exponentially (bad, bad, BAD!). 
 * It should be calculated iteratively for best performance or at
 * least use memoization.
 * 
 * Later to come.
 */
int fib(int number) {
  return number<=1 ? number : fib(number-1) + fib(number-2);
}
