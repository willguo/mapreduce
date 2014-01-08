/*
 * CS 61C Fall 2013 Project 1
 *
 * DoublePair.java is a class which stores two doubles and 
 * implements the Writable interface. It can be used as a 
 * custom value for Hadoop. To use this as a key, you can
 * choose to implement the WritableComparable interface,
 * although that is not necessary for credit.
 */

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class DoublePair implements Writable {
    // Declare any variables here
    /**
     *  A double element of a DoublePair.
     */
    private double dub1;
    
    /**
     *  Another double element of a DoublePair.
     */
    private double dub2;

    /**
     * Constructs a DoublePair with both doubles set to zero.
     */
    public DoublePair() {
        // YOUR CODE HERE
	this.dub1 = 0;
	this.dub2 = 0;
    }

    /**
     * Constructs a DoublePair containing double1 and double2.
     */ 
    public DoublePair(double double1, double double2) {
        // YOUR CODE HERE
	this.dub1 = double1;
	this.dub2 = double2;
    }

    /**
     * Returns the value of the first double.
     */
    public double getDouble1() {
        // YOUR CODE HERE
        return this.dub1;
    }

    /**
     * Returns the value of the second double.
     */
    public double getDouble2() {
        // YOUR CODE HERE
        return this.dub2;
    }

    /**
     * Sets the first double to val.
     */
    public void setDouble1(double val) {
        // YOUR CODE HERE
	this.dub1 = val;
    }

    /**
     * Sets the second double to val.
     */
    public void setDouble2(double val) {
        // YOUR CODE HERE
	this.dub2 = val;
    }

    /**
     * write() is required for implementing Writable.
     */
    public void write(DataOutput out) throws IOException {
        // YOUR CODE HERE
	out.writeDouble(getDouble1());
	out.writeDouble(getDouble2());
    }

    /**
     * readFields() is required for implementing Writable.
     */
    public void readFields(DataInput in) throws IOException {
        // YOUR CODE HERE
	setDouble1(in.readDouble());
	setDouble2(in.readDouble());
    }

    /** compareTo()method to implement Writable. */
    public int compareTo(DoublePair dp) {
	int thisVal = (int) this.getDouble1();
    int thatVal = (int) dp.getDouble1();
    int result = (int) (thisVal < thatVal ? -1 : (thisVal == thatVal ? 0 : 1));
        if (thisVal == thatVal) {
            thisVal = (int) this.getDouble2();
            thatVal = (int) dp.getDouble2();
            result = (thisVal < thatVal ? -1 : (thisVal == thatVal ? 0 : 1));
        }
        return result;
    }

    /** hashcode() method to implement Writable */
    public int hashCode() {
         final int prime = 31;
         int result = 1;
         result = prime * result + (int) this.getDouble1();
         result = prime * result + (int) ((int)getDouble2() ^ ((int)getDouble2() >>> 32));
         return result;
    }

    public static void main (String[] args) {
        DoublePair test = new DoublePair(5, 10);
        System.out.println("First double in pair: " + test.getDouble1() + "\nSecond Double in pair: " + test.getDouble2());
    }
}
