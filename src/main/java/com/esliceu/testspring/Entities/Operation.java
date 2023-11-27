package com.esliceu.testspring.Entities;

public class Operation {
    int id;
    int n1;
    int n2;

    int result;

    TOp opType;

    public void calculateResult(){
        switch (opType){
            case SUM: result = n1 + n2; break;
            case SUB: result = n1 - n2; break;
            case MULT: result = n1 * n2; break;
            case DIV: result = n1 / n2; break;
        }
    }
    public enum TOp { SUM, SUB, MULT, DIV};

    public TOp getOpType() {
        return opType;
    }

    public void setOpType(TOp tOp) {
        this.opType = tOp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }



}
