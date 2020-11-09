/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progettobriscolaprova;

/**
 *
 * @author HP
 */
public class JMazzo {

    public JMazzo() {
        mazzo = new JCarta[40];
        numEl = 0;
        Mescola();
    }

    public JCarta[] getMazzo() {
        return mazzo;
    }

    public void setMazzo(JCarta[] mazzo) {
        this.mazzo = mazzo;
    }

    public void Mescola() {
        int n = 0;
        JCarta temp = new JCarta();
        for (int i = 0; i < numEl; i++) {
            n = (int) (Math.random() * numEl);
            temp = mazzo[i];
            mazzo[i] = mazzo[n];
            mazzo[n] = temp;
        }
    }

    public JCarta getCarta(int i) {
        return mazzo[i];
    }

    public int getNumEl() {
        return numEl;
    }

  

     public void elimina(int pos) {
        for (int i = pos; i < numEl; i++) {
            mazzo[i] = mazzo[pos];
        }
        numEl--;
    }
    private JCarta[] mazzo;
    private int numEl;
}
