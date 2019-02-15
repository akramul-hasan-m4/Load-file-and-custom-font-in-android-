package com.example.loadpropertiesfileandcustomfont.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
        setCustomFont();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont();
    }

    private void setCustomFont(){
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Pacifico.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}
