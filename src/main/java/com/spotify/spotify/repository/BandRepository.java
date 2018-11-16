package com.spotify.spotify.repository;

import com.spotify.spotify.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends JpaRepository<Band, Integer> {

}
