package com.uni.trabajo.proyecto;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
    ArrayAdapter<String> adaptador;
    FloatingActionButton botonAddClient,botonUpdate;
    ArrayList<String> todoItems;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar=findViewById(R.id.miToolbar);
        setSupportActionBar(toolbar);
       // listview=(ListView)findViewById(R.id.listviewClientes);

        botonUpdate=(FloatingActionButton)findViewById(R.id.floatUpdate);
        botonAddClient=(FloatingActionButton)findViewById(R.id.floatAddbuton);
        botonAddClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogfragmentAddCliente clieteAdd=new DialogfragmentAddCliente();
                clieteAdd.show(getSupportFragmentManager(),"");
            }
        });

        botonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                adapterClientes.update();



            }
        });

        manager=new DataBaseManager(this);
        clientesList=manager.clientes();


        layoutManager=new LinearLayoutManager(this);
        listClientes=(RecyclerView)findViewById(R.id.recyclerClientes);
        listClientes.setLayoutManager(layoutManager);
        adapterClientes=new AdapterClientes(this,clientesList);
        listClientes.setAdapter(adapterClientes);

        adapterClientes.notifyDataSetChanged();

       // adapterClientes.updateListView(clientesList);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id)
        {
            case R.id.web_pag:
                Intent webpag = new Intent(Main2Activity.this,WebActivity.class);
                startActivity(webpag);
                break;
            case R.id.action_scanner:
                Intent intetScanner = new Intent(Main2Activity.this,SccannerActivity.class);
                startActivity(intetScanner);
                break;
            case R.id.action_principal:
                break;

            case R.id.action_calculadora:
                Intent intetCalcu = new Intent(Main2Activity.this,CalculadoraActivity.class);
                startActivity(intetCalcu);
                break;


            case R.id.action_about:
                 AboutDialogfragment aboutDialogfragment=new AboutDialogfragment();
               aboutDialogfragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
                aboutDialogfragment.show(getSupportFragmentManager(),"About");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
