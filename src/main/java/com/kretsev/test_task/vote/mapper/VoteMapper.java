package com.kretsev.test_task.vote.mapper;

import com.kretsev.test_task.vote.dto.NewVoteRequest;
import com.kretsev.test_task.vote.dto.VoteDto;
import com.kretsev.test_task.vote.dto.VoteShortDto;
import com.kretsev.test_task.vote.model.Vote;

import static com.kretsev.test_task.quote.mapper.QuoteMapper.toQuoteDto;
import static com.kretsev.test_task.user.mapper.UserMapper.toUserDto;

public class VoteMapper {
    private VoteMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static VoteDto toVoteDto(Vote vote) {
        return new VoteDto(
                vote.getId(),
                vote.getPositive() != null ? vote.getPositive() : !vote.getNegative(),
                vote.getCreated(),
                toUserDto(vote.getVoter()),
                toQuoteDto(vote.getQuote())
        );
    }

    public static VoteShortDto toVoteShortDto(Vote vote) {
        return new VoteShortDto(
                vote.getPositive() != null ? vote.getPositive() : !vote.getNegative(),
                vote.getCreated()
        );
    }

    public static Vote toNewVote(NewVoteRequest voteRequest) {
        return Vote.builder()
                .positive(voteRequest.getIsPositive() ? true : null)
                .negative(!voteRequest.getIsPositive() ? true : null)
                .build();
    }
}
