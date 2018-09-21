package tCRDT.set;

import generic.concurrency.Clock;
import generic.concurrency.History;
import generic.concurrency.Policy;
import generic.operations.GenericIdOpInterface;
import generic.operations.GenericOperation;

public class SetOperation extends GenericOperation implements GenericIdOpInterface {

    //type names
    public static final char ADD = 'a';
    public static final char REMOVE = 'r';

    private char type;
    private String element;
    private Clock clock;

    public SetOperation(History hist, Policy<SetOperation> hb, Policy<SetOperation> selfPolicy,
                        Policy<SetOperation> otherPolicy, char type, String element, Clock clock) {
        super(hist, hb, selfPolicy, otherPolicy);
        this.type = type;
        this.element = element;
        this.clock = clock;
    }

    public String getId() { return element; }

    public char getType() {
        return type;
    }

    public String getElement() {
        return element;
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
        string.append(", element: ").append(element);
        string.append(", clock: ").append(clock.toString()).append("]");
        return string.toString();
    }

}
