package edu.polymorphism.songperformace;

/**
 * This dude doesn't give a damn about what's going on around.
 */
public class RandomJudge extends Judge {

    @Override
    public Judgement judge(Performance performance) {
        String[] words = new String[]{" qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq",
                "polesno ochen' ", "i ", "don' t", "give ", "a ", "shit ", "aloloaloaloa", "kb sucks", "yeah ", "my knigga", "asldkjf;aksdlf",
                "vseleon lox", "sam toxic", "blablabla", ""};
        String comment = "";
        for (int i = 0; i < Math.floor(Math.random() * (words.length - 1)) + 1; i++) {
            comment += words[(int)Math.ceil(Math.random() * (words.length - 1))];
        }
        return new Judgement((int)Math.floor(Math.random()*Judgement.MAX_POINTS) + Judgement.MIN_POINTS, comment);
    }

    @Override
    public String getName() {
        return "Willie Wonka";
    }
}
