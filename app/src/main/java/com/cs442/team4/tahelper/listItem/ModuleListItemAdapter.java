package com.cs442.team4.tahelper.listItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.*;

import com.cs442.team4.tahelper.R;
import com.cs442.team4.tahelper.activity.ModuleListActivity;

import java.util.ArrayList;

/**
 * Created by sowmyaparameshwara on 10/30/16.
 */

public class ModuleListItemAdapter extends ArrayAdapter<String>{

    private int resource;
    private Context context;


    public ModuleListItemAdapter(Context context, int resource, ArrayList<String> moduleItemList) {
        super(context, resource,moduleItemList);
        this.resource = resource;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LinearLayout layout= null;

        if (convertView == null) {
            layout = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater)getContext().getSystemService(inflater);
            li.inflate(resource, layout, true);
        } else {
            layout = (LinearLayout) convertView;
        }
        final String moduleContent = getItem(position);
        TextView moduleName = (TextView) layout.findViewById(R.id.moduleNameView);
        Button editModuleButton = (Button)layout.findViewById(R.id.editModuleButtonView);
        Button scoreModuleButton = (Button)layout.findViewById(R.id.scoreModuleButtonView);
        editModuleButton.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View v) {
              ((ModuleListActivity)context).onModuleItemClickEditDelete(moduleContent);
           }
        });
        scoreModuleButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        moduleName.setText(moduleContent);
        return layout;
    }


}