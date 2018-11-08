package com.example.szedo.k_papr_oll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button Button_ko,Button_papir,Button_ollo;
    private TextView Text_View_Eredmeny;
    private ImageView Image_View_Mine, Image_View_Gep;
    public int win,lose;
    public String valasztasom,gepvalasztasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Image_View_Mine.setImageResource(R.drawable.start);
        Image_View_Gep.setImageResource(R.drawable.start);

        win = 0;
        lose = 0;


       Button_ko.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               valasztasom ="ko";
               Image_View_Mine.setImageResource(R.drawable.rock);
               eldont();
           }
       });
       Button_ollo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               valasztasom = "ollo";
               Image_View_Mine.setImageResource(R.drawable.scissors);
               eldont();
           }
       });
        Button_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valasztasom = "papir";
                Image_View_Mine.setImageResource(R.drawable.paper);
                eldont();
            }
        });


    }
    public void init(){
        Button_papir = (Button) findViewById(R.id.Button_papir);
        Button_ko = (Button) findViewById(R.id.Button_ko);
        Button_ollo = (Button) findViewById(R.id.Button_ollo);
        Text_View_Eredmeny = (TextView) findViewById(R.id.Text_View_Eredmeny);
        Image_View_Mine = (ImageView) findViewById(R.id.Image_View_Mine);
        Image_View_Gep = (ImageView) findViewById(R.id.Image_View_Gep);
        Random r = new Random();
    }
    public void eldont(){
        Random r = new Random();
        int gepDontes = r.nextInt(3);
        if(gepDontes == 0){
            gepvalasztasa="ko";
            Image_View_Gep.setImageResource(R.drawable.rock);
        }else if(gepDontes == 1){
            gepvalasztasa ="papir";
            Image_View_Gep.setImageResource(R.drawable.paper);
        }else{
            gepvalasztasa ="ollo";
            Image_View_Gep.setImageResource(R.drawable.scissors);
        }
        //valasztasom,gepvalasztasa
        if(valasztasom == "ko" && gepvalasztasa == "papir"){
            lose++;
            Toast.makeText(MainActivity.this, "Vesztettél!", Toast.LENGTH_SHORT).show();
        }else if(valasztasom == "ko" && gepvalasztasa == "ollo"){
            win++;
            Toast.makeText(MainActivity.this, "Nyertel!", Toast.LENGTH_SHORT).show();

        }else if(valasztasom == "papir" && gepvalasztasa == "ko"){
            win++;
            Toast.makeText(MainActivity.this, "Nyertel!", Toast.LENGTH_SHORT).show();

        }else if(valasztasom == "papir" && gepvalasztasa == "ollo"){
            lose++;
            Toast.makeText(MainActivity.this, "Vesztettél!", Toast.LENGTH_SHORT).show();

        }else if(valasztasom == "ollo" && gepvalasztasa == "papir"){
            win++;
            Toast.makeText(MainActivity.this, "Nyertel!", Toast.LENGTH_SHORT).show();

        }else if(valasztasom == "ollo" && gepvalasztasa == "ko"){
            lose++;
            Toast.makeText(MainActivity.this, "Vesztettél!", Toast.LENGTH_SHORT).show();

        }else if(valasztasom == gepvalasztasa){
            Toast.makeText(MainActivity.this, "Döntetlen!", Toast.LENGTH_SHORT).show();
        }
        Text_View_Eredmeny.setText("Eredmény: Te: "+win+" Gép: "+lose);
    }

}
