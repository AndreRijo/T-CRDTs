package tCRDT.map;

import generic.concurrency.History;
import generic.concurrency.Policy;
import generic.concurrency.Clock;

public class RemMapOperation extends MapOperation {

    public static final char REMOVE = 'r';

    public RemMapOperation(History hist, Policy<MapOperation> hb, Policy<MapOperation> selfPolicy,
                           Policy<MapOperation> otherPolicy, String key, Clock clock) {
        super(hist, hb, selfPolicy, otherPolicy, REMOVE, key, clock);
    }

}
