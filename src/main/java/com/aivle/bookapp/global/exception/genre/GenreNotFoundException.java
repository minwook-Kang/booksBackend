package com.aivle.bookapp.global.exception.genre;

import com.aivle.bookapp.global.exception.BusinessException;
import com.aivle.bookapp.global.exception.ErrorCode;

/**
 * 요청한 장르를 DB에서 찾을 수 없을 때 던지는 예외
 *
 * 예시: Genre genre = genreRepository.findById(genreId)
 *                  .orElseThrow(GenreNotFoundException::new);
 */
public class GenreNotFoundException extends BusinessException {
    public GenreNotFoundException() {
        super(ErrorCode.GENRE_NOT_FOUND);
    }
}

