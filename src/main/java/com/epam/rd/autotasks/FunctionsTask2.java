package com.epam.rd.autotasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class FunctionsTask2 {
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static boolean isSorted(int[] array, SortOrder order) {
        if (array == null || array.length == 0 || order == null) {
            throw new IllegalArgumentException();
        }
        Comparator<Integer> comparator = null;
        if (order == SortOrder.ASC) {
            comparator = Comparator.naturalOrder();
        } else if (order == SortOrder.DESC) {
            comparator = Comparator.reverseOrder();
        }
        int[] ints = Arrays.stream(array).boxed().sorted(comparator).mapToInt(Integer::valueOf).toArray();
        return Arrays.equals(array, ints);
    }
    /**
     * <summary>
     * Implement code according to description of task.
     * </summary>
     * if set invalid arguments in method, then method must throws
     * IllegalArgumentException
     */
    public static int[] transform(int[] array, SortOrder order) {
        if (array == null || array.length == 0 || order == null) {
            throw new IllegalArgumentException();
        }
        if (isSorted(array, order)) {
            return IntStream.range(0, array.length).map((x) -> x + array[x]).toArray();
        }
        return array;
    }
}
