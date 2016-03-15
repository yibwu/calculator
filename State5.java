package calculator;

import calculator.FSM;
import calculator.State;


public class State5 extends State {
    private FSM fsm;
    
    public State5(FSM fsm) {
        this.fsm = fsm;
    }
    
    public void handleNonzeroDigit(String ch) {
        StringBuilder sb = fsm.getRight();
        StringBuilder sc = fsm.getShowScreen();
        if (sb.toString().equals("0")) {
            sb.setLength(0);
        }
        sb.append(ch);
        
        sc.setLength(0);
        sc.append(ch);
        
        fsm.setCurrentState(fsm.getState7());
    }
    
    public void handleEqual(String ch) {
        fsm.getShowScreen().setLength(0);
        fsm.getShowScreen().append(fsm.getCR().getResult());
        fsm.setCurrentState(fsm.getState8());
    }
    
    public void handlePoint(String ch) {
        fsm.getRight().append(".");
        fsm.getShowScreen().append(ch);
        fsm.setCurrentState(fsm.getState6());
    }
    
    public void handleClear() {
        fsm.setLeft("0");
        fsm.setIsLeftNega(false);
        fsm.setShowScreen("0");
        
        fsm.setCurrentState(fsm.getState1());
    }
}
