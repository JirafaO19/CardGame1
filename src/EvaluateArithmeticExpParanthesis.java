import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluateArithmeticExpParanthesis {
    private static int ind=0;
    public static Stack<String> ops = new Stack<>();
    public static Stack<Double> vals = new Stack<>();
    public static Stack<Double> tempvals = new Stack<>();
    public static String[] tmpArr;

    private static String[] getExpAndValues(String str){
        ArrayList<String> valLst=new ArrayList<>();
        Matcher m= Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))").matcher(str);
        while(m.find())
            valLst.add(m.group());
        tmpArr=new String[valLst.size()];
        for(int i=0;i<valLst.size();i++)
            tmpArr[i]=valLst.get(i);
        return tmpArr;
    }

    public static Double processExpression(String str){
        String[] expAndValues=getExpAndValues(str);
        ind=0;
        //Stack<String> ops = new Stack<>();
        //Stack<Double> vals = new Stack<>();

       try {


        while(ind<expAndValues.length){
            String s=expAndValues[ind];
            if(s.equals("("));
            else if (s.equals("+")||s.equals("*")||s.equals("-")||s.equals("/")) {
                ops.push(s);}
            else if (s.equals(")")) {
                String op=ops.pop();
                if(op.equals("+")) {
                    vals.push(vals.pop()+vals.pop());}
                else if (op.equals("*")) {
                    vals.push(vals.pop()*vals.pop());
                    //tempvals.push(Double.valueOf(s));
                }
                else if (op.equals("-")) {
                    vals.push(-1*vals.pop()+vals.pop());
                    //tempvals.push(Double.valueOf(s));
                }
                else if (op.equals("/")) {
                    vals.push(1/vals.pop()*vals.pop());
                    //tempvals.push(Double.valueOf(s));
                }
            }
            else
                vals.push(Double.parseDouble(s));
            ind++;
        }}catch (EmptyStackException e){
//           String result="Please re-type expression ";
//           JOptionPane.showMessageDialog(null,result);
       }
       try {
           if(ops.isEmpty())
               return vals.pop();
           else{
               while(!ops.isEmpty()){
                   String op=ops.pop();
                   if(op.equals("+")) vals.push(vals.pop()+vals.pop());
                   else if (op.equals("*")) vals.push(vals.pop()*vals.pop());
                   else if (op.equals("-")) vals.push(-1*vals.pop()+vals.pop());
                   else if (op.equals("/")) vals.push(1/vals.pop()*vals.pop());
               }
               return vals.pop();
           }
       }catch (EmptyStackException e){ String result="Please re-type expression ";
           JOptionPane.showMessageDialog(null,result);}
        return null;
    }
    public static String StringOutput(int a, int b, int c, int d, String text, boolean pass, long totaltime ){

        try
        {
            File newFile=new File("logFile.txt");
            PrintWriter out = new PrintWriter(new FileWriter(newFile, true));

            out.println("*****************Start********************");
            out.println("random card 1: "+a);
            out.println("random card 2: "+b);
            out.println("random card 3: "+c);
            out.println("random card 4: "+d);
            out.println("entered expression: "+text+"= ");
            out.println("match expression "+pass);

            if (totaltime>60){
                double mini=totaltime/60;
                long iPart = (long) mini;
                double second=totaltime-(60*(int)iPart);
                long seconds=(long)second;
                out.println("total time is: "+iPart +" min "+seconds+" seconds");

            }
            out.println("total time is: "+totaltime  +" seconds");
            out.println("*******************End******************");

            out.close();
        }
        catch(Exception e){}
        return null;
    }


    public static boolean SearchNumber(String number, String expression ){
//return true is number is found on string
        String regex = "(.)*("+number+")(.)*";
        Pattern pattern = Pattern.compile(regex);
        String msg = expression;
        boolean containsNumber = pattern.matcher(msg).matches();
        return containsNumber;
    }
}
