package com.hw.corcow.sampleexpanablelist;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Tacademy on 2015-10-06.
 */
public class GroupView extends FrameLayout {

    public GroupView(Context context) {
        super(context);
        init();
    }

    TextView groupView;

    private void init() {
        inflate(getContext() , R.layout.view_group_item, this);
        groupView = (TextView)findViewById(R.id.text_group);

    }

    public void setGroupItem(GroupItem data) {
        groupView.setText(data.groupName);

    }
}
