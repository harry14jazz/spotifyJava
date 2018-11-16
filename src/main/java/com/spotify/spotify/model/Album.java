package com.spotify.spotify.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Harry Kurniansyah
 * harry kurniansyah
 * Album Model
 */

@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Entity
@Table(name = "album")

public class Album implements Serializable {

    @Id
    @Column(name = "id_album")
    private Integer idAlbum;

    @Column(name = "nama")
    private String nama;

    @Column(name = "tahun")
    private String tahun;

    @ManyToOne
    @JoinColumn(name = "nomor_band")
    private Band nomorBand;

}
