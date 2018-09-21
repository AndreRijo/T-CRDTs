package tCRDT.counter;

import generic.concurrency.History;
import generic.concurrency.Policy;

public class SetValueOperation extends CounterOperation {

    public static final char SET_VALUE = 's';

    private int value;

    public SetValueOperation(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy,
                            Policy<CounterOperation> otherPolicy, int value) {
        super(hist, hb, selfPolicy, otherPolicy, SET_VALUE);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[type: ").append(super.getType());
        string.append(", hbPolicy: ").append(super.getHbName());
        string.append(", selfPolicy: ").append(super.getSelfPolicyName());
        string.append(", otherPolicy: ").append(super.getOtherPolicyName());
        string.append(", history: ").append(super.getHistory().toString());
        string.append(", value: ").append(value).append("]");
        return string.toString();
    }

}
