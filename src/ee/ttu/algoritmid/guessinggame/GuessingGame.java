package ee.ttu.algoritmid.guessinggame;

public class GuessingGame {

    Oracle oracle;

    public GuessingGame(Oracle oracle) {
        this.oracle = oracle;
    }

    /**
     * @param cityArray - All the possible cities.
     * @return the name of the city.
     */
    public String play(City[] cityArray) {

        cityArray = mergeSort(cityArray);

        int low = 0;
        int high = cityArray.length - 1;
        int mid = (low + high) / 2;

        City firstGuess = cityArray[mid];
        String isIt = oracle.isIt(firstGuess);

        while (!isIt.equals("correct!")) {
            System.out.println("Is it " + firstGuess.getName() + "?");
            if (isIt.equals("higher population")) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            System.out.println(isIt);
            mid = (low + high) / 2;
            firstGuess = cityArray[mid];
            isIt = oracle.isIt(firstGuess);
        }
        System.out.println("Is it " + firstGuess.getName() + "?");
        return isIt + "It's " + firstGuess.getName() + "!";
    }

    private static City[] mergeSort(City[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        City[] left = new City[mid];
        City[] right;

        if (array.length % 2 == 0) {
            right = new City[mid];
        } else {
            right = new City[mid + 1];
        }
        for (int i = 0; i < right.length; i++) {
            left[i] = array[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = array[mid + j];
        }
        City[] result;

        left = mergeSort(left);
        right = mergeSort(right);

        result = merge(left, right);

        return result;
    }

    private static City[] merge(City[] left, City[] right) {
        City[] result = new City[left.length + right.length];

        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer].getPopulation() < right[rightPointer].getPopulation()) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }
}
