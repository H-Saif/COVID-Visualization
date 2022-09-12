package prj5;



/**
 * 
 * @author Hamza Saif (hsaif)
 * 
 * @version 2022.04.22
 */
public class State {

    private String name;
    private SinglyLinkedList<Race> list;

    /**
     * Default constructor.
     * 
     * @param stateName
     *            name of state
     * @param list
     *            list of states
     */
    public State(String stateName, SinglyLinkedList<Race> list) {
        this.list = list;
        name = stateName;
        list = new SinglyLinkedList<Race>();

    }


    /**
     * This method is used
     * to set name.
     * 
     * @param name
     *            name of state
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * This method is used
     * to get name.
     * 
     * @return name name of state
     */
    public String getName() {
        return name;
    }


    /**
     * This method is used to
     * get list.
     * 
     * @return list state list
     */
    public SinglyLinkedList<Race> getList() {
        return list;
    }


    /**
     * This method is used to
     * make string representation.
     * 
     * @return str the string
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i).toString());
            str.append("\n");
        }
        str.append("====");
        return str.toString();
    }

}
