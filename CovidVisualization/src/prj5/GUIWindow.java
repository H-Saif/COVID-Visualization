package prj5;

import java.awt.Color;

import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;


/**
 * 
 * @author Hamza Saif
 * @version 2022.04.27
 *
 */
public class GUIWindow {
    private Window window;
    private Button quit;
    private Button sortAlpha;
    private Button sortCFR;
    private Button repDC;
    private Button repMD;
    private Button repGA;
    private Button repTN;
    private Button repNC;
    private Button repVA;
    private CovidController cc;
    private int currentState;
    public static int WIDTH = 50;
    public static int SPACE = 90;

    /**
     * @param cc
     *            Covid Controller object to get SLList of states
     */

    public GUIWindow(CovidController cc) {
        
        this.cc = cc;
        quit = new Button("Quit");
        window = new Window("Covid Visualisation");
        sortAlpha = new Button("Sort by Alpha");
        sortCFR = new Button("Sort by CFR");
        repDC = new Button("Represent DC");
        repVA = new Button("Represent VA");
        repMD = new Button("Represent MD");
        repGA = new Button("Represent GA");
        repTN = new Button("Represent TN");
        repNC = new Button("Represent NC");

        quit.onClick(this, "clickedQuit");
        repDC.onClick(this, "clickedDC");
        repGA.onClick(this, "clickedGA");
        repMD.onClick(this, "clickedMD");
        repNC.onClick(this, "clickedNC");
        repTN.onClick(this, "clickedTN");
        repVA.onClick(this, "clickedVA");
        sortAlpha.onClick(this, "clickedSortByAlpha");
        sortCFR.onClick(this, "clickedSortByCFR");

        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);
        window.addButton(repDC, WindowSide.SOUTH);
        window.addButton(repGA, WindowSide.SOUTH);
        window.addButton(repMD, WindowSide.SOUTH);
        window.addButton(repNC, WindowSide.SOUTH);
        window.addButton(repTN, WindowSide.SOUTH);
        window.addButton(repVA, WindowSide.SOUTH);
    }


    /**
     * 
     * @param b
     *            quit button
     */
    public void clickedQuit(Button buttonb) {
        System.exit(0);
    }


    /**
     * 
     * @param buttonb
     *            clickedDC button
     */
    public void clickedDC(Button buttonb) {
        currentState = 0;
        drawBars(currentState);

    }


    /**
     * 
     * @param buttonb
     *            clicked GA button
     */
    public void clickedGA(Button buttonb) {
        currentState = 1;
        drawBars(currentState);
    }


    /**
     * 
     * @param buttonb
     *            clicked MD button
     */
    public void clickedMD(Button buttonb) {
        currentState = 2;
        drawBars(currentState);
    }


    /**
     * 
     * @param buttonb
     *            clicked NC button
     */

    public void clickedNC(Button buttonb) {
        currentState = 3;
        drawBars(currentState);
    }


    /**
     * 
     * @param buttonb
     *            clicked TN button
     */
    public void clickedTN(Button buttonb) {
        currentState = 4;
        drawBars(currentState);
    }


    /**
     * 
     * @param buttonb
     *            clicked VA button
     */
    public void clickedVA(Button buttonb) {
        currentState = 5;
        drawBars(currentState);
    }


    public void clickedSortByAlpha(Button buttonb) {
        drawBarsAlpha(currentState);
    }


    public void clickedSortByCFR(Button buttonb) {
        drawBars(currentState);
    }


    /**
     * 
     * @param index
     *            index of chosen state in SLList
     */
    public void drawBars(int index) {
        window.removeAllShapes();
        SinglyLinkedList<State> list = cc.sortCFR();
        SinglyLinkedList<Race> races = list.get(index).getList();
        int x = window.getGraphPanelWidth() / 6;
        DecimalFormat cfr = new DecimalFormat("##.#");
        for (int i = 0; i < races.size(); i++) {
            int height = (int)(races.get(i).calcCFR() * 20);
            int y = window.getGraphPanelHeight() - 50 - height;
            Shape bar = new Shape(x, y, WIDTH, height, Color.RED);
            window.addShape(bar);
            addTextShape(races.get(i).getName(), x, 250);
            addTextShape(cfr.format(races.get(i).calcCFR()) + "%", x, 270);
            addTextShape(list.get(index).getName()
                + " Case Fatality Ratios by Race", window.getGraphPanelWidth() / 3 , 10);
            x += SPACE;
        }
    }


    /**
     * 
     * @param index
     *            index of chosen state in SLList
     */
    public void drawBarsAlpha(int index) {
        window.removeAllShapes();
        SinglyLinkedList<State> list = cc.sortAlpha();
        SinglyLinkedList<Race> races = list.get(index).getList();
        int x = window.getGraphPanelWidth() / 6;
        DecimalFormat cfr = new DecimalFormat("##.#");
        for (int i = 0; i < races.size(); i++) {
            int height = (int)(races.get(i).calcCFR() * 20);
            int y = window.getGraphPanelHeight() - 50 - height;;
            Shape bar = new Shape(x, y, WIDTH, height, Color.RED);
            window.addShape(bar);
            addTextShape(races.get(i).getName(), x, 250);
            addTextShape(cfr.format(races.get(i).calcCFR()) + "%", x, 270);
            addTextShape(list.get(index).getName()
                + " Case Fatality Ratios by Race", window.getGraphPanelWidth() / 3,
                10);
            x += SPACE;
        }

    }


    /**
     * helper method
     * 
     * @param message
     *            test to be added
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     */
    private void addTextShape(String message, int x, int y) {
        if (message != null && !message.equals("-1%")) {
            TextShape shape = new TextShape(x, y, message, Color.black);
            shape.setBackgroundColor(Color.white);

            window.addShape(shape);
        }
        else if (message.equals("-1%")) {
            TextShape shape = new TextShape(x, y, "NA", Color.black);
            shape.setBackgroundColor(Color.white);

            window.addShape(shape);
        }
    }
}