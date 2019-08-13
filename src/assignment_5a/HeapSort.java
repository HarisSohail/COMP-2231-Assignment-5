/**
 * HeapSort.java
 *
 * 
 * COMP 2231 Assignment 5 Question 1
 *
 * Making the heap sort algorithm more efficient by writing a method
 * that will build a heap in place using the array to be sorted.
 * Rewriting the heap sort algorithm to make use of it.
 */
package assignment_5a;

public class HeapSort<T> {

    /**
     * Applies heapSort algorithm to sort the input array.
     *
     * @param data the array to be sorted
     * @return the sorted array
     */
    public T[] heapSort(T[] data) {
        int size = data.length;
        int heap = 0;
        int start = (size - 1) / 2;

        for (int i = start; i >= 0; i--) {//loops through elements
            maxHeapify(data, i, size - 1);
        }//end for

        for (int i = 0; i < size; i++) {
            int last = size - (i + 1);
            swap(data, heap, last);
            maxHeapify(data, heap, last - 1);
        }//end for
        return data;
    }//end heapSort

    /**
     * Function arranges node and its subtrees to satisfy the heap property.
     *
     * @param data the array containing the heap
     * @param root the index of the root of the heap to adjust
     * @param last the index of the last node of the heap to adjust
     */
    private void maxHeapify(T[] data, int root, int last) {
        int i = root;
        int largest = i;
        int left = 2 * i + 1;//left child
        int right = 2 * i + 2;//right child

        if (left <= last && (((Comparable) data[largest]).compareTo(data[left]) < 0)) {//If left child is larger than root
            largest = left;
        }//end if

        if (right <= last && (((Comparable) data[largest]).compareTo(data[right]) < 0)) {//If right child is larger than root
            largest = right;
        }//end if

        if (largest != i) {//If largest child not root 
            swap(data, largest, i);
            maxHeapify(data, largest, last);//recursive
        }//end if
    }//end maxHeapify

    /**
     * Swaps to elements in an array. Used by various sorting algorithms.
     *
     * @param data the array in which the elements are swapped
     * @param index1 the index of the first element to be swapped
     * @param index2 the index of the second element to be swapped
     */
    private void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }//end swap

    /**
     * Returns a string representation of this heap.
     *
     * @param data of heap
     * @return a string representation of heap
     */    
    public String toString(T[] data) {
        String output = " ";
        int size = data.length;
        for (int i = 0; i < size; i++) {
            output += "[" + data[i] + "]";
        }//end for
        return output;
    }//end toString

}//end HeapSort Class

/*
Assistance from Chapter 21: “Heaps and Priority Queues.”
Assistance from: 
    stackoverflow.com/questions/35051092/trying-to-understand-max-heapify
Assistance from: 
    www.geeksforgeeks.org/heap-sort/
Assistance from: 
    www.crazyforcode.com/heap-data-structure/
Swap method taken from Assignment 1 Question 2
*/
