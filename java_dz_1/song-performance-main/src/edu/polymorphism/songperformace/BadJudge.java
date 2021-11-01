package edu.polymorphism.songperformace;

/**
 * It's really difficult to impress this guy.
 */
public class BadJudge extends Judge {
    @Override
    public Judgement judge(Performance performance) {
        return new Judgement(Judgement.MIN_POINTS, "not impressed.");
    }

    @Override
    public String getName() {
        return "Johny Dillinger";
    }
}
