import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Calculator
 */
public class Calculator extends JFrame implements ActionListener {
        JButton b10,b11,b12,b13,b14,b15;
        JButton b[] = new JButton[10];
        int r,n1,n2,i;
        JTextField res;
        char op;
        JPanel p;

        //Constructor function for assigning values for the buttons and JPanel
        public Calculator(){
            setTitle("Calculator"); //Passes the title "Calculator" to the super class JFrame to set as the title
            setLayout(new BorderLayout()); 
            p = new JPanel(); //Creating a JPanel for storing the number buttons
            p.setLayout(new GridLayout(4,4)); //Creating the rows and columns of the calculator

            for(int i=0;i<=9;i++){ //Adding the number buttons to the calculator
                b[i] = new JButton(i+""); //Adds each number to the JPanel by assigning the values 
                p.add(b[i]);
                b[i].addActionListener(this);
            }

            //Creating the operation buttons, adding to the JPanel and adding even listeners

            b10 = new JButton("+");
            p.add(b10);
            b10.addActionListener(this);

            b11 = new JButton("-");
            p.add(b11);
            b11.addActionListener(this);

            b12 = new JButton("*");
            p.add(b12);
            b12.addActionListener(this);

            b13 = new JButton("/");
            p.add(b13);
            b13.addActionListener(this);

            b14 = new JButton("=");
            p.add(b14);
            b14.addActionListener(this);

            b15 = new JButton("C");
            p.add(b15);
            b15.addActionListener(this);

            res = new JTextField(10);
            add(p,BorderLayout.NORTH);
            add(res,BorderLayout.SOUTH);

            setVisible(true);
            setSize(200,200);



        }

        public void actionPerformed(ActionEvent e){
            JButton pb = (JButton)e.getSource();
            if(pb == b15){ 
                r=n1=n2=0;
                res.setText("");
            }
            else if(pb == b14){
                n2 = Integer.parseInt(res.getText());
                eval();
                res.setText(""+r);
            }
            else{
                boolean opf = false;
                if(pb == b10){
                    op = '+';
                    opf = true;            
                }
                else if(pb == b11){
                    op = '-';
                    opf = true;
                }
                else if(pb == b12){
                    op = '*';
                    opf = true;
                }
                else if(pb == b13){
                    op = '/';
                    opf = true;
                }
                if(opf == false){ //opf = false means the operations buttons are not bein clicked
                    for(int i=0;i<10;i++){
                        if(pb==b[i]){
                            String t = res.getText();
                            t+=i;
                            res.setText(t);
                        }
                    }
                }
                else{
                    n1 = Integer.parseInt(res.getText());
                    res.setText("");
                }
            }
        }
        
        int eval(){
            switch(op){
                case '+': r=n1+n2;break;
                case '-': r=n1-n2;break;
                case '*': r=n1*n2;break;
                case '/': r=n1/n2;break;

            }
            return 0;
        }
        public static void main(String[] args) {
            new Calculator();
        }
    
}