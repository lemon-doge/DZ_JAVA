package edu.polymorphism.songperformace;

/**
 * This guy s been to f*king Iraq and he knows the shit 'bout good music.
 * So he loves 'Tallica and respects the folks who play it.
 */
public class MetallicaFunJudge extends Judge{

    @Override
    public Judgement judge(Performance performance) {
        if(performance.getGroup().equals("Metallica")) {
            return new Judgement(Judgement.MAX_POINTS, "noice");
        } else {
            return new Judgement(Judgement.MIN_POINTS, "nah, das no good");
        }
    }

    @Override
    public String getName() {
        return "Jamie Smith";
    }
}
