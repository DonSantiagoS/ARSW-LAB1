/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

/**
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        HostBlackListsValidator hblv = new HostBlackListsValidator();
        List<Integer> blackListOcurrences = hblv.checkHost("202.24.34.55",50);
        long endTime = System.currentTimeMillis();
        System.out.println("The host was found in the following blacklists:" + blackListOcurrences);
        System.out.println("Tiempo:"+(endTime - startTime)+" milisegundos.");
    }
}