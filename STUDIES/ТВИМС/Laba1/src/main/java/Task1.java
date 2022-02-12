import java.util.*;

public class Task1 {
    public static List<Double> firstList = new ArrayList<>(Arrays.asList(1.064204983, -2.999010453, 1.546983512, 2.736596647,
            -0.52210937, 2.955247229, 1.412885552, 5.103396419, 0.551660292, -1.151616731, 5.805182103, -0.706612959,
            1.76825769, 1.742116283, 6.620996523, -0.851369713, 0.448888309, 2.431791358, -0.346877713, 5.35078068,
            3.393553325, -4.753291746, 0.249939304, 2.44395999, 3.822355274, -2.221113763, -4.317079438, 5.042072916,
            3.393411394, 2.941121525, 0.440216921, -0.384302029, 1.308567841, 4.210849284, 1.618969521, -3.066999117,
            -1.965557471, 5.186835078, 4.600100164, 0.221495702, -0.676809691, 0.038493164, -1.198815027, 2.10491622,
            -3.120054708, 0.390715292, 9.168750749, 1.814534416, 0.013259918, 5.524661965, 1.459778504, 3.402419506,
            1.174841971, 8.569989151, -0.041995261, 0.307954375, 0.189010578, 12.67696016, 4.320355782, 6.009100595,
            -0.117255386, -5.733005827, 1.271178251, 3.39346684, 2.247397313, 1.719067252, 3.394706552, 0.667212976,
            0.987828506, 2.12897489, -5.285890298, -2.195962721, 2.815934686, 4.51022571, -0.909654119, -1.465404675,
            -1.071109868, -3.544431543, 5.318759721, 5.274924531, 1.399511973, -2.899738318, -3.919193156, -0.819125727,
            -0.153215787, -0.171369598, 4.315201239, -0.535772436, -3.730406312, 1.898023999, 2.733520097, -0.958100523,
            2.386414372, -1.851100095, 1.914859688, -1.651932879, -3.600436641, 0.629058323, 3.413311993, -0.296729292
    ));


    public static void main(String[] args) {
        Collections.sort(firstList);
        List<Double> secondList = CommonFunctions.getSecondList(firstList);
        TreeMap<Double, Double> sampleDistribution = CommonFunctions.getSampleDistribution(firstList, secondList);
        TreeMap<Double, Double> empiricalFunction = CommonFunctions.getEmpiricalFunction(sampleDistribution);
        DrawingGraph.doGraph(empiricalFunction);
        DrawingBarGraph.doBarGraph(sampleDistribution);
        TreeMap<Double, Double> probabilities = CommonFunctions.getProbabilities(firstList);
        System.out.println("Математическое ожидание:\t" + CommonFunctions.getExpectedValue(probabilities));
        System.out.println("Дисперсия:\t" + CommonFunctions.getDispersion(probabilities));
    }
}
