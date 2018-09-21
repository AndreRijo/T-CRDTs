package tCRDT.counter;

import generic.concurrency.History;
import generic.concurrency.Policy;

public class IncrementOperation extends CounterOperation {

    public static final char INC = 'i';

    public IncrementOperation(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy,
                            Policy<CounterOperation> otherPolicy) {
        super(hist, hb, selfPolicy, otherPolicy, INC);
    }
}
