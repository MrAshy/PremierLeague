package com.pms.kirillbaranov.premierleague.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.pms.kirillbaranov.premierleague.R;

/**
 * Created by KirillBaranov on 05.12.16.
 */

public class TypeFaceTextView extends TextView {

    public TypeFaceTextView(Context context) {
        super(context);
    }

    public TypeFaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) initViewAttrs(attrs);
    }

    public TypeFaceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (!isInEditMode()) initViewAttrs(attrs);
    }

    private void initViewAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TypeFaceTextView);

        int typeFaceIndex;
        final int N = a.getIndexCount();

        for (int i = 0; i < N; ++i) {
            int attrIndex = a.getIndex(i);

            if (attrIndex == R.styleable.TypeFaceTextView_typeFace) {
                typeFaceIndex = a.getInt(attrIndex, -1);
                if (typeFaceIndex != -1) {
                    setTypeface(Font.getByIndex(typeFaceIndex, getContext()));
                }
            } else {
            }
        }
        a.recycle();
    }

}
