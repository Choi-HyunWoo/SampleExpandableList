package com.hw.corcow.sampleexpanablelist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2015-10-06.
 */
public class MyAdapter extends BaseExpandableListAdapter {

    ArrayList<GroupItem> items = new ArrayList<GroupItem>();

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition).children.size();
    }

    @Override
    public GroupItem getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public ChildItem getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition << 32 | 0xFFFFFFFF ;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition << 32 | childPosition ;
    }

    @Override
    public boolean hasStableIds() {         // Id가 Unique한지?
        return true;
    }

    public void add (String groupName, String child) {
        GroupItem g = null;
        for (GroupItem item : items) {
            if (item.groupName.equals(groupName)) {
                g = item;
                break;
            }
        }
        if (g == null) {
            g = new GroupItem();
            g.groupName = groupName;
            items.add(g);
        }
        if (child != null) {
            ChildItem item = new ChildItem();
            item.child = child;
            g.children.add(item);
        }

        notifyDataSetChanged();

    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupView view;
        if (convertView != null) {
            view = (GroupView) convertView;
        }
        else {
            view = new GroupView(parent.getContext());
        }
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildView view;
        if (convertView != null) {
            view = (ChildView) convertView;
        }
        else {
            view = new ChildView(parent.getContext());
        }
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
