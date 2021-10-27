package miniTest.managerService;

import miniTest.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerServiceStudent studentList = new ManagerServiceStudent();
        int choice = -1;
        showMenu();
        do {
            Scanner input = new Scanner(System.in);
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Nhập lại số đi");
                input.nextLine();
                choice = -1;
            } finally {
                doChoice(choice, studentList);
                showMenu();
            }
        } while (true);
    }
    public static void doChoice(int choice, ManagerServiceStudent studentList) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1 -> {
                studentList.add(createStudent());
                studentList.print();
            }
            case 2 -> studentList.print();
            case 3 -> {
                System.out.println("Điền vị trí muốn sửa");
                int index1 = input.nextInt();
                studentList.updateById(createStudent(), index1);
                studentList.print();
            }
            case 4 -> {
                System.out.println("Nhập id học sinh muốn xóa ");
                int index2 = input.nextInt();
                studentList.deleteById(index2);
                studentList.print();
            }
            case 5 -> {
                System.out.println("Nhập id học sinh muốn tìm ");
                int idToFind = input.nextInt();
                int indexToFind = studentList.findById(idToFind);
                if (indexToFind != -1) {
                    System.out.println(studentList.getStudents().get(indexToFind));
                } else System.out.println("Ko tìm thấy");
                System.out.println("=========================");
            }
            case 6 -> {
                System.out.println(studentList.sortMinToMaxByAverageScore());
            }
            case 7 -> {
                System.out.println(studentList.sortMaxToMinByAverageScore());
            }
            case 8 -> System.out.println("Sinh viên có điểm cao nhất là " + studentList.findStudentHaveMaxAverageScore());
            case 9 -> System.out.println("Điểm số cao nhất là " + studentList.findMaxAverageScore());
            case 0 -> System.exit(0);
            default -> System.out.println("Invalid choice");
        }
    }
    public static void showMenu() {
        System.out.println("Menu");
        System.out.println("1. Thêm học sinh ");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Sửa thông tin học sinh");
        System.out.println("4. Xóa học sinh ");
        System.out.println("5. Tìm học sinh theo mã ");
        System.out.println("6. Sắp xếp các học sinh từ bé đến lớn theo điểm trung bình ");
        System.out.println("7. Sắp xếp các học sinh từ lớn đến bé theo điểm trung bình ");
        System.out.println("8. Tìm sinh viên điểm cao nhất ");
        System.out.println("9. Tìm điểm cao nhất ");
        System.out.println("0. Thoát ");
        System.out.println("Điền lựa chọn: ");
        System.out.println("=========================");
    }


    public static Student createStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Điền tên của học sinh ");
        String name = scanner.nextLine();
        System.out.println("Điền tuổi của học sinh ");
        int age = scanner.nextInt();
        System.out.println("Điền điểm toán của học sinh ");
        double mathScore = scanner.nextDouble();
        System.out.println("Điền điểm vật lý của học sinh");
        double physicScore = scanner.nextDouble();
        System.out.println("Điền điểm hóa của học sinh");
        double chemistryScore = scanner.nextDouble();
        return new Student(name, age, mathScore,physicScore,chemistryScore);
    }
}

