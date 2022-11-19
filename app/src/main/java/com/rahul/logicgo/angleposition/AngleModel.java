package com.rahul.logicgo.angleposition;

public class AngleModel {

    int firstValue;

    int secondValue;
    boolean isSelected;

    public AngleModel(int i, int j, boolean isSelected) {
        this.firstValue = i;
        this.isSelected = isSelected;
        this.secondValue = j;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

}
