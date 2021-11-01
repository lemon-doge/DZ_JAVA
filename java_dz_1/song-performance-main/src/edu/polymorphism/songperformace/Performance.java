package edu.polymorphism.songperformace;

/**
 * Выступление участника шоу
 */
public class Performance {
    /**
     * Имя кандидата
     */
    private final String candidateName;
    /**
     * Название исполненной песни
     */
    private final String song;
    /**
     * Название группы
     */
    private final String group;

    public Performance(String candidateName, String song, String group) {
        this.candidateName = candidateName;
        this.song = song;
        this.group = group;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getSong() {
        return song;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Performance{" +
               "candidateName='" + candidateName + '\'' +
               ", song='" + song + '\'' +
               '}';
    }
}
