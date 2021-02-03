package edu.eci.arsw.threads;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class BlackListSearchThread extends Thread {
    private String ip;
    private int servidorInicial;
    private int servidorFinal;
    private LinkedList<Integer> blackListOcurrences;
    private static final int BLACK_LIST_ALARM_COUNT = 5;


    private AtomicInteger ocurrencesCount;
    private AtomicInteger checkedListCount;
    private HostBlacklistsDataSourceFacade facade;

    public BlackListSearchThread(String ip, int inicial, int fin, HostBlacklistsDataSourceFacade skds, AtomicInteger ocurrencesCount, AtomicInteger checkedListsCount, LinkedList<Integer> blackListOcurrences) {
        this.ip = ip;
        this.servidorInicial = inicial;
        this.servidorFinal = fin;
        this.facade = skds;
        this.ocurrencesCount = ocurrencesCount;
        this.checkedListCount = checkedListsCount;
        this.blackListOcurrences = blackListOcurrences;
    }

    public void run() {
        for (int i = servidorInicial; i < servidorFinal & ocurrencesCount.get() < BLACK_LIST_ALARM_COUNT; i++) {
            checkedListCount.getAndIncrement();
            if (facade.isInBlackListServer(i, ip)) {
                blackListOcurrences.add(i);
                ocurrencesCount.getAndIncrement();
            }
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getServidorInicial() {
        return servidorInicial;
    }

    public void setServidorInicial(int servidorInicial) {
        this.servidorInicial = servidorInicial;
    }

    public int getServidorFinal() {
        return servidorFinal;
    }

    public void setServidorFinal(int servidorFinal) {
        this.servidorFinal = servidorFinal;
    }

    public LinkedList<Integer> getBlackListOcurrences() {
        return blackListOcurrences;
    }

    public void setBlackListOcurrences(LinkedList<Integer> blackListOcurrences) {
        this.blackListOcurrences = blackListOcurrences;
    }

    public AtomicInteger getOcurrencesCount() {
        return ocurrencesCount;
    }

    public void setOcurrencesCount(AtomicInteger ocurrencesCount) {
        this.ocurrencesCount = ocurrencesCount;
    }

    public HostBlacklistsDataSourceFacade getFacade() {
        return facade;
    }

    public void setFacade(HostBlacklistsDataSourceFacade facade) {
        this.facade = facade;
    }
}
