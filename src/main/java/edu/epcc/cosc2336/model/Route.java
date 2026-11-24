package edu.epcc.cosc2336.model;

import java.util.Collections;
import java.util.List;

/**
 * Result of a shortest-path query.
 *
 * Use {@link #of(List, double)} when a path exists (the list must start at
 * the source and end at the destination). Use {@link #unreachable()} when
 * the destination is not reachable.
 *
 * For a query where src == dest, return {@code Route.of(List.of(src), 0.0)}.
 */
public final class Route {

    private final List<Integer> path;
    private final double totalMinutes;
    private final boolean reachable;

    private Route(List<Integer> path, double totalMinutes, boolean reachable) {
        this.path = path;
        this.totalMinutes = totalMinutes;
        this.reachable = reachable;
    }

    public static Route of(List<Integer> path, double totalMinutes) {
        return new Route(List.copyOf(path), totalMinutes, true);
    }

    public static Route unreachable() {
        return new Route(Collections.emptyList(), Double.POSITIVE_INFINITY, false);
    }

    public List<Integer> getPath()    { return path; }
    public double getTotalMinutes()   { return totalMinutes; }
    public boolean isReachable()      { return reachable; }
}
