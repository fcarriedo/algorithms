import java.util.List;
import java.util.ArrayList;

/**
 * O(n) solution to the problem of finding the
 * intesection between two sorted arrays.
 */
public class Intersection {

  private static Integer[] intersection(int[] a, int[] b) {
    int i =0, j = 0;
    List<Integer> intersections = new ArrayList<Integer>();
    while(i < a.length && j < b.length) {
      // If equal, add them to the intersection list
      if(a[i] == b[j]) {
        intersections.add( a[i] );
        i++; j++; // Increment both indexes.
      } else {
        // Increment the according index
        if( a[i] < b[j] ) i++; else j++;
      }
    }
    return intersections.toArray(new Integer[]{});
  }

  public static void main(String[] args) {
    int[] a = {-5, -2, 4, 34, 89,13890};
    int[] b = {-25,1,2,3,4,34,56,89,105,13890};
    Integer[] result = intersection(a, b);
    for(int num:result) System.out.print(num + ", ");
  }
}
