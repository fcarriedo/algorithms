#!/usr/bin/python

import sys

from collections import defaultdict

"""
  Small script that shows the first letter distribution
  from dictionary.

    Eg. How many entries are there for 'a', how many for 'b' and so on..

  You can have fun =P analyzing different language dictionaries and see
  how they graph.
"""

def parse_dict(dict_file_name):
    """
    Returns a list of tuples which represent:

      (k, v) where
             k = initial letter
             v = percent of occurrence of the initial letter on the dict
    """
    total_words = 0
    acumulator = defaultdict(int)
    dict_file = open(dict_file_name, 'r')
    for line in dict_file:
        first_letter = line[:1]
        acumulator[first_letter.lower()] += 1
        total_words += 1

    return [ (letter, float((count*100))/total_words) for letter, count in acumulator.items() ]

def graph(stats):
    """Creates a simple ASCII graph"""
    for digit, percent in stats:
        print "\n%s = %.2f%% %s" % (digit, percent, ('x'*int(percent))),

def main(args):
    if not args:
        print "\nYou need to specify a dictionary file to read from:"
        print "\n   Usage: $ ./dict-ix-dist.py eng-dict.txt\n"
        sys.exit(1)
    else:
        dict_file_name = args[0]

    stats = parse_dict(dict_file_name)
    graph(stats)


if __name__ == '__main__':
    main(sys.argv[1:])
