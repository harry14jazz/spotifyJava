package com.spotify.spotify.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Harry Kurniansyah harry14jazz@gmail.com
 * Tracks Model
 */


@Entity
@Setter
@Getter
@Table(name = "tracks")
@EntityListeners(AuditingEntityListener.class)

public class Tracks implements Serializable {

    @Id
    @Column(name = "id_tracks")
    private Integer idTracks;

    @Column(name = "judul")
    private String judul;

    @Column(name = "durasi")
    private String durasi;

    @ManyToOne
    @JoinColumn(name = "nomor_album")
    private Album nomorAlbum;

}
