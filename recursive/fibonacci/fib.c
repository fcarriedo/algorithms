#include<stdio.h>

int fib(int);

int main() {
  int number = 35;
  printf("\nFibonacci # of %d: %d\n", number, fib(number));
}

int fib(int number) {
  return number<=1 ? number : fib(number-1) + fib(number-2);
}
