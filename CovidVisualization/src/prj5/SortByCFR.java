package prj5;

import java.util.Comparator;


/**
 * 
 * @author Hamza Saif (hsaif)
 * @version 2022.04.20
 */
public class SortByCFR implements Comparator<Race> {

    @Override
    public int compare(Race r1, Race r2) {
        if (r1.calcCFR() < r2.calcCFR()) {
            return 1;
        }
        else if (r1.calcCFR() > r2.calcCFR()) {
            return -1;
        }
        else {
            if (r1.getName().compareTo(r2.getName()) > 0) {
                return 1;
            }
            else if (r1.getName().compareTo(r2.getName()) < 0) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }
}
