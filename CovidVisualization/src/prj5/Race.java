package prj5;

import java.text.DecimalFormat;


/**
 * This class is used to
 * get races.
 * 
 * @author Hamza Saif
 * @version 2022.04.19
 */
public class Race {

    private String name;
    private int cases;
    private int death;

    /**
     * Default constructor.
     * 
     * @param r
     *            race name
     * @param c
     *            number of cases
     * @param d
     *            number of deaths
     */
    public Race(String r, int c, int d) {
        this.name = r;
        this.cases = c;
        this.death = d;
    }


    /**
     * This method is used to get
     * cases.
     * 
     * @return cases #case
     */
    public int getCases() {
        return cases;
    }


    /**
     * This method is used to
     * get death.
     * 
     * @return death #death
     */
    public int getDeath() {
        return death;
    }


    /**
     * This method is used to
     * calculate CFR.
     * 
     * @return CFR covid fatalty ratio
     */
    public double calcCFR() {
        if (cases == -1 || death == -1) {
            return -1;
        }
        double cfr = ((double)death / (double)cases) * 100;
        return cfr;
    }


    /**
     * This method is used
     * to get race name.
     * 
     * @return name race name
     */
    public String getName() {
        return name;
    }


    /**
     * This method is used to give
     * the output as a string.
     * 
     * @return str string representation
     */
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        StringBuilder str = new StringBuilder();
        str.append(name);
        str.append(": ");
        str.append(cases);
        str.append(" cases, ");
        str.append(df.format(calcCFR()));
        str.append("% CFR");
        return str.toString();
    }
}
