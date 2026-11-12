package com.example.bmicalculate;

public class BmiResult {
    private double result;
    private BmiNote note;

    public BmiResult(double result, BmiNote note){
        this.result = result;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Twoje BMI: %.2f | status: %s\n%s".formatted(result,note,note.getDescription());
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public BmiNote getNote() {
        return note;
    }

    public void setNote(BmiNote note) {
        this.note = note;
    }
}
