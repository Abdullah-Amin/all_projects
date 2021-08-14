package com.example.insan;

public class Data {

    String text;
    String mid_text;
    String btn_text;

    public Data(String text, String mid_text, String btn_text) {
        this.text = text;
        this.mid_text = mid_text;
        this.btn_text = btn_text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMid_text() {
        return mid_text;
    }

    public void setMid_text(String mid_text) {
        this.mid_text = mid_text;
    }

    public String getBtn_text() {
        return btn_text;
    }

    public void setBtn_text(String btn_text) {
        this.btn_text = btn_text;
    }



    @Override
    public String toString() {
        return "Data{" +
                "text='" + text + '\'' +
                ", mid_text='" + mid_text + '\'' +
                ", btn_text='" + btn_text + '\'' +
                '}';
    }

}
