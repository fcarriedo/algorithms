# Insertion sort algorithm

## Compile and run

Compile as:
  `gcc insertionsort.c -o sort'

Run as:
  `./sort`

## Best, Worst and Average cases (source: (wikipedia)[http://en.wikipedia.org/wiki/Insertion_sort#Best.2C_worst.2C_and_average_cases])

The best case input is an array that is already sorted. In this case insertion sort has a linear running time (i.e., Θ(n)). During each iteration, the first remaining element of the input is only compared with the right-most element of the sorted subsection of the array.

The worst case input is an array sorted in reverse order. In this case every iteration of the inner loop will scan and shift the entire sorted subsection of the array before inserting the next element. For this case insertion sort has a quadratic running time (i.e., O(n2)).

The average case is also quadratic, which makes insertion sort impractical for sorting large arrays. However, insertion sort is one of the fastest algorithms for sorting very small arrays, even faster than quick sort; indeed, good quick sort implementations use insertion sort for arrays smaller than a certain threshold, also when arising as subproblems; the exact threshold must be determined experimentally and depends on the machine, but is commonly around ten.
