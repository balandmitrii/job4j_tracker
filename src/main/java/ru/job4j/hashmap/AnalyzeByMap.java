package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                totalSubjects++;
                totalScore += subject.getScore();
            }
        }
        return totalScore / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.getSubjects()) {
                totalScore += subject.getScore();
            }
            result.add(
                    new Label(pupil.getName(),
                    totalScore / pupil.getSubjects().size())
            );
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        HashMap<String, Double> subjectsHash = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                String subjectName = subject.getName();
                subjectsHash.put(subjectName,
                        subjectsHash.getOrDefault(subjectName, 0.0D)
                        + subject.getScore());
            }
        }
        for (Map.Entry<String, Double> subject : subjectsHash.entrySet()) {
            result.add(new Label(
                    subject.getKey(), subject.getValue() / pupils.size()
            ));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label result = null;
        for (Pupil pupil : pupils) {
            double totalScore = 0;
            for (Subject subject : pupil.getSubjects()) {
                totalScore += subject.getScore();
            }
            if (result == null || result.score() < totalScore) {
                result = new Label(
                        pupil.getName(),
                        totalScore
                );
            }
        }
        return result;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Label result = null;
        HashMap<String, Double> subjects = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.getSubjects()) {
                subjects.put(subject.getName(),
                        subjects.getOrDefault(subject.getName(), 0.0D) + subject.getScore());
            }
        }
        for (Map.Entry<String, Double> subject : subjects.entrySet()) {
            if (result == null || result.score() < subject.getValue()) {
                result = new Label(subject.getKey(), subject.getValue());
            }
        }
        return result;
    }
}