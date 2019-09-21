package ee.ttu.algoritmid.guessinggame;

public class Main {

    public static void main(String[] args) {
        //Madrid, Berlin, Yokohama, Giza, Hong Kong, New York, Tokyo, Dehli

        City[] listOfCities = new City[]{
                new City("Dehli", 16787941),
                new City("Berlin", 3671000),
                new City("Madrid", 3207247),
                new City("Hong Kong", 7298600),
                new City("New York", 8537673),
                new City("Tokyo", 13513734),
                new City("Giza", 4239988),
                new City("Yokohama", 3726167)
        };
        int[] cities = new int[]{1, 6, 4, 2, 8, 13, 89, 45, 23, 78, 28};

        GuessingGame guessingGame = new GuessingGame(new Oracle(listOfCities[4])); //New York
        String newGame = guessingGame.play(listOfCities);
        System.out.println(newGame);

    }
}
