package com.uni.trabajo.proyecto.Clases;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.uni.trabajo.proyecto.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Makofave on 09/05/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<Clientes> my_data,mydata_array;
    private int idorigen;
    private int uniPos;
    private boolean pasar;
    //fragments
    public android.app.FragmentManager fragmentManager;

    public Adapter(Context context, List<Clientes> my_data){
        this.context=context;
        mydata_array=new ArrayList<>();

        this.my_data=my_data;

        //mydata_array=new ArrayList<>();
        // mydata_array.addAll(my_data);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_clientes,parent,false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.idCliente.setText(""+my_data.get(position).getId());
        holder.nameClientes.setText(""+my_data.get(position).getNombre());
        holder.apellidoCliente.setText(""+my_data.get(position).getApellido());
        holder.direccion.setText(""+my_data.get(position).getDireccion());
        holder.correo.setText(""+my_data.get(position).getCorreo());

    }



    @Override
    public int getItemCount() {
        return my_data.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView idCliente,nameClientes,direccion,correo,apellidoCliente;


        public ViewHolder(final View itemView) {
            super(itemView);

            idCliente=(TextView)itemView.findViewById(R.id.txtidCliente);
            nameClientes=(TextView)itemView.findViewById(R.id.nameCliente);
            direccion=(TextView)itemView.findViewById(R.id.txtDireccion);
            correo=(TextView)itemView.findViewById(R.id.txtCorreo);
            apellidoCliente=(TextView)itemView.findViewById(R.id.txtApellido);

            //nuevo

        }


    }





}