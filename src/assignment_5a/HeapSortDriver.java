/**
 * HeapSortDriver.java
 *
 * 
 * COMP 2231 Assignment 5 Question 1
 *
 * Driver
 */
package assignment_5a;

public class HeapSortDriver {

    public static void main(String[] args) {
        HeapSort<Integer> heap = new HeapSort<>();

        System.out.println("=======================================================");
        System.out.println("                   TESTING HEAPSORT                    ");
        System.out.println("=======================================================");

        System.out.println("------------------------Test 1-------------------------");
        System.out.println("The array before sorting:");
        Integer[] Test1 = {3, 1, 4, 5, 2};
        System.out.println(heap.toString(Test1));

        System.out.println("The array after sorting:");
        System.out.println(heap.toString(heap.heapSort(Test1)));
        System.out.println();

        System.out.println("------------------------Test 2-------------------------");
        System.out.println("The array before sorting:");
        Integer[] Test2 = {2, 11, 33, 4, 22, 89, 567, 32, 456, 3, 1, 2333};
        System.out.println(heap.toString(Test2));

        System.out.println("The array after sorting:");
        System.out.println(heap.toString(heap.heapSort(Test2)));
        System.out.println();

        System.out.println("------------------------Test 3-------------------------");
        System.out.println("The array before sorting:");
        Integer[] Test3 = {22, 33, 1432, 122, 87, 33, 817, 144, 10702};
        System.out.println(heap.toString(Test3));

        System.out.println("The array after sorting:");
        System.out.println(heap.toString(heap.heapSort(Test3)));
        System.out.println();

        System.out.println("------------------------Test 4-------------------------");
        System.out.println("The array before sorting:");
        Integer[] Test4 = {22, -41, 14, -22, 12, -12};
        System.out.println(heap.toString(Test4));

        System.out.println("The array after sorting:");
        System.out.println(heap.toString(heap.heapSort(Test4)));
        System.out.println();

        System.out.println("------------------------Test 5-------------------------");
        System.out.println("The array before sorting:");
        Integer[] Test5 = {1, 9, 4, 36, 16, 49, -9, -1, -36, -4, -49};
        System.out.println(heap.toString(Test5));

        System.out.println("The array after sorting:");
        System.out.println(heap.toString(heap.heapSort(Test5)));
        System.out.println();
    }//end main

}//end HeapSortDriver
