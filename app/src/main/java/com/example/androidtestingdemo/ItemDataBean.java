package com.example.androidtestingdemo;

public class ItemDataBean {

    private String title;
    private boolean isChecked;
    private String name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemDataBean{" +
                "title='" + title + '\'' +
                ", isChecked=" + isChecked +
                ", name='" + name + '\'' +
                '}';
    }
}
