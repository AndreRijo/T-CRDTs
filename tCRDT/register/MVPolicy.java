package tCRDT.register;

import generic.concurrency.Policy;

public class MVPolicy implements Policy<RegisterOperation> {

    public static final String NAME = "mv";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(RegisterOperation op, RegisterOperation otherOp) {
        return false;
    }
}