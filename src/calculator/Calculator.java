/**
 * This program will display a GUI calculator using Java swing. When the buttons are pressed I used
 * ActionListener and inheritance to display the proper output.
 */
package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    // make the buttons and text from the form
    private JPanel calculator;
    private JTextField textField;
    private JButton squareBtn;
    private JButton mClearBtn;
    private JButton mSubBtn;
    private JButton mAddBtn;
    private JButton mRecallBtn;
    private JButton powerBtn;
    private JButton logBtn;
    private JButton sqrBtn;
    private JButton divideBtn;
    private JButton percentageBtn;
    private JButton clearBtn;
    private JButton signBtn;
    private JButton sevenBtn;
    private JButton fourBtn;
    private JButton oneBtn;
    private JButton zeroBtn;
    private JButton eightBtn;
    private JButton nineBtn;
    private JButton mulBtn;
    private JButton fiveBtn;
    private JButton sixBtn;
    private JButton minusBtn;
    private JButton threeBtn;
    private JButton addBtn;
    private JButton digitBtn;
    private JButton equalBtn;
    private JButton twoBtn;

    //memory values
    private double memValue = 0.0;
    private double mem1 = 0.0;
    private double mem2 = 0.0;

    //when the buttons are pressed they become true
    boolean addClicked = false;
    boolean subClicked = false;
    boolean mulClicked = false;
    boolean divClicked = false;
    boolean powerClicked = false;

    /** Main method,
     * This calls on the Calculator method*/
    public static void main(String[] args) {
        new Calculator().calculator();
    }

    public void calculator() {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.pack();

        frame.setVisible(true);
    }

    /** Constructor method,
     * This includes the calculator's GUI components and logic.
     * This allows the creation and operation of the arithmetic operators*/
    public Calculator() {

        zeroBtn.addActionListener(new zeroBtnClicked(textField, zeroBtn));
        oneBtn.addActionListener(new oneBtnClicked(textField, oneBtn));
        twoBtn.addActionListener(new twoBtnClicked(textField, twoBtn));
        threeBtn.addActionListener(new threeBtnClicked(textField, threeBtn));
        fourBtn.addActionListener(new fourBtnClicked(textField, fourBtn));
        fiveBtn.addActionListener(new fiveBtnClicked(textField, fiveBtn));
        sixBtn.addActionListener(new sixBtnClicked(textField, sixBtn));
        sevenBtn.addActionListener(new sevenBtnClicked(textField, sevenBtn));
        eightBtn.addActionListener(new eightBtnClicked(textField, eightBtn));
        nineBtn.addActionListener(new nineBtnClicked(textField, nineBtn));

        digitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + ".");
            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mem1 = Double.parseDouble(textField.getText());
                textField.setText("");
                textField.setText("+");
                addClicked = true;
            }
        });
        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mem1 = Double.parseDouble(textField.getText());
                textField.setText("");
                textField.setText("-");
                subClicked = true;
            }
        });
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mem1 = Double.parseDouble(textField.getText());
                textField.setText("");
                textField.setText("*");
                mulClicked = true;
            }
        });
        divideBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mem1 = Double.parseDouble(textField.getText());
                textField.setText("");
                textField.setText("/");
                divClicked = true;
            }
        });
        percentageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double current = Double.parseDouble(textField.getText());
                //This is used to make sure that #.0 is just #
                double result = current / 100;
                if (result % 1 == 0) {
                    int temp1 = (int) result;
                    textField.setText(temp1 + "");
                } else {
                    textField.setText(result + "");
                }
            }
        });
        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //making sure if there is already a -, and if the button is pressed again it removes it
                if (textField.getText().charAt(0) == '-') {
                    textField.setText(textField.getText().substring(1));
                } else {
                    textField.setText("-" + textField.getText());
                }
            }
        });
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
            }
        });

        equalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mem2 = Double.parseDouble(textField.getText());
                if (addClicked) {
                    mem1 += mem2;
                    addClicked = false;
                    if (mem1 % 1 == 0) {
                        int temp = (int) mem1;
                        textField.setText(temp + "");
                    } else {
                        textField.setText(mem1 + "");
                    }
                } else if (subClicked) {
                    mem1 -= mem2;
                    subClicked = false;
                    if (mem1 % 1 == 0) {
                        int temp = (int) mem1;
                        textField.setText(temp + "");
                    } else {
                        textField.setText(mem1 + "");
                    }
                } else if (mulClicked) {
                    mem1 *= mem2;
                    mulClicked = false;
                    if (mem1 % 1 == 0) {
                        int temp = (int) mem1;
                        textField.setText(temp + "");
                    } else {
                        textField.setText(mem1 + "");
                    }
                } else if (divClicked) {
                    if (mem2 == 0) {
                        textField.setText("ERROR");
                    } else {
                        mem1 /= mem2;
                        divClicked = false;
                    }
                    if (mem1 % 1 == 0) {
                        int temp = (int) mem1;
                        textField.setText(temp + "");
                    } else {
                        textField.setText(mem1 + "");
                    }
                } else if (powerClicked) {
                    double temp = Math.pow(mem1, mem2);
                    mem1 = temp;
                    powerClicked = false;
                    if (mem1 % 1 == 0) {
                        int temp1 = (int) mem1;
                        textField.setText(temp1 + "");
                    } else {
                        textField.setText(mem1 + "");
                    }
                }
            }
        });

        squareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double current = Double.parseDouble(textField.getText());
                double result = current * current;
                if (result % 1 == 0) {
                    int temp1 = (int) result;
                    textField.setText(temp1 + "");
                } else {
                    textField.setText(result + "");
                }
            }
        });
        powerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mem1 = Double.parseDouble(textField.getText());
                textField.setText("");
                powerClicked = true;

            }
        });
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().charAt(0) == '-' || textField.getText().equals("0")) {
                    textField.setText("ERROR");
                } else {
                    double current = Double.parseDouble(textField.getText());
                    double result = Math.log(current);
                    if (result % 1 == 0) {
                        int temp1 = (int) result;
                        textField.setText(temp1 + "");
                    } else {
                        textField.setText(result + "");
                    }
                }
            }
        });
        sqrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().charAt(0) == '-') {
                    textField.setText("ERROR");
                } else {
                    double current = Double.parseDouble(textField.getText());
                    double result = Math.sqrt(current);
                    if (result % 1 == 0) {
                        int temp1 = (int) result;
                        textField.setText(temp1 + "");
                    } else {
                        textField.setText(result + "");
                    }
                }
            }
        });
        mClearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memValue = 0.0;
            }
        });
        mRecallBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(memValue));
            }
        });
        mAddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memValue += Double.parseDouble(textField.getText());
            }
        });
        mSubBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memValue -= Double.parseDouble(textField.getText());
            }
        });

    }

    //INHERITANCE
    class numberBtnClicked implements ActionListener {
        public JTextField text;
        public JButton buttons;

        public numberBtnClicked(JTextField text, JButton buttons) {
            this.text = text;
            this.buttons = buttons;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //this will make sure that the operation or starting 0 will be deleted and the number will be displayed
            if (text.getText().equals("-") || text.getText().equals("+")
                    || text.getText().equals("/") || text.getText().equals("*")
                    || text.getText().equals("0")) {
                text.setText(buttons.getText());
            }
            //
            else {
                text.setText(text.getText() + buttons.getText());
            }
        }
    }

    class zeroBtnClicked extends numberBtnClicked {
        public zeroBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class oneBtnClicked extends numberBtnClicked {
        public oneBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class twoBtnClicked extends numberBtnClicked {
        public twoBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class threeBtnClicked extends numberBtnClicked {
        public threeBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class fourBtnClicked extends numberBtnClicked {
        public fourBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class fiveBtnClicked extends numberBtnClicked {
        public fiveBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class sixBtnClicked extends numberBtnClicked {
        public sixBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class sevenBtnClicked extends numberBtnClicked {
        public sevenBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class eightBtnClicked extends numberBtnClicked {
        public eightBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }

    class nineBtnClicked extends numberBtnClicked {
        public nineBtnClicked(JTextField text, JButton Btn) {
            super(text, Btn);
        }
    }
}

