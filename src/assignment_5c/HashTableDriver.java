/**
 * HashTableDriver.java
 *
 * 
 * COMP 2231 Assignment 5 Question 3
 *
 * Driver
 */
package assignment_5c;

import jsjf.exceptions.EmptyCollectionException;

public class HashTableDriver {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("         EMPTY HASH TABLE        ");
        System.out.println("=================================");
        
        System.out.println("---------Empty hash table--------");
        HashTable hashTable = new HashTable();
        System.out.println(hashTable.toString());
        
        System.out.println("---------Check hash table--------");
        System.out.println("is hash table empty: " + hashTable.isEmpty());
        System.out.println("size of hash table: " + hashTable.size());     
       
        System.out.println("contains 123456789: " + hashTable.contains(123456789));
        try {
            hashTable.remove(123456789);
        } catch (EmptyCollectionException e) {
            System.out.println(e);
        }
        System.out.println();
        
        System.out.println("=================================");
        System.out.println("        TESTING HASH TABLE       ");
        System.out.println("=================================");
        System.out.println("-------Creating hash table-------");
        
        //adding incorrect SIN to empty hash table
        try {
            hashTable.add("Michael Jordan", 23);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
        
        //adding correct SIN to empty hash table
        try {
            hashTable.add("Lebron James", 504343736);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
        
        System.out.println("is hash table empty: " + hashTable.isEmpty());
        System.out.println("size of hash table: " + hashTable.size());            
        System.out.println(hashTable.toString());
        
        //adding SIN using HashTableEntry
        HashTableEntry test1 = new HashTableEntry("Kyle Lowry", 424367805);
        try {
            hashTable.add("Kyle Lowry", 424367805);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }        

        HashTableEntry test2 = new HashTableEntry("Steph Curry", 477436905);
        try {
            hashTable.add("Steph Curry", 477436905);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }       
        
        System.out.println("---------Check hash table--------");
        System.out.println("is hash table empty: " + hashTable.isEmpty());
        System.out.println("size of hash table: " + hashTable.size()); 
        System.out.println("contains 424367805: " + hashTable.contains(424367805));
        System.out.println("contains test2: " + hashTable.contains(test2));
        
        System.out.println("removing 477436905");
        hashTable.remove(477436905);
        System.out.println("contains test2: " + hashTable.contains(477436905));
        System.out.println();
        
        System.out.println("=================================");
        System.out.println("            HASH TABLE           ");
        System.out.println("=================================");

        HashTable test = new HashTable();
        try {
            test.add("Michael Jordan", 234506333);
            test.add("Ray Allen", 452400894);
            test.add("Kobe Bryant", 824052016);
            test.add("Larry Bird", 330319870);
            test.add("Magic Johnson", 320519790);
            test.add("Chris Paul", 463726483);
            test.add("Kevin Love", 234567873);
            test.add("James Harden", 367820180);
            test.add("Chris Bosh", 323445321);
            test.add("Kawhi Leonard", 987326213);
            test.add("Russel Westbrook",101010003);
            test.add("Jerry West", 527435521 );
            test.add("Kyle Lowry", 424367805);
            test.add("Rick Barry", 845821132);
            test.add("Carmelo Anthony", 715000001);
            test.add("Steph Curry", 477436905);
            test.add("Dwight Howard", 102170273);
            test.add("Klay Thompson", 337373728);
            test.add("Kevin Durant", 350721234);
            test.add("Tim Duncan", 928381823);
            test.add("Manute Bol", 777777777);
            test.add("Zion Williamson", 123987465);
            test.add("Steve Nash", 185111234);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }

        System.out.println("is hash table empty: " + hashTable.isEmpty());
        System.out.println("size of hash table: " + hashTable.size());
        System.out.println("-----------Hash Table------------");
        System.out.println(test.toString());
        
        //will cause reseize once added
        try {
            test.add("Lebron James", 230603360);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
        System.out.println("-------------RESIZED-------------");
        System.out.println("-----------Hash Table------------");
        System.out.println(test.toString());
    }
}
