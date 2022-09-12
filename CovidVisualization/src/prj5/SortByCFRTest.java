package prj5;

/**
 * This class is used to test
 * sort by CFR.
 * 
 * @author Hamza Saif (hsaif)
 * @version 2022.04.20
 */
public class SortByCFRTest extends student.TestCase {
    private Race r;
    private Race r1;
    private Race r2;
    private Race rCopy1;
    private Race rCopy2;
    private Race rCopy3;
    private Race rCopy4;

    



    private SortByCFR cc;

    /**
     * sets up cases
     */
    public void setUp() {
        r = new Race("alack", 200, 20);
        rCopy1 = new Race("black", 200, 20);
        rCopy3 = new Race("black", 200, 20);
        rCopy4 = new Race("zlack", 200, 20);

        rCopy2 = new Race("clack", 200, 20);

        r1 = new Race("black", 400, 20);
        r2 = new Race("other", 100, 20);


        cc = new SortByCFR();
    }


    /**
     * This method is used to
     * test sort by alpha.
     */
    public void testcompare() {
        assertEquals(cc.compare(r, r1), -1); // <0
        assertEquals(cc.compare(r1, r2), 1); // >0
        assertEquals(cc.compare(r1, rCopy1), 1);
        assertEquals(cc.compare(rCopy2, rCopy1), 1);
        assertEquals(cc.compare(rCopy1, rCopy3), 0);
        assertEquals(cc.compare(rCopy2, rCopy4), -1);



        assertEquals(cc.compare(rCopy1, r1), -1);

    }
}
