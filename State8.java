package calculator;

import calculator.FSM;
import calculator.State;

public class State8 extends State {
    private FSM fsm;
    
    public State8(FSM fsm) {
        this.fsm = fsm;
    }
    
    public void handleZero(String ch) {
        fsm.setIsLeftNega(false);
        fsm.setIsRightNega(false);
        fsm.setLeft("0");
        fsm.setRight("0");
        fsm.setShowScreen(ch);
        
        fsm.setCurrentState(fsm.getState1()); 
    }
    
    public void handleNonzeroDigit(String ch) {
        fsm.setIsLeftNega(false);
        fsm.setIsRightNega(false);
        fsm.setLeft(ch);
        fsm.getRight().setLength(0);
        fsm.getRight().append("0");
        fsm.setShowScreen(ch);
        
        fsm.setCurrentState(fsm.getState2()); 
    }
    
    // handle +/-
    public void handleNega() {
        // if it's a positive number
        if (fsm.getIsResultNega() == false) {
            fsm.setLeft(fsm.getResult().toString());
            fsm.getResult().insert(0, '-');
            fsm.getShowScreen().insert(0, '-');
        } else {
            fsm.getResult().deleteCharAt(0);
            fsm.getShowScreen().deleteCharAt(0); 
            fsm.setLeft(fsm.getResult().toString());
        }     
        fsm.setIsResultNega();
        fsm.setIsLeftNega(fsm.getIsResultNega());
    }
    
    public void handleOper(String ch) {
        if (fsm.getIsResultNega() == true) {
            fsm.setLeft(fsm.getResult().deleteCharAt(0).toString());
        } else {
            fsm.setLeft(fsm.getResult().toString());           
        }    
        fsm.setIsLeftNega(fsm.getIsResultNega());
        fsm.setIsRightNega(false);
        fsm.setRight("0");
        fsm.setOper(ch);
        
        fsm.setCurrentState(fsm.getState4());
    }
    
    public void handlePoint(String ch) {
        fsm.setLeft("0.");
        fsm.setIsLeftNega(false);       
        fsm.setRight("0");
        fsm.setIsRightNega(false);
        fsm.setShowScreen("0.");
        
        fsm.setCurrentState(fsm.getState3());
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
