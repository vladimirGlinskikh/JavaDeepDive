package kz.zhelezyaka.solid.srp.bestPractice;

public class SeniorityChecker {
    public String checkSeniority(double experienceInYears){
        return experienceInYears >= 5 ? "senior" : "junior";
    }
}
