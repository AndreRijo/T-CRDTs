package tCRDT.map;

import generic.concurrency.Policy;

public class MapRemWinsPolicy implements Policy<MapOperation> {

    public static final String NAME = "mRem";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(MapOperation op, MapOperation otherOp) {
        return op.getKey().equals(otherOp.getKey()) && op.getType() == RemMapOperation.REMOVE &&
                otherOp.getType() == AddMapOperation.ADD;
    }

}
