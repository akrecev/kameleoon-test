package com.kretsev.test_task.vote.model;

import com.kretsev.test_task.quote.model.Quote;
import com.kretsev.test_task.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "votes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean positive;

    private Boolean negative;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "voter_id", nullable = false)
    private User voter;

    @ManyToOne
    @JoinColumn(name = "quote_id", nullable = false)
    private Quote quote;

}
