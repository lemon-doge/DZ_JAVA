package edu.polymorphism.songperformace;

/**
 * Some say he s always high, some say he s somewhat gay...
 * Anyway he doesn't hesitate to give good scores.
 */
public class GoodJudge extends Judge {
    @Override
    public Judgement judge(Performance performance) {
        String[] words = new String[]{"fantastic ", "fascinating ", "impressive ", "astonishing ", "incredible ", "unbelievable "};
        return new Judgement(Judgement.MAX_POINTS, words[(int)Math.floor(Math.random()*words.length)] + "!");
    }

    @Override
    public String getName() {
        return "Sir Elton John";
    }
}
