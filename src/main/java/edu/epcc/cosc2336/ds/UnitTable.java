package edu.epcc.cosc2336.ds;

import edu.epcc.cosc2336.model.Unit;
import edu.epcc.cosc2336.model.UnitStatus;

/**
 * Hash table keyed by unit ID (for example, "AMB-0417").
 *
 * Implement with your own hash function and collision strategy. Resize
 * (typically double the bucket count and rehash) whenever the load factor
 * exceeds 0.75.
 *
 * Do NOT use java.util.HashMap, Hashtable, or TreeMap.
 */
public interface UnitTable {

    /** Insert a unit. Behavior on duplicate key is up to you — document it. */
    void insert(String id, Unit unit);

    /** Return the Unit with this id, or null if absent. */
    Unit find(String id);

    /** Update the status of the unit with this id. No-op if absent. */
    void updateStatus(String id, UnitStatus status);

    /** Remove the unit with this id. No-op if absent. */
    void remove(String id);

    /** Current load factor: (number of entries) / (number of buckets). */
    double loadFactor();

    /**
     * Iterate every unit currently in the table. Order does not matter.
     * Used by the dispatcher to scan for the nearest available unit.
     */
    Iterable<Unit> all();
}
