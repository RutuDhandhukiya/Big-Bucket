package com.example.bigbucket;

public class NumberView
{
    private  int ivNumberImageId;
    private String mNumberInDigit;
    private String mNumbersInText;

    public NumberView(int NumberImageId, String NumberInDigit, String NumbersInText) {
        ivNumberImageId = NumberImageId;
        mNumberInDigit = NumberInDigit;
        mNumbersInText = NumbersInText;
    };

    public int getNumbersImageId() {
        return ivNumberImageId;
    }

    public String getNumberInDigit() {
        return mNumberInDigit;
    }

    public String getNumbersInText() {
        return mNumbersInText;
    }
}
