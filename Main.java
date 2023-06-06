import java.util.Scanner;

class Profile {
    String Name;
    String Rollnumber;

    public Profile(String Name, String Rollnumber) {
        this.Name = Name;
        this.Rollnumber = Rollnumber;
    }

    public void showProfile() {
        System.out.println("Name: " + this.Name);
        System.out.println("Roll number : " + this.Rollnumber+"\n");
    }
}

class Registration extends Profile {
    int[] Coursereg = new int[10];
    String[] Courselst = new String[]{"Algorithm Analysis", "Computer Networks", "Computer Networks Laboratory", "Gender Equality", "Java Programming (Integrated Course)"};
    String[] Regulationlst = new String[]{"2021", "2021", "2021", "2021", "2021"};
    String[] Coursecodelst = new String[]{"21UCS403", "21UCS402", "21UCS407", "21UGM431", "21UIT404"};

    public Registration(String Name, String Rollnumber) {
        super(Name, Rollnumber);
    }

    public void showCourses() {
        int n = Coursecodelst.length;
        System.out.println("Regulation \t Course Code \t Course Name \t");
        for (int i = 0; i < n; i++) {
            System.out.println(this.Regulationlst[i] + "\t \t" + this.Coursecodelst[i] + "\t \t" + this.Courselst[i]);
        }
    }

    public void regMechanism(int i) {
        Scanner sc = new Scanner(System.in);
        int flag;
        System.out.println("Add " + this.Coursecodelst[i] + "\t" + this.Courselst[i] + "?" + "(yes-1/no-0)");
        flag = sc.nextInt();
        if (flag == 1) {
            System.out.println("Added successfully");
            this.Coursereg[i] = 1;
        } else {
            this.Coursereg[i] = 0;
        }

    }

    public int getTotal() {
        return this.Courselst.length;
    }

    public void showFinal() {
        int n = Coursecodelst.length;
        System.out.println("Regulation \t Course Code \t Course Name \t");
        for (int i = 0; i < n; i++) {
            if (this.Coursereg[i] == 1) {
                System.out.println(this.Regulationlst[i] + "\t \t" + this.Coursecodelst[i] + "\t \t" + this.Courselst[i]);
            }
        }

    }
}

class Main {
    public static void main(String[] args) {
        String n, r;
        int k, conf, drive = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Course Registration");
        System.out.println("Please Enter your Following details");
        System.out.println("Name:");
        n = sc.nextLine();
        System.out.println("Rollnumber:");
        r = sc.nextLine();
        while (drive == 1) {
            Registration reg = new Registration(n, r);
            reg.showCourses();
            System.out.println("Select Courses \n");
            k = reg.getTotal();
            for (int i = 0; i < k; i++) {
                reg.regMechanism(i);
            }
            System.out.println("Courses for confirmation \n");
            reg.showProfile();
            reg.showFinal();
            System.out.println("Proceed to confirmation? (1-yes/0-no)");
            conf = sc.nextInt();
            if (conf == 1) {
                System.out.println("Registration is completed \n");
                drive = 0;
            } else {
                System.out.println("Try again later");
                drive = 1;
            }
        }

    }
}