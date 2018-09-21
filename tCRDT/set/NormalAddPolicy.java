package tCRDT.set;

import generic.concurrency.Policy;

public class NormalAddPolicy implements Policy<SetOperation> {

    public static final String NAME = "nAdd";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(SetOperation op, SetOperation otherOp) {
        return op.getElement().equals(otherOp.getElement()) && op.getType() == SetOperation.ADD &&
        otherOp.getType() == SetOperation.REMOVE && otherOp.getSelfPolicyName().equals(NormalRemovePolicy.NAME);
    }
}
