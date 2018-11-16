package com.spotify.spotify.controller.Band;

import com.spotify.spotify.exception.ResourceNotFoundException;
import com.spotify.spotify.model.Band;
import com.spotify.spotify.model.dto.BandsPayload;
import com.spotify.spotify.repository.BandRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/spotify")

public class BandController {
    @Autowired
    BandRepository bandRepository;

    //Get all Bands
    @GetMapping("/bands")
    public List<Band> getAllBands() {
        return bandRepository.findAll();
    }

    //Get a Single Bands
    @GetMapping("/band")
    public Map<String, Object> getBandById(
            @RequestParam(value = "id_band") Integer idBand){

        Map<String, Object> map = new HashMap<>();
        Band band = bandRepository.findById(idBand).orElseThrow(()-> new ResourceNotFoundException("Data Band", "bandId", idBand));
        BandsPayload bandsPayload = new BandsPayload();
        bandsPayload.setNamaBand(band.getNama());
        bandsPayload.setGenreBand(band.getGenre());

        map.put("data", bandsPayload);
        return map;
    }
}
