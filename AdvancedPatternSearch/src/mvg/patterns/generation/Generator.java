package mvg.patterns.generation;

public class Generator {
    public static double[] generateSimpleSequence(SequenceRule rule, double startingPoint, int steps) {

        double[] pattern = new double[steps+1];
        pattern[0] = startingPoint;

        for(int i = 1; i < steps+1; i++){
            pattern[i] = rule.get_next(pattern[i-1], i-1);
        }

        return pattern;
    }

    public static double[] generateExtendedSimpleSequence(ExtendedRule rule,
                                                          double startingPoint0,
                                                          double startingPoint1,
                                                          int steps) {

        double[] pattern = new double[steps+2];
        pattern[0] = startingPoint0;
        pattern[1] = startingPoint1;

        for(int i = 2; i < steps+2; i++){
            pattern[i] = rule.get_next(pattern[i-1], pattern[i-2], i-1);
        }

        return pattern;
    }
}
