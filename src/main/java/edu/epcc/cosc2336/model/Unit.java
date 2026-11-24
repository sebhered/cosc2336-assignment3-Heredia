package edu.epcc.cosc2336.model;

/**
 * A response unit (ambulance, fire engine, patrol car).
 * Status is mutable; everything else is fixed at creation.
 */
public final class Unit {

    private final String id;
    private final String type;
    private UnitStatus status;
    private final int stationNode;

    public Unit(String id, String type, UnitStatus status, int stationNode) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.stationNode = stationNode;
    }

    public String getId()              { return id; }
    public String getType()            { return type; }
    public UnitStatus getStatus()      { return status; }
    public void setStatus(UnitStatus s){ this.status = s; }
    public int getStationNode()        { return stationNode; }

    @Override
    public String toString() {
        return "Unit{" + id + ", " + type + ", " + status
                + ", station=" + stationNode + "}";
    }
}
