package tCRDT.set;

import generic.concurrency.Policy;

public class HbSetPolicy implements Policy<SetOperation> {

    public static final String NAME = "hbSet";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(SetOperation op, SetOperation otherOp) {
        return op.getElement().equals(otherOp.getElement());
    }
}
