package com.example.final_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    TableLayout bukvi;
    int r, h, w, ww, hh, ii, jj, iii, jjj, iiiz, jjjz, noml, muz = 0, rn, nab; //nab
    double x, y;
    String nameb, namef;
    boolean chit;
    ConstraintLayout cnst;
    //Words word;
    Words word;
    Random rnd = new Random();
    UpperTextView[][] elem = new UpperTextView[15][15];
    List<UpperTextView> za = new ArrayList<UpperTextView>();
    List<Integer> lin_v = new ArrayList<Integer>();
    String buklet;
    List<List> poloch_ot_haichi = new ArrayList<List>();
    List<List> real_dor = new ArrayList<List>();
    MediaPlayer mediaPlayer;
    // boolean iz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//чтобы не было строки заголовка
        setContentView(R.layout.activity_main);
        Intent mintent = getIntent();
        TableLayout.LayoutParams tblp = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
        //int nab;
        muz = mintent.getExtras().getInt("utai");
        bukvi = (TableLayout) findViewById(R.id.table);
        cnst = (ConstraintLayout) findViewById(R.id.cnst1);
        bukvi.setStretchAllColumns(true);
        chit = false;
        Point size = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(size);
        h = (int) (size.y);
        w = (int) (size.x);
        TableRow.LayoutParams trp1 = new TableRow.LayoutParams(w / 16, h / 15);
        //Random ran = new Random();
        word = new Words();
        rn = rnd.nextInt(22) + 1;
        if (!Game_start.razfons.contains(String.valueOf(rn))) {
            Game_start.razfons.add(String.valueOf(rn));
            // Game_start.fon++;*/
        }
        namef = "ff" + String.valueOf(rn);
        int nab1 = getResources().getIdentifier(namef, "drawable", getPackageName());
        //bukvi.setBackgroundResource(nab);
        try {
            cnst.setBackgroundResource(nab1);
        } catch (OutOfMemoryError e) {

        }
        if (Game_start.iz) {
            word = new Words(true);
        } else {
            word = new Words();
        }
        while (true) {
            try {
                poloch_ot_haichi = Haichi.metod_shisti_putei();
                break;
            } catch (Exception e) {
                continue;
            }
        }
        List<List> real_dor = new ArrayList<List>();
        List<String> let_zap = new ArrayList<String>();
        let_zap = poloch_ot_haichi.get(0);
        Iterator<String> bukv = let_zap.iterator();
        buklet = "";

        for (int i = 0; i < 15; i++) {
            TableRow tr = new TableRow(getApplicationContext());
            tr.setLayoutParams(tblp);
            tr.setBackgroundResource(R.color.cc);
            for (int k = 0; k < 15; k++) {
                UpperTextView bu = new UpperTextView(getApplicationContext());
                if (i % 2 == 0 && k % 2 == 0) {
                    nameb = bukv.next();
                    bu.setText(nameb);
                    bu.setTextColor(Color.BLACK);
                    bu.setOnTouchListener(this);
                    bu.setTag("0");
                    bu.specBn = noml;
                    noml++;

                } else {
                    bu.setTag("net");
                    if (i % 2 == 1 && k % 2 == 0) {
                        bu.setText("0");
                        bu.setTextColor(Color.TRANSPARENT);
                        bu.setOnTouchListener(this);
                        bu.setTag("net1");
                    } else {
                        if (i % 2 == 0) {
                            bu.setText("9");
                            bu.setTextColor(Color.TRANSPARENT);
                            bu.setOnTouchListener(this);
                            bu.setTag("net1");
                        }
                    }
                }
                bu.setLayoutParams(trp1);
                elem[i][k] = bu;
                bu.setTextSize(24);
                bu.setGravity(Gravity.CENTER);
                tr.addView(bu);
            }
            bukvi.addView(tr);
        }
        switch (muz) {
            case 0:
                break;
            case 2:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fonuta1);
                mediaPlayer.start();
                break;
            case 1:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fonuta2);
                mediaPlayer.start();
                break;

        }
        chit = false;
        //Words wr;
        Toast tost = Toast.makeText(MainActivity.this, word.fons.get(rn - 1), Toast.LENGTH_LONG);
        tost.setGravity(Gravity.RIGHT, 0, 0);
        tost.show();

    }

    protected void onStop() {
        super.onStop();
        if (muz != 0) {
            mediaPlayer.stop();
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        UpperTextView nTx = (UpperTextView) v;
        ww = (int) bukvi.getWidth() / 15;
        hh = (int) bukvi.getHeight() / 15;
        ii = (int) event.getX() / ww;
        jj = (int) event.getRawY() / hh;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (chit) {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                    mBuilder.setTitle(getString(R.string.dei))
                            .setMessage(getString(R.string.yv))
                            .setIcon(R.drawable.sets)
                            .setCancelable(false)
                            .setNegativeButton(getString(R.string.sogl), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    // dialog.cancel();закрытие окна
                                }
                            });
                    AlertDialog malert = mBuilder.create();
                    malert.show();
                }
                chit = true;
                za.clear();
                lin_v.clear();
                x = event.getX();
                y = event.getY();
                if (!nTx.metka && nTx.specBn!=-1) {
                    Logic_game.chAnge(nTx);
                    nTx.metka = !(nTx.metka);
                    iiiz = jj + ((int) nTx.getY() / hh);
                    jjjz = ii + ((int) nTx.getX() / ww);
                    za.add(nTx);
                    if (nTx.specBn != -1) {
                        lin_v.add(nTx.specBn);
                        buklet += nTx.getText();
                    }
                }

                break;
            case MotionEvent.ACTION_MOVE:
                iii = jj + ((int) nTx.getY() / hh);
                jjj = ii + ((int) nTx.getX() / ww);
                if (iii < 15 && iii >= 0 && jjj >= 0 && jjj < 15) {
                    nTx = elem[iii][jjj];
                    if (!nTx.metka && (iiiz == iii + 1 || iiiz == iii - 1 || iii == iiiz) && (jjjz == jjj + 1 || jjjz == jjj - 1 || jjj == jjjz) && (jjj == jjjz || iii == iiiz)) {
                        Logic_game.chAnge(nTx);
                        nTx.metka = !(nTx.metka);
                        za.add(nTx);
                        if (nTx.specBn != -1) {
                            lin_v.add(nTx.specBn);
                            buklet += nTx.getText();
                        }
                        if (!(nTx.getTag().equals("net"))) {
                            iiiz = iii;
                            jjjz = jjj;
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                chit = false;
                real_dor = poloch_ot_haichi.get(1);
                Iterator<List> red = real_dor.iterator();
                boolean sterca = true;
                int sch = 0;
                while (red.hasNext()) {
                    List A = red.next();
                    sch++;
                    sterca = !(Logic_game.hikaku(A, lin_v));
                    if (!sterca) {
                        real_dor.remove(sch - 1);
                        break;
                    }
                }

                if (!sterca) {
                    if (Game_start.onner) {
                        Toast.makeText(MainActivity.this, "" + getString(R.string.ye), Toast.LENGTH_SHORT).show();
                    }
                    int co = za.size();
                    if ((za.get(co - 1)).specBn == -1) {
                        Logic_game.chAnge(za.get(co - 1));
                        za.remove(co - 1);
                    }
                    if (za.get(0).specBn == -1) {
                        Logic_game.chAnge(za.get(0));
                        za.remove(0);
                    }
                    if (!Game_start.slisb.contains(buklet)) {
                        Game_start.slisb.add(buklet);
                        // Game_start.leters++;
                    }
                    if (word.red.contains(buklet) && !Game_start.red.contains(buklet)) {
                        Game_start.red.add(buklet);
                        //Game_start.cre++;
                        Toast toast3 = Toast.makeText(getApplicationContext(), getString(R.string.omered), Toast.LENGTH_LONG);
                        toast3.setGravity(Gravity.CENTER, 0, 0);
                        try {
                            LinearLayout toastContainer = (LinearLayout) toast3.getView();
                            ImageView catImageView = new ImageView(MainActivity.this);
                            catImageView.setImageResource(R.drawable.winp);
                            toastContainer.addView(catImageView, 0);
                        } catch (OutOfMemoryError ex) {

                        }
                        toast3.show();

                    }
                    if (word.ep.contains(buklet) && !Game_start.setep.contains(buklet)) {
                        Game_start.setep.add(buklet);
                        //Game_start.colep++;
                        Toast toast3 = Toast.makeText(getApplicationContext(), getString(R.string.omeep), Toast.LENGTH_LONG);
                        toast3.setGravity(Gravity.CENTER, 0, 0);
                        try {
                            LinearLayout toastContainer = (LinearLayout) toast3.getView();
                            ImageView catImageView = new ImageView(MainActivity.this);
                            catImageView.setImageResource(R.drawable.winp);
                            toastContainer.addView(catImageView, 0);
                        } catch (OutOfMemoryError ex) {

                        }
                        toast3.show();
                    }
                    r = rnd.nextInt(12) + 1;
                    nameb = "c" + String.valueOf(r);
                    nab = getResources().getIdentifier(nameb, "color", getPackageName());
                    Iterator<UpperTextView> zak = za.listIterator();
                    buklet = "";
                    while (zak.hasNext()) {
                        UpperTextView why = zak.next();
                        why.setBackgroundResource(nab);
                    }
                    if (real_dor.size() == 0) {
                        if (muz != 0) {
                            mediaPlayer.stop();
                        }
                        Game_start.pob++;
                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                        mBuilder.setTitle(getString(R.string.vipo))
                                .setMessage(getString(R.string.omede))
                                //.setIcon(R.drawable.abswin)
                                .setCancelable(false)
                                .setNegativeButton(getString(R.string.exi), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        finish();
                                    }
                                });
                        AlertDialog malert = mBuilder.create();
                        malert.show();
                    }
                }
                if (sterca) {
                    if (Game_start.onner) {
                        Toast.makeText(MainActivity.this, "" + getString(R.string.nee), Toast.LENGTH_SHORT).show();
                    }
                    Iterator<UpperTextView> zak = za.listIterator();
                    while (zak.hasNext()) {
                        UpperTextView why = zak.next();
                        Logic_game.chAnge(why);
                        why.metka = false;
                        buklet = "";
                    }
                }

                break;
        }
        return true;
    }
}
