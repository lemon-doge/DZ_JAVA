package edu.polymorphism.songperformace;

public class SongPerformanceShow {
    public static void main(String[] args) {
        // TODO: Судей добавить в этот массив
        Judge[] judges = {new BadJudge(), new ClownJudge(), new GoodJudge(), new RandomJudge(), new MetallicaFunJudge()};
        // TODO: Выступления добавляем сюда
        Performance[] performances = {new Performance("Balabanka","Song of walu","Peacekeepers"),
                new Performance("Dmitry Tatyanchenko","Fade to black","Metallica"),
                new Performance("Dmitry Tatyanchenko","The whistler","The White Buffalo"),
                new Performance("Andrew Los'","Sex machine","Samara Band"),
                new Performance("Tim Valovitch","fuji","playingtheangel"),
                new Performance("asdasd","asd","asdasd"),
                new Performance("Freddy the Masculine","who wants to live forever","King"),
                new Performance("Elton John","Saturday","Elton John")};

        for (Performance performance : performances) {
            System.out.println(performance.getCandidateName() + " исполняет '" + performance.getSong() + "'");

            for (Judge judge : judges) {
                Judgement judgement = judge.judge(performance);
                System.out.println(judge.getName() + " говорит: '" + judgement.comment()
                                   + "', оценка: " + judgement.points() + " из " + Judgement.MAX_POINTS);
            }
        }
    }
}
