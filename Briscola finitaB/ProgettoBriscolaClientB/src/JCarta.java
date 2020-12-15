
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class JCarta {

    public JCarta(int valore, String seme, boolean briscola, String png) {
        this.valore = valore;
        this.seme = seme;
        this.png = png;
    }

    public JCarta(String png) {
        this.png = png;
        String[] url = png.split("-");
        this.valore = Integer.parseInt(url[0]);
        this.seme = url[1].substring(0,1);

    }

    public JCarta() {
        valore = 0;
        seme = "";
        png = "";
    }

    public int getValore() {
        return valore;
    }

    public String getSeme() {
        return seme;
    }

    public String getPng() {
        return png;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public void setSeme(String seme) {
        this.seme = seme;
    }

    public void setPng(String png) {
        this.png = png;
    }

    private int valore;
    private String seme;
    private String png;
}
