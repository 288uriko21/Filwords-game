package com.example.final_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Obuchenie extends AppCompatActivity implements View.OnTouchListener {

    private Timer mTimer;
    private MyTimerTask mTTask;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, tuu;
    List<TextView> och = new ArrayList<TextView>();
    Button nex, ex, pod;
    TextView txt;
    String[][] mas;
    String word, myw;
    Intent mintp;
    boolean chit = false;
    //Words word;
    TableLayout tbl;
    double x, y;
    int n = 0, nas = 0, ww, hh, ii, jj, iiiz, jjjz, iii, jjj;
    List<UpperTextView> za = new ArrayList<UpperTextView>();
    //List<String> sprit = new ArrayList<String>();
    TableLayout.LayoutParams TLP;
    UpperTextView[][] elem = new UpperTextView[4][4];
    TableRow.LayoutParams mLP;
    //String nameb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_obuchenie);
        mintp = getIntent();
        t1 = (TextView) findViewById(R.id.tv1);
        och.add(t1);
        t2 = (TextView) findViewById(R.id.tv2);
        och.add(t2);
        t3 = (TextView) findViewById(R.id.tv3);
        och.add(t3);
        t4 = (TextView) findViewById(R.id.tv4);
        och.add(t4);
        t5 = (TextView) findViewById(R.id.tv5);
        och.add(t5);
        t6 = (TextView) findViewById(R.id.tv6);
        och.add(t6);
        t7 = (TextView) findViewById(R.id.tv7);
        och.add(t7);
        t8 = (TextView) findViewById(R.id.tv8);
        och.add(t8);
        t9 = (TextView) findViewById(R.id.tv9);
        och.add(t9);
        t10 = (TextView) findViewById(R.id.tv10);
        och.add(t10);
        t11 = (TextView) findViewById(R.id.tv11);
        och.add(t11);
        t12 = (TextView) findViewById(R.id.tv12);
        och.add(t12);
        t13 = (TextView) findViewById(R.id.tv13);
        och.add(t13);
        t14 = (TextView) findViewById(R.id.tv14);
        och.add(t14);
        t15 = (TextView) findViewById(R.id.tv15);
        och.add(t15);
        nex = (Button) findViewById(R.id.button2);
        ex = (Button) findViewById(R.id.bexit);
        pod = (Button) findViewById(R.id.pod);
        txt = (TextView) findViewById(R.id.txt);
        tbl = (TableLayout) findViewById(R.id.table);
        tuu = (TextView) findViewById(R.id.textView2);
        mTimer = new Timer();
        //word = new Words(1);
        mTTask = new MyTimerTask();
        mTimer.schedule(mTTask, 500, 500);
        //muz = mintp.getExtras().getInt("utai");
        // mintent = new Intent(Obuchenie.this, MainActivity.class);
        //////tbl.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
        tbl.setStretchAllColumns(true);
        Point size = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(size);
        int h = (int) (size.y);
        int w = (int) (size.x);
        TLP = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
        mLP = new TableRow.LayoutParams(w / 4, h / 4);
        List<String[][]> pol = new ArrayList<String[][]>();
        pol = Haichi.obuchmet();
        mas = pol.get(0);
        word = (pol.get(1))[0][0];
        myw = "";

        pod.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tuu.setVisibility(View.VISIBLE);
                pod.setVisibility(View.INVISIBLE);
            }
        });

        nex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (nas) {
                    case 0:
                        txt.setText(R.string.prav2);
                        break;
                    case 1:
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                        }
                        for (int i = 0; i < och.size(); i++) {
                            och.get(i).setTextColor(Color.WHITE);
                            och.get(i).setBackgroundColor(Color.GREEN);
                        }
                        txt.setText(R.string.prav3);
                        break;
                    case 2:
                        for (int i = 0; i < och.size(); i++) {
                            och.get(i).setVisibility(View.INVISIBLE);
                        }
                        nex.setEnabled(false);
                        nex.setVisibility(View.INVISIBLE);
                        txt.setVisibility(View.INVISIBLE);
                        zap();
                        tbl.setVisibility(View.VISIBLE);
                        break;
                }
                nas++;
            }
        });
        ex.setOnClickListener(exi);
    }

    View.OnClickListener exi = new View.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    };

    public void zap() {
        //Words worde = new Words(1);
        for (int i = 0; i < 4; i++) {
            TableRow tr = new TableRow(getApplicationContext());
            tr.setLayoutParams(TLP);
            for (int k = 0; k < 4; k++) {
                UpperTextView buk = new UpperTextView(getApplicationContext());
                buk.setLayoutParams(mLP);
                buk.setTextColor(Color.WHITE);
                buk.setTag("0");
                if (mas[i][k].equals("#")) {
                    Random rnd = new Random();
                    int r = rnd.nextInt(33) + 1;
                    String nameb = "l" + String.valueOf(r);
                    int nab = getResources().getIdentifier(nameb, "string", getPackageName());
                    buk.setText(nab);
                } else {
                    buk.setText(mas[i][k]);
                }
                buk.setTextSize(60);
                buk.setOnTouchListener(this);
                buk.setGravity(Gravity.CENTER);
                tr.addView(buk);
                elem[i][k] = buk;
            }
            tbl.addView(tr);
        }

    }

    public boolean onTouch(View v, MotionEvent event) {
        UpperTextView nTx = (UpperTextView) v;
        //if(nTx.getTag().equals("0")) {
        ww = (int) tbl.getWidth() / 4;
        hh = (int) tbl.getHeight() / 4;
        ii = (int) event.getX() / ww;
        jj = (int) event.getRawY() / hh;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (chit) {

                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(Obuchenie.this);
                    mBuilder.setTitle(getString(R.string.napom))
                            .setMessage(getString(R.string.nepa))
                            .setIcon(R.drawable.sets)
                            .setCancelable(false)
                            .setNegativeButton(getString(R.string.oki), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();//закрытие окна
                                }
                            });
                    AlertDialog malert = mBuilder.create();
                    malert.show();
                } else {
                    chit = true;
                    za.clear();
                    x = event.getX();
                    y = event.getY();
                    nTx.setTextColor(Color.rgb(255, 64, 129));
                    nTx.metka = !(nTx.metka);
                    iiiz = jj + ((int) nTx.getY() / hh);
                    jjjz = ii + ((int) nTx.getX() / ww);
                    za.add(nTx);
                    myw += nTx.getText();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                iii = jj + ((int) nTx.getY() / hh);
                jjj = ii + ((int) nTx.getX() / ww);
                if (iii < 4 && iii >= 0 && jjj >= 0 && jjj < 4) {
                    nTx = elem[iii][jjj];
                    if (!nTx.metka && (iiiz == iii + 1 || iiiz == iii - 1 || iii == iiiz) && (jjjz == jjj + 1 || jjjz == jjj - 1 || jjj == jjjz) && (jjj == jjjz || iii == iiiz)) {
                        nTx.setTextColor(Color.rgb(255, 64, 129));
                        nTx.metka = !(nTx.metka);
                        za.add(nTx);
                        myw += nTx.getText();
                        iiiz = iii;
                        jjjz = jjj;
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                chit = false;
                boolean sterca = true;
                //nt sch = 0;
                if (myw.equals(word)) {
                    sterca = false;
                }
                if (!sterca) {
                    AlertDialog.Builder mmBuilder = new AlertDialog.Builder(Obuchenie.this);
                    mmBuilder.setTitle(getString(R.string.vseve))
                            .setMessage(getString(R.string.vipon))
                            .setIcon(R.drawable.sets)
                            .setCancelable(false)
                            .setNegativeButton(getString(R.string.bgame), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                    AlertDialog malert1 = mmBuilder.create();
                    malert1.show();
                }
                if (sterca) {
                    int sch = 0;
                    while (sch < za.size()) {
                        tuu.setText(word);
                        za.get(sch).setTextColor(Color.WHITE);
                        za.get(sch).metka = false;
                        sch++;
                        myw = "";
                        pod.setVisibility(View.VISIBLE);
                    }
                }

                break;
        }
        //}
        return true;
    }

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (och.size() > n) {
                        och.get(n).setTextColor(Color.WHITE);
                        och.get(n).setBackgroundColor(Color.GREEN);
                        n++;
                    } else {
                        for (int i = 0; i < och.size(); i++) {
                            och.get(i).setTextColor(Color.rgb(255, 64, 129));
                            och.get(i).setBackgroundColor(Color.TRANSPARENT);
                        }
                        n = 0;
                    }

                }
            });
        }
    }
}




