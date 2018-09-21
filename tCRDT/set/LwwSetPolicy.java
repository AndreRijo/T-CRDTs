package tCRDT.set;

import generic.concurrency.Policy;

public class LwwSetPolicy implements Policy<SetOperation> {

    public static final String NAME = "lww";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(SetOperation op, SetOperation otherOp) {
        return op.getElement().equals(otherOp.getElement()) && op.getSelfPolicyName().equals(NAME) &&
                (!otherOp.getSelfPolicyName().equals(NAME) || op.getClock().compareTo(otherOp.getClock()) > 0);
    }
}
