package tCRDT.counter;

import generic.concurrency.Policy;

public class MaxMergePolicy implements Policy<CounterOperation> {

    public static final String NAME = "maxM";

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

    //Note: merge policy always returns false, so it's not necessary to call or define it

    @Override
    public Boolean apply(CounterOperation op, CounterOperation otherOp) {
        return maxPolicy(op, otherOp);
    }

}
