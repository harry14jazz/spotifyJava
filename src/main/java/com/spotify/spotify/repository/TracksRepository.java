package com.spotify.spotify.repository;

import com.spotify.spotify.model.Tracks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TracksRepository extends JpaRepository<Tracks, Integer> {
    List<Tracks> findByNomorAlbumIdAlbum(Integer idAlbum);
}
