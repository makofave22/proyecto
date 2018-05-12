package com.uni.trabajo.proyecto;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {


    Button ce,c,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPunto,btnMas,btnMenos,btnPor,btndiv,btnBack,
            btnSeno,btnCoseno,btnTan,btnigual;

    public FloatingActionButton fabAbout;

    TextView textViewResult,txtOperador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        fabAbout=(FloatingActionButton)findViewById(R.id.floatingAbout);
        fabAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intetCalcu = new Intent(CalculadoraActivity.this,MainActivity.class);
                //startActivity(intetCalcu);

               /* AboutDialogfragment aboutDialogfragment=new AboutDialogfragment();
               aboutDialogfragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
                aboutDialogfragment.show(getSupportFragmentManager(),"About");*/


            }
        });

        txtOperador=(TextView)findViewById(R.id.txtOperador);
        textViewResult=(TextView)findViewById(R.id.texviewResult);

        ce=(Button)findViewById(R.id.btce);
        ce.setOnClickListener(this);

        c=(Button)findViewById(R.id.btc);
        c.setOnClickListener(this);

        btn0=(Button)findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3=(Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4=(Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5=(Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6=(Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7=(Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8=(Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9=(Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        //btnPunto,btnMas,btnMenos,btnPor,btndiv,btnBack;
        btnPunto=(Button)findViewById(R.id.btnPunto);
        btnPunto.setOnClickListener(this);
        btnMenos=(Button)findViewById(R.id.btnMenos);
        btnMenos.setOnClickListener(this);
        btnMas=(Button)findViewById(R.id.btnMas);
        btnMas.setOnClickListener(this);
        btndiv=(Button)findViewById(R.id.btndiv);
        btndiv.setOnClickListener(this);
        btnBack=(Button)findViewById(R.id.btnback);
        btnBack.setOnClickListener(this);

        btnPor=(Button)findViewById(R.id.btnpor);
        btnPor.setOnClickListener(this);

        btnSeno=(Button)findViewById(R.id.btnSeno);
        btnSeno.setOnClickListener(this);

        btnCoseno=(Button)findViewById(R.id.btnCos);
        btnCoseno.setOnClickListener(this);

        btnTan=(Button)findViewById(R.id.btnTan);
        btnTan.setOnClickListener(this);

        btnigual=(Button)findViewById(R.id.btnIgual);
        btnigual.setOnClickListener(this);




    }


    public Double valor1,valor2,result=0.0;
    public String operacion="";
    @Override
    public void onClick(View view) {
        Button boton=(Button)view;

        Double valor=0.0;
        DecimalFormat df = new DecimalFormat("#.00");
        switch (boton.getText().toString())
        {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if(operacion=="=")
                {
                    textViewResult.setText("0");
                    txtOperador.setText("");
                    operacion="";
                    result=0.0;
                }
                String num="",txtResult=textViewResult.getText().toString();
                if(textViewResult.getText().toString()=="")

                    num=boton.getText().toString();
                else
                    num=textViewResult.getText().toString()+boton.getText().toString();
            textViewResult.setText(num);
            break;


            case ".":
                String dato=textViewResult.getText().toString();
                if(!textViewResult.getText().toString().contains("."))
                    textViewResult.setText(dato+".");

                break;
            case "C":
                textViewResult.setText("0");
                txtOperador.setText("");
                operacion="";
                result=0.0;
                break;

            case "CE":
                textViewResult.setText("0");
                txtOperador.setText("");
                break;

            case "/":
                operacion="/";
                valor=Double.parseDouble(textViewResult.getText().toString());

                if(result!=0)
                    result/=valor;
                else
                    result=valor;

                textViewResult.setText("0");
                txtOperador.setText("/");
                break;
            case "X":
                operacion="X";
                 valor=Double.parseDouble(textViewResult.getText().toString());

                if(result!=0)
                    result*=valor;
                else
                    result=valor;

                textViewResult.setText("0");
                txtOperador.setText("X");
                break;

            case "+":
                operacion="+";
                valor=Double.parseDouble(textViewResult.getText().toString());

                if(result!=0)
                    result+=valor;
                else
                    result=valor;

                textViewResult.setText("0");
                txtOperador.setText("+");
                break;
            case "-":
                operacion="-";
                valor=Double.parseDouble(textViewResult.getText().toString());

                if(result!=0)
                    result-=valor;
                else
                    result=valor;

                textViewResult.setText("0");
                txtOperador.setText("-");
                break;
            case "SIN X":
                operacion="";
                valor=Double.parseDouble(textViewResult.getText().toString());
                valor=Math.toRadians(valor);

                if(valor!=0)
                    result=Math.sin(valor);

                textViewResult.setText(""+result);
                txtOperador.setText("SEN");
                break;
            case "COS X":
                operacion="";
                valor=Double.parseDouble(textViewResult.getText().toString());
                valor=Math.toRadians(valor);

                if(valor!=0)
                    result=Math.cos(valor);

                textViewResult.setText(""+result);
                txtOperador.setText("COS");
                break;
            case "TAN X":
                operacion="";
                valor=Double.parseDouble(textViewResult.getText().toString());
                valor=Math.toRadians(valor);

                if(valor!=0)
                    result=Math.tan(valor);

                textViewResult.setText(""+result);
                txtOperador.setText("TAN");
                break;

            case "=":

                Double valor1=0.0;
                switch (operacion)
                {
                    case "/":
                         valor1=Double.parseDouble(textViewResult.getText().toString());

                        if(valor1!=0) {
                            result /= valor1;
                             df = new DecimalFormat("#.000");
                            textViewResult.setText(""+df.format(result));
                            txtOperador.setText("=");
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Divicion entre 0 NO valida: ",Toast.LENGTH_LONG).show();


                        break;

                    case "X":
                         valor1=Double.parseDouble(textViewResult.getText().toString());


                            result *= valor1;
                            textViewResult.setText(""+df.format(result));
                            txtOperador.setText("=");
                        break;

                    case "+":
                        valor1=Double.parseDouble(textViewResult.getText().toString());
                        result += valor1;
                        textViewResult.setText(""+df.format(result));
                        txtOperador.setText("=");
                        break;
                    case "-":
                        valor1=Double.parseDouble(textViewResult.getText().toString());
                        result -= valor1;
                        textViewResult.setText(""+df.format(result));
                        txtOperador.setText("=");
                        break;



                }
                operacion="=";
                break;



        }
        //if(boton.getText()=="CE")
           // Toast.makeText(getApplicationContext(),"Presionastes: "+boton.getText(),Toast.LENGTH_LONG).show();
    }
}
