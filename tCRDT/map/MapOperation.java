package tCRDT.map;

import generic.concurrency.Clock;
import generic.concurrency.History;
import generic.concurrency.Policy;
import generic.operations.GenericIdOpInterface;
import generic.operations.GenericOperation;

/**
 * Note: This class can't be instantiated. Instead, use AddMapOperation or RemMapOperation
 */
public abstract class MapOperation extends GenericOperation implements GenericIdOpInterface {

    private char type;
    private String key;
    private Clock clock;

    public MapOperation(History hist, Policy<MapOperation> hb, Policy<MapOperation> selfPolicy,
                        Policy<MapOperation> otherPolicy, char type, String key, Clock clock) {
        super(hist, hb, selfPolicy, otherPolicy);
        this.type = type;
        this.key = key;
        this.clock = clock;
    }

    public String getId() { return key; }

    public char getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public Clock getClock() {
        return clock;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[type: ").append(type);
        string.append(", hbPolicy: ").append(super.getHbName());
        string.append(", selfPolicy: ").append(super.getSelfPolicyName());
        string.append(", otherPolicy: ").append(super.getOtherPolicyName());
        string.append(", key: ").append(key);
        string.append(", clock: ").append(clock.toString());
        return string.toString();
    }

}
