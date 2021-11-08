package com.example.individuaproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.gson.Gson;

public class Dialog extends AppCompatDialogFragment {
    StartWalking startWalking = new StartWalking();
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("save")
                .setMessage("are you sure to save information ! ")
                .setPositiveButton("save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        saveData();

                    }
                });
        return builder.create();
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json =gson.toJson(startWalking.seconds);
        editor.putString("task list",json);
        editor.apply();
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(),"Data Saved successfully ",Toast.LENGTH_SHORT).show();
            }
        });

    }


//    public void loadData(){
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = sharedPreferences.getString("task list",null);
//        Type type = new TypeToken<ArrayList<>>() {}.getType();
//        arraylist = gson.fromJson(json,type);
//
//        if (arraylist == null){
//            arraylist = new ArrayList<>();
//        }
//    }
}
