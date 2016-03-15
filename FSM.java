package calculator;

import calculator.ComputeResult;

import calculator.State;
import calculator.State1;
import calculator.State2;
import calculator.State3;
import calculator.State4;
import calculator.State5;
import calculator.State6;
import calculator.State7;
import calculator.State8;

public class FSM {
    ;
    private State s1;
    private State s2;
    private State s3;
    private State s4;
    private State s5;
    private State s6;
    private State s7;
    private State s8;
    private State currentState;
    private StringBuilder left;
    private StringBuilder showScreen;
    private boolean isLeftNega;
    private boolean isRightNega;
    private boolean isResultNega;
    private StringBuilder right;
    private String oper;
    private StringBuilder result;
    private ComputeResult cr;

    public FSM() {
        s1 = new State1(this);
        s2 = new State2(this);
        s3 = new State3(this);
        s4 = new State4(this);
        s5 = new State5(this);
        s6 = new State6(this);
        s7 = new State7(this);
        s8 = new State8(this);
        cr = new ComputeResult(this);
        currentState = s1;
        left = new StringBuilder("0");
        right = new StringBuilder("0");
        showScreen = new StringBuilder("0");
        isLeftNega = false;
        isRightNega = false;
        isResultNega = false;
        oper = new String();
        result = new StringBuilder("0");
    }

    public ComputeResult getCR() {
        return cr;
    }

    public StringBuilder getShowScreen() {
        return showScreen;
    }

    public void setShowScreen(String s) {
        showScreen = new StringBuilder(s);
    }

    public boolean getIsLeftNega() {
        return isLeftNega;
    }

    public boolean getIsRightNega() {
        return isRightNega;
    }
    
    public boolean getIsResultNega() {
        return isResultNega;
    }

    public void setIsLeftNega() {
        if (isLeftNega == true) {
            isLeftNega = false;
        } else {
            isLeftNega = true;
        }
    }

    public void setIsRightNega() {
        if (isRightNega == true) {
            isRightNega = false;
        } else {
            isRightNega = true;
        }
    }
    
    public void setIsResultNega() {
        if (isResultNega == true) {
            isResultNega = false;
        } else {
            isResultNega = true;
        }
    }

    public void setIsLeftNega(boolean b) {
        isLeftNega = b;
    }

    public void setIsRightNega(boolean b) {
        isRightNega = b;
    }
    
    public void setIsResultNega(boolean b) {
        isResultNega = b;
    }

    public State getCurrentState() {
        return currentState;
    }

    // transfer state from current to another
    public void setCurrentState(State s) {
        currentState = s;
    }

    public void setLeft(String l) {
        left = new StringBuilder(l);
    }

    public StringBuilder getLeft() {
        return left;
    }

    public void setRight(String l) {
        right = new StringBuilder(l);
    }

    public StringBuilder getRight() {
        return right;
    }

    public void setOper(String op) {
        oper = op;
    }

    public String getOper() {
        return oper;
    }

    public void setResult(String r) {
        result = new StringBuilder(r);
    }

    public StringBuilder getResult() {
        return result;
    }

    public void handleZero(String ch) {
        currentState.handleZero(ch);
    }

    public void handleNonzeroDigit(String ch) {
        currentState.handleNonzeroDigit(ch);
    }

    public void handleOper(String ch) {
        currentState.handleOper(ch);
    }

    public void handEqual(String ch) {
        currentState.handleEqual(ch);
    }

    public void handlePoint(String ch) {
        currentState.handlePoint(ch);
    }

    public void handleNega() {
        currentState.handleNega();
    }
    
    public void handleClear() {
        currentState.handleClear();
    }
    
    public State getState1() {
        return s1;
    }

    public State getState2() {
        return s2;
    }

    public State getState3() {
        return s3;
    }

    public State getState4() {
        return s4;
    }

    public State getState5() {
        return s5;
    }

    public State getState6() {
        return s6;
    }

    public State getState7() {
        return s7;
    }

    public State getState8() {
        return s8;
    }
}
