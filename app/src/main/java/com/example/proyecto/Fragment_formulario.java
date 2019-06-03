package com.example.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class Fragment_formulario extends Fragment{

    ImageView img;
    View vista;
    Button btnActivity;





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_formulario, container,false);

       // Button btn = vista.findViewById(R.id.btn_foto);
        //img = vista.findViewById(R.id.imagen);


        //---------------ESTO ABRE UN ACTIVITY------------------------
        btnActivity = vista.findViewById(R.id.btn_detalles);
        btnActivity.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Main2Activity.class);
                getActivity().startActivity(intent);
            }
        });
        //_--------------------------------------------------------------






        //Sirve para inicializar los botones la variable "vista"

        return vista;

    }


    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        img.setImageBitmap(bitmap);

    }








}
