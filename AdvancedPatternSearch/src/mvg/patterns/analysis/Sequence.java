package mvg.patterns.analysis;
import java.util.Arrays;


public class Sequence {
    double[] sequence;

    public Sequence(double[] start_sequence){
        sequence = start_sequence;
    }

    @Override
    public String toString() {

        String strSequence = "";
        for (double num : sequence) {
            if (num % 1 == 0) {
                strSequence += String.valueOf((int) num);
            } else {
                strSequence += String.valueOf(num);
            }
            strSequence += " ";
        }

        return strSequence;
    }

    public Sequence getDifferences() {

        int steps = sequence.length;
        double[] differences = new double[steps - 1];

        for(int i = 1; i < steps; i++){
            differences[i-1] = sequence[i] - sequence[i-1];
        }

        return new Sequence(differences);
    }

    public Sequence getQuotients() {

        int steps = sequence.length;
        double[] quotients = new double[steps - 1];

        for(int i = 1; i < steps; i++){
            if (sequence[i-1] != 0) {
                quotients[i - 1] = sequence[i] / sequence[i - 1];
            } else {
                throw new ArithmeticException("Non-finite expression encountered");
            }
        }

        return new Sequence(quotients);
    }

    public boolean isConstant() {

        for (double num : sequence) {
            if (num != sequence[0]) {
                return false;
            }
        }

        return true;
    }

    public Sequence truncateFirst(){
        double[] truncatedSequence = Arrays.copyOfRange(sequence, 1, sequence.length);
        return new Sequence(truncatedSequence);
    }
}
