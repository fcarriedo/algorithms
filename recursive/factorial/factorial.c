#include<stdio.h>

int factorial(int);

int main(int argc, char *argv[]) {
  if(argc <= 1) {
    printf("Usage: \n\t./fact my_number\n");
    return 0;
  }

  int number = atoi(argv[1]);
  if(!number) {
    printf("'my_number' has to be an integer.\n");
    return -1;
  }

  printf("\n %d! = %d\n", number, factorial(number));
}

/**
 * Method that performs the factorial calculation.
 *
 * Note: Beautiful oneliner recursive implementation
 * based on the ternary operator.
 */
int factorial(int number) {
  return number<=1 ? 1 : number*factorial(number-1);
}
