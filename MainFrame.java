package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame {
    private FSM fsm;
    private final JFrame frame;
    private final JPanel panelMain;
    private final JPanel tfPanel;
    private final JTextField tf;
    private final JPanel panelArr[];
    private final JButton butArr[], butAdd, butMinus, butMultiply, butDivide,
                    butEqual, butCancel, butRemainder, butPoint, butNegate;
    private final String[] buttonValue = {"0","1","2","3","4","5","6","7","8","9"};
    private final Font f1 = new Font("ope1", Font.PLAIN, 22);
    private final Font f2 = new Font("ope1", Font.PLAIN, 30);
    private Color c1 = new Color(255, 133, 51);
    private Color c2 = new Color(224, 224, 209);
    private Color c3 = new Color(255, 255, 255);
    
    public MainFrame(FSM fsm) {
        this.fsm = fsm;
        frame = new JFrame("Calculator");
        frame.setResizable(false);
        
        panelMain = new JPanel(new GridLayout(5, 1));
        tfPanel = new JPanel();
        tf = new JTextField(15);
        tf.setText("0");
        tf.setEditable(false);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        
        panelArr = new JPanel[6];
        for (int i = 0; i < 6; i++) {
            panelArr[i] = new JPanel(new GridLayout(1, 4));
        }
        
        butArr = new JButton[10];
        for (int i = 0; i < 10; i++) {
            butArr[i] = new JButton(buttonValue[i]);
        }
        
        butAdd = new JButton("+");
        butMinus = new JButton("-");
        butMultiply = new JButton("*");
        butDivide = new JButton("/");
        butEqual = new JButton("=");
        butCancel = new JButton("AC");
        butRemainder = new JButton("%");
        butPoint = new JButton(".");
        butNegate = new JButton("+/-");
    }
    
    class MyMonitor extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            JButton b = (JButton)e.getSource();
            String butName = b.getName();
            
            switch(butName) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                fsm.handleOper(butName);
                tf.setText(fsm.getShowScreen().toString());
                break;
            case "0":
                fsm.handleZero(butName);
                tf.setText(fsm.getShowScreen().toString());
                break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                fsm.handleNonzeroDigit(butName);
                tf.setText(fsm.getShowScreen().toString());
                break;
            case ".":
                fsm.handlePoint(butName);
                tf.setText(fsm.getShowScreen().toString());
                break;
            case "+/-":
                fsm.handleNega();
                tf.setText(fsm.getShowScreen().toString());
                break;
            case "=":
                fsm.handEqual(butName);
                tf.setText(fsm.getShowScreen().toString());
                break;
            case "AC":
                fsm.handleClear();
                tf.setText(fsm.getShowScreen().toString());
                break;
            }
        }
    }
    
    public void initFrame() {
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for (int i = 0; i < 10; i++) {
            JButton bt = butArr[i];
            bt.setFont(f1);
            bt.setBackground(c3);
            bt.setName(buttonValue[i]);
            bt.addMouseListener(new MyMonitor());
        }
        
        butAdd.setFont(f1);
        butAdd.setBackground(c1);
        butAdd.setName("+");
        butAdd.addMouseListener(new MyMonitor());
        
        butMinus.setFont(f1);
        butMinus.setBackground(c1);
        butMinus.setName("-");
        butMinus.addMouseListener(new MyMonitor());
        
        butMultiply.setFont(f1);
        butMultiply.setBackground(c1);
        butMultiply.setName("*");
        butMultiply.addMouseListener(new MyMonitor());
        
        butDivide.setFont(f1);
        butDivide.setBackground(c1);
        butDivide.setName("/");
        butDivide.addMouseListener(new MyMonitor());
        
        butEqual.setFont(f1);
        butEqual.setBackground(c1);
        butEqual.setName("=");
        butEqual.addMouseListener(new MyMonitor());
        
        butCancel.setFont(f1);
        butCancel.setBackground(c2);
        butCancel.setName("AC");
        butCancel.addMouseListener(new MyMonitor());
        
        butRemainder.setFont(f1);
        butRemainder.setBackground(c2);
        butRemainder.setName("%");
        butRemainder.addMouseListener(new MyMonitor());
        
        butPoint.setFont(f1);
        butPoint.setBackground(c3);
        butPoint.setName(".");
        butPoint.addMouseListener(new MyMonitor());
        
        
        butNegate.setFont(f1);
        butNegate.setBackground(c2);
        butNegate.setName("+/-");
        butNegate.addMouseListener(new MyMonitor());
        
        tf.setFont(f2);
        
        tfPanel.add(tf);
        panelArr[0].add(butCancel);
        panelArr[0].add(butNegate);
        panelArr[0].add(butRemainder);
        panelArr[0].add(butDivide);
        
        panelArr[1].add(butArr[7]);
        panelArr[1].add(butArr[8]);
        panelArr[1].add(butArr[9]);
        panelArr[1].add(butMultiply);
        
        panelArr[2].add(butArr[4]);
        panelArr[2].add(butArr[5]);
        panelArr[2].add(butArr[6]);
        panelArr[2].add(butMinus);
        
        panelArr[3].add(butArr[1]);
        panelArr[3].add(butArr[2]);
        panelArr[3].add(butArr[3]);
        panelArr[3].add(butAdd);
        
        panelArr[4].setLayout(new GridLayout(1, 2));
        panelArr[5].setLayout(new GridLayout(1, 2));
        panelArr[5].add(butPoint);
        panelArr[5].add(butEqual);
        panelArr[4].add(butArr[0]);
        panelArr[4].add(panelArr[5]);
        
        panelMain.add(tfPanel);
        for (int i = 0; i < 5; i++) {
            panelMain.add(panelArr[i]);
        }
        
        frame.add(tfPanel, BorderLayout.NORTH);
        frame.add(panelMain);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
