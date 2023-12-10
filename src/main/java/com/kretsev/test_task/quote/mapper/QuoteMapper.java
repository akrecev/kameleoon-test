package com.kretsev.test_task.quote.mapper;

import com.kretsev.test_task.quote.dto.NewQuoteRequest;
import com.kretsev.test_task.quote.dto.QuoteDto;
import com.kretsev.test_task.quote.dto.QuoteFullDto;
import com.kretsev.test_task.quote.dto.QuoteShortDto;
import com.kretsev.test_task.quote.model.Quote;
import com.kretsev.test_task.vote.mapper.VoteMapper;

import java.util.stream.Collectors;

import static com.kretsev.test_task.user.mapper.UserMapper.toUserDto;
import static com.kretsev.test_task.user.mapper.UserMapper.toUserShortDto;

public class QuoteMapper {
    private QuoteMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static QuoteDto toQuoteDto(Quote quote) {
        return new QuoteDto(
                quote.getId(),
                quote.getContent(),
                quote.getCreated(),
                quote.getUpdated(),
                toUserShortDto(quote.getSpeaker()),
                quote.getVotes().stream()
                        .map(VoteMapper::toVoteShortDto)
                        .collect(Collectors.toList())
        );
    }

    public static QuoteFullDto toQuoteFullDto(Quote quote) {
        return new QuoteFullDto(
                quote.getId(),
                quote.getContent(),
                quote.getCreated(),
                quote.getUpdated(),
                toUserDto(quote.getSpeaker()),
                quote.getVotes() != null
                        ? quote.getVotes().stream()
                        .map(VoteMapper::toVoteShortDto)
                        .collect(Collectors.toList())
                        : null
        );
    }

    public static QuoteShortDto toQuoteShortDto(Quote quote) {
        return new QuoteShortDto(
                quote.getContent()
        );
    }

    public static Quote toNewQuote(NewQuoteRequest quoteRequest) {
        return Quote.builder()
                .content(quoteRequest.getContent())
                .build();
    }
}
