package com.spotify.spotify.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Harry Kurniansyah
 * harry14jazz@gmail.com
 * Band Model
 */

@Entity
@Setter
@Getter
@Table(name = "Band")

@EntityListeners(AuditingEntityListener.class)

public class Band implements Serializable {

    @Id
    @Column(name = "id_band")
    private Integer idBand;

    @Column(name = "nama")
    private String nama;

    @Column(name = "genre")
    private String genre;
}
