package com.example.designprofile.profile.menuprofile.membership;

public class ItemPaymentHistory {

    private float membershipFee;
    private String date;

    public ItemPaymentHistory(float membershipFee, String date) {
        this.membershipFee = membershipFee;
        this.date = date;
    }

    public float getMembershipFee() {
        return membershipFee;
    }

    public void setMembershipFee(float membershipFee) {
        this.membershipFee = membershipFee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
