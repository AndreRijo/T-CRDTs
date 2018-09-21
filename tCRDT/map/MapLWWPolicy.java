package tCRDT.map;

import generic.concurrency.Policy;

public class MapLWWPolicy implements Policy<MapOperation> {

    public static final String NAME = "mLWW";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Boolean apply(MapOperation op, MapOperation otherOp) {
        return op.getKey().equals(otherOp.getKey()) && op.getSelfPolicyName().equals(NAME) &&
                (otherOp.getSelfPolicyName().equals(MapMVPolicy.NAME) ||
                    (otherOp.getSelfPolicyName().equals(NAME) && op.getClock().compareTo(otherOp.getClock()) > 0));
    }

}
