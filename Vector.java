public class Vector extends Matrix {
    public Vector(int c) {
        super(1, c);
    }

    public Vector(int c, double[] linArr) {
        super(1, c, linArr);
//  calls super to access to create a "Matrix" type object with zero rows inputting 1 for the row, int c for columns
//  and lastly the linArr single array from this Vector class.

    }

    public double getElement(int c) {

        return this.getElement(0, c);
//  This returns the element from the current vector object that inherits from the Matrix Class.
    }
}
