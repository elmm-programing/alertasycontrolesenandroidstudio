package com.example.alertasycontroles;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout relativeLayout;
    public String nombre,clase,Instituto;
    SwipeListener swipeListener;
    private ArrayList<CheckBox> mChecks;
    private ArrayList<CheckBox> mSelectedChecks;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout= (RelativeLayout) findViewById(R.id.relative_layouts);
        swipeListener = new SwipeListener(relativeLayout);
        nombre = "Edwin Levinson Mejia Marcelino";
        clase= "Introducción al Desarrollo de Aplicaciones Móviles";
        Instituto="ITLA";
        mChecks = new ArrayList<CheckBox>();
        mSelectedChecks = new ArrayList<CheckBox>();
        CheckBox check1 = (CheckBox)findViewById(R.id.checkBox);
        CheckBox check2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox check3 = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox check4 = (CheckBox)findViewById(R.id.checkBox4);
        //Add to tracking list
        mChecks.add(check1);
        mChecks.add(check2);
        mChecks.add(check3);
        mChecks.add(check4);
        ImageView img = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1.isChecked()){
                    if (check2.isChecked()){
                        img.setImageResource(R.drawable.calleconmusica);

                    }else if (check3.isChecked()){
                        img.setImageResource(R.drawable.calleconpersonas);

                    }else if(check4.isChecked()){
                        img.setImageResource(R.drawable.carroencalle2);

                    }

                }else if(check2.isChecked()){
                    if (check1.isChecked()){
                        img.setImageResource(R.drawable.calleconmusica);
                    }else if (check3.isChecked()){
                        img.setImageResource(R.drawable.musicaconpersona);
                    }else if(check4.isChecked()){
                        img.setImageResource(R.drawable.carroconmusica);
                    }

                }else if(check3.isChecked()){
                    if (check2.isChecked()){
                        img.setImageResource(R.drawable.musicaconpersona);
                    }else if (check1.isChecked()){
                        img.setImageResource(R.drawable.calleconpersonas);
                    }else if(check4.isChecked()){
                        img.setImageResource(R.drawable.personaconcarro);
                    }

                }else if(check4.isChecked()){
                    if (check2.isChecked()){
                        img.setImageResource(R.drawable.carroconmusica);
                    }else if (check3.isChecked()){
                        img.setImageResource(R.drawable.personaconcarro);
                    }else if(check1.isChecked()){
                        img.setImageResource(R.drawable.carroencalle);
                    }

                }
            }
        });


        //Add Click listener
        for(CheckBox c : mChecks) {
            c.setOnClickListener(this);
        }



    }

    @Override
    public void onClick(View view) {
        CheckBox c = (CheckBox)view;

        if(mSelectedChecks.contains(c)) {
            mSelectedChecks.remove(c);
        } else {
            if(mSelectedChecks.size() < 2) {
                mSelectedChecks.add(c);
            } else {
                mSelectedChecks.remove(0);
                mSelectedChecks.add(c);
            }
        }

        drawResults();
    }

    public void drawResults() {
        for(CheckBox c : mChecks) {
            c.setChecked(mSelectedChecks.contains(c));
        }
    }
    public void showEditDialog(View view)
    {

        // Create an alert builder
        AlertDialog.Builder builder
                = new AlertDialog.Builder(this);
        builder.setTitle("Editar Datos");

        // set the custom layout
        final View customLayout
                = getLayoutInflater()
                .inflate(
                        R.layout.editinfo,
                        null);
        builder.setView(customLayout);
        final View info
                = getLayoutInflater()
                .inflate(
                        R.layout.info,
                        null);
        builder.setView(customLayout);

        // add a button
        builder
                .setPositiveButton(
                        "editar",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(
                                    DialogInterface dialog,
                                    int which)


                            {

                                // send data from the
                                // AlertDialog to the Activity
                                EditText editNombre = customLayout.findViewById(R.id.editName);
                                EditText editMateria = customLayout.findViewById(R.id.editClase);
                                EditText editInstituto = customLayout.findViewById(R.id.editInstituto);
                               nombre = editNombre.getText().toString();
                               clase = editMateria.getText().toString();
                               Instituto =editInstituto.getText().toString();





                            }
                        });

        // create and show
        // the alert dialog
        AlertDialog dialog
                = builder.create();
        dialog.show();
    }

    // Do something with the data
    // coming from the AlertDialog
    private void sendDialogDataToActivity(String data)
    {
        Toast.makeText(this,
                        data,
                        Toast.LENGTH_SHORT)
                .show();
    }
    public void showAlertDialogButtonClicked(View view)
    {

        // Create an alert builder
        AlertDialog.Builder builder
                = new AlertDialog.Builder(this);
        builder.setTitle("Name");

        // set the custom layout
        final View customLayout
                = getLayoutInflater()
                .inflate(
                        R.layout.info,
                        null);
        builder.setView(customLayout);
        TextView TextNombre = customLayout.findViewById(R.id.textView5);
        TextView Textmateria = customLayout.findViewById(R.id.textView6);
        TextView TextInstituto = customLayout.findViewById(R.id.textView7);
        TextNombre.setText(nombre);
        Textmateria.setText(clase);
        TextInstituto.setText(Instituto);
        // add a button
        builder
                .setPositiveButton(
                        "ok",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(
                                    DialogInterface dialog,
                                    int which)
                            {

                                // send data from the
                                // AlertDialog to the Activity





                            }
                        });

        // create and show
        // the alert dialog
        AlertDialog dialog
                = builder.create();
        dialog.show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public class SwipeListener implements View.OnTouchListener {
        GestureDetector gestureDetector;

        SwipeListener(View view){
            int threshold =100;
            int velocity_threshold=100;

            GestureDetector.SimpleOnGestureListener listener =
                    new GestureDetector.SimpleOnGestureListener(){
                        @Override
                        public boolean onDown(MotionEvent e) {
                            return true;
                        }

                        @Override
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                            float xDiff =e2.getX() - e1.getX();
                            float yDiff=e2.getY() - e1.getY();
                            try {
                                if (Math.abs(xDiff)> Math.abs(yDiff)){
                                    if (Math.abs(xDiff)> threshold && Math.abs(velocityX)>velocity_threshold){
                                        if (xDiff >0){


                                        }else{
                                            MainActivity.this.finish();
                                            System.exit(0);
                                        }
                                        return true;
                                    }
                                }else{
                                    return false;
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            return false;
                        }
                    };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);
        }
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }
    }

}
