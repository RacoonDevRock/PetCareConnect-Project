package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "community")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;
    private String content;

    @Column(name = "ate_post")
    private Date datePost;

//    @ManyToOne(targetEntity = Owner.class)
//    @JoinColumn(name = "owner_id")
//    private Owner owner;
}
