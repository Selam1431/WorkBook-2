import java.util.Arrays;
public class testStatistics {
    public static void main(String[] args) {

        int[] scores= {80, 90, 75, 92, 85, 76, 94, 89, 83, 95};

        double average = calculateAverage(scores);

        Arrays.sort(scores);

        int highest = findHighest(scores);

        int lowest = findLowest(scores);

        double median = calculateMedian(scores);


        System.out.println("Average: " + average);
        System.out.println("High score: " + highest);
        System.out.println("Low Score; " + lowest);
        System.out.println("Median: " + median);





    }

    public static double calculateAverage(int[] scores) {

        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.length;

    }

    public static int findHighest(int[] scores) {

        return scores[scores.length - 1];

    }

    public static int findLowest(int[] scores) {
        return scores[0];

    }

    public static double calculateMedian(int[] scores) {
        int middle = scores.length / 2;

        if (scores.length % 2 == 0) {
            return (scores[middle - 1] + scores[middle]) / 2.0;
        } else {
            return scores[middle];
        }

    }


}
