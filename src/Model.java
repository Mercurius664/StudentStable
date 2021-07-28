import java.util.ArrayList;

public class Model {

    private static ArrayList<Student> studentArrayList = new ArrayList<>();
    private static ArrayList<Student> studentArrayListForFind = new ArrayList<>();

    public static ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public static ArrayList<Student> getStudentArrayListForFind() {
        return studentArrayListForFind;
    }

}
