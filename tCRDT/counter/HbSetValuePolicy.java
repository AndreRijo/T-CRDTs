package tCRDT.counter;

import generic.concurrency.Policy;

public class HbSetValuePolicy implements Policy<CounterOperation> {

    public static final String NAME = "hbSV";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(CounterOperation op, CounterOperation otherOp) {
        return true;
    }

}
