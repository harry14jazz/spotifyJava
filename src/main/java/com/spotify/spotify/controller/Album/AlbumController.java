package com.spotify.spotify.controller.Album;

import com.spotify.spotify.exception.ResourceNotFoundException;
import com.spotify.spotify.model.Album;
import com.spotify.spotify.model.Band;
import com.spotify.spotify.model.dto.AlbumDetaliPayload;
import com.spotify.spotify.model.dto.AlbumPayload;
import com.spotify.spotify.repository.AlbumRepository;
import com.spotify.spotify.repository.BandRepository;
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
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    BandRepository bandRepository;

    // Get all Albums
    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    //Get a Single Album
    @GetMapping("/album")
    public Map<String, Object> getAlbumById(
            @RequestParam(value = "nomor_band")Integer nomorBand ){

        Map<String, Object> map = new HashMap<>();
        List<AlbumDetaliPayload> albumDetaliPayloadList = new ArrayList<>();
        List<Album> albumList  = albumRepository.findByNomorBandIdBand(nomorBand);
        AlbumPayload albumPayload = new AlbumPayload();
        for (Album row : albumList){
            AlbumDetaliPayload tmp = new AlbumDetaliPayload();
            tmp.setNamaAlbum(row.getNama());
            tmp.setTahunRilis(row.getTahun());
            albumDetaliPayloadList.add(tmp);
        }

        albumPayload.setNamaBand(albumList.get(0).getNomorBand().getNama());
        albumPayload.setAlbum(albumDetaliPayloadList);
        map.put("data", albumPayload);
        return map;
    }
}