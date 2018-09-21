package tCRDT.counter;

import generic.concurrency.History;
import generic.concurrency.Policy;
import tCRDT.TCRDT;

public interface TCounterInterface extends TCRDT<CounterOperation> {

    IncrementOperation increment(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy, Policy<CounterOperation> otherPolicy);

    DecrementOperation decrement(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy, Policy<CounterOperation> otherPolicy);

    SetValueOperation setValue(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy, Policy<CounterOperation> otherPolicy, int value);

    int value();
}
