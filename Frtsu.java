package com.example.final_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frtsu {

    public static int[][] go(int sos[][], char mas[][], int i, int j) {/// возвр след ход
        int[][] nex = new int[1][2];
        int i1, j1, pom, la = 5;
        boolean f = false;
        Random rnd = new Random();
        for (int x = 0; x < 4 && sos[x][0] != -1; x++) {
            i1 = sos[x][0];
            j1 = sos[x][1];
            pom = Haichi.reply_tsukiguchi(mas, Haichi.tip(i1, j1), i1, j1, mas[i1][j1]);
            char e = mas[i1][j1];
            if (pom < la && (e != '1' && e != '2' && e != '3' && e != '4' && e != '5' && e != '6' && e != '7' && e != '8')) {
                la = pom;
                f = rnd.nextBoolean();
                nex[0][0] = i1;
                nex[0][1] = j1;
            }
            if (pom == la && f && (e != '1' && e != '2' && e != '3' && e != '4' && e != '5' && e != '6' && e != '7' && e != '8')) {
                nex[0][0] = i1;
                nex[0][1] = j1;
                f = rnd.nextBoolean();
                ;
            }

        }
        return nex;
    }

    public static int[][] tsukiguchi(char mas[][], int t, int i, int j, char a) {/// возвращает сами одноим
        int[][] sos = new int[4][2];
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 2; y++) {
                sos[x][y] = -1;
            }
        }
        int col = 0;
        switch (t) {
            case 1:
                if (mas[i + 1][j] == a) {
                    sos[col][0] = i + 1;
                    sos[col][1] = j;
                    col++;
                }
                if (mas[i][j - 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j - 1;
                    col++;
                }
                break;
            case 2:
                if (mas[i][j + 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j + 1;
                    col++;
                }
                if (mas[i + 1][j] == a) {
                    sos[col][0] = i + 1;
                    sos[col][1] = j;
                    col++;
                }
                break;
            case 3:
                if (mas[i - 1][j] == a) {
                    sos[col][0] = i - 1;
                    sos[col][1] = j;
                    col++;
                }
                if (mas[i][j + 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j + 1;
                    col++;
                }
                break;
            case 4:
                if (mas[i - 1][j] == a) {
                    sos[col][0] = i - 1;
                    sos[col][1] = j;
                    col++;
                }
                if (mas[i][j - 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j - 1;
                    col++;
                }
                break;
            case 5:
                if (mas[i - 1][j] == a) {
                    sos[col][0] = i - 1;
                    sos[col][1] = j;
                    col++;
                }
                if (mas[i][j - 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j - 1;
                    col++;
                }
                if (mas[i + 1][j] == a) {
                    sos[col][0] = i + 1;
                    sos[col][1] = j;
                    col++;
                }
                break;
            case 6:
                if (mas[i - 1][j] == a) {
                    sos[col][0] = i - 1;
                    sos[col][1] = j;
                    col++;
                }
                if (mas[i][j - 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j - 1;
                    col++;
                }
                if (mas[i][j + 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j + 1;
                    col++;
                }
                break;
            case 7:
                if (mas[i - 1][j] == a) {
                    sos[col][0] = i - 1;
                    sos[col][1] = j;
                    col++;
                }
                if (mas[i][j + 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j + 1;
                    col++;
                }
                if (mas[i + 1][j] == a) {
                    sos[col][0] = i + 1;
                    sos[col][1] = j;
                    col++;
                }
                break;
            case 8:
                if (mas[i + 1][j] == a) {
                    sos[col][0] = i + 1;
                    sos[col][1] = j;
                    col++;
                }
                if (mas[i][j - 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j - 1;
                    col++;
                }
                if (mas[i][j + 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j + 1;
                    col++;
                }
                break;
            case 9:
                if (mas[i + 1][j] == a) {
                    sos[col][0] = i + 1;
                    sos[col][1] = j;
                    col++;
                }
                if (mas[i][j - 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j - 1;
                    col++;
                }
                if (mas[i][j + 1] == a) {
                    sos[col][0] = i;
                    sos[col][1] = j + 1;
                    col++;
                }
                if (mas[i - 1][j] == a) {
                    sos[col][0] = i - 1;
                    sos[col][1] = j;
                    col++;
                }
                break;
        }
        return sos;
    }

    public static String v_letter(int size) {
        Random rnd = new Random();
        Words slov;
        List<Integer> nihonbanzai = new ArrayList<Integer>();
        if(Game_start.iz){
            slov = new Words(true);
            nihonbanzai.add(15);
            nihonbanzai.add(4);
            nihonbanzai.add(3);
            nihonbanzai.add(2);
            nihonbanzai.add(2);
            nihonbanzai.add(2);
            nihonbanzai.add(2);
            nihonbanzai.add(2);
            nihonbanzai.add(2);
            nihonbanzai.add(2);
            nihonbanzai.add(2);
            nihonbanzai.add(2);
        }
        else{
            slov = new Words();
            nihonbanzai.add(11);
            nihonbanzai.add(45);
            nihonbanzai.add(150);
            nihonbanzai.add(84);
            nihonbanzai.add(152);
            nihonbanzai.add(6);
            nihonbanzai.add(4);
            nihonbanzai.add(5);
            nihonbanzai.add(3);
            nihonbanzai.add(3);
            nihonbanzai.add(2);
        }
       //List<Integer> rus = new ArrayList<Integer>();
        //List<Integer> jp = new ArrayList<Integer>();
        String ver = "iiiiiiiiiiii";
        switch (size) {
            case 2:
                ver = (slov.wor_2).get(rnd.nextInt(nihonbanzai.get(0)));
                break;
            case 3:
                ver = (slov.wor_3).get(rnd.nextInt(nihonbanzai.get(1)));
                break;
            case 4:
                ver = (slov.wor_4).get(rnd.nextInt(nihonbanzai.get(2)));
                break;
            case 5:
                ver = (slov.wor_5).get(rnd.nextInt(nihonbanzai.get(3)));
                break;
            case 6:
                ver = (slov.wor_6).get(rnd.nextInt(nihonbanzai.get(4)));
                break;
            case 7:
                ver = (slov.wor_7).get(rnd.nextInt(nihonbanzai.get(5)));
                break;
            case 8:
                ver = (slov.wor_8).get(rnd.nextInt(nihonbanzai.get(6)));
                break;
            case 9:
                ver = (slov.wor_8).get(rnd.nextInt(nihonbanzai.get(7)));
                break;
            case 10:
                ver = (slov.wor_10).get(rnd.nextInt(nihonbanzai.get(8)));
                break;
            case 11:
                ver = (slov.wor_11).get(rnd.nextInt(nihonbanzai.get(9)));
                break;
            case 12:
                ver = (slov.wor_12).get(rnd.nextInt(nihonbanzai.get(10)));
                break;
        }
        return ver;
    }
}
