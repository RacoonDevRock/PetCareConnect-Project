package com.petcareconnect.api.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "community")
@Builder
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    Long postId;
    String content;
    @Column(name = "date_post")
    Date datePost;

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name = "owner_id")
    Owner owner;
}
