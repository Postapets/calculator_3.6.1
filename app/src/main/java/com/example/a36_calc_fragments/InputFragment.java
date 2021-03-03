package com.example.a36_calc_fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment implements View.OnClickListener{
    EditText A;
    EditText B;
    String answer;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button plusButton = (Button) getView().findViewById(R.id.plusButton);
        plusButton.setOnClickListener(this);

        Button minusButton = (Button) getView().findViewById(R.id.minusButton);
        minusButton.setOnClickListener(this);

        Button multButton = (Button) getView().findViewById(R.id.multButton);
        multButton.setOnClickListener(this);

        Button divButton = (Button) getView().findViewById(R.id.divButton);
        divButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        A = (EditText) getView().findViewById(R.id.A);
        B = (EditText) getView().findViewById(R.id.B);
        if (A.getText().length()>0 && B.getText().length()>0){

        double a = Double.parseDouble(String.valueOf(A.getText()));
        double b = Double.parseDouble(String.valueOf(B.getText()));


        switch (v.getId()){
            case R.id.plusButton:
                a+=b;
                break;
            case R.id.minusButton:
                a-=b;
                break;
            case R.id.multButton:
                a*=b;
                break;
            case R.id.divButton:
                a/=b;
                break;

        }
        answer = "" + a;


        } else answer = "A or B is not found";
        MessageFragment fragment = (MessageFragment)getFragmentManager().findFragmentById(R.id.fragment_answer);
        fragment.setMessage(answer);
    }
}
