package com.aivle.bookapp.global.exception.genre;

import com.aivle.bookapp.global.exception.BusinessException;
import com.aivle.bookapp.global.exception.ErrorCode;

/**
 * 이미 존재하는 이름의 장르를 다시 추가하려 할 때 던지는 예외
 *
 * 예시: if (genreRepository.existsByName(name)) {
 *           throw new GenreAlreadyExistsException();
 *       }
 */
public class GenreAlreadyExistsException extends BusinessException {
    public GenreAlreadyExistsException() {
        super(ErrorCode.GENRE_ALREADY_EXISTS);
    }
}
