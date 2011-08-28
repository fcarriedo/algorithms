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

    Linear (theoretical) implementation of the
    fibonnaci number calculation
    """
    result = []
    curr, next = 0, 1
    for x in xrange(n):
        result.append(next)
        next, curr = ((next+curr), next)

    return result

def benford_dist(data):
    count = dict( (i,0) for i in range(10) ) # init the dict
    for elem in data:
        first_letter = str(elem)[:1]
        count[ int(first_letter) ] += 1

    return [ (k, (v*100)/len(data)) for k, v in count.items() if k != 0 ]

def graph(stats):
    """Creates a simple ASCII graph"""
    for k, v in stats:
        line = "".join('x' for x in xrange(v))
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
