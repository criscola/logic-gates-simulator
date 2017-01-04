package logicgatessimulator.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dias
 */
public class Wire {
    protected Pin start;
    protected Pin end;

    public Wire() {
    }

    public Wire(Pin start, Pin end) {
        this.start = start;
        this.end = end;
    }

    public void setEnd(Pin end) {
        this.end = end;
    }

    public Pin getEnd() {
        return end;
    }

    public Pin getStart() {
        return start;
    }

    public void setStart(Pin start) {
        this.start = start;
    }
    
}
