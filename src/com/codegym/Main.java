package com.codegym;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        String[] student = {"Thang", "Viet", "Binh", "Cuong"};
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập tên sinh viên cần tìm: ");
//        String name = scanner.nextLine();
//        Stream<String> stream = Arrays.stream(student);
//        stream.sorted((s1,s2) -> s2.compareTo(s1) ).forEach(thang -> System.out.println(thang));
//        Integer[] numbers = {3,4,5,1,2,45,633,2222,23,12};
//        Supplier<Stream<Integer>> stream = () -> Arrays.stream(numbers);
//        Optional<Integer> maxNum = stream.get().max(Comparator.comparing(Integer::valueOf));
//        System.out.println("Giá trị lớn nhất là: ");
//            System.out.println(maxNum.get());
//
//
//        Optional<Integer> minNum = stream.get().min(Comparator.comparing(Integer::valueOf));
//        System.out.println("Giá trị nhỏ nhất là: ");
//
//        System.out.println(minNum.get());
        List<Student> students = Arrays.asList(
                new Student("A", true, 18, 5, Arrays.asList("Toan", "Ly", "Hoa")),
                new Student("A", true, 18, 5, Arrays.asList("Van", "Su", "Hoa")),
                new Student("B", false, 15, 8, Arrays.asList("Toan", "Van", "Anh", "Su")),
                new Student("C", false, 12, 9, Arrays.asList("Cong nghe", "Dia ly")),
                new Student("D", true, 10, 3, Arrays.asList("Anh van", "Hoa", "Sinh")),
                new Student("E", true, 10, 2, Arrays.asList("My Thuat", "Am nhac")),
                new Student("F", false, 18, 10, Arrays.asList()));

        // lọc các sinh viên có giới tính là nam, tuổi trên 10, điểm >= 5
        Supplier<Stream<Student>> studentStream = () -> students.stream();
        System.out.println("Danh sách sinh viên nam: ");
        studentStream.get().filter(student -> student.isMale && student.age > 10 && student.score >= 5)
                .forEach(student -> System.out.println(student.toString()));
        //Ví dụ Sử dụng filter() lọc các Student là nam, có tuổi trên 10, điểm từ trung bình trở lên.
        // Quá trình filter sẽ bắt đầu từ sinh viên thứ 2 trong ArrayList xử lý tối đa 3 Student.
        System.out.println("Danh sách rút gọn sinh viên: ");
        studentStream.get().skip(1).limit(3)
                .filter(student -> student.isMale() == false && student.age >= 10 && student.score >= 5)
                .forEach(student -> System.out.println(student.toString()));
        //Ví dụ trích danh sách điểm của tất cả các sinh viên.
        System.out.println("Danh sách điểm của các sinh viên: ");
        List<Integer> scores =  studentStream.get().map(student -> student.getScore())
                .collect(Collectors.toList());
        System.out.print(scores + ", ");

        //Ví dụ liệt qua tất cả các môn học của tất cả các Student.
        System.out.println("Danh sách các môn học của sinh viên");
        Set<String> subject = studentStream.get().flatMap(student -> student.subjects.stream())
                .collect(Collectors.toSet());
        System.out.print(subject + ", ");
        //Ví dụ sắp xếp các Student theo độ tuổi.
        System.out.println(" Sắp xếp sinh viên theo độ tuổi");
        studentStream.get().sorted((s1,s2) -> s2.age - s1.age)
                .forEach(s -> System.out.println(s));
    }
}
