package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Hamza Saif
 * @version 2022.03.20
 *
 */
public class InputReader {
    private SinglyLinkedList<State> stateData;

    @SuppressWarnings("unused")
    public InputReader(String statesFileName) throws FileNotFoundException {

        stateData = DataReader(statesFileName);
        CovidController control = new CovidController(stateData);
        GUIWindow window = new GUIWindow(control);

         
        
    }


    @SuppressWarnings("resource")
    private SinglyLinkedList<State> DataReader(String fileName)
        throws FileNotFoundException {
        
        SinglyLinkedList<State> stateList = new SinglyLinkedList<State>();
        Scanner file = new Scanner(new File(fileName));
        file.nextLine();
        
        while (file.hasNextLine()) {
            String currline = file.nextLine();
            Scanner file2 = new Scanner(currline).useDelimiter(",\\s*");
            String[] value = new String[11];

            int tokenCount = 0;
            while (file2.hasNext() && tokenCount < value.length) {

                value[tokenCount++] = file2.next();
// System.out.println(Arrays.toString(value));

            }

            String stateName = "";
            int cases_White = 0;
            int cases_Black = 0;
            int cases_Latino = 0;
            int cases_Asian = 0;
            int cases_Other = 0;
            int deaths_White = 0;
            int deaths_Black = 0;
            int deaths_Latino = 0;
            int deaths_Asian = 0;
            int deaths_Other = 0;

            for (int i = 1; i < value.length; i++) {

                if (value[i].equals("NA")) {
                    value[i] = "-1";
                }
            }

            stateName = value[0];
            cases_White = Integer.parseInt(value[1]);
            cases_Black = Integer.parseInt(value[2]);
            cases_Latino = Integer.parseInt(value[3]);
            cases_Asian = Integer.parseInt(value[4]);
            cases_Other = Integer.parseInt(value[5]);
            deaths_White = Integer.parseInt(value[6]);
            deaths_Black = Integer.parseInt(value[7]);
            deaths_Latino = Integer.parseInt(value[8]);
            deaths_Asian = Integer.parseInt(value[9]);
            deaths_Other = Integer.parseInt(value[10]);

            String white = "white";
            String black = "black";
            String latinx = "latinx";
            String asian = "asian";
            String other = "other";

            Race whites = new Race(white, cases_White, deaths_White);
            Race blacks = new Race(black, cases_Black, deaths_Black);
            Race latinos = new Race(latinx, cases_Latino, deaths_Latino);
            Race asians = new Race(asian, cases_Asian, deaths_Asian);
            Race others = new Race(other, cases_Other, deaths_Other);

            SinglyLinkedList<Race> list = new SinglyLinkedList<Race>();

            list.add(whites);
            list.add(blacks);
            list.add(latinos);
            list.add(asians);
            list.add(others);

            State temp = new State(stateName, list);

            stateList.add(temp);

        }
        
        

        file.close();
        return stateList;
    }


    public SinglyLinkedList<State> getStates() {
        return stateData;
    }

}
