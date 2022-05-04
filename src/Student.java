public class Student {

        private String name;
        private String surname;
        private String schoolGrade;
        private String grade;

        public Student(String name, String surname, String schoolGrade, String grade){
            this.name = name;
            this.surname = surname;
            this.schoolGrade = schoolGrade;
            this.grade = grade;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String capital) {
            this.surname = surname;
        }

        public String getNameAndSurname(){return (name + " " + surname);}

        public String getSchoolGrade() {
            return schoolGrade;
        }

        public void setSchoolGrade(String nickname) {
            this.schoolGrade = schoolGrade;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String population) {
            this.grade = grade;
        }

        public String getTicketPrice(){
            if (getGrade().equals("7"))
                return "5";
            else if (getGrade().equals("6") || getGrade().equals("5"))
                return "10";
            else if (getGrade().equals("4") || getGrade().equals("3"))
                return "20";
            else
                return "30";
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", schoolGrade='" + schoolGrade + '\'' +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }

