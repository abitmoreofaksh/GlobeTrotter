package com.GlobeTrotter.DTO;

public class LeaderboardDTO {

    private String username;
    private Integer correctAnswers;
    private Integer totalAnswers;

    public LeaderboardDTO(String username, Integer totalAnswers, Integer correctAnswers) {
        this.username = username;
        this.totalAnswers = totalAnswers;
        this.correctAnswers = correctAnswers;
    }

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = username;
    }

    public Integer getTotalAnswers() {
        return totalAnswers;
    }

    public void setTotalAnswers(Integer totalAnswers) {
        this.totalAnswers = totalAnswers;
    }

    public Integer getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Integer correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
}
