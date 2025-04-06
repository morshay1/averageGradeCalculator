public class Course {
    String name;
    int grade;
    double nakaz;

    public Course(String courseName, int finalGrade, double nakazAmount){
        name = courseName;
        grade = finalGrade;
        nakaz = nakazAmount;
    }

    public String getName(){ return name;  }

    public int getGrade(){
        return grade;
    }

    public double getNakaz(){
        return nakaz;
    }
}
