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

    static class Student {
        private String studentName;
        private String fatherName;
        private int fatherEarnings;
        private String motherName;
        private int motherEarnings;
        private int numberOfBrothers;
        private int numberOfSisters;

        Student(String studentName, String fatherName, int fatherEarnings,
                String motherName, int motherEarnings, int numberOfBrothers,
                int numberOfSisters) {

            this.studentName = studentName;
            this.fatherName = fatherName;
            this.fatherEarnings = fatherEarnings;
            this.motherName = motherName;
            this.motherEarnings = motherEarnings;
            this.numberOfBrothers = numberOfBrothers;
            this.numberOfSisters = numberOfSisters;

        }

        public String getStudentName() {
            return studentName;
        }

        public String getFatherName() {
            return fatherName;
        }

        public int getNumberOfSisters() {
            return numberOfSisters;
        }

        public int getNumberOfBrothers() {
            return numberOfBrothers;
        }

        public int getMotherEarnings() {
            return motherEarnings;
        }

        public String getMotherName() {
            return motherName;
        }

        public int getFatherEarnings() {
            return fatherEarnings;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Student)) {
                return false;
            }
            Student student = (Student) obj;
            return this.studentName.equals(student.studentName) &&
                    this.fatherName.equals(student.fatherName) &&
                    this.fatherEarnings == student.fatherEarnings &&
                    this.motherName.equals(student.motherName) &&
                    this.motherEarnings == student.motherEarnings &&
                    this.numberOfBrothers == student.numberOfBrothers &&
                    this.numberOfSisters == student.numberOfSisters;
        }
    }
}
