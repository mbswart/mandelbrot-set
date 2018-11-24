/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package complextesterproject;

/**
 *
 * @author swarm8383
 */
public class ComplexNumber {
    double a;
    double b;
    String aString;
    String bString;

    
    public ComplexNumber(double x, double y){
        this.a = x;
        this.b = y;
    }
    
    public ComplexNumber(String x, String y){
        this.aString = x;
        this.bString = y;     
    }
    
    public void display(){
        String aPart, bPart;
        if (a == 0){
            aPart = "";
        }
        else{
            aPart = Double.toString(a) + " ";
        }
        
        if (b == 0){
            bPart = "";
        }
        else if(b == 1){
            bPart = " + " + "i";
        }
        else if(b < 0){
            bPart = " + " + Double.toString(b) + "i";
        }
        else{
            bPart = " + " + Double.toString(b) + "i";
        }
        if (aPart.equals("") && bPart.equals("")){
            System.out.println("0");
        }
        else{
        System.out.println(aPart + bPart);
        }
    }
    public ComplexNumber add(ComplexNumber other){
        double newa, newb;
        newa = this.a + other.a;
        newb = this.b + other.b;
        return new ComplexNumber(newa , newb);
    }
    
    public ComplexNumber multiply(ComplexNumber other){
        double newa, newb;
        newa = this.a * other.a - this.b * other.b;
        newb = this.b * other.a + this.a * other.b;
        return new ComplexNumber(newa , newb);
    }
    
    public ComplexNumber getConjugate(){
        double newb;
        newb = this.b * -1;
        return new ComplexNumber(this.a, newb);
    }
    
    public double absoluteValue(){
        double value;
        value = Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
        return value;       
    }
   
    public ComplexNumber divide(ComplexNumber other){
        double newa,newb;
        ComplexNumber numerator = this.multiply(other.getConjugate());
        Double denominator = Math.pow(absoluteValue(), 2);
        newa = numerator.a/denominator;
        newb = numerator.b/denominator;
        return new ComplexNumber(newa, newb);
    }
    
}
