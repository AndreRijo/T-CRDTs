package tCRDT.counter;

import generic.concurrency.Policy;

public class MinWritePolicy implements Policy<CounterOperation> {

    public static final String NAME = "minW";

    @Override
    public String getName() {
        return NAME;
    }

    private boolean minPolicy(CounterOperation op, CounterOperation otherOp) {
        return op.getType() == SetValueOperation.SET_VALUE && otherOp.getType() == SetValueOperation.SET_VALUE &&
                !otherOp.getSelfPolicyName().equals(MaxWritePolicy.NAME) && !otherOp.getSelfPolicyName().equals(MaxMergePolicy.NAME) &&
                  ((SetValueOperation)op).getValue() < ((SetValueOperation)otherOp).getValue();
    }

    private boolean writePolicy(CounterOperation op, CounterOperation otherOp) {
        return otherOp.getType() != SetValueOperation.SET_VALUE;
    }

    @Override
    public Boolean apply(CounterOperation op, CounterOperation otherOp) {
        return writePolicy(op, otherOp) || minPolicy(op, otherOp);
    }
}
