package prj5;
import java.util.Comparator;



/**
 * 
 * @author Hamza Saif
 * @version 2022.04.20
 */
public class SortByAlpha implements Comparator<Race> {


    /**
     * This method is used to 
     * compare two races. 
     */
    @Override
    public int compare(Race r1, Race r2) {
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
