package com.mvn.service;

public class TestService {
    private double number1;
    private double number2;
    private String CalChar;
    private double result;

    public TestService() {

    }

    public TestService(double number1, double number2, String calChar) {
        this.number1 = number1;
        this.number2 = number2;
        this.CalChar = calChar;
    }

    public TestService(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.CalChar = null;
    }

    public TestService(String calChar) {
        this.number1 = 0;
        this.number2 = 0;
        this.CalChar = calChar;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public String getCalChar() {
        return CalChar;
    }

    public void setCalChar(String calChar) {
        CalChar = calChar;
    }

    public double getResult() {
        switch (this.CalChar.charAt(0)) {
            case '-':
                setResult(this.number1 - this.number2);
                break;
            case '+':
                setResult(this.number1 + this.number2);
                break;
            case '*':
                setResult(this.number1 * this.number2);
                break;
            case '/':
                setResult(this.number1 / this.number2);
                break;
        }
        return this.result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public boolean isCalchar() {
        if (this.CalChar.equals("+") || this.CalChar.equals("-") ||
                this.CalChar.equals("/") || this.CalChar.equals("*"))
            return true;
        else
            return false;
    }

    public static String getServiceDescription()
    {
        return "中铁十二局集团第一工程有限公司！";
    }
}
