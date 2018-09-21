package tCRDT.counter;

import generic.concurrency.History;
import generic.concurrency.Policy;

public class DecrementOperation extends CounterOperation {

    public static final char DEC = 'd';

    public DecrementOperation(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy,
                              Policy<CounterOperation> otherPolicy) {
        super(hist, hb, selfPolicy, otherPolicy, DEC);
    }

}
