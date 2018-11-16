package com.spotify.spotify.repository;

import com.spotify.spotify.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByNomorBandIdBand(Integer idBand);
}
