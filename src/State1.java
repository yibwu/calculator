package calculator;

import calculator.FSM;
import calculator.State;

public class State1 extends State {
    private FSM fsm;
    
    public State1(FSM fsm) {
        this.fsm = fsm;
    }
    
    public void handleNonzeroDigit(String ch) {
        StringBuilder sb = fsm.getLeft();
        StringBuilder sc = fsm.getShowScreen();

        if (sb.toString().equals("0")) {
            sb.setLength(0);
        }
        if (sc.toString().equals("0")) {
            sc.setLength(0);
        }
        
        sb.append(ch);
        sc.append(ch);
        fsm.setCurrentState(fsm.getState2());
    }
    
    public void handleOper(String ch) {
        fsm.setOper(ch);        
        fsm.setCurrentState(fsm.getState4());
    }
    
    public void handlePoint(String ch) {
        fsm.getLeft().append(ch);
        fsm.getShowScreen().append(ch);
        fsm.setCurrentState(fsm.getState3());
    }
}
