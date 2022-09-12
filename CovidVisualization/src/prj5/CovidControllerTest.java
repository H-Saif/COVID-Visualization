/**
 * 
 */
package prj5;

/**
 * @author Hamza Saif
 * @version 2022.03.20
 *
 */
public class CovidControllerTest extends student.TestCase {
    private CovidController con;

    /**
     * sets up tests
     */
    public void setUp() {
        SinglyLinkedList<Race> races = new SinglyLinkedList<Race>();
        int casesWhite = 10;
        int casesBlack = 10;
        int casesLatino = 10;
        int casesAsian = 10;
        int casesOther = 10;
        int deathsWhite = 1;
        int deathsBlack = 2;
        int deathsLatino = 3;
        int deathsAsian = 4;
        int deathsOther = 5;
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
        SinglyLinkedList<State> states = new SinglyLinkedList<State>();
        State va = new State("VA", races);
        states.add(va);
        con = new CovidController(states);
    }


    /**
     * test sortAlpha()
     */
    public void testSortAlpha() {
        System.out.println(con.sortAlpha());
        String r = "{asian: 10 cases, 40% CFR\r\n"
            + "black: 10 cases, 20% CFR\r\n" + "latino: 10 cases, 30% CFR\r\n"
            + "other: 10 cases, 50% CFR\r\n" + "white: 10 cases, 10% CFR\n====}";
        assertEquals(con.sortAlpha().toString(), r);
    }


    /**
     * test sortCFR()
     */
    public void testSortCFR() {
        String s = "{other: 10 cases, 50% CFR\r\n"
            + "asian: 10 cases, 40% CFR\r\n" + "latino: 10 cases, 30% CFR\r\n"
            + "black: 10 cases, 20% CFR\r\n" + "white: 10 cases, 10% CFR\r\n"
            + "====}";
        assertEquals(con.sortCFR(), s);
    }



}
