/**
 * HashTableEntry.java
 *
 * 
 * COMP 2231 Assignment 5 Question 3
 *
 *
 */
package assignment_5c;

public class HashTableEntry {

    private String key;//name of person
    private int value;//SIN value
    private boolean deleted;//determines if element was deleted

    /**
     * Sets required parameters for each entry of hash table.
     * 
     * @param name 
     * @param SIN
     */
    public HashTableEntry(String name, int SIN) {
        key = name;
        value = SIN;
        deleted = false;
    }//end HashTableEntry
    
    /**
     * Getter for name.
     * 
     * @return name given 
     */
    public String getName() {
        return key;
    }//end getName

    /**
     * Can change name.
     * 
     * @param name of person
     */
    public void setName(String name) {
        this.key = name;
    }//end setName

    /**
     * Getter for SIN
     * 
     * @return SIN value
     */
    public int getSIN() {
        return value;
    }//end getSIN
    
    /**
     * returns true if deleted and false if not deleted.
     * 
     * @return true if deleted and false if not deleted
     */
    public boolean isDeleted() {
        return deleted;
    }//end isDeleted

    /**
     * Set deleted value
     * 
     * @param deleted 
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }//end setDeleted

    /**
     * Returns a string representation of hash elements.
     *
     * @return a string representation of hash elements
     */    
    public String toString() {
        return "Name: " + key + " SIN: " + value;
    }//end toString

}
