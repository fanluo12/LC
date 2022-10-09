## 301. Remove Invalid Parentheses
Use set and queue to store valid string. While queue is not empty, poll string of it and judge by isValid function. If it is valid, result arraylist add it. If it is not valid, loop through it and make new strings divided by looping index and add to queue and set.
For isValid function, simply define a count variable and add 1 to count if looping ( and -1 for ). Finally judge if count == 0

## 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
Use two queues, min queue and max queue to store less and greater element. Compare two queues' peeks and update left window
