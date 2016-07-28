package calculator;

import calculator.FSM;
import calculator.State;

public class State4 extends State {
    private FSM fsm;
    
    public State4(FSM fsm) {
        this.fsm = fsm;
    }
    
    public void handleZero(String ch){
        fsm.setRight(ch);
        StringBuilder sc = fsm.getShowScreen();
        sc.setLength(0);
        sc.append(ch);
        
        fsm.setCurrentState(fsm.getState5());
    }
    
    public void handleNonzeroDigit(String ch) {
        StringBuilder sb = fsm.getRight();

        if (sb.toString().equals("0")) {
            sb.setLength(0);
        }
        sb.append(ch);
        StringBuilder sc = fsm.getShowScreen();
        sc.setLength(0);
        sc.append(ch);
        
        fsm.setCurrentState(fsm.getState7());
    }
    
    public void handleOper(String ch) {
        fsm.setOper(ch);
    }
   
    public void handleClear() {
        fsm.setLeft("0");
        fsm.setIsLeftNega(false);
        fsm.setShowScreen("0");
        
        fsm.setCurrentState(fsm.getState1());
    }
}
