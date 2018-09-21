package tCRDT.counter;

import generic.concurrency.Policy;

public class MaxWritePolicy implements Policy<CounterOperation> {

    public static final String NAME = "maxW";

    @Override
    public String getName() {
        return NAME;
    }

    private boolean maxPolicy(CounterOperation op, CounterOperation otherOp) {
        return op.getType() == SetValueOperation.SET_VALUE && otherOp.getType() == SetValueOperation.SET_VALUE &&
                (otherOp.getSelfPolicyName().equals(MinWritePolicy.NAME) || otherOp.getSelfPolicyName().equals(MinMergePolicy.NAME) ||
                  ((op.getSelfPolicyName().equals(MaxWritePolicy.NAME) || op.getSelfPolicyName().equals(MaxMergePolicy.NAME)) &&
                    ((SetValueOperation)op).getValue() > ((SetValueOperation)otherOp).getValue()));
    }

    private boolean writePolicy(CounterOperation op, CounterOperation otherOp) {
        return otherOp.getType() != SetValueOperation.SET_VALUE;
    }

    @Override
    public Boolean apply(CounterOperation op, CounterOperation otherOp) {
        return writePolicy(op, otherOp) || maxPolicy(op, otherOp);
    }
}
