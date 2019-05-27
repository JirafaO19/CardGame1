//importations needed for below functions to work

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Functions {

    private static Map<Character, BinOperation> operations = new HashMap<>();
    static int a,b,c,d;
    static int x=0,y=0;
    //Buttons, TextField, Labels and JPanel for the JFrame which is also created below
    static JButton find_A_SolutionButton, refreshButon, verifyButton,tutorial_Button;
    static JTextField outPutSolutionField, verifyField;
    static JLabel label1,label2;
    static JPanel panel, panel2;
    static int low1=1;
    static int high2=12;
    static Random random1;
    private static String str="";
    static long strtGm;//start of timer
    static long endGm;//end of timer
    static long totaltime=endGm-strtGm; //created time elapsed for the timer
    static boolean pass=false;
    static double number;
    static boolean firstEvaluation=false;
    static boolean secondEvaluation=false;
    static boolean thirdEvaluation=false;
    static boolean fourthEvaluation=false;
    static boolean fifthEvaluation=false;
    static String aaray[]={"+","-","/","*"};//using all below for the finding a solution button
    static String stringToEvaluate ="";
    static String stringToEvaluate2="";
    static String stringToEvaluate3="";
    static String stringToEvaluate4="";
    static String stringToEvaluate5="";
    static String stringToEvaluate6="";
    static String text="";
    static double calcu=0;
    static double calcu1=0;
    static double calcu2=0;
    static double calcu3=0;
    static double calcu4=0;

    public static void main(String[] args){

        operations.put('*', new Multiplication()); //symbols for operations
        operations.put('+', new Addition());
        operations.put('-', new Subtraction());
        operations.put('\\', new Division());
//need random for cards
        random1=new Random();


        JFrame frame=new JFrame("Card Game 24");
        frame.setSize(890,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close when x is pressed
        frame.setLayout(null);

        JLabel lbl1=new JLabel();
        lbl1.setIcon(new ImageIcon("C_12_Clubs.png")); //extracts all the club images of cards
        lbl1.setBounds(5, 80, 350, 350);
        frame.getContentPane().add(lbl1);


        JLabel lbl2=new JLabel();
        lbl2.setIcon(new ImageIcon("C_12_Diam.png"));//extracts all the diamond images of cards
        lbl2.setBounds(199,80, 350, 350);
        frame.getContentPane().add(lbl2);

        JLabel lbl3=new JLabel();
        lbl3.setIcon(new ImageIcon("C_12_Heart.png"));//extracts all the heart images of cards
        lbl3.setBounds(400, 80, 350, 350);
        frame.getContentPane().add(lbl3);

        JLabel lbl4=new JLabel();
        lbl4.setIcon(new ImageIcon("C_12_Spade.png"));//extracts all the spade images of cards
        lbl4.setBounds(600, 80, 350, 350);
        frame.getContentPane().add(lbl4);

        tutorial_Button= new JButton("Tutorial");
        tutorial_Button.setBounds(0,450,200,50);
        tutorial_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Desktop desktop=Desktop.getDesktop();
                try {
                    desktop.browse(new URI("https://www.youtube.com/watch?v=HbVS174-It8"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }

            }
        });

        frame.getContentPane().add(tutorial_Button);
        find_A_SolutionButton =new JButton("Find a Solution"); //Button added for finding a solution
        find_A_SolutionButton.setBounds(0,20,200,50);
        find_A_SolutionButton.addActionListener(new ActionListener() {//need for activation
            public void actionPerformed(ActionEvent e) {

   //             String text= verifyField.getText();

                //evaluation("("+a+aaray[i]+b+")"+aaray[j]+"("+c+aaray[k]+d+")");



                for (int i=0;i<aaray.length;i++){
                    for (int j=0;j<aaray.length;j++){
                        for (int k=0;k<aaray.length;k++){
                            for (int l=0;l<aaray.length;l++){

                                stringToEvaluate="("+a+aaray[i]+b+")"+aaray[j]+"("+c+aaray[k]+d+")";
                                calcu= EvaluateArithmeticExpParanthesis.processExpression(stringToEvaluate);
                                System.out.println("result1: "+stringToEvaluate+"= "+calcu);//this is repeated to make 6 results total

                                stringToEvaluate2="("+a+aaray[i]+"("+b+aaray[j]+c+")"+")"+aaray[k]+d;
                                calcu1=EvaluateArithmeticExpParanthesis.processExpression(stringToEvaluate2);
                                System.out.println("result2: "+stringToEvaluate2+"= "+calcu1);

                                stringToEvaluate3=a+aaray[i]+"("+b+aaray[j]+c+aaray[k]+d+")";
                                calcu2=EvaluateArithmeticExpParanthesis.processExpression(stringToEvaluate3);
                                System.out.println("result3: "+stringToEvaluate3+"= "+calcu2);

                                stringToEvaluate4="("+a+aaray[i]+b+aaray[j]+c+")"+aaray[k]+d;
                                calcu3=EvaluateArithmeticExpParanthesis.processExpression(stringToEvaluate4);
                                System.out.println("result4: "+stringToEvaluate4+"= "+calcu3);

                                stringToEvaluate5=a+aaray[i]+"("+"("+b+aaray[j]+c+")"+aaray[k]+d+")";
                                calcu4=EvaluateArithmeticExpParanthesis.processExpression(stringToEvaluate5);
                                System.out.println("result5: "+stringToEvaluate5+"= "+calcu4);

                                if ((calcu==24)){ // win the game if you get exactly 24
                                    System.out.println("win1");
                                    //System.out.println(go+"= 24");
                                    outPutSolutionField.setText(stringToEvaluate+"= "+calcu);
                                    firstEvaluation=true;

                                }


                                if ((calcu1==24)){ // win the game if you get exactly 24
                                    System.out.println("win2");
                                    //System.out.println(go+"= 24");
                                    outPutSolutionField.setText(stringToEvaluate2+"= "+calcu1);
                                    secondEvaluation=true;


                                }


                                if ((calcu2==24)){ // win the game if you get exactly 24
                                    System.out.println("win3");
                                    //System.out.println(go+"= 24");
                                    outPutSolutionField.setText(stringToEvaluate3+"= "+calcu2);
                                    thirdEvaluation=true;


                                }

                                if ((calcu3==24)){ // win the game if you get exactly 24
                                    System.out.println("win4");
                                    //System.out.println(go+"= 24");
                                    outPutSolutionField.setText(stringToEvaluate4+"= "+calcu3);
                                    fourthEvaluation=true;


                                }

                                if ((calcu4==24)){ // win the game if you get exactly 24
                                    System.out.println("win5");
                                    //System.out.println(go+"= 24");
                                    outPutSolutionField.setText(stringToEvaluate5+"= "+calcu4);
                                    fifthEvaluation=true;

                                }




                            }}}
                }

                if ((!firstEvaluation)&&(!secondEvaluation)&&(!thirdEvaluation)&&(!fourthEvaluation)&&(!fifthEvaluation)){
                    outPutSolutionField.setText("No solution found");

                    firstEvaluation=false;secondEvaluation=false;thirdEvaluation=false;fourthEvaluation=false;fifthEvaluation=false;

                }

                firstEvaluation=false;secondEvaluation=false;thirdEvaluation=false;fourthEvaluation=false;fifthEvaluation=false;


            }
        });
        frame.getContentPane().add(find_A_SolutionButton);
        refreshButon =new JButton("Refresh");// this button is to refresh the cards if you would like to play a new round of if there is no solution with the four cards that you were given
        refreshButon.setBounds(600,20,200,50);
        frame.getContentPane().add(refreshButon);
        verifyButton =new JButton("Verify");// this button determines if your answer was correct and if you used the right values for the cards above
        verifyButton.setBounds(600,450,200,50);
        frame.getContentPane().add(verifyButton);
        outPutSolutionField =new JTextField(50);
        outPutSolutionField.setBounds(300,20,200,50);
        outPutSolutionField.setText("Solution");
        frame.getContentPane().add(outPutSolutionField);

        verifyField =new JTextField(50);
        verifyField.setBounds(300,450,200,50);

        verifyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//this is to make the verify button to work
                outPutSolutionField.setText("Solution");
                text= verifyField.getText();
                String searchMe = text;

                int local=0;
// it takes all the values as seen below
                String findMe = String.valueOf(a);
                String findMe1 = String.valueOf(b);
                String findMe2 = String.valueOf(c);
                String findMe3 = String.valueOf(d);
//it solves the cards according to their values to equal 24
                int search = searchMe.length();
                int LengthofValue = findMe.length();
                int goahead=2;
                int goehead1=4;
                int goahead2=6;
                int goahead3=8;

                boolean foundIt = false;
                boolean foundIt1 = false;
                 boolean foundIt2 = false;
                boolean foundIt3 = false;

                foundIt=EvaluateArithmeticExpParanthesis.SearchNumber(findMe,text);
                foundIt1=EvaluateArithmeticExpParanthesis.SearchNumber(findMe1,text);
                foundIt2=EvaluateArithmeticExpParanthesis.SearchNumber(findMe2,text);
                foundIt3=EvaluateArithmeticExpParanthesis.SearchNumber(findMe3,text);
try {

                if ((foundIt)&&(foundIt1)&&(foundIt2)&&(foundIt3)&&(EvaluateArithmeticExpParanthesis.processExpression(text) == 24)
                        //(goahead==0)&&(goehead1==0)&&(goahead2==0)&&(goahead3==0)&&(local==24)
                    ){
                    String result="Correct! Number equals 24 ";
                    JOptionPane.showMessageDialog(null,result);
                    pass=true;
                    endGm=System.currentTimeMillis();
                    totaltime=(endGm-strtGm)/1000;
                    EvaluateArithmeticExpParanthesis.StringOutput(a,b,c,d, text,pass, totaltime);
                }
                else {
                    String result2 = "Does not equal 24 or does not matches card values";
                    JOptionPane.showMessageDialog(null,result2);
                    endGm=System.currentTimeMillis();
                    totaltime=(endGm-strtGm)/1000;
                    pass=false;

                    EvaluateArithmeticExpParanthesis.StringOutput(a,b,c,d, text,pass, totaltime);
                }

                verifyField.setText("Enter expression here");}catch (NullPointerException e1){}

            }
        });
        frame.getContentPane().add(verifyField);
        label1=new JLabel("Enter an expression : "); //label seen below on the right on the JFrame
        label1.setBounds(150,425,200,100); //label location
        frame.getContentPane().add(label1);
        panel= new JPanel();
        panel.setBounds(0,0,890,600);
        panel.setBackground(Color.green);// set background color to green
        panel2= new JPanel();
        panel2.setBounds(0,100,830,330);
        panel2.setBackground(Color.WHITE);
        frame.getContentPane().add(panel2);

        frame.getContentPane().add(panel);
        frame.setBackground(Color.green);

        refreshButon.addActionListener(new ActionListener() {//activating refresh button
            public void actionPerformed(ActionEvent e) {
                verifyField.setText("Enter expression field");
                outPutSolutionField.setText("Solution");
                strtGm=System.currentTimeMillis();
                a=random1.nextInt((high2-low1))+low1;//randomly setting the four cards as many times as you would like
                b=(int)(1+Math.random()*13);
                c=(int)(1+Math.random()*13);
                d=(int)(1+Math.random()*13);
                //System.out.println(a);


                lbl1.setIcon(new ImageIcon("C_"+a+ "_Clubs.png"));//showing image of club
                lbl2.setIcon(new ImageIcon("C_"+b+"_Diam.png"));//showing image of diamond
                lbl3.setIcon(new ImageIcon("C_"+c+"_Heart.png"));//showing image of heart
                lbl4.setIcon(new ImageIcon("C_"+d+"_Spade.png"));//showing image of spade

            }
        });
        frame.setSize(890,600);
        frame.setVisible(true);//set visibility to true to see it
    }

}