package com.example.masum_pc.dynamicfielddemo1;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

public class AddLayoutClass  implements View.OnClickListener{

    public  Context _context;
    public  ViewGroup _parent;
    public  int _child;
    public  AddLayoutClass(Context aContext , ViewGroup parent , int child){

        this._context= aContext;
        this._parent = parent;
        this._child = child;
    }

    //Context _context;


    public void AddToLayout(){


        Context context = _context ;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view ;
        view = inflater.inflate( this._child, null);

        this._parent.addView(view );

        ViewGroup theView = (ViewGroup) view;

        int childCount = theView.getChildCount();

        for (int i=0;i<childCount;i++){
            View thechild = theView.getChildAt(i);

            if(thechild instanceof EditText){
                EditText editText = (EditText) thechild;
            }
            if(thechild instanceof Button){
                int theButton = thechild.getId();
                Button aButton = thechild.findViewById(theButton);
                aButton.setOnClickListener(this);
            }


        }

    }

    @Override
    public void onClick(View v) {
      //  Toast.makeText(_context , "Clicked", Toast.LENGTH_LONG).show();
        switch (v.getId()) {
            case R.id.addButtonDetails:
                AddToLayout();
                break;
        }
    }
}
