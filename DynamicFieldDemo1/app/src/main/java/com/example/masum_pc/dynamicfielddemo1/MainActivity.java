package com.example.masum_pc.dynamicfielddemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button addFirstOne , saveButton, childLayoutbtnadd ,childLayoutbtnremove  ;
    LinearLayout parentLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFirstOne = findViewById(R.id.btnAddFirst);
        saveButton = findViewById(R.id.btnSave);

        saveButton.setOnClickListener(this);
        addFirstOne.setOnClickListener(this);
        saveButton.setOnClickListener(this);

//        addFirstOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                AddChildView();
//
//            }
//        });


//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                parentLayout = findViewById(R.id.parentLayout);
//
//                int child = parentLayout.getChildCount();
//
//                int totalChild = child;
//
//
//                for(int i=0;i<child;i++){
//
//                    View aView = parentLayout.getChildAt(i);
//
//                    EditText editText = aView.findViewById(R.id.nameEditText);
//
//                    String theText = editText.getText().toString();
//                    String a = theText;
//                }
//
//
//
//            }
//        });



    }

    public  void AddChildView(){
        ViewGroup parent =   findViewById(R.id.parentLayout);

         int a = parent.getChildCount();
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View view = inflater.inflate(R.layout.dynamic_layout, null);


        view.setTag(a);
        parent.addView(view );

        childLayoutbtnadd = view.findViewById(R.id.addButtonDetails);
        childLayoutbtnremove = view.findViewById(R.id.removeButtonDetails);

        childLayoutbtnadd.setOnClickListener(this);
        childLayoutbtnremove.setOnClickListener(this);
        //childLayoutbtnremove.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAddFirst:
                //AddChildView();

                AddLayoutClass addLayoutClass = new AddLayoutClass(getApplicationContext(),(ViewGroup)findViewById(R.id.parentLayout), R.layout.dynamic_layout);
                addLayoutClass.AddToLayout();

                break;


//            case R.id.addButtonDetails:
//              //  AddChildView();
//                break;

            case R.id.btnSave:

                parentLayout = findViewById(R.id.parentLayout);


                int child = parentLayout.getChildCount();

                int totalChild = child;


                for(int i=0;i<child;i++){

                    View aView = parentLayout.getChildAt(i);

                    View av = aView;

                    EditText editText = aView.findViewById(R.id.nameEditText);

                    String theText = editText.getText().toString();
                    String a = theText;
                }

                break;

            case R.id.removeButtonDetails:
                View ia  = (View) v.getParent();
                LinearLayout layout = (LinearLayout)ia;
                ViewGroup iaPagent = (ViewGroup) ia.getParent();
                int index = ((ViewGroup) layout.getParent()).indexOfChild(ia);
                iaPagent.removeViewAt(index);
                break;


        }

    }


}
