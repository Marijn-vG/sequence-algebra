package mvg.patterns.generation;

@FunctionalInterface
public interface SequenceRule {

    double get_next(double previousValue, int index);

}
