package miniTest.model;

public class Student extends Person {
    private double mathScore;
    private double physicScore;
    private double chemistryScore;
    private double averageScore;

    public Student(String name, int age, double mathScore, double physicScore, double chemistryScore) {
        super(name, age);
        this.mathScore = mathScore;
        this.physicScore = physicScore;
        this.chemistryScore = chemistryScore;
        this.averageScore = (mathScore + physicScore + chemistryScore) / 3;
    }

    public Student(double mathScore, double physicScore, double chemistryScore) {
        this.mathScore = mathScore;
        this.physicScore = physicScore;
        this.chemistryScore = chemistryScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getPhysicScore() {
        return physicScore;
    }

    public void setPhysicScore(double physicScore) {
        this.physicScore = physicScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return String.format("|%-8s|%-10d|%-7d|%-13.2f|%-13.2f|%-13.2f|%-13.2f|",
                getName(), getId(), getAge(), mathScore, physicScore, chemistryScore,getAverageScore());
    }
}
