package com.aivle.bookapp.global.exception.book;

import com.aivle.bookapp.global.exception.BusinessException;
import com.aivle.bookapp.global.exception.ErrorCode;

/**
 * 예시: Book book = bookRepository.findById(bookId)
 *                 .orElseThrow(BookNotFoundException::new);
 * 요청한 책을 DB에서 찾을 수 없을 때 던지는 예외
 */
public class BookNotFoundException extends BusinessException {
    public BookNotFoundException() {
        super(ErrorCode.BOOK_NOT_FOUND);
    }
}
