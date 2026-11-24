package edu.epcc.cosc2336.impl;

import edu.epcc.cosc2336.ds.CallQueue;
import edu.epcc.cosc2336.model.Call;

/**
 * TODO (Part B3): implement a binary max-heap of Call.
 *
 * Priority rules (highest first):
 *   - higher severity wins;
 *   - equal severity: earlier arrival time wins.
 *   The arrival time is stored as "HH:MM:SS" — plain String compare works.
 *
 * Suggested fields:
 *   private final ArrayList<Call> heap = new ArrayList<>();
 *     (index 0 is the root)
 *
 * Suggested private helpers:
 *   int parent(int i)   { return (i - 1) / 2; }
 *   int left(int i)     { return 2 * i + 1; }
 *   int right(int i)    { return 2 * i + 2; }
 *   void siftUp(int i)
 *   void siftDown(int i)
 *   int compare(Call a, Call b)   // returns positive if 'a' has higher priority
 *
 * Testing hints (Part C1):
 *   - pop() on an empty queue should throw (document which exception).
 *   - Equal-severity calls must come out in arrival order.
 *   - Push 10,000 random calls; pop them all; the sequence must be
 *     non-increasing in priority.
 */
public class CallQueueImpl implements CallQueue {

    @Override
    public void push(Call call) {
        throw new UnsupportedOperationException("TODO: implement push");
    }

    @Override
    public Call pop() {
        throw new UnsupportedOperationException("TODO: implement pop");
    }

    @Override
    public Call peek() {
        throw new UnsupportedOperationException("TODO: implement peek");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("TODO: implement size");
    }

    @Override
    public boolean empty() {
        throw new UnsupportedOperationException("TODO: implement empty");
    }
}
