/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;

/**
 *
 * @author HP
 */
public class JMazzo {

    public JMazzo() throws IOException {
        file=new FileCSV("CarteCsv.csv");
        mazzo=file.leggiCSV();
        numEl = 30;
       Mescola();
    }

    public JCarta[] getMazzo() {
        return mazzo;
    }

    public void setMazzo(JCarta[] mazzo) {
        this.mazzo = mazzo;
    }

    private void Mescola() {
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
        for (int i = pos; i < numEl-1; i++) {
            mazzo[i] = mazzo[i+1];
        }
        numEl--;
    }
   private FileCSV file;
    private JCarta[] mazzo;
    private int numEl;

}
