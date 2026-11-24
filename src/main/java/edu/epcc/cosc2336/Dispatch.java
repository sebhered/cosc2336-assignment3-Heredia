package edu.epcc.cosc2336;

import edu.epcc.cosc2336.ds.CallQueue;
import edu.epcc.cosc2336.ds.RoadNetwork;
import edu.epcc.cosc2336.ds.UnitTable;
import edu.epcc.cosc2336.impl.CallQueueImpl;
import edu.epcc.cosc2336.impl.RoadNetworkImpl;
import edu.epcc.cosc2336.impl.UnitTableImpl;
import edu.epcc.cosc2336.io.CsvLoader;

/**
 * RapidResponse dispatch driver (Part B4).
 *
 * Usage:
 *   java -cp target/classes edu.epcc.cosc2336.Dispatch
 *     -> defaults: data/roads.csv  data/units.csv  data/calls.csv
 *
 *   java -cp target/classes edu.epcc.cosc2336.Dispatch \
 *        data/roads.csv data/units.csv data/calls_small.csv
 *
 * Output format (one line per dispatched call, printed to stdout):
 *
 *   CALL=<call_id> UNIT=<unit_id> ROUTE=<n1->n2->...->nK> TIME=<min to 2 decimals>
 *
 * If no reachable available unit exists for a call, print:
 *
 *   CALL=<call_id> UNIT=NONE ROUTE= TIME=
 */
public class Dispatch {

    public static void main(String[] args) {
        String roadsPath = args.length > 0 ? args[0] : "data/roads.csv";
        String unitsPath = args.length > 1 ? args[1] : "data/units.csv";
        String callsPath = args.length > 2 ? args[2] : "data/calls.csv";

        CallQueue  queue = new CallQueueImpl();
        UnitTable  units = new UnitTableImpl();
        RoadNetwork roads = new RoadNetworkImpl();

        try {
            CsvLoader.loadRoads(roadsPath, roads);
            CsvLoader.loadUnits(unitsPath, units);
            CsvLoader.loadCalls(callsPath, queue);
        } catch (Exception e) {
            System.err.println("Could not load input: " + e.getMessage());
            System.exit(1);
        }

        // TODO (B4): implement the dispatch loop described in the assignment PDF.
        // Use the three data structures above; the required output format is
        // documented in this class's Javadoc.
    }
}
