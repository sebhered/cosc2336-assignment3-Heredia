package edu.epcc.cosc2336;

import edu.epcc.cosc2336.model.Call;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Smoke test — proves JUnit 5 is wired up and the build runs tests.
 * Delete me once your real tests are in place.
 */
class SampleTest {

    @Test
    void callHoldsItsFields() {
        Call c = new Call("C-001", "08:00:00", 5, 4);
        assertEquals("C-001", c.getId());
        assertEquals(5, c.getSeverity());
        assertEquals(4, c.getLocationNode());
        assertEquals("08:00:00", c.getArrivalTime());
    }
}
