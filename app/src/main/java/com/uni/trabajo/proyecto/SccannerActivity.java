package com.uni.trabajo.proyecto;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.uni.trabajo.proyecto.Clases.AdapterClientes;
import com.uni.trabajo.proyecto.Clases.Clientes;
import com.uni.trabajo.proyecto.Clases.DataBaseManager;
import com.uni.trabajo.proyecto.Clases.TessOCR;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SccannerActivity extends AppCompatActivity {

    DataBaseManager manager;
    public TessOCR mTessOCR;
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    private File file = new File(ruta_fotos);

    FloatingActionButton fabcam,botonUpdate;
    SurfaceView camara;
    TextView mostrar;
    CameraSource cameraSource;
    final int RequestCameraPermissionID = 1001;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RequestCameraPermissionID: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    try {
                        cameraSource.start(camara.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
            break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

//          mTessOCR =new TessOCR(this,"español");
        camara = (SurfaceView) findViewById(R.id.surfaceView);
        mostrar = (TextView) findViewById(R.id.txtMostrar);

        TextRecognizer textoReconocido = new TextRecognizer.Builder(getApplicationContext()).build();
        if (!textoReconocido.isOperational()) {
            Log.w("MainActivity", "Las dependencias del detector aún no están disponibles");
        } else {

            cameraSource = new CameraSource.Builder(getApplicationContext(), textoReconocido)
                    .setFacing(CameraSource.CAMERA_FACING_BACK)
                    .setRequestedPreviewSize(1280, 1024)
                    .setRequestedFps(2.0f)
                    .setAutoFocusEnabled(true)
                    .build();
            camara.getHolder().addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceCreated(SurfaceHolder surfaceHolder) {

                    try {
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                            ActivityCompat.requestPermissions(SccannerActivity.this,
                                    new String[]{Manifest.permission.CAMERA},
                                    RequestCameraPermissionID);
                            return;
                        }
                        cameraSource.start(camara.getHolder());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

                }

                @Override
                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    cameraSource.stop();
                }
            });

            textoReconocido.setProcessor(new Detector.Processor<TextBlock>() {
                @Override
                public void release() {

                }

                @Override
                public void receiveDetections(Detector.Detections<TextBlock> detections) {

                    final SparseArray<TextBlock> items = detections.getDetectedItems();
                    if(items.size() != 0)
                    {
                        mostrar.post(new Runnable() {
                            @Override
                            public void run() {
                                StringBuilder stringBuilder = new StringBuilder();
                                for(int i =0;i<items.size();++i)
                                {
                                    TextBlock item = items.valueAt(i);
                                    stringBuilder.append(item.getValue());
                                    stringBuilder.append("\n");
                                }
                                mostrar.setText(stringBuilder.toString());
                            }
                        });
                    }
                }
            });
        }








        // listview=(ListView)findViewById(R.id.listviewClientes);

        fabcam=(FloatingActionButton)findViewById(R.id.fabCam);

        fabcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String file = Environment.getExternalStorageDirectory() +  "img.jpg";
                     File mi_foto = new File( file );
                    try {
                                  mi_foto.createNewFile();
                              } catch (IOException ex) {
                               Log.e("ERROR ", "Error:" + ex);
                              }
                              //
                              Uri uri = Uri.fromFile( mi_foto );
                              //Abre la camara para tomar la foto
                              Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                              //Guarda imagen

                              cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                              //Retorna a la actividad
                              startActivityForResult(cameraIntent, 0);


            }
        });


       // adapterClientes.updateListView(clientesList);





    }
    @SuppressLint("SimpleDateFormat")
  private String getCode() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = dateFormat.format(new Date());
        String photoCode = "pic_" + date;
        return photoCode;
    }

    private void doOCR (final Bitmap bitmap) {
        /*if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog.show(ocrView, "Processing",
                    "Doing OCR...", true);
        } else {
            mProgressDialog.show();
        }*/
        /*
        new Thread(new Runnable() {
            public void run() {
                final String srcText = mTessOCR.getOCRResult(bitmap);
                ocrView.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        if (srcText != null && !srcText.equals("")) {
                            //srcText contiene el texto reconocido
                        }
                        mTessOCR.onDestroy();
                        //mProgressDialog.dismiss();
                    }
                });
            }
        }).start();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
