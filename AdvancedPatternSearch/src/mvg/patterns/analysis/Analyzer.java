package mvg.patterns.analysis;


public class Analyzer {
    public static float[] getParametersSimpleSequence(Sequence sequence){
        // Return the parameters [t, v, w] for a_(n+1) = t*a_n + v*n + w

        if (sequence.sequence.length < 4) {
            throw new IllegalArgumentException("Given sequence is not long enough. Provide at least 4 values.");
        }

        Sequence step_1 = sequence.getDifferences();
        if (step_1.isConstant()){
            return new float[] {1, 0, (float) step_1.sequence[0]};
        }

        if (step_1.truncateFirst().isConstant()){
            return new float[] {0, (float) step_1.sequence[1], (float) sequence.sequence[1]};
        }

        Sequence step_2 = step_1.getDifferences();
        Sequence step_3;
        try {
            step_3 = step_2.getQuotients();
        } catch(ArithmeticException e) {
            throw new IllegalArgumentException("Given sequence is not a simple sequence");
        }
        if(!step_3.isConstant()) {
            throw new IllegalArgumentException("Given sequence is not a simple sequence");
        }

        float t = (float) step_3.sequence[0];
        float v = (float) (step_1.sequence[1] - t*step_1.sequence[0]);
        float w = (float) (sequence.sequence[1] - t*sequence.sequence[0]);

        return new float[] {t, v, w};
    }

    public static void printSimpleSequenceRule(Sequence sequence){
        float[] parameters = getParametersSimpleSequence(sequence);
        float t = parameters[0];
        float v = parameters[1];
        float w = parameters[2];

        StringBuilder rule = new StringBuilder();
        rule.append("a_{n+1} = ");
        if (t != 0){
            rule.append(t);
            rule.append("*a_{n}");
            if (v != 0 || w != 0){
                rule.append(" + ");
            }
        }
        if (v != 0){
            rule.append(v);
            rule.append("*n");
            if (w != 0){
                rule.append(" + ");
            }
        }
        if (w != 0){
            rule.append(w);
        }

        System.out.println(rule);
    }

    public static float[] getParametersExtendedSequence(Sequence sequence){
        // Return the parameters [t, u, v, w] for a_(n+1) = t*a_n + u*a_{n-1} + v*n + w

        double[] sec = sequence.sequence;

        if (sec.length < 5) {
            throw new IllegalArgumentException("Given sequence is not long enough. Provide at least 5 values.");
        }

        if (sec[1]*sec[1] == sec[2]*sec[0]) {

            if (sec[1] == 0 || sec[0] == 0){
                throw new IllegalArgumentException("Given sequence is not an extended simple sequence");
            }

            return new float[] {(float) (sec[1] / sec[0]), 0, 0, 0};
        }

        Sequence step_1 = sequence.getDifferences();
        Sequence step_2 = step_1.getDifferences();

        double[] sec1 = step_1.sequence;
        double[] sec2 = step_2.sequence;

        double denominator = sec2[2]*sec2[0] - sec2[1]*sec2[1];

        float t = (float) ( (sec2[0]*sec2[3] - sec2[1]*sec2[2]) / denominator );
        float u = (float) ( (sec2[2]*sec2[2] - sec2[1]*sec2[3]) / denominator );
        float v = (float) ( sec1[2] - t*sec1[1] - u*sec1[0] );
        float w = (float) ( sec[2] - sec1[2] + t*(sec1[1] - sec[1]) + u*(sec1[0] - sec[0]) );

        return new float[] {t, u, v, w};
    }
}
