package calculator;

import calculator.FSM;
import calculator.State;

public class State7 extends State {
    private FSM fsm;
    
    State7(FSM fsm) {
        this.fsm = fsm;
    }
    
    public void handleZero(String ch){
        fsm.getRight().append(ch);
        fsm.getShowScreen().append(ch);
    }
    
    public void handleNonzeroDigit(String ch) {
        fsm.getRight().append(ch);
        fsm.getShowScreen().append(ch);
    }
    
    public void handleEqual(String ch) {
        fsm.getShowScreen().setLength(0);
        fsm.getShowScreen().append(fsm.getCR().getResult());
        fsm.setCurrentState(fsm.getState8());
    }
    
    public void handlePoint(String ch) {
        fsm.getRight().append(".");
        fsm.getShowScreen().append(".");
        fsm.setCurrentState(fsm.getState7());
    }
    
    public void handleNega() {
        fsm.setIsRightNega();
        
        if (fsm.getIsRightNega() == true) {
            fsm.getShowScreen().insert(0, '-');
        } else {
            fsm.getShowScreen().deleteCharAt(0);
        }
    }
    
    public void handleClear() {
        fsm.setLeft("0");
        fsm.setIsLeftNega(false);
        fsm.setLeft("0");
        fsm.setIsRightNega(false);
        fsm.setShowScreen("0");
        
        fsm.setCurrentState(fsm.getState1());
    }
}
