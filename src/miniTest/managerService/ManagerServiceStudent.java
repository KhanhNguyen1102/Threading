package miniTest.managerService;

import miniTest.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ManagerServiceStudent implements ManagerService<Student>{
    private  ArrayList<Student> students = new ArrayList<>();
    private static int autoGenerateId = 1;
    public ManagerServiceStudent(ArrayList<Student> students) {
        this.students = students;
    }

    public ManagerServiceStudent() {
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public static int getAutoGenerateId() {
        return autoGenerateId;
    }

    public static void setAutoGenerateId(int autoGenerateId) {
        ManagerServiceStudent.autoGenerateId = autoGenerateId;
    }

    @Override
    public void add(Student student) {
        student.setId(autoGenerateId);
        students.add(student);
        autoGenerateId++;
        System.out.println("Đã thêm thành công ");
    }

    @Override
    public void updateById(Student student, int id) {
        int indexToUpdate = findById(id);
        if (indexToUpdate == -1){
            System.out.println("không tìm thấy học sinh này");
        }else {
            student.setId(students.get(id).getId());
            students.set(indexToUpdate,student);
            System.out.println("Đã cập nhật thành công");
        }
    }

    @Override
    public void deleteById(int id) {
        int indexToDelete = findById(id);
        if (indexToDelete == -1){
            System.out.println("Không tìm thấy học sinh này");
        }else {
            students.remove(indexToDelete);
            System.out.println("Đã xóa thành công");
        }
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < students.size(); i++) {
            boolean isContain = students.get(i).getId() == id;
            if (isContain){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void print() {
        printFullLine();
        System.out.printf("|%-8s|%-10s|%-7s|%-13s|%-13s|%-13s|%-13s|%n",
                "Tên", "ID", "Tuổi", "Điểm toán", "Điểm lý", "Điểm Hóa", "Điểm TB");
        printFullLine();
        for (Student student:students) {
            System.out.println(student);
        }
        printFullLine();
    }

    public ArrayList<Student> sortMinToMaxByAverageScore(){
        ArrayList<Student> students1 = (ArrayList<Student>) students.clone();
        students1.sort(Comparator.comparingDouble(Student::getAverageScore));
        System.out.println("Đã sắp xếp thành công !");
        return students1;
    }
    public ArrayList<Student> sortMaxToMinByAverageScore(){
        ArrayList<Student> students2 = (ArrayList<Student>) students.clone();
        students.sort((o1, o2) -> Double.compare(o2.getAverageScore(), o1.getAverageScore()));
        System.out.println("Đã sắp xếp thành công !");
        return students2;
    }
    public double findMaxAverageScore(){
        double maxAverageScore = 0;
        for (Student student: students) {
            if (student.getAverageScore() > maxAverageScore){
                maxAverageScore = student.getAverageScore();
            }
        }
        return maxAverageScore;
    }
    public Student findStudentHaveMaxAverageScore(){
        double maxAverageScore = findMaxAverageScore();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageScore() == maxAverageScore){
                return students.get(i);
            }
        }
        return null;
    }
    public static void printLine(int space) {
        for (int i = 0; i <= space; i++) {
            if (i == space) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
    }
    public static void printFullLine() {
        System.out.print("+");
        printLine(8);
        printLine(10);
        printLine(7);
        printLine(13);
        printLine(13);
        printLine(13);
        printLine(13);
        System.out.println();
    }
    public void writeToFile(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Name , Id , Age , Math Score, Physic Score, Chemistry Score ");
        for (Student student:students) {
            bufferedWriter.write("\n" + student.getName() +
                                     " , "  + student.getId()+
                                     " , "  + student.getAge()+
                                     " , "  + student.getMathScore()+
                                     " , "  + student.getPhysicScore()+
                                     " , "  + student.getChemistryScore());
        }
        bufferedWriter.close();
    }
    public ArrayList<Student> getStudentFromFile(String filePath) throws IOException{
        ArrayList<Student> students = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null){
            String[] str = line.split(",");
            String name = str[0];
            int id = Integer.parseInt(str[1].trim());
            int age = Integer.parseInt(str[2].trim());
            double mathScore = Double.parseDouble(str[3].trim());
            double mathPhysicScore = Double.parseDouble(str[4].trim());
            double mathChemistryScore = Double.parseDouble(str[5].trim());
            Student student = new Student(name,age,mathScore,mathPhysicScore,mathChemistryScore);
            student.setId(id);
            students.add(student);
        }
        return students;
    }
}
