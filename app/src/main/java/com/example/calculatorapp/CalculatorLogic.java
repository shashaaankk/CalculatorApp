package com.example.calculatorapp;

import androidx.annotation.NonNull;

import java.util.*;
public class CalculatorLogic {
    /*
    funtion to calculate simple equations without brackets
    returns the result after processing as a string
    */
    public String compute(String s){
        double result =0;
        String [] number_data = s.split("[()*+/-]");
        int position = 0;
        int index = 0;
        if (number_data.length>=1){
            if(s.charAt(0)=='-'){
                position+=1;
                result = Double.parseDouble(number_data[position])*-1;
                index = number_data[position].length()+1;
            }
            else{
                result = Double.parseDouble(number_data[position]);
                index = number_data[position].length();
            }
        }
        while(position+1  < number_data.length) {
            char operator = s.charAt(index);
            double op2 = 0;
            if (s.charAt(index+1)=='-'){
                op2 = (Double.parseDouble(number_data[position+2])*-1);
                index+=number_data[position+2].length()+2;
                position+=2;
            }
            else{
                op2 = Double.parseDouble(number_data[position+1]);
                index+=number_data[position+1].length()+1;
                position+=1;
            }
            if (operator == '+'){
                result +=op2;
            }
            else if (operator == '-'){
                result -=op2;
            }
            else if (operator == '/'){
                if(op2==0)
                    return "divide by zero";
                else
                    result /=op2;
            }
            else if (operator == '*'){
                result *=op2;
            }
        }
        return Double.toString(result);
    }
    /*
    this function is for handling brackets in the equation
    calls the compute function to solve the equation within brackets and simplifies equation
    */
    public String eval(String s){
        String substring="";
        String computeResult = "";
        Stack<Integer> position = new Stack<Integer>();  //stack to save positions of brackets to create substrings
        int pos = 0;
        int idx = 0;
        while(pos<s.length()){
            if (s.charAt(pos) == '(')
                position.push(pos);
            if (s.charAt(pos) == ')'){
                if(position.empty()){
                    return "error in format";
                }
                else{
                    idx = position.pop();
                    substring = s.substring(idx+1,pos);
                    computeResult = compute(substring);
                    if (computeResult.equals("divide by zero"))
                        return computeResult;
                    else{
                        s = s.replace('('+substring+')',computeResult);
                        pos= idx;
                    }
                }
            }
            pos +=1;
        }
        if (position.empty())
            return compute(s);
        else
            return "error in format";
    }
    //public void main(String args[]) {
    //  String ip = "(-489.5*(-0.671/3))+(1+3)*(-1)+17899";  //ip for function
    //  System.out.println(SolveBrackets(ip));               //printing the output
    //}

}
