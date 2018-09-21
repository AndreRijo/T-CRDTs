package tCRDT.counter;

import generic.concurrency.Policy;

public class MinMergePolicy implements Policy<CounterOperation> {

    public static final String NAME = "minM";

    @Override
    public String getName() {
        return NAME;
    }

    private boolean minPolicy(CounterOperation op, CounterOperation otherOp) {
        return op.getType() == SetValueOperation.SET_VALUE && otherOp.getType() == SetValueOperation.SET_VALUE &&
                !otherOp.getSelfPolicyName().equals(MaxWritePolicy.NAME) && !otherOp.getSelfPolicyName().equals(MaxMergePolicy.NAME) &&
                  ((SetValueOperation)op).getValue() < ((SetValueOperation)otherOp).getValue();
    }

    //Note: merge policy always returns false, so it's not necessary to call or define it

    @Override
    public Boolean apply(CounterOperation op, CounterOperation otherOp) {
        return minPolicy(op, otherOp);
    }

}
