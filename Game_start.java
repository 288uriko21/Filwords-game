package com.example.final_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class Game_start extends AppCompatActivity {
    Button B_st, B_pr, B_set, B_stat;
    TextView opred;
    Switch toster, wo;
    public static final String KEY_N = "N";
    public static final String KEY_iz = "iaz";
    public static final String KEY_Pob = "s";
    public static final String KEY_spifon = "i";
    public static final String KEY_slova = "u";
    public static final String KEY_setep = "setep";
    public static final String KEY_red = "re";
    public static boolean onner, anibnida=true;
    public static int pob = 0;
    public static Set<String> razfons;
    public static Set<String> slisb;
    public static Set<String> setep;
    public static Set<String> red;
    private SharedPreferences mSPref;
    public static boolean iz = true, piz = true;
    int muz, globalcol = 0;
    Intent mintent, mintent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_start);
        muz = 0;
        onner = false;
        razfons = new HashSet<>();
        slisb = new HashSet<>();
        red = new HashSet<>();
        setep = new HashSet<>();
        mSPref = getPreferences(Context.MODE_PRIVATE);
        mLoad();
        B_st = (Button) findViewById(R.id.startb);
        B_pr = (Button) findViewById(R.id.prb);
        B_set = (Button) findViewById(R.id.Sett);
        B_stat = (Button) findViewById(R.id.stat);
        toster = (Switch) findViewById(R.id.toster);
        wo = (Switch) findViewById(R.id.wo);
        opred = (TextView) findViewById(R.id.textView);
        if (toster != null) {
           toster.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
           {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   // в зависимости от значения isChecked выводим нужное сообщение
                   if (isChecked) {
                      onner=true;
                   } else {
                      onner=false;
                   }
               }
           });
        }
        if (wo != null) {
            wo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        anibnida=true;
                    } else {
                        anibnida=false;
                    }
                }
            });
        }
        if(opred.getText().equals("Филворды")){
            iz = false;
        }
        if(iz !=  piz){
            globalcol = 0;
            setep.clear();
            red.clear();
            razfons.clear();
            pob = 0;
            slisb.clear();
        }

        mintent = new Intent(Game_start.this, MainActivity.class);

        B_st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalcol++;
                //mintent = new Intent(Game_start.this, MainActivity.class);
                mintent.putExtra("utai", muz);
                startActivity(mintent);
            }
        });

        B_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mintent2 = new Intent(Game_start.this, Obuchenie.class);
                mintent2.putExtra("utai", muz);
                startActivity(mintent2);
            }
        });
        B_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] mVariant = {getString(R.string.loud),getString(R.string.tsh), getString(R.string.nomuz)};
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Game_start.this);
                mBuilder.setTitle(getString(R.string.selmu));
                mBuilder.setItems(mVariant, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), getString(R.string.vib) + mVariant[which], Toast.LENGTH_SHORT).show();
                        if (mVariant[which].equals(getString(R.string.tsh))) {
                            muz = 1;
                        }
                        if (mVariant[which].equals(R.string.loud)) {
                            muz = 2;
                        }
                        mintent.putExtra("utai", muz);
                    }
                });

                AlertDialog malert = mBuilder.create();
                malert.show();

            }
        });
        B_stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Game_start.this);
                mBuilder.setTitle(R.string.stat)
                        .setMessage(getString(R.string.col) + String.valueOf(globalcol) + "\r\n" + getString(R.string.pob) + String.valueOf(pob) + "\r\n" + getString(R.string.colsl) + String.valueOf(slisb.size()) + getString(R.string.ocols) + "\r\n" + getString(R.string.res) + String.valueOf(red.size()) +
                                getString(R.string.reds) + "\r\n" +  getString(R.string.e) + String.valueOf(setep.size()) + getString(R.string.eps) +"\r\n" +getString(R.string.colfon)+ String.valueOf(razfons.size()) + " / 22")
                        .setCancelable(false)
                        .setNegativeButton("ОК", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();//закрытие окна
                            }
                        })
                        .setPositiveButton(getString(R.string.fstat), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                globalcol = 0;
                                setep.clear();
                                red.clear();
                                razfons.clear();
                                pob = 0;
                                slisb.clear();
                            }

                        })
                        .setNeutralButton(R.string.more, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog1, int which) {
                                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Game_start.this);
                                mBuilder.setTitle(getString(R.string.worcol))
                                        .setMessage(Logic_game.output(red, getString(R.string.worred)) + Logic_game.output(setep, getString(R.string.ep)))
                                        .setCancelable(false)
                                        .setNegativeButton("ОК", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                //finish();
                                                dialog.cancel();
                                            }
                                        });
                                AlertDialog malert1 = mBuilder.create();
                                malert1.show();
                            }
                        });
                AlertDialog malert = mBuilder.create();
                malert.show();

            }
        });
    }

    public void mLoad() {
        if (mSPref.contains(KEY_N)) {
            globalcol = mSPref.getInt(KEY_N, 0);
        }
        if (mSPref.contains(KEY_iz)) {
            piz = mSPref.getBoolean(KEY_iz,true );
        }
        if (mSPref.contains(KEY_Pob)) {
            pob = mSPref.getInt(KEY_Pob, 0);
        }
         if (mSPref.contains(KEY_spifon)) {
          razfons = mSPref.getStringSet(KEY_spifon, new HashSet<String>());
        }
        if (mSPref.contains(KEY_setep)) {
            setep = mSPref.getStringSet(KEY_setep, new HashSet<String>());
        }
        if (mSPref.contains(KEY_slova)) {
            slisb = mSPref.getStringSet(KEY_slova, new HashSet<String>());
        }
        if (mSPref.contains(KEY_red)) {
            red = mSPref.getStringSet(KEY_red, new HashSet<String>());
        }

    }

    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor myeditor = mSPref.edit();
        myeditor.putInt(KEY_N, globalcol);
        myeditor.putStringSet(KEY_spifon, razfons);
        myeditor.putBoolean(KEY_iz, piz);
        myeditor.putStringSet(KEY_red, red);
        myeditor.putStringSet(KEY_slova, slisb);
        myeditor.putStringSet(KEY_setep, setep);
        myeditor.putInt(KEY_Pob, pob);
        myeditor.apply();

    }

}

