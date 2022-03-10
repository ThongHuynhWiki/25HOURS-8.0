package com.example.designprofile.profile.menuprofile.myactivities.filter;

public class ItemCheckbox {

    private String label;
    private boolean check;

    public ItemCheckbox(String label, boolean check) {
        this.label = label;
        this.check = check;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
