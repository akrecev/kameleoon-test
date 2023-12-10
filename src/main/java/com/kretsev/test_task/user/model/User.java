package com.kretsev.test_task.user.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kretsev.test_task.quote.model.Quote;
import com.kretsev.test_task.vote.model.Vote;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 512)
    private String email;

    @Column(nullable = false, length = 512)
    private String password;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime created;

    @JsonManagedReference
    @OneToMany(mappedBy = "voter")
    private Set<Vote> votes;

    @JsonManagedReference
    @OneToMany(mappedBy = "speaker")
    private Set<Quote> quotes;

    @ToString.Include(name = "password")
    private String maskPassword() {
        return "********";
    }
}
