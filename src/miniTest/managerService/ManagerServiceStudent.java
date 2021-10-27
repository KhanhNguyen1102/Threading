package miniTest.managerService;

import miniTest.model.Student;

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
        for (Student student:students) {
            System.out.println(student);
        }
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
}
