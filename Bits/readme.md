## 1356. Sort Integers by The Number of 1 Bits
Arrays.sort() only works with arrays of reference types. It uses the natural ordering or a custom comparator to sort the elements. We need to sort the array based on the number of 1 bits in each element. However, Arrays.sort() doesn't have an overload that accepts a primitive int[] array and a custom comparator. By converting the int[] array to an Integer[] array, we can take advantage of the Arrays.sort() method with a custom comparator.


