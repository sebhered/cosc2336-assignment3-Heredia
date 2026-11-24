package edu.epcc.cosc2336.ds;

import edu.epcc.cosc2336.model.Route;

/**
 * Weighted directed graph of the road network.
 *
 * Use an adjacency list — the road network is sparse (edges roughly 3x nodes),
 * so an adjacency list uses O(V + E) space instead of O(V^2).
 *
 * For addRoad:
 *   - oneWay == true  : add from -> to only.
 *   - oneWay == false : add BOTH from -> to AND to -> from.
 *
 * For shortestPath, use Dijkstra's algorithm. Return Route.unreachable()
 * when dest cannot be reached from src. When src == dest, return
 * Route.of(List.of(src), 0.0).
 *
 * Do NOT use any graph library (JGraphT, etc.).
 */
public interface RoadNetwork {

    void addRoad(int from, int to, double minutes, boolean oneWay);

    Route shortestPath(int src, int dest);
}
