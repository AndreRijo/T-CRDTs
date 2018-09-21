package tCRDT.set;

import generic.concurrency.Clock;
import generic.concurrency.History;
import generic.concurrency.Policy;
import tCRDT.TCRDT;

import java.util.Set;

public interface TSetInterface extends TCRDT<SetOperation> {

    SetOperation add(History hist, Policy<SetOperation> hb, Policy<SetOperation> selfPolicy, Policy<SetOperation> otherPolicy, String element, Clock clk);

    SetOperation remove(History hist, Policy<SetOperation> hb, Policy<SetOperation> selfPolicy, Policy<SetOperation> otherPolicy, String element, Clock clk);

    /**
     * <b>Pre-condition</b>: the policies used don't allow an add(element) and remove(element) to be both non-obsolete simultaneously.
     *
     * This contains may do optimizations such as returning earlier if it finds a remove(element). It should still respect the expected
     * contains semantics.
     * @param element - the element to search for
     * @return true, if there's an add(element) that isn't obsolete; false, if there's an remove(element) that isn't obsolete or no add(element) is found.
     */
    boolean lookup(String element);

    /**
     * This lookup should correspond exactly to the one in the specification, i.e., it will ignore any remove(element).
     * @param element - the element to search for
     * @return true, if there's an add(element) that isn't obsolete; false, otherwise.
     */
    boolean originalLookup(String element);

    Set<String> elements();

}
