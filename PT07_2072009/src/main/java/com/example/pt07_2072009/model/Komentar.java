package com.example.pt07_2072009.model;

public class Komentar {
    public Komentar(String username, String komentarmu) {
        this.username = username;
        this.komentarmu = komentarmu;
    }

    private String username;
    private String komentarmu;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKomentarmu() {
        return komentarmu;
    }

    public void setKomentarmu(String komentarmu) {
        this.komentarmu = komentarmu;
    }

    @Override
    public String toString() {
        return username + " - " + komentarmu;
    }
}
