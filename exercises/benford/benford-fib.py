#!/usr/bin/python

import sys
from collections import defaultdict

"""
  Small script that shows the Benford's distribution
  with the fibonacci sequence.

  See:
    http://en.wikipedia.org/wiki/Benford's_law
    http://youtu.be/6KmeGpjeLZ0
"""

def fib(n):
    """
    Return Fibonacci series up to n

    Uses a theoretically linear implementation of the
    fibonnaci number calculation
    """
    result = []
    curr, next = 0, 1
    for x in xrange(n):
        result.append(next)
        next, curr = ((next+curr), next)

    return result

def benford_dist(data):
    """
    Returns a list of touples which represent:

      (k, v) where
               k = digit
               v = percent of occurrence of the digit on data

    Benford's law, also called the first-digit law, states that in lists of
    numbers from many (but not all) real-life sources of data, the leading
    digit is distributed in a specific, non-uniform way. According to this law,
    the first digit is 1 about 30% of the time, and larger digits occur as the
    leading digit with lower and lower frequency, to the point where 9 as a first
    digit occurs less than 5% of the time. This distribution of first digits
    is the same as the widths of gridlines on the logarithmic scale.
    """
    count = dict( (i,0) for i in range(10) ) # init the dict with 1..10 all val=0
    for elem in data:
        first_letter = str(elem)[:1]
        count[ int(first_letter) ] += 1

    return [ (k, (v*100)/len(data)) for k, v in count.items() if k != 0 ]

def graph(stats):
    """Creates a simple ASCII graph"""
    for k, v in stats:
        line = "".join('x' for x in xrange(v)) # line of length of percentage
        print "\n%s = %d%% %s" % (k, v, line),

def main(args):
    if not args:
        print "\nYou need to specify a max fibonnaci number to calculate:"
        print "\n   Usage: $ ./benford-fib.py 150\n"
        sys.exit(1)
    else:
        max_fib = int(args[0])

    stats = benford_dist( fib(max_fib) )
    graph(stats)


if __name__ == '__main__':
    main(sys.argv[1:])
