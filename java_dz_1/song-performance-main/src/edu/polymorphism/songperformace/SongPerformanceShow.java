package edu.polymorphism.songperformace;

public class SongPerformanceShow {
    public static void main(String[] args) {
        // TODO: Судей добавить в этот массив
        Judge[] judges = {};
        // TODO: Выступления добавляем сюда
        Performance[] performances = {new Performance("Яна", "Видеоигры")};

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
