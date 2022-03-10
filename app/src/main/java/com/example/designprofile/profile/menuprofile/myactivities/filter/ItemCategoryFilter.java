package com.example.designprofile.profile.menuprofile.myactivities.filter;

import java.util.List;

public class ItemCategoryFilter {

    private String title;
    private List<ItemCheckbox> list;

    public ItemCategoryFilter(String title, List<ItemCheckbox> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ItemCheckbox> getList() {
        return list;
    }

    public void setList(List<ItemCheckbox> list) {
        this.list = list;
    }
}
