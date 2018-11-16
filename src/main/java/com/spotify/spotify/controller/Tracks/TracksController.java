package com.spotify.spotify.controller.Tracks;

import com.spotify.spotify.exception.ResourceNotFoundException;
import com.spotify.spotify.model.Album;
import com.spotify.spotify.model.Band;
import com.spotify.spotify.model.Tracks;
import com.spotify.spotify.model.dto.ShowPayload;
import com.spotify.spotify.model.dto.TracksPayload;
import com.spotify.spotify.model.dto.ShowPayload;
import com.spotify.spotify.repository.AlbumRepository;
import com.spotify.spotify.repository.BandRepository;
import com.spotify.spotify.repository.TracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/spotify")

public class TracksController {

    @Autowired
    TracksRepository tracksRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    BandRepository bandRepository;

    // Get all Tracks
    @GetMapping("/tracks")
    public List<Tracks> getAllTracks() {
        return tracksRepository.findAll();
    }

    // Get All Tracks from a Single Album
    @GetMapping("/track")
    public Map<String, Object> showRequest(
            @RequestParam(value = "nomor_album") Integer idAlbum) {

        Map<String, Object> map = new HashMap<>();
        List<TracksPayload> tracksListPayload = new ArrayList<>();
        List<Tracks> listTrack = tracksRepository.findByNomorAlbumIdAlbum(idAlbum);

        for (Tracks row : listTrack) {
            TracksPayload tmp = new TracksPayload();
            tmp.setJudulLagu(row.getJudul());
            tmp.setDurasi(row.getDurasi());
            tracksListPayload.add(tmp);
        }

        ShowPayload showPayload = new ShowPayload();
        showPayload.setNamaBand(listTrack.get(0).getNomorAlbum().getNomorBand().getNama());
        showPayload.setGenre(listTrack.get(0).getNomorAlbum().getNomorBand().getGenre());
        showPayload.setNamaAlbum(listTrack.get(0).getNomorAlbum().getNama());
        showPayload.setTahun(listTrack.get(0).getNomorAlbum().getTahun());
        showPayload.setLagu(tracksListPayload);
        map.put("data", showPayload);
        return map;
    }


}
