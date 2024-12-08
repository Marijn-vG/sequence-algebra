package mvg.patterns;

import mvg.patterns.analysis.Analyzer;
import mvg.patterns.analysis.Sequence;
import mvg.patterns.generation.Generator;


public class Main {

    public static void main(String[] args) {

        double[] pattern = Generator.generateSimpleSequence(
                (double prev, int n) -> 1*prev + 2*n + 3,
                1,
                10);

        double[] pattern_2 = Generator.generateExtendedSimpleSequence(
                (double prev1, double prev2, int n) -> -2*prev1 - 1*prev2 + 0*n + 0,
                1, -2,
                50);

        double[] input_pattern = {0, 4, 5, 9, 8};

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