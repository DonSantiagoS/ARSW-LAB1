/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 * @author hcadavid
 */
public class CountThreadsMain {

    public static void main(String a[]) {
        CountThread hilo1 = new CountThread(0, 99);
        CountThread hilo2 = new CountThread(100, 199);
        CountThread hilo3 = new CountThread(200, 299);
        Thread x = new Thread(hilo1);
        Thread y = new Thread(hilo2);
        Thread z = new Thread(hilo3);

        System.out.println("Con Run:");
        x.run();
        y.run();
        z.run();
        System.out.println("Con start:");
        x.start();
        y.start();
        z.start();


    }

}
