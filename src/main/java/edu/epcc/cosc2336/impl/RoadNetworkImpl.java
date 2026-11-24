package edu.epcc.cosc2336.impl;

import edu.epcc.cosc2336.ds.RoadNetwork;
import edu.epcc.cosc2336.model.Route;

/**
 * TODO (Part B3): implement a weighted directed graph with Dijkstra's
 * shortest-path algorithm.
 *
 * Representation:
 *   - Adjacency list. For each node, hold a list of outgoing edges
 *     (neighbor + weight). A road network with ~500 intersections and
 *     ~1,400 roads is sparse, so adjacency list beats adjacency matrix.
 *
 * addRoad:
 *   - oneWay == true  : add from -> to only.
 *   - oneWay == false : add BOTH from -> to AND to -> from.
 *
 * shortestPath:
 *   - Use Dijkstra with a min-priority queue keyed on current distance.
 *     You can (and should!) reuse your heap work from CallQueueImpl —
 *     this is the "dependency" question from Part A3.
 *   - Reconstruct the path from a prev[] array populated during the
 *     search.
 *   - Return Route.of(path, totalMinutes) on success.
 *   - Return Route.unreachable() when dest can't be reached.
 *   - When src == dest, return Route.of(List.of(src), 0.0).
 *
 * Testing hints (Part C1):
 *   - A one-way road must NOT be traversable backward.
 *   - An unreachable destination must return Route.unreachable().
 *   - src == dest must return a path of length 1 and time 0.
 *   - Build a small hand-checked graph (the rubric specifically asks for
 *     a 6-node graph with a known shortest path).
 */
public class RoadNetworkImpl implements RoadNetwork {

    @Override
    public void addRoad(int from, int to, double minutes, boolean oneWay) {
        throw new UnsupportedOperationException("TODO: implement addRoad");
    }

    @Override
    public Route shortestPath(int src, int dest) {
        throw new UnsupportedOperationException("TODO: implement shortestPath");
    }
}
