package prj5;



/**
 * This class is used to
 * test state.
 * 
 * @author Hamza Saif (hsaif)
 * @version 2022.04.22
 */
public class StateTest extends student.TestCase {
    private SinglyLinkedList<Race> races = new SinglyLinkedList<Race>();
    private State va;

    /**
     * This method is used to
     * setup object.
     */
    public void setUp() {
        String stateName = "VA";
        int casesWhite = 10;
        int casesBlack = 10;
        int casesLatino = 10;
        int casesAsian = 10;
        int casesOther = 10;
        int deathsWhite = 10;
        int deathsBlack = 10;
        int deathsLatino = 10;
        int deathsAsian = 10;
        int deathsOther = 10;
        String white = "white";
        String black = "black";
        String latino = "latino";
        String asian = "asian";
        String other = "other";

        Race whites = new Race(white, casesWhite, deathsWhite);
        Race blacks = new Race(black, casesBlack, deathsBlack);
        Race latinos = new Race(latino, casesLatino, deathsLatino);
        Race asians = new Race(asian, casesAsian, deathsAsian);
        Race others = new Race(other, casesOther, deathsOther);
        races.add(whites);
        races.add(blacks);
        races.add(latinos);
        races.add(asians);
        races.add(others);
        va = new State(stateName, races);
    }


    /**
     * This method is used to test
     * get name.
     */
    public void testGetName() {
        assertEquals("VA", va.getName());
    }


    /**
     * This method is used to
     * test set name.
     */
    public void testSetName() {
        va.setName("PA");
        assertEquals("PA", va.getName());
    }


    /**
     * This method is used to test
     * to string.
     */
    public void testToString() {
        assertEquals("white: 10 cases, 100% CFR\r\n"
            + "black: 10 cases, 100% CFR\r\n" + "latino: 10 cases, 100% CFR\r\n"
            + "asian: 10 cases, 100% CFR\r\n" + "other: 10 cases, 100% CFR\r\n"
            + "====", va.toString());
    }


    /**
     * This method is used to test get list.
     */
    public void testgetList() {
        assertEquals(va.getList(), races);
    }
}
