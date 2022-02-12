import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CommonFunctions {
    public static List<Double> getSecondList(List<Double> firstList) {
        double amountOfNumbers = 20.0;
        double maxNumber = 0;
        double minNumber = 0;
        for (Double number : firstList) {
            if (maxNumber < number)
                maxNumber = number;
            if (minNumber > number)
                minNumber = number;
        }
        double segmentLength = (maxNumber - minNumber) / amountOfNumbers;
        List<Double> secondList = new ArrayList<>();
        for (int i = 0; i <= amountOfNumbers; i++) {
            secondList.add(minNumber + i * segmentLength);
        }
        return secondList;
    }

    public static TreeMap<Double, Double> getSampleDistribution(List<Double> firstList, List<Double> secondList) {
        //по схеме точка = количество чисел, которые <=опорная точка, но > предыдущая опорная точка(так в лекциях)
        TreeMap<Double, Double> sampleDistribution = new TreeMap<>();
        for (int i=0;i<secondList.size();i++) {
            sampleDistribution.put(secondList.get(i), 0.0);
            for (int j=0;j<firstList.size();j++) {
                if(i==0 && firstList.get(j) <= secondList.get(i)){
                    sampleDistribution.put(secondList.get(i), sampleDistribution.get(secondList.get(i)) + 1);
                }
                if (i!=0 && firstList.get(j) <= secondList.get(i) && firstList.get(j) > secondList.get(i-1)) {
                    sampleDistribution.put(secondList.get(i), sampleDistribution.get(secondList.get(i)) + 1);
                }
            }
        }
        return sampleDistribution;
    }


    public static TreeMap<Double, Double> getEmpiricalFunction(TreeMap<Double, Double> sampleDistribution) {
        List<Double> x = new ArrayList(sampleDistribution.keySet());
        List<Double> y = new ArrayList(sampleDistribution.values());
        double sampleSize = 0;
        for (Double number : y) {
            sampleSize += number;
        }
        TreeMap<Double, Double> empiricalFunction = new TreeMap<>();
        double adder = 0.0;
        for (int i = 0; i < sampleDistribution.size(); i++) {
            adder+=y.get(i) / sampleSize;
            empiricalFunction.put(x.get(i), adder);
        }
        return empiricalFunction;
    }

    public static TreeMap<Double, Double> getProbabilities(List<Double> firstList) {
        TreeMap<Double, Double> probabilities = new TreeMap<>();
        for (Double number : firstList) {
            if (!probabilities.containsKey(number)) {
                probabilities.put(number, 1.0 / (double) firstList.size());
            } else {
                probabilities.put(number, probabilities.get(number) + (1.0 / (double) firstList.size()));
            }
        }
        return probabilities;
    }

    public static Double getExpectedValue(TreeMap<Double, Double> probabilities) {
        List<Double> x = new ArrayList(probabilities.keySet());
        List<Double> y = new ArrayList(probabilities.values());
        double expectedValue = 0.0;
        for (int i = 0; i < x.size(); i++) {
            expectedValue += x.get(i) * y.get(i);
        }
        return expectedValue;
    }

    public static Double getDispersion(TreeMap<Double, Double> probabilities) {
        List<Double> x = new ArrayList(probabilities.keySet());
        List<Double> y = new ArrayList(probabilities.values());
        double expectedValue = 0.0;
        for (int i = 0; i < x.size(); i++) {
            expectedValue += x.get(i) * y.get(i);
        }
        Double expectedValue1 = 0.0;
        for (int i = 0; i < x.size(); i++) {
            expectedValue1 += Math.pow(x.get(i), 2) * y.get(i);
        }
        Double expectedValue2 = Math.pow(expectedValue, 2);
        return expectedValue1 - expectedValue2;
    }

}
