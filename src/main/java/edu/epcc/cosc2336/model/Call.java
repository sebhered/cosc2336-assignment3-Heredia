package edu.epcc.cosc2336.model;

/**
 * A single emergency call waiting to be dispatched.
 * Immutable — once created, fields do not change.
 */
public final class Call {

    private final String id;
    private final String arrivalTime;   // "HH:MM:SS" — lexicographically comparable
    private final int severity;         // 1 = least, 5 = most severe
    private final int locationNode;

    public Call(String id, String arrivalTime, int severity, int locationNode) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.severity = severity;
        this.locationNode = locationNode;
    }

    public String getId()            { return id; }
    public String getArrivalTime()   { return arrivalTime; }
    public int getSeverity()         { return severity; }
    public int getLocationNode()     { return locationNode; }

    @Override
    public String toString() {
        return "Call{" + id + ", sev=" + severity
                + ", arrived=" + arrivalTime + ", at=" + locationNode + "}";
    }
}
