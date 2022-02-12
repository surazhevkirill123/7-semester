import java.util.*;

public class Task2 {
    public static List<Double> firstList = new ArrayList<>(Arrays.asList(-7.0, 4.0, 12.0, 4.0, 12.0, 4.0, 4.0, -7.0,
            4.0, 4.0, -7.0, 4.0, 12.0, 4.0, -7.0, 4.0, 12.0, 4.0, -7.0, 4.0, 12.0, 4.0, 12.0, 12.0, -7.0, -7.0, 12.0,
            -7.0, 4.0, 12.0, 12.0, 12.0, 12.0, 12.0, 12.0, -7.0, 4.0, 12.0, 4.0, 12.0, 4.0, 4.0, 12.0, -7.0, 4.0, 4.0,
            12.0, 12.0, 4.0, 4.0, 4.0, 12.0, 12.0, 12.0, 4.0, 12.0, 12.0, 12.0, 4.0, 12.0, 4.0, 12.0, -7.0, 12.0, 12.0,
            -7.0, 12.0, 12.0, 4.0, 12.0, 12.0, 12.0, -7.0, 12.0, -7.0, 4.0, 12.0, 12.0, 12.0, 12.0, 12.0, 12.0, -7.0,
            12.0, 12.0, 12.0, 12.0, 4.0, 12.0, 12.0, 4.0, 4.0, 12.0, 4.0, 12.0, -7.0, 12.0, 4.0, 12.0, 12.0
    ));


    public static void main(String[] args) {
        Collections.sort(firstList);
        List<Double> secondList = new ArrayList<>(Arrays.asList(-7.0, 4.0, 12.0));
        TreeMap<Double, Double> sampleDistribution = CommonFunctions.getSampleDistribution(firstList, secondList);
        TreeMap<Double, Double> empiricalFunction = CommonFunctions.getEmpiricalFunction(sampleDistribution);
        TreeMap<Double, Double> probabilities = CommonFunctions.getProbabilities(firstList);
        DrawingPointGraph.doPointGraph(probabilities);
        DrawingGraph.doGraph(empiricalFunction);
        System.out.println("Математическое ожидание:\t" + CommonFunctions.getExpectedValue(probabilities));
        System.out.println("Дисперсия:\t" + CommonFunctions.getDispersion(probabilities));
    }
}
