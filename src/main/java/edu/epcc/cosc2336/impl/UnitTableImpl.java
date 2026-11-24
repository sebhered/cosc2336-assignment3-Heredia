package edu.epcc.cosc2336.impl;

import edu.epcc.cosc2336.ds.UnitTable;
import edu.epcc.cosc2336.model.Unit;
import edu.epcc.cosc2336.model.UnitStatus;

/**
 * TODO (Part B3): implement a hash table from scratch.
 *
 * Requirements:
 *   - Key is the unit ID (String).
 *   - Average O(1) insert, find, update, remove.
 *   - Document (right here in this comment) the hash function you chose
 *     and the collision strategy. Separate chaining with a linked list of
 *     entries is a reasonable choice.
 *   - Resize when loadFactor() exceeds 0.75 (typically: double the bucket
 *     count, rehash every entry).
 *   - all() iterates every currently-stored Unit (order does not matter).
 *
 * Suggested fields:
 *   private Entry[] buckets;   // Entry = { String key, Unit value, Entry next }
 *   private int size;          // number of live entries
 *
 * Testing hints (Part C1):
 *   - find() on a missing ID must return null (not throw).
 *   - update-then-find must reflect the new status.
 *   - After enough inserts to trigger a resize, all previous keys must
 *     still be findable and loadFactor() must drop back below 0.75.
 *   - You can force collisions by inserting keys you know hash to the same
 *     bucket, then verify all of them are retrievable.
 */
public class UnitTableImpl implements UnitTable {

    @Override
    public void insert(String id, Unit unit) {
        throw new UnsupportedOperationException("TODO: implement insert");
    }

    @Override
    public Unit find(String id) {
        throw new UnsupportedOperationException("TODO: implement find");
    }

    @Override
    public void updateStatus(String id, UnitStatus status) {
        throw new UnsupportedOperationException("TODO: implement updateStatus");
    }

    @Override
    public void remove(String id) {
        throw new UnsupportedOperationException("TODO: implement remove");
    }

    @Override
    public double loadFactor() {
        throw new UnsupportedOperationException("TODO: implement loadFactor");
    }

    @Override
    public Iterable<Unit> all() {
        throw new UnsupportedOperationException("TODO: implement all");
    }
}
