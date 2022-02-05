package com.mcal.expansionpanel.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mcal.expansionpanel.R;


public class ExpansionsViewGroupLinearLayout extends LinearLayout {

    private final ExpansionViewGroupManager expansionViewGroupManager = new ExpansionViewGroupManager(this);

    public ExpansionsViewGroupLinearLayout(Context context) {
        super(context);
        init(context, null);
    }

    public ExpansionsViewGroupLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ExpansionsViewGroupLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ExpansionsViewGroupLinearLayout);
            if (a != null) {
                expansionViewGroupManager.setOpenOnlyOne(a.getBoolean(R.styleable.ExpansionsViewGroupLinearLayout_expansion_openOnlyOne, false));
                a.recycle();
            }
        }
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        expansionViewGroupManager.onViewAdded();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        expansionViewGroupManager.onViewAdded();
    }
}