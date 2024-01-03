public class MarkovChain {
    private Vector stateVector;
    private Matrix transitionMatrix;

    public MarkovChain(Vector sVector, Matrix tMatrix) {
        this.stateVector = sVector;
        this.transitionMatrix = tMatrix;
    }
// Establishing sVector and tMatrix.

    public boolean isValid() {
        double totalSV = 0;
        double totalTM = 0;
        int counter = 0;
        if (transitionMatrix.getNumRows() == transitionMatrix.getNumCols() && transitionMatrix.getNumCols() == stateVector.getNumCols()) {
            for (int i = 0; i < stateVector.getNumCols(); i++) {
                totalSV += stateVector.getElement(i);
            }
            if (totalSV != 1.0) {
            return false;
//  Since state vector is 1 row it checks to see if its sum is 1.0 if not return false.
            }
            for (int b = 0; b < transitionMatrix.getNumRows(); b++) {
                totalTM = 0;
                for (int c = 0; c < transitionMatrix.getNumCols(); c++) {
                    totalTM += transitionMatrix.getElement(b, c);
                }
                if (totalTM > 0.99 && totalTM < 1.01) {
                    counter = 1;
                } else {
                    counter = 0;
                    return false;
                }
            } if (counter ==1) {
                return true;
//  The first for loop goes into the rows of the transition matrix if total of state vector is 1.
//  Second for loop checks and gets the values in each column of the row and adds it to a total.
//  If the total of all the elements in each row of the transition matrix is 1.0 then return counter=1 each time.
//  If counter=0 this means one of the rows totaled to a number that is not within our range of 0.99 and 1.01.
//  If our counter value at the end of the for loop is still counter=1 then this means true therefore we return true.
            }else {
                return false;
//  If our counter value is not 1 return false.
            }
        }else{
            return false;
        }
//  If anything in the if statement is not what we put inside of it meaning does not adhere to these patterns, we quit
//  our large if statement and return false.
    }





    public Matrix computeProbabilityMatrix(int numSteps) {
        if (!isValid()) {
            return null;
//  Immediately return null if isValid is not true.
        }
        Matrix tranOriginal = transitionMatrix.multiply(1);
//  We want to keep the original matrix, so we assign it under a different number with it multiplied by a scalar of 1.
        for (int i = 0; i < (numSteps - 1); i++) {

            transitionMatrix = transitionMatrix.multiply(tranOriginal);
//  As instructed we go from 0 to numSteps-1, and we multiply the transition matrix by the original we made.
        }
        Matrix result = stateVector.multiply(transitionMatrix);
        transitionMatrix = tranOriginal;
        return result;
//  Lastly, we make a new result Matrix object and this will multiply our stateVector by our transitionMatrix we just
//  made, then we return probability matrix.
    }

}
