package edu.epcc.cosc2336.io;

import edu.epcc.cosc2336.ds.CallQueue;
import edu.epcc.cosc2336.ds.RoadNetwork;
import edu.epcc.cosc2336.ds.UnitTable;
import edu.epcc.cosc2336.model.Call;
import edu.epcc.cosc2336.model.Unit;
import edu.epcc.cosc2336.model.UnitStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * CSV loaders for the three data files. Provided for you so you can focus on
 * the data structures instead of CSV parsing. Each loader:
 *   - skips the header row,
 *   - trims whitespace around each field,
 *   - skips blank lines,
 *   - throws IOException with the file and line number on a malformed row.
 */
public final class CsvLoader {

    private CsvLoader() { }

    public static void loadRoads(String path, RoadNetwork roads) throws IOException {
        try (BufferedReader r = Files.newBufferedReader(Path.of(path))) {
            r.readLine(); // header
            String line;
            int ln = 1;
            while ((line = r.readLine()) != null) {
                ln++;
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                if (p.length != 4) {
                    throw new IOException(path + ":" + ln
                            + " expected 4 columns, got " + p.length);
                }
                try {
                    int from = Integer.parseInt(p[0].trim());
                    int to   = Integer.parseInt(p[1].trim());
                    double m = Double.parseDouble(p[2].trim());
                    boolean oneWay = "Y".equalsIgnoreCase(p[3].trim());
                    roads.addRoad(from, to, m, oneWay);
                } catch (NumberFormatException e) {
                    throw new IOException(path + ":" + ln + " malformed row: " + line, e);
                }
            }
        }
    }

    public static void loadUnits(String path, UnitTable table) throws IOException {
        try (BufferedReader r = Files.newBufferedReader(Path.of(path))) {
            r.readLine(); // header
            String line;
            int ln = 1;
            while ((line = r.readLine()) != null) {
                ln++;
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                if (p.length != 4) {
                    throw new IOException(path + ":" + ln
                            + " expected 4 columns, got " + p.length);
                }
                try {
                    String id = p[0].trim();
                    String type = p[1].trim();
                    UnitStatus status = UnitStatus.valueOf(p[2].trim());
                    int station = Integer.parseInt(p[3].trim());
                    table.insert(id, new Unit(id, type, status, station));
                } catch (IllegalArgumentException e) {
                    throw new IOException(path + ":" + ln + " malformed row: " + line, e);
                }
            }
        }
    }

    public static void loadCalls(String path, CallQueue queue) throws IOException {
        try (BufferedReader r = Files.newBufferedReader(Path.of(path))) {
            r.readLine(); // header
            String line;
            int ln = 1;
            while ((line = r.readLine()) != null) {
                ln++;
                if (line.isBlank()) continue;
                String[] p = line.split(",");
                if (p.length != 4) {
                    throw new IOException(path + ":" + ln
                            + " expected 4 columns, got " + p.length);
                }
                try {
                    String id = p[0].trim();
                    String arr = p[1].trim();
                    int sev = Integer.parseInt(p[2].trim());
                    int loc = Integer.parseInt(p[3].trim());
                    queue.push(new Call(id, arr, sev, loc));
                } catch (NumberFormatException e) {
                    throw new IOException(path + ":" + ln + " malformed row: " + line, e);
                }
            }
        }
    }
}
