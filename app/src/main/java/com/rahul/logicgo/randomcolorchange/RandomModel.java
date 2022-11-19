package com.rahul.logicgo.randomcolorchange;

public class RandomModel {
    int blueItemPosition;
    boolean red;
    boolean selected;

    public RandomModel(int blueItemPosition, boolean red, boolean selected) {
        this.blueItemPosition =blueItemPosition;
        this.red =red;
        this.selected=selected;
    }


    public int getBlueItemPosition() {
        return blueItemPosition;
    }

    public void setBlueItemPosition(int blueItemPosition) {
        this.blueItemPosition = blueItemPosition;
    }

    public boolean getRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
