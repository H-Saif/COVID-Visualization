package prj5;

/**
 * 
 * @author Hamza Saif
 * @version 2022.03.20
 *
 */
public class CovidController {

    private SinglyLinkedList<State> states;
    private SortByAlpha alpha;
    private SortByCFR cfr;

    /**
     * @param states
     *            singly linked list of states with races
     */
    public CovidController(SinglyLinkedList<State> states) {
        this.states = states;
        alpha = new SortByAlpha();
        cfr = new SortByCFR();
        for (int i = 0; i < states.size(); i++) {
            State a = states.get(i);
            a.getList().insertionSort(alpha);
            System.out.println(states.get(i).getName().toString());
            System.out.println(states.get(i).toString());
            a.getList().insertionSort(cfr);
            System.out.println(states.get(i).toString());
        }

    }


    /**
     * /**
     * 
     * @return a SLList of sorted races (alphabetically)
     */
    public SinglyLinkedList<State> sortAlpha() {

        for (int i = 0; i < states.size(); i++) {
            State a = states.get(i);
            a.getList().insertionSort(alpha);
            System.out.println(states.get(i).toString());
        }
        return states;

    }


    /**
     * @return a SLList of sorted races (by CFR)
     */
    public SinglyLinkedList<State> sortCFR() {

        for (int i = 0; i < states.size(); i++) {
            State a = states.get(i);
            a.getList().insertionSort(cfr);

        }
        return states;
    }


    public SinglyLinkedList<State> getStates() {
        return states;
    }

}
