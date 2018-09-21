package tCRDT.map;

import generic.concurrency.Policy;

public class MapAddWinsPolicy implements Policy<MapOperation> {

    public static final String NAME = "mAdd";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(MapOperation op, MapOperation otherOp) {
        return op.getKey().equals(otherOp.getKey()) && op.getType() == AddMapOperation.ADD &&
                otherOp.getType() == RemMapOperation.REMOVE;
    }

}
