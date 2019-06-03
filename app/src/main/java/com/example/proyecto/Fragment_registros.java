package com.example.proyecto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Fragment_registros extends Fragment {
    Button btnActivity2;
    ImageView img;
    View vista;

   // @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_registros, container,false);

        //---------------ESTO ABRE UN ACTIVITY------------------------
        btnActivity2 = vista.findViewById(R.id.btn_captura);
        btnActivity2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Main4Activity.class);
                getActivity().startActivity(intent);
            }
        });
        //_--------------------------------------------------------------



        return vista;
    }

    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        img.setImageBitmap(bitmap);

    }
}
