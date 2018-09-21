package tCRDT.counter;

import generic.concurrency.Policy;

public class DummyPolicy implements Policy<CounterOperation> {

    public static final String NAME = "d";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(CounterOperation counterOperation, CounterOperation counterOperation2) {
        return false;
    }
}
