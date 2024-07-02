package com.kh.boot.domain.dto;

import lombok.Getter;
import lombok.Setter;

public class BoardRequest {

    @Getter
    @Setter
    public static class CreateDTO{
        private String userId;
        private String pwd;
        private String title;
        private String contents;
    }

    @Getter
    @Setter
    public static class UpdateDTO{
        private String boardId;
        private String userId;
        private String pwd;
        private String title;
        private String contents;
    }
}
