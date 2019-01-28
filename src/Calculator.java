package calculator;

import calculator.FSM;
import calculator.MainFrame;

public class Calculator {
    private MainFrame mf;
    private FSM fsm;
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Calculator();
    }
    
    public Calculator() {
        fsm = new FSM();
        mf = new MainFrame(fsm);
        mf.initFrame();
    }
}


