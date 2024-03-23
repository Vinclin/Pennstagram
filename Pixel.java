package org.cis1200;

/*
 * This file has been adapted by the CIS 120 course staff from code by
 * Richard Wicentowski and Tia Newhall (2005).
 *
 * You need to complete this file FIRST before moving on to the
 * rest of the project.
 */

/**
 * A point of color.
 * <p>
 * Pixels are represented as three integral color components (red, green, and
 * blue) in the inclusive range [0, 255]. Lower values mean less color; higher
 * mean more. For example, {@code new Pixel(255,255,255)} represents white,
 * {@code new Pixel(0,0,0)} represents black, and {@code new Pixel(0,255,0)}
 * represents green.
 * <p>
 * This data structure is immutable. Once a {@code Pixel} is created, it cannot
 * be modified.
 *
 * @author vinlin
 */
public class Pixel implements Comparable<Pixel> {

    /**
     * The {@code Pixel} representing the RGB color black.
     */
    public static final Pixel BLACK = new Pixel(0, 0, 0);

    /**
     * The {@code Pixel} representing the RGB color blue.
     */
    public static final Pixel BLUE = new Pixel(0, 0, 255);

    /**
     * The {@code Pixel} representing the RGB color red.
     */
    public static final Pixel RED = new Pixel(255, 0, 0);

    /**
     * The {@code Pixel} representing the RGB color green.
     */
    public static final Pixel GREEN = new Pixel(0, 255, 0);

    /**
     * The {@code Pixel} representing the RGB color white.
     */
    public static final Pixel WHITE = new Pixel(255, 255, 255);

    private final int r;
    private final int g;
    private final int b;

    /**
     * Create a new pixel with the provided color components.
     * <p>
     * If the provided components are not between 0 and 255,
     * they are clipped. Negative components are set to 0,
     * and components greater than 255 are set to 255.
     *
     * @param r the red component of the pixel
     * @param g the green component of the pixel
     * @param b the blue component of the pixel
     */
    public Pixel(int r, int g, int b) {
        // Implement this constructor
        // red component r
        if (0 > r) {
            this.r = 0;
        } else {
            this.r = Math.min(r, 255);
        }

        // green component g
        if (0 > g) {
            this.g = 0;
        } else {
            this.g = Math.min(g, 255);
        }

        // blue component b
        if (0 > b) {
            this.b = 0;
        } else {
            this.b = Math.min(b, 255);
        }
    }

    /**
     * Create a new pixel with the provided color components, specified as an
     * array. The index {@code c[0]} corresponds to {@code Pixel}'s red
     * component; {@code c[1]} its green component, and {@code c[2]} its blue
     * component.
     * <p>
     * If {@code c} is null or has fewer than 3 entries, the missing
     * components are set to 0. If {@code c} has more than 3 entries, the extra
     * entries are ignored. If the provided components are not between 0 and
     * 255, they are clipped. Negative components are set to 0, and
     * components greater than 255 are set to 255.
     * <p>
     * This constructor must not throw any exceptions.
     *
     * @param c the array of components
     */
    public Pixel(int[] c) {
        // Implement this constructor
        if (0 == c.length) {
            r = 0;
            g = 0;
            b = 0;
        } else if (1 == c.length) {
            if (0 > c[0]) {
                r = 0;
            } else {
                r = Math.min(c[0], 255);
            }
            g = 0;
            b = 0;
        } else if (2 == c.length) {
            if (0 > c[0]) {
                r = 0;
            } else {
                r = Math.min(c[0], 255);
            }
            if (0 > c[1]) {
                g = 0;
            } else {
                g = Math.min(c[1], 255);
            }
            b = 0;
        } else {
            if (0 > c[0]) {
                r = 0;
            } else {
                r = Math.min(c[0], 255);
            }
            if (0 > c[1]) {
                g = 0;
            } else {
                g = Math.min(c[1], 255);
            }
            if (0 > c[2]) {
                b = 0;
            } else {
                b = Math.min(c[2], 255);
            }
        }
    }

    /**
     * Accessor for the red component of the pixel.
     *
     * @return the int value of the red component
     */
    public int getRed() {
        // Implement this method
        return r;
    }

    /**
     * Accessor for the green component of the pixel.
     *
     * @return the int value of the green component
     */
    public int getGreen() {
        // Implement this method
        return g;
    }

    /**
     * Accessor for the blue component of the pixel.
     *
     * @return the int value of the blue component
     */
    public int getBlue() {
        // Implement this method
        return b;
    }

    /**
     * Accessor for the pixel's components as an array of 3 integers, where
     * index 0 is red, index 1 is green, and index 2 is blue.
     * <p>
     * Note that this method should not break encapsulation.
     *
     * @return an int array representing the pixel's components
     */
    public int[] getComponents() {
        // Implement this method
        return new int[]{r, g, b};
    }

    /**
     * Determines the level of similarity between this pixel and another by
     * summing the absolute values of the differences between corresponding
     * components of the two pixels. Distance to a null pixel is defined as -1.
     * <p>
     * Hint: use {@code Math.abs}
     *
     * @param px the other pixel with which to compare
     * @return the sum of the differences in each of the color components
     */
    public int distance(Pixel px) {
        // Implement this method
        if (null == px) {
            return -1;
        } else {
            return Math.abs(r - px.r) + Math.abs(g - px.g) + Math.abs(b - px.b);
        }
    }

    /**
     * Returns a string representation of this pixel. The string should
     * comma separate the rgb values and surround them with parentheses.
     * <p>
     * For example, {@code RED.toString()} is {@code "(255, 0, 0)"}
     * <p>
     * Note: This function will allow you to print pixels in a readable format.
     * This can be very helpful while debugging, and we highly encourage you to
     * use print statements to aid your debugging throughout this assignment.
     *
     * @return a string representation of this pixel
     */
    @Override
    public String toString() {
        // Implement this method
        return "(" + r + ", " + g + ", " + b + ")";
    }

    /**
     * Compares the RGB values of the current Pixel with another to check if
     * they are the same (and thus whether the two Pixels equal each other)
     *
     * @param px The pixel being compared with this
     * @return whether the two pixels contain the same components
     */
    public boolean sameRGB(Pixel px) {
        // Implement this method
        if (null == px) {
            return false;
        } else {
            return r == px.r && g == px.g && b == px.b;
        }
    }

    /* ---------------- Don't modify below this line ------------------ */

    /**
     * Checks whether this pixel has the same components as the given Object.
     * If the other object is not a Pixel, then the method returns false.
     */
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (getClass() == other.getClass()) {
            return this.sameRGB((Pixel) other);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h = 0;
        int[] components = getComponents();

        for (int k = 0; k < components.length; k++) {
            h += k * 255 + components[k];
        }
        return h;
    }

    @Override
    public int compareTo(Pixel o) {
        int rc = this.r - o.r;
        int gc = g - o.g;
        int bc = this.b - o.b;

        if (0 != rc) {
            return rc;
        } else if (0 != gc) {
            return gc;
        } else {
            return bc;
        }
    }
}