package com.kh.boot.service;

import com.kh.boot.domain.dto.BoardRequest;

public interface BoardService {
    Boolean create(BoardRequest.CreateDTO request) throws Exception;
}
