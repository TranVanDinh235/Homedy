package com.example.homedy.NewPost;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import com.example.homedy.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DialogPostFragment extends DialogFragment {


    @InjectView(R.id.numberpicker) NumberPicker _numberPicker;
    String[] strings = {"Ha Noi", "Hai Phong", "Da Nang", "Ho Chi Minh"};

    public interface DialogPostFragmetListener{
        public abstract void setDataFromFragment(String data);
    }

    DialogPostFragmetListener mListenter;

    public void setNumberPickerData(String[] data, NumberPicker numberPicker) {
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(data.length - 1);
        numberPicker.setDisplayedValues(data);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_dialog, null);
        ButterKnife.inject(this, view);
        setNumberPickerData(strings,_numberPicker);
        builder.setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListenter.setDataFromFragment(strings[_numberPicker.getValue()]);
                    }
                })
                .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return builder.create();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DialogPostFragment.DialogPostFragmetListener) {
            mListenter = (DialogPostFragment.DialogPostFragmetListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement DialogPostFragmentListener");
        }
    }
}
