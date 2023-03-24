package com.example.final_project;

import android.graphics.Color;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Logic_game {

    public static void chAnge(TextView nTx) {
        boolean r = true;
        if (nTx.getText().equals("|")) {
            nTx.setText("0");
            r = false;
            nTx.setBackgroundColor(Color.TRANSPARENT);
            nTx.setTextColor(Color.TRANSPARENT);
        }
        if (nTx.getText().equals("9")) {
            nTx.setText("—");
            r = false;
            nTx.setBackgroundColor(Color.MAGENTA);
            nTx.setTextColor(Color.BLUE);
        }
        if (nTx.getText().equals("—") && r) {
            nTx.setBackgroundColor(Color.TRANSPARENT);
            nTx.setTextColor(Color.TRANSPARENT);
            nTx.setText("9");
        }
        if (nTx.getText().equals("0") && r) {
            nTx.setText("|");
            nTx.setBackgroundColor(Color.MAGENTA);
            nTx.setTextColor(Color.BLUE);
        }
        if (!(nTx.getTag().equals("net")) && !(nTx.getTag().equals("net1"))) {
            if (nTx.getTag().equals("0")) {
                nTx.setTag("1");
                nTx.setTextColor(Color.YELLOW);
                nTx.setBackgroundColor(Color.MAGENTA);
            } else {
                nTx.setTextColor(Color.BLACK);
                nTx.setBackgroundColor(Color.TRANSPARENT);
                nTx.setTag("0");
            }
        }
    }

    public static boolean hikaku(List A, List B) {
        boolean v = true;
        if (A.size() == B.size()) {
            Iterator<Integer> AA = A.iterator();
            Iterator<Integer> BB = B.iterator();
            while (AA.hasNext()) {
                int a = AA.next();
                int b = BB.next();
                if (a != b) {
                    v = false;
                    break;
                }

            }
        } else {
            v = false;
        }
        return v;
    }

    public static String output(Set<String> S, String title) {
        String tex = title + "\r\n";
        String[] mas = S.toArray(new String[S.size()]);
        for (int i = 0; i < S.size(); i++) {
            tex += mas[i] + "\r\n";
        }
        return tex;
    }


}
