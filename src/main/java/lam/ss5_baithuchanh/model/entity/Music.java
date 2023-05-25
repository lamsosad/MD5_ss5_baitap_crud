package lam.ss5_baithuchanh.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameSong;
    private String nameSinger;
    private String song;

    public Music() {
    }

    public Music(String nameSong, String nameSinger, String song) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.song = song;
    }

    public Music(Long id, String nameSong, String nameSinger, String song) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.song = song;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
