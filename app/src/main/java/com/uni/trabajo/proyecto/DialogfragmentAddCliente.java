package com.uni.trabajo.proyecto;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.uni.trabajo.proyecto.Clases.Clientes;
import com.uni.trabajo.proyecto.Clases.DataBaseManager;

/**
 * Created by Makofave on 09/05/2018.
 */

public class DialogfragmentAddCliente extends DialogFragment
{
    public DialogfragmentAddCliente() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    public Button botonGuardar;
    DataBaseManager manager;

    public EditText nombre,apellid,direccion,correo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view= inflater.inflate(R.layout.dialog_add_clientes, container, false);

        nombre=(EditText)view.findViewById(R.id.editTextNombre);
        apellid=(EditText)view.findViewById(R.id.editTextApellido);
        direccion=(EditText)view.findViewById(R.id.editTextDireccion);
        correo=(EditText)view.findViewById(R.id.editTextCorreo);
        botonGuardar=(Button)view.findViewById(R.id.btnGuardar);

        manager=new DataBaseManager(getActivity());
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(nombre.getText().length()>0&&apellid.getText().length()>0&&direccion.getText().length()>0&&
                        correo.getText().length()>0)
                {
                    Clientes clientes=new Clientes();

                    manager.insertClientes(nombre.getText().toString(),
                                            apellid.getText().toString(),
                                            direccion.getText().toString(),
                                            correo.getText().toString()
                                            );
                    Toast.makeText(getActivity(),"Cliente Guardado ",Toast.LENGTH_SHORT).show();
                    dismiss();



                }else
                    Toast.makeText(getActivity(),"Llene todos los campos ",Toast.LENGTH_SHORT).show();

            }
        });




        return view;
    }
}
