package tCRDT.set;

import generic.concurrency.Policy;

public class PriorityRemovePolicy implements Policy<SetOperation> {

    public static final String NAME = "pRem";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(SetOperation op, SetOperation otherOp) {
        return op.getElement().equals(otherOp.getElement()) && op.getType() == SetOperation.REMOVE &&
                otherOp.getType() == SetOperation.ADD && otherOp.getSelfPolicyName().equals(NormalAddPolicy.NAME);
    }
}
