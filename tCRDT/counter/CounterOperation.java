package tCRDT.counter;

import generic.operations.GenericOperation;
import generic.concurrency.History;
import generic.concurrency.Policy;

/**
 * Note: This class can't be instantiated. Instead, use IncOperation, DecOperation or SetValueOperation
 */
public abstract class CounterOperation extends GenericOperation {

    private char type;

    public CounterOperation(History hist, Policy<CounterOperation> hb, Policy<CounterOperation> selfPolicy,
                             Policy<CounterOperation> otherPolicy, char type) {
        super(hist, hb, selfPolicy, otherPolicy);
        this.type = type;
    }

    public char getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[type: ").append(type);
        string.append(", hbPolicy: ").append(super.getHbName());
        string.append(", selfPolicy: ").append(super.getSelfPolicyName());
        string.append(", otherPolicy: ").append(super.getOtherPolicyName());
        string.append(", hist: ").append(super.getHistory().toString()).append("]");
        return string.toString();
    }
}
