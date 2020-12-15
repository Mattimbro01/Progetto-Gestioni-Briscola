/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class Briscola {

    public Briscola() throws IOException {
        this.mazzo = new JMazzo();
        this.briscola = mazzo.getCarta(mazzo.getNumEl() - 1).getSeme();
        Playerturno = 2;
        CartepresePlayer1 = new ArrayList<JCarta>();
        CartepresePlayer2 = new ArrayList<JCarta>();
    }

    public void ConfrontoTradueCarte(JCarta c1, JCarta c2) {
        if (c1.getSeme().equals(briscola) && c2.getSeme().equals(briscola)) {
            if (c1.getValore() > c2.getValore()) {
                CartepresePlayer1.add(c1);
                CartepresePlayer1.add(c2);
                Playerturno = 1;
            } else {
                CartepresePlayer2.add(c1);
                CartepresePlayer2.add(c2);
                Playerturno = 2;
            }
        } else if (c1.getSeme().equals(briscola)) {
            CartepresePlayer1.add(c1);
            CartepresePlayer1.add(c2);
            Playerturno = 1;

        } else if (c2.getSeme().equals(briscola)) {
            CartepresePlayer2.add(c1);
            CartepresePlayer2.add(c2);
            Playerturno = 2;

        } else {//parte
            if (Playerturno == 1) {
                if (c1.getSeme().equals(c2.getSeme())) {
                    if (c1.getValore() > c2.getValore()) {
                        CartepresePlayer1.add(c1);
                        CartepresePlayer1.add(c2);
                        Playerturno = 1;
                    } else {
                        CartepresePlayer2.add(c1);
                        CartepresePlayer2.add(c2);
                        Playerturno = 2;
                    }
                } else {
                    CartepresePlayer1.add(c1);
                    CartepresePlayer1.add(c2);
                    Playerturno = 1;
                }

            }
            if (Playerturno == 2) {
                if (c1.getSeme().equals(c2.getSeme())) {
                    if (c1.getValore() > c2.getValore()) {
                        CartepresePlayer1.add(c1);
                        CartepresePlayer1.add(c2);
                        Playerturno = 1;
                    } else {
                        CartepresePlayer2.add(c1);
                        CartepresePlayer2.add(c2);
                        Playerturno = 2;
                    }
                } else {
                    CartepresePlayer2.add(c1);
                    CartepresePlayer2.add(c2);
                    Playerturno = 2;
                }

            }
        }//finisce
    }

    public int ContaPunti(ArrayList<JCarta> cartePrese) {
        int punti = 0;
        for (int i = 0; i < cartePrese.size(); i++) {
            if (cartePrese.get(i).getValore() > 7) {
                punti += ValoreEffettivo(cartePrese.get(i).getValore());
            }
        }
        return punti;
    }
//metodo vincitore

    public int Vincitore() {
        int vinci = -1;
        int puntiplayer1 = ContaPunti(CartepresePlayer1);
        int puntiplayer2 = ContaPunti(CartepresePlayer2);
        if(puntiplayer1>puntiplayer2)
            vinci=1;
        else if(puntiplayer1<puntiplayer2)
               vinci=2;
        else
            vinci = 0;
        return vinci;
    }

    private int ValoreEffettivo(int valore) {
        int v = 0;
        switch (valore) {
            case 8:
                v = 2;
                break;
            case 9:
                v = 3;
                break;
            case 10:
                v = 4;
                break;
            case 11:
                v = 10;
                break;
            case 12:
                v = 11;
                break;
        }
        return v;
    }

    public String[] DistribuisciTreCarte() {
        String[] tre = new String[3];
        tre[0] = mazzo.getCarta(0).getPng();

        tre[1] = mazzo.getCarta(2).getPng();

        tre[2] = mazzo.getCarta(4).getPng();
        mazzo.elimina(0);
        mazzo.elimina(1);
        mazzo.elimina(2);
        return tre;
    }

    public String DistribuisciUnaCarta() {
        String una = "";
        una = mazzo.getCarta(0).getPng();
        mazzo.elimina(0);
        return una;
    }

    public String getUltimaCarta() {
        return mazzo.getCarta(mazzo.getNumEl() - 1).getPng();
    }

    public int getPlayerturno() {
        return Playerturno;
    }

    public void setPlayerturno(int Playerturno) {
        this.Playerturno = Playerturno;
    }

    public int getCarteNelMazzo() {
        return mazzo.getNumEl();
    }
    private JMazzo mazzo;
    private String briscola;
    private int Playerturno;
    private ArrayList<JCarta> CartepresePlayer1;
    private ArrayList<JCarta> CartepresePlayer2;

}
