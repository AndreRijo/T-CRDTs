package tCRDT.map;

import generic.concurrency.Clock;
import generic.concurrency.History;
import generic.concurrency.Policy;
import tCRDT.TCRDT;

import java.util.Set;

public interface TMapInterface extends TCRDT<MapOperation> {

    //Note: The same value can be used for both clock and history.
    //The history here is an argument since it is intended to be something externally controlled (such as a VectorClock) instead of the real operation history,
    //as that would be too inefficient.
    AddMapOperation add(History hist, Policy<MapOperation> hb, Policy<MapOperation> selfPolicy, Policy<MapOperation> otherPolicy, String key, String element, Clock clk);

    RemMapOperation remove(History hist, Policy<MapOperation> hb, Policy<MapOperation> selfPolicy, Policy<MapOperation> otherPolicy, String key, Clock clk);

    /**
     * <b>Pre-condition</b>: the policies used don't allow an add(key, value) and remove(key) to be both non-obsolete simultaneously.
     * This contains may do optimizations such as returning earlier if it finds a remove(key). It should still respect the expected
     * contains semantics.
     * @param key - the key to search for
     * @return true, if there's an add(key) that isn't obsolete; false, if there's an remove(key) that isn't obsolete or no add(key) is found.
     */
    boolean contains(String key);

    /**
     * This contains should correspond exactly to the one in the specification, i.e., ignore any remove(key).
     * @param key - the key to search for
     * @return true, if there's an add(key) that isn't obsolete; false, otherwise.
     */
    boolean originalContains(String key);

    /**
     * A different version of <b>get</b> that assumes that, for each key, at most one add is non-obsolete.
     * If such condition is not met, then any of the elements associated to the key can be returned.
     * @param key - the key to search for
     * @return the element associated to the key, if it exists; null otherwise
     */
    public String singleGet(String key);

    /**
     * An implementation of this method is allowed to return multiple elements, depending on the policy.
     * An element is considered to be associated to the key if there is at least one non-obsolete add which contains both the key and element. Removes are ignored.
     * @param key - the key to search for
     * @return the element(s) associated to the key, if it exists; null if a remove with that key exists or no operation referring to the key is found.
     */
    Set<String> get(String key);

    Set<String> keys();

    Set<String> elements();

}
