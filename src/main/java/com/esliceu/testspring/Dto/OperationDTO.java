package com.esliceu.testspring.Dto;

import com.esliceu.testspring.Entities.Operation;

public class OperationDTO {
    int n1;
    int n2;
    int r;
     String op;

    public OperationDTO(int n1, int n2, int r, String op) {
        this.n1 = n1;
        this.n2 = n2;
        this.r = r;
        this.op = op;
    }
    public OperationDTO(Operation op){
        this.n1 = op.getN1();
        this.n2 = op.getN2();
        this.r = op.getResult();
        switch (op.getOpType()){
          case SUM -> {this.op = "+";break; }
            case SUB -> {this.op = "-";break;}

            case MULT -> {this.op = "*";break;}

            case DIV -> {this.op = "/";break;}

        }

    }
}
