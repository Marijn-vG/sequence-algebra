package mvg.patterns;

import mvg.patterns.analysis.Analyzer;
import mvg.patterns.analysis.Sequence;
import mvg.patterns.generation.Generator;


public class Main {

    public static void main(String[] args) {

        double[] input_pattern = {2, 4, 6, 9};

        double[] pattern = Generator.generateSimpleSequence(
                (double prev, int n) -> 1*prev + 2*n + 3,
                1,
                10);

        double[] pattern_2 = Generator.generateExtendedSimpleSequence(
                (double prev1, double prev2, int n) -> -1*prev1 + 2*prev2 + 2*n + 2,
                2, 3,
                50);

        Sequence active_sequence = new Sequence( input_pattern );

        System.out.println(active_sequence);
//        System.out.println( new Sequence(pattern_2) );
//        System.out.println(active_sequence.getDifferences());
//        System.out.println(active_sequence.getDifferences().getDifferences());
//        System.out.println(active_sequence.getDifferences().getDifferences().getDifferences());
//        Analyzer.printSimpleSequenceRule(new Sequence(pattern_2));
        float[] parameters = Analyzer.getParametersSimpleSequence(active_sequence);
        for(float number: parameters){
            System.out.println(number);
        }
    }
}