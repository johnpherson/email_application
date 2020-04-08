package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;

    // Constructer to recieve firstname and lastname
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: "+ this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is : "+this.password);

        // Combine elements to make email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department.toLowerCase()+".com";
        System.out.println("Your email is : "+email);

    }
        // Ask for the department
    private String setDepartment() {
        System.out.print("Enter the department\n1 for Sales\n2 for Accounting\n3 for Development\n0 for none ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        }
        else if (depChoice == 2){
            return "Accounting";
        }
        else if (depChoice == 3){
            return "dev";
        }
        else {
            return "";
        }
        //return null;
    }



        //generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789%$^#%@";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

        //set mailbox capacity
    public void setmailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;

    }

        //set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

        //change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() {return alternateEmail;}
    public String getPassword() { return password;}
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }


}
