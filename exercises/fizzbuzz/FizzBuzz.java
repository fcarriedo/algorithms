/**
 * Write a program that prints the numbers from 1 to 100.
 * But for multiples of three print "Fizz" instead of the number 
 * and for the multiples of five print "Buzz".
 * For numbers which are multiples of both three and five print "FizzBuzz".
 */

public class FizzBuzz {
  public static void main(String[] args) {
    for(int i=1; i<=100; i++) {
      System.out.println( i%3==0 && i%5==0 ? "FizzBuzz" : i%3==0 ? "Fizz" : i%5==0 ? "Buzz" : String.valueOf(i) );
    }
  }
}
