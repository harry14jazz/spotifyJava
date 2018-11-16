package com.spotify.spotify.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class AlbumPayload {
    private String namaBand;
    private List<AlbumDetaliPayload>album;
}
