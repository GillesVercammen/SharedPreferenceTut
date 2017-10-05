package com.example.gilles.sharedpreferencestutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Checkbox = "checkBoxKey";

    SharedPreferences sharedpreferences;
    EditText mEditTextName;
    EditText mEditTextEmail;
    Button mButton1;
    Button mButton2;
    Button mButton3;
    CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditTextName = (EditText)findViewById(R.id.editText);
        mEditTextEmail = (EditText)findViewById(R.id.editText2);
        mButton1 = (Button)findViewById(R.id.button);
        mButton2 = (Button)findViewById(R.id.button2);
        mButton3 = (Button)findViewById(R.id.button3);
        mCheckBox = (CheckBox)findViewById(R.id.checkBox);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            mEditTextName.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            mEditTextEmail.setText(sharedpreferences.getString(Email, ""));
        }
        if (sharedpreferences.contains(Checkbox)) {
            mCheckBox.setText(sharedpreferences.getString(Checkbox, ""));
        }

    }

    public void Save(View view) {
        String name = mEditTextName.getText().toString();
        String email = mEditTextEmail.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(Checkbox, mCheckBox.isChecked());
        editor.putString(Name, name);
        editor.putString(Email, email);
        editor.commit();
    }

    public void Clear(View view) {
        mEditTextName = (EditText) findViewById(R.id.editText);
        mEditTextEmail = (EditText) findViewById(R.id.editText2);
        mEditTextName.setText("");
        mEditTextEmail.setText("");
        mCheckBox.setChecked(false);
    }

    public void Get(View view) {
        mEditTextName = (EditText) findViewById(R.id.editText);
        mEditTextEmail = (EditText) findViewById(R.id.editText2);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        boolean checkBoxValue = sharedpreferences.getBoolean(Checkbox, false);
        if (checkBoxValue) {
            mCheckBox.setChecked(true);
        } else {
            mCheckBox.setChecked(false);
        }

        if (sharedpreferences.contains(Name)) {
            mEditTextName.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            mEditTextEmail.setText(sharedpreferences.getString(Email, ""));

        }
    }


}
