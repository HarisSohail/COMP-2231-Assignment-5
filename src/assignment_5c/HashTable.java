/**
 * HashTable.java
 *
 * 
 * COMP 2231 Assignment 5 Question 3
 *
 * Implementing a dynamically resizable hash table to store
 * people’s names and Social Security numbers. Use the extraction method with
 * division using the last four digits of the Social Security number.
 * Use an initial table size of 31 and a load factor of 0.80.
 * Use open addressing with double hashing using an extraction method on the
 * first three digits of the Social Security number.
 */
package assignment_5c;

import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;
import java.util.regex.Pattern;

public class HashTable {

    private static final int INITIAL_SIZE = 31;//default initial size
    private static final double LOAD_FACTOR = 0.80;//default initial load factor

    private int threshold;//current resizing value
    private int numOfElements;//number on elements in hash table

    private HashTableEntry[] hashTable;//storing hash table entries

    /**
     * The default size and load factor used for creating hash table.
     */
    public HashTable() {
        hashTable = new HashTableEntry[INITIAL_SIZE];//new hash table with default size
        threshold = (int) (LOAD_FACTOR * INITIAL_SIZE);//equation for threshold
        numOfElements = 0;
    }//end HashTable

    /**
     * Adds element to hash table.
     *
     * @param element to be added
     */
    public void add(HashTableEntry element) {
        try {//try-catch required to satify IllegalAccessException 
            add(element.getName(), element.getSIN());
        }//end try
        catch (IllegalAccessException e) {
            System.out.println(e);
        }//end catch
    }//end add

    /**
     * Adds element to hash table.
     *
     * @param name of person for respective SIN
     * @param SIN to be added
     * @throws IllegalAccessException
     */
    public void add(String name, int SIN) throws IllegalAccessException {
        if (!Pattern.matches("[\\d]{9}", String.valueOf(SIN))) {//if SIN format valid
            throw new IllegalAccessException("Not a SIN.");
        }//end if

        if (numOfElements + 1 >= threshold) {//if resize needed
            resize();
        }//end if

        int index = calculateNextIndex(SIN);//look at following index
        hashTable[index] = new HashTableEntry(name, SIN);//new entry in hash table
        numOfElements++;//increment elem
    }//end add

    /**
     * Removes element from existing hash table.
     *
     * @param SIN to be removed
     * @return deleted SIN
     * @throws EmptyCollectionException
     */
    public int remove(int SIN) {
        int index = -1;//set index to -1
        if (isEmpty()) {
            throw new EmptyCollectionException("Hash Table");
        }//end if

        try {//if not found try-catch
            index = find(SIN);
        }//end try 
        catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }//end catch

        if (index != 1) {
            hashTable[index].setDeleted(true);//delete element
            numOfElements--;//decrease size
        }//end if
        return hashTable[index].getSIN();
    }//end remove

    /**
     * Resizes hash table as needed.
     */
    private void resize() {
        HashTableEntry[] oldHashTable1 = hashTable;//old hash table
        hashTable = new HashTableEntry[newSize()];//empty hash table

        for (HashTableEntry oldHashTable2 : oldHashTable1) {//for-each loop
            if (oldHashTable2 != null && !oldHashTable2.isDeleted()) {
                int SIN = oldHashTable2.getSIN();
                int temp = calculateNextIndex(SIN);
                hashTable[temp] = oldHashTable2;//new position
            }//end if
        }//end for
        threshold = (int) (LOAD_FACTOR * hashTable.length);//recalculate threshold
    }//end resize

    /**
     * Get new hash table size.
     *
     * @return new hash table size
     */
    private int newSize() {
        int newSize = hashTable.length * 2;//resized length
        for (int i = newSize; true; i++) {
            if (isPrime(i)) {//check if prime number
                newSize = i;
                break;
            }//end if
        }//end for
        return newSize;
    }//end newSize

    /**
     * Checks if number is prime number.
     *
     * @param num number being checked
     * @return if number is prime number
     */
    private boolean isPrime(int num) {
        if (num % 2 == 0) {//if divisible by 2 not prime
            return false;
        }//end if

        for (int i = 3; i * i <= num; i += 2) {//check for prime
            if (num % i == 0) {
                return false;
            }//end if
        }//end for
        return true;
    }//end isPrime

    /**
     * Finds element in hash table.
     *
     * @param SIN
     * @return found element in hash table
     * @throws ElementNotFoundException
     */
    private int find(int SIN) {
        boolean found = false;
        int index = primaryHashFunction(SIN);

        int i = 1;
        while (!found) {//if not found(true)
            if (hashTable[index] == null) {//if key null
                throw new ElementNotFoundException("Hash Table");
            }//end if
            else if (SIN != hashTable[index].getSIN() || hashTable[index].isDeleted()) {//if element has incorrect key or is deleted, find next index
                index = (index * i) + (i + secondaryHashFunction(SIN)) % hashTable.length;//new index value
                i++;
            }//end else if 
            else if (SIN == hashTable[index].getSIN()) {//if key found
                found = true;
            }//end else if
        }//end while
        return index;
    }//end find 

    /**
     * Returns true if hash table contains element in SIN.
     *
     * @param element
     * @return
     */
    public boolean contains(HashTableEntry element) {
        return contains(element.getSIN());
    }//end contains

    /**
     * Returns true if hash table contains element in SIN.
     *
     * @param SIN
     * @return
     */
    public boolean contains(int SIN) {
        boolean found = true;
        try {//try-catch if element has been deleted
            int index = find(SIN);
            if (hashTable[index].isDeleted()) {//if no SIN
                found = false;
            }//end if
        }//end try 
        catch (ElementNotFoundException e) {
            found = false;
        }//end catch
        return found;
    }//end contains

    /**
     * Calculates index to use for inserting new entry into the hash table.
     *
     * @param SIN to be hashed
     * @return index used
     */
    private int calculateNextIndex(int SIN) {
        int i = primaryHashFunction(SIN);
        int j = i;
        int index = primaryHashFunction(SIN);

        if (hashTable[i] != null && !hashTable[i].isDeleted()) {//entry not null and not deleted
            j = (i + secondaryHashFunction(SIN)) % hashTable.length;//caluclating value for index
            index = j;
        }//end if

        int k = 1;
        while (hashTable[index] != null && !hashTable[index].isDeleted()) {//loop through possible positions until one is found
            //checks if an index is available    
            index = ((index + k) * (k + secondaryHashFunction(SIN))) % hashTable.length;//new index value
            k++;//increment value until position found
        }//end while
        return index;
    }//end calculateNextIndex

    /**
     * First hashing function to store elements.
     *
     * @param SIN
     * @return
     */
    private int primaryHashFunction(int SIN) {
        int key = Integer.parseInt(String.valueOf(SIN).substring(5, 8));
        int index = key % hashTable.length;//equation calcualted 
        return index;
    }//end primaryHashFunction

    /**
     * Second hashing function to resolve collisions.
     *
     * @param SIN
     * @return
     */
    private int secondaryHashFunction(int SIN) {
        int key = Integer.parseInt(String.valueOf(SIN).substring(0, 3));
        int index = key % hashTable.length;
        return index;
    }//end secondaryHashFunction(int SIN)

    /**
     * Returns true if hash table is empty and false otherwise.
     *
     * @return true if this hash table is empty
     */
    public boolean isEmpty() {
        return (numOfElements == 0);
    }//end is empty

    /**
     * Returns number of elements in hash table.
     *
     * @return number of elements in hash table
     */
    public int size() {
        return numOfElements;
    }//end size

    /**
     * Returns a string representation of this hash table.
     *
     * @return a string representation of hash table
     */
    public String toString() {
        String output = "";
        if (isEmpty()) {
            System.out.println("Empty hash table");
        }//end if
        else {
            for (int i = 0; i < hashTable.length; i++) {
                if (hashTable[i] == null) {//if empty(null)
                    output += "[" + i + "] " + "null\n";
                }//end if 
                else {//if hash table has elements
                    output += "[" + i + "] " + hashTable[i].toString() + "\n";
                }//end else
            }//end for
        }//end else
        return output;
    }//end toString

}//end HashTable Class

/*
Assistance from codereview:
    www.codereview.hash tableexchange.com/questions/186063/hash-table-implementation-using-java
Assistance from algolist:
    www.algolist.net/Data_structures/Hash_table/Dynamic_resizing
Assistance from oracle:
    www.docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
Assistance from java67 to complete isPrime():
    www.java67.com/2014/01/how-to-check-if-given-number-is-prime.html
Assistance from stackoverflow:
    www.stackoverflow.com/questions/40223547/remove-method-in-hashtable-failing-tests
 */
