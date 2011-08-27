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
  """Linear implementation of the fibonnaci number calculation"""
  if n == 0 or n == 1: return n
  curr, next = 1, 1
  for x in xrange(2, n):
    next, curr = ((next+curr),next)
  return next

def graph(stats,max_fib):
  """Creates a simple ASCII graph"""
  for i in range(1,10):
    percent = (stats[str(i)]*100/max_fib)
    percent_line = "".join('x' for x in range(percent))
    print "\n%d = %d%% %s" % (i, percent, percent_line),


def main(args):
  if len(args) == 0:
    print "\nYou need to specify a max fibonnaci number to calculate:"
    print "\n   Usage: $ ./benford-fib.py 150\n"
    sys.exit(1)
  else:
    max_fib = int(args[0])

  stats = defaultdict(int)

  for i in range(max_fib):
    fib_num = fib(i)
    key = str(fib_num)[0:1]
    stats[key] += 1

  graph(stats, max_fib)


if __name__ == '__main__':
  main(sys.argv[1:])
