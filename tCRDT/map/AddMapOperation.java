package tCRDT.map;

import generic.concurrency.History;
import generic.concurrency.Policy;
import generic.concurrency.Clock;

public class AddMapOperation extends MapOperation {

    public static final char ADD = 'a';

    private String element;

    public AddMapOperation(History hist, Policy<MapOperation> hb, Policy<MapOperation> selfPolicy,
                             Policy<MapOperation> otherPolicy, String key, String element, Clock clock) {
        super(hist, hb, selfPolicy, otherPolicy, ADD, key, clock);
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[type: ").append(super.getType());
        string.append(", hbPolicy: ").append(super.getHbName());
        string.append(", selfPolicy: ").append(super.getSelfPolicyName());
        string.append(", otherPolicy: ").append(super.getOtherPolicyName());
        string.append(", key: ").append(super.getKey());
        string.append(", element: ").append(element);
        string.append(", clock: ").append(super.getClock().toString()).append("]");
        return string.toString();
    }

}
