package com.uni.trabajo.proyecto;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.uni.trabajo.proyecto.Clases.Adapter;
import com.uni.trabajo.proyecto.Clases.AdapterClientes;
import com.uni.trabajo.proyecto.Clases.Clientes;
import com.uni.trabajo.proyecto.Clases.DataBaseManager;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    DataBaseManager manager;
    RecyclerView listClientes;
    public List<Clientes> clientesList;
    public AdapterClientes adapterClientes;
    ListView listview;
    FloatingActionButton botonAddClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar=findViewById(R.id.miToolbar);
        setSupportActionBar(toolbar);

        botonAddClient=(FloatingActionButton)findViewById(R.id.floatAddbuton);
        botonAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogfragmentAddCliente clieteAdd=new DialogfragmentAddCliente();
                clieteAdd.show(getSupportFragmentManager(),"");
            }
        });
        listview=(ListView)findViewById(R.id.listviewClientes);


        //listview.setlist


       // clientesList=new ArrayList<>();

        manager=new DataBaseManager(this);
        clientesList=manager.clientes();

        ArrayList<String> todoItems = new ArrayList<String>();

        //todoItems.clear();

        for(int i=0;i<clientesList.size();i++)
        {
            todoItems.add(clientesList.get(i).toString());
        }
        /*for (Clientes cli :
                clientesList) {
            todoItems2.add(clientesList.toString());

        }*/


        //Toast.makeText(this,"Tamaño de lista todoitem: "+todoItems.size(),Toast.LENGTH_SHORT).show();

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this, R.layout.simple_list_item_1,todoItems);
        listview.setAdapter(adaptador);

        //manager.insertClientes("Alberto","Elias","Emiliano Zapata. #1115","Makofave22@gmail.com");


       /* listClientes=(RecyclerView)findViewById(R.id.listCliente);
        adapterClientes=new AdapterClientes(this,clientesList);
        listClientes.setAdapter(adapterClientes);

        adapterClientes.notifyDataSetChanged();

        adapterClientes.updateListView(clientesList);*/





    }
}
