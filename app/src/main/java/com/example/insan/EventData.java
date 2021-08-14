package com.example.insan;

public class EventData {
    String btn_text;
    String textView_text;

    public EventData(String btn_text, String textView_text) {
        this.btn_text = btn_text;
        this.textView_text = textView_text;
    }

    public String getBtn_text() {
        return btn_text;
    }

    public void setBtn_text(String btn_text) {
        this.btn_text = btn_text;
    }

    public String getTextView_text() {
        return textView_text;
    }

    public void setTextView_text(String textView_text) {
        this.textView_text = textView_text;
    }

    @Override
    public String toString() {
        return "EventData{" +
                "btn_text='" + btn_text + '\'' +
                ", textView_text='" + textView_text + '\'' +
                '}';
    }
}
