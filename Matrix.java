import java.lang.reflect.Array;
import java.util.Arrays;

public class Matrix {
    private int numRows;
    private int numCols;
    private double[][] data;
// Creating instance variables for the Matrix Class.
    public Matrix(int r, int c) {
        numRows = r;
        numCols = c;
        data = new double[r][c];
//  Establishing our r and c parameters
//  declaring data as a new double that creates an array with the values of r as rows and c as columns
    }

    public Matrix(int r, int c, double[] linArr) {
        numRows = r;
        numCols = c;
        data = new double[r][c];
        int counter = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                data[i][j] = linArr[counter];
                counter++;
//  This takes the value of data at row i column j and sets its equal to the linArr value at the counter value position.
//  The counter increases by 1 each time it goes to the next value of data[i][j].
            }
        }

    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public double[][] getData() {
        return data;
    }

    public double getElement(int r, int c) {
        return data[r][c];
    }

    public double setElement(int r, int c, double value) {
        return data[r][c] = value;
    }
//  Getters and setters.

    public void transpose() {
        double[][] dataCopy = data.clone();
        data = new double[this.numCols][this.numRows];
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numCols; j++) {
                data[j][i] = dataCopy[i][j];
            }
        }
        this.numRows = data.length;
        this.numCols = data[0].length;
//  We clone data so that it does not override "this" it essentially copies it.
//  We take data that we made in Matrix and we flip it so the number of columns and rows are swapped with each other.
//  This means number of columns is now number of rows and vice versa.
//  Following this dataCopy is the new transposed matrix as it takes all the first values of each row and sets them in
//  dataCopy as the values of a row in dataCopy
//  Ex: 1 7   will become   1 2 4
//      2 6                 7 6 5
//      4 5
    }

    public Matrix multiply(double scalar) {
        Matrix matrix = new Matrix(numRows, numCols);

        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numCols; j++) {
                matrix.setElement(i, j, scalar * (data[i][j]));
//  this is the scalar multiplication version of multiply where we multiply the value of data[i][j] with whatever the
//  scalar is.
            }
        }

        return matrix;
    }

    public Matrix multiply(Matrix other) {
        if (this.numCols != other.numRows)
            return null;
        else {
            double substitute = 0;
            Matrix matrix2 = new Matrix(this.numRows, other.getNumCols());
            for (int i = 0; i < this.numRows; i++) {
                for (int j = 0; j < getNumCols(); j++) {
                    for (int k = 0; k < this.numCols; k++) {
                        substitute += (data[i][k]) * other.getElement(k, j);
                    }
                    matrix2.setElement(i, j, substitute);
                    substitute = 0;
//  first for loop goes through each  column, second for loop goes through each row, third will into the set of numbers
//  that it needs to multiply with. Substitute is used to reset to 0 for the next series of multiplication.
                }
            }
            return matrix2;
//  returns our new matrix.
        }
    }

    public String toString() {
        if (data.length == 0) {
            return "Empty matrix";
        }
        StringBuilder matrixContents = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrixContents.append(String.format("%8.3f", data[i][j]));
//  Used a string builder here. This will go our what is in our matrix and format it to 8 characters
//  and 3 decimal places
            }
            matrixContents.append("\n");
//  new line after each value
        }
        return matrixContents.toString();
//  all of our matrixContents that are appended go through our toString function to create a string version of it.
        }
}
