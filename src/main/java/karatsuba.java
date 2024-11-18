

import java.math.BigInteger;

/**
 * This class implements the Karatsuba algorithm for multiplying two BigInteger numbers.
 */
public class karatsuba {

    private static int threshold = 64; // Default threshold value

    /**
     * Multiplies two BigInteger numbers using the Karatsuba algorithm.
     * if x or y is less than threshold, it uses normal multiplication
     * @param x the first BigInteger number
     * @param y the second BigInteger number
     * @return the product of x and y using the Karatsuba algorithm
     */
    public static BigInteger karatsuba_mult(BigInteger x, BigInteger y) {
        // Verify input numbers
        if (!verifyInput(x, y)) {
            return null;
        }
        // Base case: if either number is small enough, use normal multiplication
        if (x.bitLength() <= threshold || y.bitLength() <= threshold) {
            return x.multiply(y);
        }

        // Determine the number of bits
        int n = Math.max(x.bitLength(), y.bitLength());
        int half = n / 2;

        // Split x and y into high and low parts
        BigInteger highX = x.shiftRight(half); // High part of x
        BigInteger lowX = x.subtract(highX.shiftLeft(half)); // Low part of x
        BigInteger highY = y.shiftRight(half); // High part of y
        BigInteger lowY = y.subtract(highY.shiftLeft(half)); // Low part of y

        // Recursively calculate three products
        BigInteger z0 = karatsuba_mult(lowX, lowY);
        BigInteger z1 = karatsuba_mult(lowX.add(highX), lowY.add(highY)); // Cross term multiplication
        BigInteger z2 = karatsuba_mult(highX, highY);

        // Combine results using Karatsuba formula
        BigInteger result = z2.shiftLeft(2 * half)
                .add(z1.subtract(z2).subtract(z0).shiftLeft(half))
                .add(z0);

        return result;
    }

    /**
     * Verifies that the input numbers are valid.
     * @param x the first BigInteger number
     * @param y the second BigInteger number
     * @return true if both numbers are valid, false otherwise
     */
    public static boolean verifyInput(BigInteger x, BigInteger y) {
        if (x == null || y == null) {
            System.out.println("Error: One or both of the input numbers are null.");
            return false;
        }
        if (x.signum() == -1 || y.signum() == -1) {
            System.out.println("Error: One or both of the input numbers are negative.");
            return false;
        }
        return true;
    }

    /**
     * Sets the threshold value for the Karatsuba algorithm.
     * @param newThreshold the new threshold value
     */
    public static void setThreshold(int newThreshold) {
        threshold = newThreshold;
    }
}