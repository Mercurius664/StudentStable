class Student {
    private final String studentName;
    private final String fatherName;
    private final int fatherEarnings;
    private final String motherName;
    private final int motherEarnings;
    private final int numberOfBrothers;
    private final int numberOfSisters;

    public Student(String studentName, String fatherName, int fatherEarnings,
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
