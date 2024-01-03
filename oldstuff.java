//public class oldstuff {
//    public class MarkovChain {
//        private Vector stateVector;
//        private Matrix transitionMatrix;
//
//        public MarkovChain(Vector sVector, Matrix tMatrix) {
//            this.stateVector = sVector;
//            this.transitionMatrix = tMatrix;
//        }
//
//        public boolean isValid() {
//            double totalSV = 0;
//            double totalTM = 0;
//            if (transitionMatrix.getNumRows() == transitionMatrix.getNumCols() && transitionMatrix.getNumCols() == stateVector.getNumCols()) {
//                for (int i = 0; i < stateVector.getNumCols(); i++) {
//                    totalSV += stateVector.getElement(i);
//                }
//                for (int b = 0; b < transitionMatrix.getNumRows(); b++) {
//                    totalTM = 0;
//                    for (int c = 0; c < transitionMatrix.getNumCols(); c++) {
//                        totalTM += transitionMatrix.getElement(b, c);
//                    }
//                    if (!(totalSV > 0.99 && totalSV < 1.01 && totalTM > 0.99 && totalTM < 1.01)) {
//                        return false;
//                    }
//                    return true;
//                }
//            } else {
//                return false;
//            }
//            return true;
//        }
//
//
//
//
//
//        public Matrix computeProbabilityMatrix(int numSteps) {
//            if (!isValid()) {
//                return null;
//            }
//            Matrix tranOriginal = transitionMatrix.multiply(1);
//            for (int i = 0; i < (numSteps - 1); i++) {
//
//                transitionMatrix = transitionMatrix.multiply(tranOriginal);
//            }
//            Matrix result = stateVector.multiply(transitionMatrix);
//            transitionMatrix = tranOriginal;
//            return result;
//        }
//
//    }
//
//}
