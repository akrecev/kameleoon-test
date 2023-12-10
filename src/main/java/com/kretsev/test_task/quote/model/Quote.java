package com.kretsev.test_task.quote.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kretsev.test_task.user.model.User;
import com.kretsev.test_task.vote.model.Vote;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "quotes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 3000)
    private String content;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime created;

    @Column(name = "updated_on")
    private LocalDateTime updated;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "speaker_id")
    private User speaker;

    @JsonManagedReference
    @OneToMany(mappedBy = "quote")
    private Set<Vote> votes;
}
