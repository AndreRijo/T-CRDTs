package tCRDT.map;

import generic.concurrency.Policy;

public class MapMVPolicy implements Policy<MapOperation> {

    public static final String NAME = "mMV";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(MapOperation op, MapOperation otherOp) {
        return false;
    }

}
