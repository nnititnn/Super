package com.example.publi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
        ArrayList<Integer> daymay= new ArrayList<Integer>();
         ArrayList<Integer> daynguoi= new ArrayList<Integer>();

        ArrayList<Integer> dayso=new ArrayList<Integer>();
        HashSet<Integer> hashset= new HashSet<Integer>();

          ArrayList<Integer> dayrd= new ArrayList<Integer>();

    EditText nhap, nhap2;
    TextView thongbao, ketqua, ketqua2;
    Button tinh, tinh2, tinh3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nhap=(EditText)findViewById(R.id.edtnhap);
        tinh=(Button)findViewById(R.id.btntinh);
        thongbao=(TextView)findViewById(R.id.txtthongbao);
        tinh3=(Button)findViewById(R.id.btntao);
        ketqua2=(TextView)findViewById(R.id.txtketqua2);
        nhap2=(EditText)findViewById(R.id.edtnhap2);
        tinh2=(Button)findViewById(R.id.btntinh2);
        ketqua=(TextView)findViewById(R.id.txtketqua);
        Random r=new Random();
        for (int i=0;i<4;i++){
            int so=r.nextInt(6-1+1)+1;
            daymay.add(so);

        }
//        for (int i=0; i<4;i++){
//            int so2=r.nextInt(9-0+1)+0;
//            dayso.add(so2);
//        }

        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_daynguoi=nhap.getText().toString();
                String[] mangchuoi=s_daynguoi.split(" ");
                daynguoi.clear();
                for(int i=0;i<mangchuoi.length;i++){
                    daynguoi.add(Integer.parseInt(mangchuoi[i]));
                    String chuoi="day may";
                    for(Integer item : daymay){
                        chuoi+=item+",";
                    }
                }
                int coso=0;
                int dungsovitri=0;
                for(int i=0;i<daynguoi.size();i++){
                    if(daymay.contains(daynguoi.get(i))==true){
                        coso++;
                    }
                }
                for (int i=0; i<daynguoi.size();i++){
                    if (daynguoi.get(i)==daymay.get(i)){
                        dungsovitri++;
                    }
                }
                thongbao.setText("day may la  :"+daymay+"\n"+ "day nguoi la "+daynguoi+ "\n"+"phan tu nguoi nam trong phan tu may la    "+coso+"\n"+"so phan tu dung so dung so vi tri voi may : "+dungsovitri);
            }
        });

        tinh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_dayso=nhap2.getText().toString();
                String[] manghashset=s_dayso.split(" ");

                dayso.clear();
                for (int i=0; i<manghashset.length;i++){
                    Integer soso =Integer.parseInt(manghashset[i]);
                  for(int j=0; j<10;j++){
                      if(soso == j){
                          dayso.add(j);
                      }
                  }
                }
                ketqua.setText("day so la "+dayso);
            }
        });
        tinh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inewnumber=0, iprevious=-1;
                for(int i=0;i<13;i++){
                Random rd=new Random();
                inewnumber =rd.nextInt(52);
                    if(inewnumber!=iprevious){
                        iprevious=inewnumber;
                       dayrd.add(inewnumber);
                        ketqua2.setText("");
                    }
                    ketqua2.setText("day so random+"+dayrd);
                }
            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
