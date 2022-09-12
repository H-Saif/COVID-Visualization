package prj5;


/**
 * 
 * @author Hamza Saif
 * @version 2022.04.22
 *
 */

public class RaceTest extends student.TestCase {
    private Race r;

    /**
     * sets up test cases
     */
    public void setUp() {
        r = new Race("asian", 10, 10);
    }


    /**
     * This method is used to
     * test the get name method.
     */
    public void testgetName() {
        assertEquals(r.getName(), "asian");
    }


    /**
     * This method is used to
     * test get cases.
     */
    public void testgetCases() {
        assertEquals(r.getCases(), 10);
    }


    /**
     * This method is used to test
     * get death.
     */
    public void testgetDeath() {
        assertEquals(r.getDeath(), 10);
    }


    /**
     * This method is used to
     * test calc CFR.
     */
    public void testcalcCFR() {
        assertEquals(100.0, r.calcCFR(), 0.1);

        Race r1 = new Race("black", -1, 10);
        assertEquals(-1.0, r1.calcCFR(), 0.1);

        Race r2 = new Race("black", 10, -1);
        assertEquals(-1.0, r2.calcCFR(), 0.1);
    }


    /**
     * This method is used to
     * test to string.
     */
    public void testtoString() {
        assertEquals("asian: 10 cases, 100% CFR", r.toString());
    }
}
