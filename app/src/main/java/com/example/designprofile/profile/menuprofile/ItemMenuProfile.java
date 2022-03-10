package com.example.designprofile.profile.menuprofile;

public class ItemMenuProfile {

    private int logo;
    private String content;

    public ItemMenuProfile(int logo, String content) {
        this.logo = logo;
        this.content = content;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
