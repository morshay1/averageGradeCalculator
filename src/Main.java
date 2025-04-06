import java.io.*;
import java.util.*;
import java.io.IOException;

public class Main {
    public static double calcCourse(Course[] Courses) {
        double finalAvg = 0;
        double total_nakaz = 0;
        for (Course value : Courses) {
            int Course = value.getGrade();
            double nakaz = value.getNakaz();
            if(value.getGrade() <= 100){
                total_nakaz = total_nakaz + nakaz;
                finalAvg = finalAvg + nakaz * Course;
            }
        }
        double finalCourse = finalAvg / (total_nakaz);
        return Math.round(finalCourse * 100.0) / 100.0;
    }

    public static double coutNakaz(Course[] Courses) {
        double total_nakaz = 0;
        for (Course Course : Courses) {
            double nakaz = Course.getNakaz();
            total_nakaz = total_nakaz + nakaz;
        }
        return total_nakaz;
    }

    public static Course[] createCourses(String filename) {
        List<Course> courseList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    int grade = Integer.parseInt(parts[1].trim());
                    double nakaz = Double.parseDouble(parts[2].trim());
                    courseList.add(new Course(name, grade, nakaz));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseList.toArray(new Course[0]);
    }

    public static void main(String[] args) {
        Course[] array = createCourses("gradesSheet.txt");

        System.out.println("Avarage Garde: " + calcCourse(array));
        System.out.println("Total Nakaz: " + coutNakaz(array));
    }
}