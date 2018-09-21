package tCRDT.map;

import generic.concurrency.Policy;

public class HbMapPolicy implements Policy<MapOperation> {

    public static final String NAME = "hbMap";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(MapOperation op, MapOperation otherOp) {
        return op.getKey().equals(otherOp.getKey());
    }

}

