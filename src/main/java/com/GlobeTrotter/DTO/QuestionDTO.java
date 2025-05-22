package com.GlobeTrotter.DTO;

import java.util.List;

public class QuestionDTO {
    private Long questionId;
    private String questionURL;
    private List<String> clues;
    private List<DestinationOption> options;

    public QuestionDTO() {
    }

    public QuestionDTO(Long questionId, List<DestinationOption> options, List<String> clues, String questionURL) {
        this.questionId = questionId;
        this.options = options;
        this.clues = clues;
        this.questionURL = questionURL;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public List<DestinationOption> getOptions() {
        return options;
    }

    public void setOptions(List<DestinationOption> options) {
        this.options = options;
    }

    public List<String> getClues() {
        return clues;
    }

    public void setClues(List<String> clues) {
        this.clues = clues;
    }

    public String getQuestionURL() {
        return questionURL;
    }

    public void setQuestionURL(String questionURL) {
        this.questionURL = questionURL;
    }
}
