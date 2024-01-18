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
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String comment;
    private String image;
    private Date publishDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity", nullable = false)
    private Activity activity;
}
