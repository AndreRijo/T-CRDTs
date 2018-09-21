package tCRDT.counter;

import generic.concurrency.Policy;

public class HbIncDecPolicy implements Policy<CounterOperation> {

    public static final String NAME = "hbID";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(CounterOperation op, CounterOperation otherOp) {
        return false;
    }
}
