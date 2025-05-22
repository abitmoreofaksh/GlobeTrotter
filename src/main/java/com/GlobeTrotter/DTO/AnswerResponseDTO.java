package com.GlobeTrotter.DTO;

public class AnswerResponseDTO {
    private boolean correct;
    private Long correctDestinationId;
    private String correctDestinationName;
    private String fact;

    public AnswerResponseDTO(boolean correct, String fact, String correctDestinationName, Long correctDestinationId) {
        this.correct = correct;
        this.fact = fact;
        this.correctDestinationName = correctDestinationName;
        this.correctDestinationId = correctDestinationId;
    }

    public AnswerResponseDTO() {
    }

    public Long getCorrectDestinationId() {
        return correctDestinationId;
    }

    public void setCorrectDestinationId(Long correctDestinationId) {
        this.correctDestinationId = correctDestinationId;
    }

    public String getCorrectDestinationName() {
        return correctDestinationName;
    }

    public void setCorrectDestinationName(String correctDestinationName) {
        this.correctDestinationName = correctDestinationName;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
