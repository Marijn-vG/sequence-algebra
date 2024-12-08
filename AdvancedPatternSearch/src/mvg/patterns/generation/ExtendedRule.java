package mvg.patterns.generation;

@FunctionalInterface
public interface ExtendedRule {

    double get_next(double previousValue1, double previousValue2, int index);

}
