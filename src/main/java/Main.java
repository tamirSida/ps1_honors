

import java.math.BigInteger;

/**
 * Main class to test the Karatsuba multiplication algorithm.
 */
public class Main {

    /**
     * Main method to test the Karatsuba multiplication algorithm.
     *
     * @param args command line arguments (not used)
     * this method generates two random 500-bit numbers and multiplies them using Karatsuba algorithm
     * there is a verification option to check the result with normal mult uncomment the lines to verify
     */
    public static void main(String[] args) {
        // Generate two random 500-bit numbers
        BigInteger a = new BigInteger(500, new java.util.Random());
        BigInteger b = new BigInteger(500, new java.util.Random());

        // Perform multiplication using Karatsuba algorithm
        BigInteger result = karatsuba.karatsuba_mult(a, b);

        // Print the numbers and the result
        System.out.println("Number A: " + a);
        System.out.println("Number B: " + b);
        System.out.println("Karatsuba Result: " + result);

        // Verify with standard multiplication uncomment below lines to verify
//        BigInteger standardResult = a.multiply(b);
//        System.out.println("Standard Multiplication Result: " + standardResult);
//        System.out.println("Verification: " + (result.equals(standardResult) ? "Success" : "Failure"));
    }
}