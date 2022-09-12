package prj5;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with
// honor and integrity at all times.
// I will not lie, cheat, or steal, nor will
// I accept the actions of those who do.
// -- Prahaara (prahaara08)
/**
 * *
 * 
 * @author Prahaara (prahaara08)
 * @version 2022.04.20
 */
public class SortByAlphaTest extends student.TestCase {

    /**
     * This method is used to
     * test sort by alpha.
     */
    public void testcompare() {
        Race r;
        Race r1;
        Race r2;
        SortByAlpha cc;
        r = new Race("asian", 200, 20);
        r1 = new Race("black", 200, 20);
        r2 = new Race("other", 200, 20);

        cc = new SortByAlpha();

        assertEquals(cc.compare(r, r), 0);
        assertEquals(cc.compare(r, r1), -1);
        assertEquals(cc.compare(r2, r1), 1);
    }
}
