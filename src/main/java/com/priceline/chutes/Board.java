package com.priceline.chutes;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

    List<BoardSquare> squares;

     Board() {
        squares = java.util.stream.IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Optional
                        .ofNullable(specialSquares.get(i))
                        .orElseGet(BoardSquare::new))
                .collect(Collectors.toList());
    }

    public BoardSquare getSquareAtPosition(int i){
        return squares.get(i-1);
    }
    Stream<AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>> streamOfBoards=
         Stream.of(
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(1, new BoardSquare(false, true, 37)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(4, new BoardSquare(false, true, 10)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(9, new BoardSquare(false, true, 22)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(16, new BoardSquare(true, false, 10)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(21, new BoardSquare(false, true, 21)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(28, new BoardSquare(false, true, 56)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(36, new BoardSquare(false, true, 8)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(47, new BoardSquare(true, false, 21)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(49, new BoardSquare(true, false, 38)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(51, new BoardSquare(false, true, 16)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(56, new BoardSquare(true, false, 3)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(62, new BoardSquare(true, false, 43)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(64, new BoardSquare(true, false, 4)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(71, new BoardSquare(false, true, 20)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(80, new BoardSquare(false, true, 20)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(87, new BoardSquare(true, false, 63)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(93, new BoardSquare(true, false, 20)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(95, new BoardSquare(true, false, 20)),
            new AbstractMap.SimpleImmutableEntry<Integer, BoardSquare>(98, new BoardSquare(true, false, 20)));
    Map<Integer, BoardSquare> specialSquares = streamOfBoards.collect(Collectors.toMap(
            AbstractMap.SimpleImmutableEntry::getKey,
            AbstractMap.SimpleImmutableEntry::getValue));
}
