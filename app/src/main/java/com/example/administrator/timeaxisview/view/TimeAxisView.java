package com.example.administrator.timeaxisview.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.timeaxisview.R;

import java.util.List;

/**
 * Created by Administrator on 15-11-5.
 */
public class TimeAxisView extends LinearLayout {
    private static final int EXIS_WIDTH = 50;
    private int axisColor = R.color.black;
    private Drawable axisBackground;
    private int nodeBackground = 0;
    private int nodeTextColor = R.color.black;
    private float nodeTextSize = 20;

    public TimeAxisView(Context context) {
        super(context);
    }

    public TimeAxisView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNode(List<String> nodeList) {
        LinearLayout.LayoutParams nodeLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT
                , LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams axisLayoutParams;
        if (axisBackground != null) {
            axisLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, EXIS_WIDTH);
        } else {
            if (getOrientation() == HORIZONTAL) {
                axisLayoutParams = new LayoutParams(EXIS_WIDTH
                        , 3);
            } else {
                axisLayoutParams = new LayoutParams(3
                        , EXIS_WIDTH);
            }
        }
        setGravity(Gravity.CENTER_HORIZONTAL);
        for (int i = 0; i < nodeList.size(); i++) {
            String node = nodeList.get(i);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setLayoutParams(nodeLayoutParams);
            relativeLayout.setGravity(Gravity.CENTER);
            if (nodeBackground != 0) {
                relativeLayout.setBackgroundResource(nodeBackground);
            }
            TextView textView = new TextView(getContext());
            textView.setTextColor(nodeTextColor);
            textView.setTextSize(nodeTextSize);
            textView.setText(node);
            textView.setPadding(10,10,10,10);
            relativeLayout.addView(textView);
            addView(relativeLayout);
            if (i < nodeList.size() - 1) {
                TextView axisView = new TextView(getContext());
                axisView.setLayoutParams(axisLayoutParams);
                if (axisBackground != null) {
                    axisView.setBackground(axisBackground);
                } else {
                    axisView.setBackgroundColor(axisColor);
                }
                addView(axisView);
            }
        }
    }

    public void setAxisColor(int axisColor) {
        this.axisColor = axisColor;
    }

    public void setAxisBackground(Drawable axisBackground) {
        this.axisBackground = axisBackground;
    }

    public void setNodeBackground(int nodeBackground) {
        this.nodeBackground = nodeBackground;
    }

    public void setNodeTextColor(int nodeTextColor) {
        this.nodeTextColor = nodeTextColor;
    }

    public void setNodeTextSize(float nodeTextSize) {
        this.nodeTextSize = nodeTextSize;
    }

}
