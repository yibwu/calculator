package calculator;

import calculator.FSM;
import calculator.State;

public class State6 extends State {
    private FSM fsm;
    
    public State6(FSM fsm) {
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
    
    public void handleNega() {
        if (fsm.getRight().toString().equals("0.")) {
            ;
        } else {
            fsm.setIsRightNega();
            if (fsm.getIsRightNega() == true) {
                fsm.getShowScreen().insert(0, '-');
            } else {
                fsm.getShowScreen().deleteCharAt(0);
            }
        }
    }
    
    public void handleClear() {
        fsm.setLeft("0");
        fsm.setIsLeftNega(false);
        fsm.setRight("0");
        fsm.setIsRightNega(false);
        fsm.setShowScreen("0");
        
        fsm.setCurrentState(fsm.getState1());
    }
}
