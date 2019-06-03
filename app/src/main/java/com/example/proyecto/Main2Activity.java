package com.example.proyecto;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.proyecto.model.persona;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main2Activity extends AppCompatActivity {

    private List<persona> listaPersona = new ArrayList<>();
    ArrayAdapter<persona> arrayAdapterPersona;

    EditText nombre, mensaje;
    ImageButton enviarM;
    ListView listv_mensaje;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = findViewById(R.id.txt_nombrePersona);
        mensaje = findViewById(R.id.txt_mensaje);
        enviarM = findViewById(R.id.enviar);


        listv_mensaje = findViewById(R.id.lv_mensajes);
        iniciarFirebase();
        listarDatos();




        enviarM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = nombre.getText().toString();
                String msj = mensaje.getText().toString();

                persona p = new persona();
                p.setUid(UUID.randomUUID().toString());
                p.setNombre(nom);
                p.setMensaje(msj);
                databaseReference.child("persona").child(p.getUid()).setValue(p);
                limpiarcajas();
            }
        });
    }

    private void listarDatos() {
        databaseReference.child("persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaPersona.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()){
                    persona p = objSnapshot.getValue(persona.class);
                    listaPersona.add(p);

                    arrayAdapterPersona = new ArrayAdapter<persona>(Main2Activity.this,android.R.layout.simple_list_item_1,listaPersona);
                    listv_mensaje.setAdapter(arrayAdapterPersona);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void limpiarcajas() {
        nombre.setText("");
        mensaje.setText("");
    }

    private void iniciarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
    }
}









