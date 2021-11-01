package edu.polymorphism.songperformace;


/**
 * This guy knows how to make some good damn contests.
 */
public class ClownJudge extends Judge {

    @Override
    public Judgement judge(Performance performance) {
        int score = (int) Math.floor(Math.random() * 3) + 1;

        if (score > 0) {
            return new Judgement(score, "your performance hasn't passed closed tests");
        }

        return new Judgement(score, "PCF");
    }

    @Override
    public String getName() {
        return "I love algos";
    }
}
