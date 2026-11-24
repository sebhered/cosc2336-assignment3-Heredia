package edu.epcc.cosc2336.ds;

import edu.epcc.cosc2336.model.Call;

/**
 * Priority queue of emergency calls, ordered by:
 *   1. Highest severity first (5 is most severe).
 *   2. Ties broken by earlier arrival time (the earlier call wins).
 *
 * Implement as a binary heap. Do NOT use java.util.PriorityQueue.
 */
public interface CallQueue {

    /** Insert a call. */
    void push(Call call);

    /** Remove and return the highest-priority call. */
    Call pop();

    /** Look at (but do not remove) the highest-priority call. */
    Call peek();

    /** Number of calls currently waiting. */
    int size();

    /** True iff size() == 0. */
    boolean empty();
}
