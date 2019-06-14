package com.example.calculator.UI;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.Button;

import com.example.calculator.R;

public class OperationButton extends Button {

    public OperationButton(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.setTextColor(getContext().getColor(R.color.blue));
    }

}
