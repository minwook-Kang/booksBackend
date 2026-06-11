package com.aivle.bookapp.services;

import com.aivle.bookapp.domain.Genre;
import com.aivle.bookapp.global.exception.genre.GenreAlreadyExistsException;
import com.aivle.bookapp.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    @Transactional
    public Genre addGenre(String name) {
        String normalized = name.trim();
        if (genreRepository.existsByName(normalized)) {
            throw new GenreAlreadyExistsException();  // 직접 정의
        }
        return genreRepository.save(new Genre(normalized));
    }

    @Transactional(readOnly = true)
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }
}
