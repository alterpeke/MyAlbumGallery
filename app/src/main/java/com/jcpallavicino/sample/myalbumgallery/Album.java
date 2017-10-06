package com.jcpallavicino.sample.myalbumgallery;

/**
 * Created by juan.pallavicino on 21/9/2017.
 */

public class Album {
    private String albumName;
    private String artistName;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
