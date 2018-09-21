package tCRDT.counter;

import generic.models.GenericCRDT;
import generic.concurrency.History;
import generic.concurrency.Policy;

import java.util.Set;

public class TCounterCRDT implements TCounterInterface {

    private GenericCRDT<CounterOperation> crdt;

    public TCounterCRDT(boolean cache) {
        crdt = new GenericCRDT<>(cache);
    }

    public void downstream(CounterOperation op) {
        crdt.addOp(op);
    }

    public IncrementOperation increment(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy, Policy<CounterOperation> otherPolicy) {
        IncrementOperation op = new IncrementOperation(hist, hb, selfPolicy, otherPolicy);
        crdt.addOp(op);
        return op;
    }

    public DecrementOperation decrement(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy, Policy<CounterOperation> otherPolicy) {
        DecrementOperation op = new DecrementOperation(hist, hb, selfPolicy, otherPolicy);
        crdt.addOp(op);
        return op;
    }

    public SetValueOperation setValue(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy, Policy<CounterOperation> otherPolicy, int value) {
        SetValueOperation op = new SetValueOperation(hist, hb, selfPolicy, otherPolicy, value);
        crdt.addOp(op);
        return op;
    }

    /**
     * <b>Pre-condition</b>: the policies used don't allow two setValues with different value to be both non-obsolete
     * @return the value of the non-obsolete setValue (if any) + all incs - all decs that happened-after it.
     */
    public int value() {
        Set<CounterOperation> nonObs = crdt.calculateState();
        //It is acceptable for multiple setValues with the same value to be present in the non-obsolete state
        int nSetValuesFound = 0;
        int value = 0;
        int setValue = 0;
        SetValueOperation currSetValue = null;
        for (CounterOperation op: nonObs) {
            if (op.getType() == IncrementOperation.INC)
                value++;
            else if (op.getType() == DecrementOperation.DEC)
                value--;
            else {
                currSetValue = (SetValueOperation) op;
                setValue = currSetValue.getValue();
                value += setValue;
                nSetValuesFound++;
            }
        }
        return value - ((nSetValuesFound - 1) * setValue);
    }

    //TODO: Remove
    public Set<CounterOperation> getOps() {
        return crdt.getOps();
    }

    //TODO: Remove
    public Set<CounterOperation> getNonObsoleteOps() {
        return crdt.calculateState();
    }
}