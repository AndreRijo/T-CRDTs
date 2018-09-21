package tCRDT.set;

import generic.concurrency.Policy;

public class NormalRemovePolicy implements Policy<SetOperation> {

    public static final String NAME = "nRem";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(SetOperation setOperation, SetOperation setOperation2) {
        return false;
    }
}
