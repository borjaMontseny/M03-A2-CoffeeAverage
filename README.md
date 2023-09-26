# A2 - CoffeAverage

Say that you are interested in computing the average acid level of coffee as served by coffee shops in your home town. You visit many coffee shops and dip your pH meter into samples of coffee. You record your results in a text file such as the following. The first line of the file gives the number of values that follow.

- 13
- 5,6
- 6,2
- 6,0
- 5,5
- 5,7
- 6,1
- 7,4
- 5,5
- 5,5
- 6,3
- 6,4
- 4,0
- 6,9

Unfortunately, your pH meter sometimes produces false readings. So you decide to disregard the reading that is most distant from the average.

Compute the average of all the data. Now scan through the array to find the value that is farthest (in either direction) from that average. Remember the index of this value, and now scan through the array again, computing an average that does not include this value. Print the new average.

Here is a run of the program:

```
Average: 5.930769230769231
Most distant value: 4.0
New average: 6.091666666666668
```