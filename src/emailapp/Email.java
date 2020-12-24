package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String companyName = "abcompany.com";
    private int emailBoxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;

    // Constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Ask for department
        this.department = setDepartment();

        //Call method to make random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password: " + this.password);

        //Generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department  + "." + companyName;
    }

    //Set
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        switch (depChoice) {
            case 1: return "sales";
            case 2: return "dev";
            case 3: return "acc";
            default: return "";
        }
    }

    //Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set email box capacity
    public void setEmailBoxCapacity(int capacity) {
        this.emailBoxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getEmailBoxCapacity() {
        return emailBoxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + emailBoxCapacity + "mb";
    }
}
