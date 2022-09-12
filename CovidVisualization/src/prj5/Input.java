package prj5;
import java.io.FileNotFoundException;


/**
 * 
 * @author Hamza Saif
 * @version 2022.04.27
 *
 */

public class Input {
    public static void main(String[] args)
        throws FileNotFoundException
         {

        if (args.length == 1) {
            new InputReader(args[0]);
        }
        else {
            new InputReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}
