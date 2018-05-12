package com.uni.trabajo.proyecto.Clases;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.uni.trabajo.proyecto.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makofave on 07/05/2018.
 */

public class AdapterClientes extends RecyclerView.Adapter<AdapterClientes.ViewHolder> {

    private Context context;
    private List<Clientes> my_data;

    public AdapterClientes(Context context, List<Clientes> my_data) {
        this.context = context;
        this.my_data = my_data;

        Toast.makeText(context,"Tamaño de lista: "+my_data.size(),Toast.LENGTH_SHORT).show();

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_clientes,parent,false);

        ViewHolder viewhold=new ViewHolder(itemView);
        //return new ViewHolder(itemView);
        return  viewhold;
    }
    public void updateListView(List<Clientes> viewModels){
        this.my_data = viewModels;
        notifyDataSetChanged();
        Toast.makeText(context,"Tamaño de lista: "+my_data.size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Toast.makeText(context,"Posision: "+position,Toast.LENGTH_SHORT).show();
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

    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        TextView idCliente,nameClientes,direccion,correo,apellidoCliente;

        public ViewHolder(View itemView) {
            super(itemView);

            idCliente=(TextView)itemView.findViewById(R.id.txtidCliente);
            nameClientes=(TextView)itemView.findViewById(R.id.nameCliente);
            direccion=(TextView)itemView.findViewById(R.id.txtDireccion);
            correo=(TextView)itemView.findViewById(R.id.txtCorreo);
            apellidoCliente=(TextView)itemView.findViewById(R.id.txtApellido);
        }
    }
}
