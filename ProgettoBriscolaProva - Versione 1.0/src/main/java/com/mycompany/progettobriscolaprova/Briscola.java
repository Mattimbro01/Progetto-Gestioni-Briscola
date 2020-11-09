/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettobriscolaprova;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Briscola {

    public Briscola() {
        this.mazzo = new JMazzo();
        this.briscola = mazzo.getCarta(mazzo.getNumEl()).getSeme();
        Playerturno = 1;
        CartepresePlayer1 = new ArrayList<JCarta>();
        CartepresePlayer2 = new ArrayList<JCarta>();
    }

    public void ConfrontoTradueCarte(JCarta c1, JCarta c2) {
        if (c1.getSeme().equals(briscola) && c2.getSeme().equals(briscola)) {
            if (c1.getValore() > c2.getValore()) {
                CartepresePlayer1.add(c1);
                CartepresePlayer1.add(c2);
            } else {
                CartepresePlayer2.add(c1);
                CartepresePlayer2.add(c2);
            }
        } else if (c1.getSeme().equals(briscola)) {
            CartepresePlayer1.add(c1);
            CartepresePlayer1.add(c2);

        } else if (c2.getSeme().equals(briscola)) {
            CartepresePlayer2.add(c1);
            CartepresePlayer2.add(c2);

        } else {//parte
            if (Playerturno == 1) {
                if (c1.getSeme().equals(c2.getSeme())) {
                    if (c1.getValore() > c2.getValore()) {
                        CartepresePlayer1.add(c1);
                        CartepresePlayer1.add(c2);
                    } else {
                        CartepresePlayer2.add(c1);
                        CartepresePlayer2.add(c2);
                    }
                } else {
                    CartepresePlayer1.add(c1);
                    CartepresePlayer1.add(c2);
                }

            }
            if (Playerturno == 2) {
                if (c1.getSeme().equals(c2.getSeme())) {
                    if (c1.getValore() > c2.getValore()) {
                        CartepresePlayer1.add(c1);
                        CartepresePlayer1.add(c2);
                    } else {
                        CartepresePlayer2.add(c1);
                        CartepresePlayer2.add(c2);
                    }
                } else {
                    CartepresePlayer2.add(c1);
                    CartepresePlayer2.add(c2);
                }

            }
        }//finisce
    }

    public int ContaPunti(ArrayList<JCarta> cartePrese) {
        int punti = 0;
        for (int i = 0; i < cartePrese.size(); i++) {
            punti += cartePrese.get(i).getValore();
        }
        return punti;
    }

    public String[] DistribuisciTreCarte() {
        String[] tre = new String[3];
        tre[0] = mazzo.getCarta(0).getPng();
        tre[1] = mazzo.getCarta(2).getPng();
        tre[2] = mazzo.getCarta(4).getPng();
        mazzo.elimina(0);
        mazzo.elimina(2);
        mazzo.elimina(4);
        return tre;
    }

    public String DistribuisciUnaCarta() {
        String una = "";
        una = mazzo.getCarta(0).getPng();
        mazzo.elimina(0);
        return una;
    }
    private JMazzo mazzo;
    private String briscola;
    private int Playerturno;
    private ArrayList<JCarta> CartepresePlayer1;
    private ArrayList<JCarta> CartepresePlayer2;

}
