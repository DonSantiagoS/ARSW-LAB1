/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 * @author hcadavid
 */
public class CountThread implements Runnable {
    private int rangoInicial;
    private int rangoFinal;

    public CountThread(int a, int b) {
        this.rangoInicial = a;
        this.rangoFinal = b;

    }

    public int getRangoInicial() {
        return rangoInicial;
    }

    public void setRangoInicial(int rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    public int getRangoFinal() {
        return rangoFinal;
    }

    public void setRangoFinal(int rangoFinal) {
        this.rangoFinal = rangoFinal;
    }

    @Override
    public void run() {
        for (int i = rangoInicial; i <= rangoFinal; i++) {
            System.out.println(i);
        }

    }
}