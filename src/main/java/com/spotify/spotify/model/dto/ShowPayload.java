package com.spotify.spotify.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShowPayload {

    private String namaBand;
    private String genre;
    private String namaAlbum;
    private String tahun;
    private List<TracksPayload> lagu;

}
