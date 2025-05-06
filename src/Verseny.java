import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Verseny {
    private LocalDate datum;
    private String hely;
    private int helyezes;
    private int korok;
    private int pontok;
    private String csapat;
    private String statusz;

    public Verseny(String sor) {
        String [] reszek = sor.split(";");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.datum = LocalDate.parse(reszek[0], format);
        this.hely = reszek[1];
        this.helyezes = Integer.parseInt(reszek[2]);
        this.korok = Integer.parseInt(reszek[3]);
        this.pontok = Integer.parseInt(reszek[4]);
        this.csapat = reszek[5];
        this.statusz = reszek[6];
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getHely() {
        return hely;
    }

    public int getHelyezes() {
        return helyezes;
    }

    public int getKorok() {
        return korok;
    }

    public int getPontok() {
        return pontok;
    }

    public String getCsapat() {
        return csapat;
    }

    public String getStatusz() {
        return statusz;
    }

    @Override
    public String toString() {
        return "datum=" + datum +
                ", hely=" + hely +
                ", helyezes=" + helyezes +
                ", korok=" + korok +
                ", pontok=" + pontok +
                ", csapat=" + csapat +
                ", statusz=" + statusz;
    }
}
