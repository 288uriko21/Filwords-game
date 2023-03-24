package com.example.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Haichi {
    public static int tip(int i, int j) {
        int tip = 9;
        if (j == 7) {
            tip = 5;
        }
        if (j == 0) {
            tip = 7;
        }
        if (i == 7) {
            tip = 6;
        }
        if (i == 0) {
            tip = 8;
        }
        if (i == 7 && j == 7) {
            tip = 4;
        }
        if (i == 0 && j == 7) {
            tip = 1;
        }
        if (i == 7 && j == 0) {
            tip = 3;
        }
        if (i == 0 && j == 0) {
            tip = 2;
        }
        return tip;
    }

    public static int reply_tsukiguchi(char mas[][], int t, int i, int j, char a) {/// возвращает кол-во одноименных
        int col = 0;
        switch (t) {
            case 1:
                if (mas[i + 1][j] == a)
                    col++;
                if (mas[i][j - 1] == a)
                    col++;
                break;
            case 2:
                if (mas[i][j + 1] == a)
                    col++;
                if (mas[i + 1][j] == a)
                    col++;
                break;
            case 3:
                if (mas[i - 1][j] == a)
                    col++;
                if (mas[i][j + 1] == a)
                    col++;
                break;
            case 4:
                if (mas[i - 1][j] == a)
                    col++;
                if (mas[i][j - 1] == a)
                    col++;
                break;
            case 5:
                if (mas[i - 1][j] == a)
                    col++;
                if (mas[i][j - 1] == a)
                    col++;
                if (mas[i + 1][j] == a)
                    col++;
                break;
            case 6:
                if (mas[i - 1][j] == a)
                    col++;
                if (mas[i][j - 1] == a)
                    col++;
                if (mas[i][j + 1] == a)
                    col++;
                break;
            case 7:
                if (mas[i - 1][j] == a)
                    col++;
                if (mas[i][j + 1] == a)
                    col++;
                if (mas[i + 1][j] == a)
                    col++;
                break;
            case 8:
                if (mas[i + 1][j] == a)
                    col++;
                if (mas[i][j - 1] == a)
                    col++;
                if (mas[i][j + 1] == a)
                    col++;
                break;
            case 9:
                if (mas[i + 1][j] == a)
                    col++;
                if (mas[i][j - 1] == a)
                    col++;
                if (mas[i][j + 1] == a)
                    col++;
                if (mas[i - 1][j] == a)
                    col++;
                break;
        }
        return col;
    }

    public static int count(char mas[][], char a) {
        int col = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (mas[i][j] == a) {
                    col++;
                }
            }
        }
        return col;
    }

    public static List<List> metod_shisti_putei() {
        // TODO Auto-generated method stub
        char a1 = 'а';// 97
        int t = (int) (a1);
        // a = (char)(t+1);
        // System.out.println(t);
        Random r = new Random();
        List<List> ret = new ArrayList<List>();
        List<List> linii = new ArrayList<List>();
        List<String> bukvi = new ArrayList<String>();
        Seru hou = new Seru();
        int a, b;
        //int n = 0;
        ArrayList<Seru> houhou = new ArrayList<Seru>();

        char[][] pole = new char[8][8];
        String[][] tab = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pole[i][j] = '0';
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i != 7 && j != 7 && pole[i][j] == '0') {
                    a = r.nextInt(2) + 1;
                    b = r.nextInt(2) + 1;
                    for (int x = 0; x < a; x++) {
                        for (int y = 0; y < b; y++) {
                            pole[i + x][j + y] = a1;
                        }
                    }
                    t++;
                    a1 = (char) (t);
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (count(pole, (pole[i][j])) == 1 || pole[i][j] == '0') {
                    if (i != 7) {
                        if (j < 7) {
                            pole[i][j] = pole[i][j + 1];
                        } else {
                            pole[i][j] = pole[i][j - 1];
                        }
                    } else {
                        pole[i][j] = pole[i - 1][j];
                    }
                }
            }
        }

        int w, g, gy, gc, gcc, li = 49;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char s = pole[i][j];
                if (s != '1' || s != '2' || s != '3' || s != '4' || s != '5' || s != '6' || s != '7') {
                    w = reply_tsukiguchi(pole, tip(i, j), i, j, pole[i][j]);
                    int[][] gona = new int[1][2];
                    g = i;
                    gy = j;
                    while (w != 0) {
                        gc = g;
                        gcc = gy;
                        gona = (Frtsu.go(Frtsu.tsukiguchi(pole, tip(g, gy), g, gy, pole[g][gy]), pole, g, gy));
                        if (gona[0][0] == 0 && gona[0][1] == 0)
                            break;
                        g = gona[0][0];
                        gy = gona[0][1];
                        pole[gc][gcc] = (char) (li);
                        Seru hou1 = new Seru();
                        hou1.pris(gc, gcc);
                        houhou.add(hou1);
                        li++;
                        w = reply_tsukiguchi(pole, tip(g, gy), g, gy, pole[g][gy]);
                        if (w == 0) {
                            pole[g][gy] = (char) (li);
                            Seru hou2 = new Seru();
                            hou2.pris(g, gy);
                            houhou.add(hou2);
                            int dlin = houhou.size();
                            String fin = Frtsu.v_letter(dlin);
                            List<Integer> pars = new ArrayList<Integer>();
                            for (int f = 0; f < dlin; f++) {
                                hou = houhou.get(f);
                                tab[hou.i][hou.j] = String.valueOf(fin.charAt(f));
                                pars.add((hou.i) * 7 + hou.j + hou.i);
                            }
                            if (Game_start.anibnida && r.nextInt(2) > 0) {
                                int da = pars.size();
                                List<Integer> parsr = new ArrayList<Integer>();
                                int hai = 0;
                                String finik = Frtsu.v_letter(pars.size());
                                int ost, tsel, vs;
                                while (da > hai) {
                                    parsr.add(pars.get(da - hai - 1));
                                    vs = pars.get(da - hai - 1);
                                    ost = vs % 8;
                                    tsel = vs / 8;
                                    tab[tsel][ost] = String.valueOf(finik.charAt(hai));
                                    hai++;
                                }
                                linii.add(parsr);
                            } else {
                                linii.add(pars);
                            }

                        }
                    }
                    li = 49;
                    houhou.clear();
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                bukvi.add(tab[i][j]);
            }

        }
        ret.add(bukvi);
        ret.add(linii);
        return ret;
    }

    public static List<String[][]> obuchmet() {
        Random r = new Random();
        List<String[][]> ret = new ArrayList<String[][]>();
        String[][] pole = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                pole[i][j] = "#";
            }
        }
        int cont = 0;
        int pred = 0;
        int col = r.nextInt(5) + 4;
        int sh = 1;
        Random rnd = new Random();
        int x = 0, y = 0;
        y = rnd.nextInt(4);
        Random rnd1 = new Random();
        x = rnd1.nextInt(4);
        pole[x][y] = "0";
        for (int i = 0; i < col; i++) {
            int a = r.nextInt((4 - 1) + 1) + 1;
            switch (a) {
                case 1:
                    if (x + 1 < 4 && pred != 2 && pole[x + 1][y].equals("#")) {
                        pole[x + 1][y] = String.valueOf(sh);
                        x++;
                        sh++;
                        pred = 1;
                    } else {
                        i--;
                    }
                    break;

                case 2:
                    if (x - 1 > 0 && pred != 1 && pole[x - 1][y] == "#") {
                        pole[x - 1][y] = String.valueOf(sh);
                        x--;
                        sh++;
                        pred = 2;
                    } else {
                        i--;
                    }
                    break;
                case 3:
                    if (y - 1 > 0 && pred != 4 && pole[x][y - 1] == "#") {
                        pole[x][y - 1] = String.valueOf(sh);
                        y--;
                        sh++;
                        pred = 3;
                        i--;
                    }
                    break;
                case 4:
                    if (y + 1 < 4 && pred != 3 && pole[x][y + 1] == "#") {
                        pole[x][y + 1] = String.valueOf(sh);
                        y++;
                        sh++;
                        pred = 4;
                    } else {
                        i--;
                    }
                    break;
            }
            cont = sh;
        }
        String let = Frtsu.v_letter(cont);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (pole[i][j].equals("#")) {
                } else {
                    pole[i][j] = String.valueOf(let.charAt(Integer.parseInt(pole[i][j])));
                }
            }
        }
        ret.add(pole);
        String[][] slov = new String[1][1];
        slov[0][0] = let;
        ret.add(slov);
        return ret;
    }
}
