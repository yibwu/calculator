package calculator;

import calculator.FSM;
import calculator.State;

public class State2 extends State {
    private FSM fsm;
    
    public State2(FSM fsm) {
        this.fsm = fsm;
    }
    
    public void handleZero(String ch){
        fsm.getLeft().append(ch);
        fsm.getShowScreen().append(ch);
    }
    
    public void handleNonzeroDigit(String ch) {
        fsm.getLeft().append(ch);
        fsm.getShowScreen().append(ch);
    }
    
    public void handleOper(String ch) {
        fsm.setOper(ch);        
        fsm.setCurrentState(fsm.getState4());
    }
      
    public void handleNega(){
        fsm.setIsLeftNega();
        
        if (fsm.getIsLeftNega() == true) {
            fsm.getShowScreen().insert(0, '-');
        } else {
            fsm.getShowScreen().deleteCharAt(0);
        }
    }
    
    public void handlePoint(String ch) {
        fsm.getLeft().append(ch);
        fsm.getShowScreen().append(ch);
        
        fsm.setCurrentState(fsm.getState3());
    }
    
    public void handleClear() {
        fsm.setLeft("0");
        fsm.setIsLeftNega(false);
        fsm.setShowScreen("0");
        
        fsm.setCurrentState(fsm.getState1());
    }
}
