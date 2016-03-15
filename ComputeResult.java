package calculator;

import calculator.FSM;

public class ComputeResult {
    private FSM fsm;
    
    public ComputeResult(FSM fsm) {
        this.fsm = fsm;
    }
    
    String getResult() {
        String result = new String("0");
        
        String oper = fsm.getOper();
        String left = fsm.getLeft().toString();
        String right = fsm.getRight().toString();
  
        Double doubleLeft = 0.0;
        Double doubleRight = 0.0;
        Double doubleResult = 0.0;
        Double doubleResutlDivider = 0.0;   // to handle integer 3/2=1.5 not 3/2=1 
        
        long intLeft = 0;
        long intRight = 0;
        long intResult = 0;
        
        if (left.contains(".") || right.contains(".")) {
            doubleLeft = Double.valueOf(left) * (fsm.getIsLeftNega() ? -1 : 1);
            doubleRight = Double.valueOf(right) * (fsm.getIsRightNega() ? -1 : 1);
            
            switch (oper) {
            case "+":
                doubleResult = doubleLeft + doubleRight;
                break;
            case "-":
                doubleResult = doubleLeft - doubleRight;
                break;
            case "*":
                doubleResult = doubleLeft * doubleRight;
                break;
            case "/":
                if (doubleRight == 0) {
                    result = "ERROR";
                } else {
                    doubleResult = doubleLeft / doubleRight;
                }
                break;
            case "%":
                if (doubleRight == 0) {
                    result = "ERROR";
                } else {
                    doubleResult = doubleLeft % doubleRight;
                }
                break;
            }
            if (!result.equals("ERROR")) {
                if (doubleResult < 0) {
                    fsm.setIsResultNega(true);
                } else {
                    fsm.setIsResultNega(false);
                }
                
                fsm.setResult(Double.toString(doubleResult).replaceAll("\\.?0*$", ""));
                result = Double.toString(doubleResult).replaceAll("\\.?0*$", "");
            }
        } else {
            intLeft = Integer.valueOf(left) * (fsm.getIsLeftNega() ? -1 : 1);
            intRight = Integer.valueOf(right) * (fsm.getIsRightNega() ? -1 : 1);
            
            switch (oper) {
            case "+":
                intResult = intLeft + intRight;
                break;
            case "-":
                intResult = intLeft - intRight;
                break;
            case "*":
                intResult = intLeft * intRight;
                break;
            case "/":
                if (intRight == 0) {
                    result = "ERROR";
                } else {
                    //intResult = intLeft / intRight;
                    doubleResutlDivider = intLeft * 1.0 / intRight;
                }
                break;
            case "%":
                if (intRight == 0) {
                    result = "ERROR";
                } else {
                    intResult = intLeft % intRight;
                }
                break;
            }
            if (!result.equals("ERROR")) {             
                if (oper.equals("/")) {
                    if (doubleResutlDivider < 0) {
                        fsm.setIsResultNega(true);
                    } else {
                        fsm.setIsResultNega(false);
                    }
                    fsm.setResult(Double.toString(doubleResutlDivider).replaceAll("\\.?0*$", ""));
                    result = Double.toString(doubleResutlDivider).replaceAll("\\.?0*$", "");
                } else {
                    if (intResult < 0) {
                        fsm.setIsResultNega(true);
                    } else {
                        fsm.setIsResultNega(false);
                    }
                    fsm.setResult(Long.toString(intResult));
                    result = Long.toString(intResult);
                }
            }
        }
        return result;
    }
}
