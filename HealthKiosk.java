import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
        System.out.println("Welcome to Health Kiosk");
        Scanner input = new Scanner(System.in);
        System.out.print(" Enter service code (P/L/T/C): ");
        char service_code = input.next().charAt(0);
        service_code = Character.toUpperCase(service_code);
        System.out.print(service_code);
        //using switch statement (case-insensitive)
        switch (service_code) {
            case 'P':
                System.out.println(" Go to: Pharmacy Desk");
                break;
            case 'L':
                System.out.println(" Go to: Lab Desk");
                break;
            case 'T':
                System.out.println(" Go to: Triage Desk");
                break;
            case 'C':
                System.out.println(" Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
        }

        //Task 2
        System.out.println(" Kindly choose a Health Metric: ");
        System.out.println(" 1. BMI: ");
        System.out.println("2. Dosage round-up: ");
        System.out.println("3. Simple trig helper: ");
        int user_choice = input.nextInt();

        //Using if else and two-way if else
        double metric = 0;

        if (user_choice == 1) {
            System.out.print(" Enter weight (kg):  ");
            double weight = input.nextDouble();
            System.out.print(" Enter height (m):  ");
            double height = input.nextDouble();

            double BMI = weight / Math.pow(height, 2);
            metric = Math.round(BMI * 10) / 10.0;
            System.out.println("BMI: " + BMI);

            if (BMI < 18.5) {
                System.out.println(" Underweight");
            } else if (BMI < 25) {
                System.out.println(" Normal");
            } else if (BMI < 30) {
                System.out.println(" Overweight");
            } else {
                System.out.println(" Obese");
            }
        }
        if (user_choice == 2) {
            System.out.println("Enter required dosage(mg):  ");
            double dosage = input.nextDouble();

            int tablets = (int) Math.ceil(dosage / 250.0);
             metric =  tablets;
            System.out.println("Tablets: " + tablets);
        }

        if (user_choice == 3) {
            System.out.println("Enter an angle in degrees:  ");
            double degrees = input.nextDouble();
            double radians = Math.toRadians(degrees);
            double cosine_value = Math.round(Math.sin(radians) * 1000) / 1000.0;
            double sine_value = Math.round(Math.cos(radians) * 1000) / 1000.0;
            metric =  Math.round(Math.sin(radians) * 100);

            System.out.println("Cosine value: " + cosine_value);
            System.out.println("Sine value: " + sine_value);
        }

        //Task 3
        System.out.println(" Student short ID generating.");
        char random_character = (char) ('A' + (int) (Math.random() * 26));
        // rnd for random
        int rnd1 = 3 + (int) (Math.random() * 7);
        int rnd2 = 3 + (int) (Math.random() * 7);
        int rnd3 = 3 + (int) (Math.random() * 7);
        int rnd4 = 3 + (int) (Math.random() * 7);

        //concatenating
        String studentID = random_character + "" + rnd1 + rnd2 + rnd3 + rnd4;
        System.out.println("Student ID: " + studentID);

        // Checking validation
        if (studentID.length() != 5) {
            System.out.println("Invalid length");
        } else if (!Character.isLetter(studentID.charAt(0))) {
            System.out.println("Invalid: first char must be a letter");
        } else if (!(Character.isDigit(studentID.charAt(1)) && Character.isDigit(studentID.charAt(2)) && Character.isDigit(studentID.charAt(3)) && Character.isDigit(studentID.charAt(4)))) {
            System.out.println("Invalid: last 4 must be digits");
        } else {
            System.out.println("ID OK");
        }




        //Task 4
        System.out.println("Enter your first name: ");
        String first_name = input.next();
        System.out.println("First name: "  + first_name );
        char base_code = Character.toUpperCase(first_name.charAt(0));
        System.out.println("Base code = " + base_code);
        char shifted_letter = (char)('A' + (base_code - 'A' + 2) % 26);
        System.out.println("Shifted letter of based code = " + shifted_letter);
        String last_twoNames = studentID.substring(studentID.length()-2);
        System.out.println("Last two characters for ID:  " + last_twoNames);
        int rounded_metric = (int) Math.round(metric);
        System.out.println("BMI: " + rounded_metric);
        String code_display = shifted_letter + last_twoNames + "-" + rounded_metric;
        System.out.println("Display code: " + code_display);

        //Task 5 - using a switch statement
        System.out.println("Service summary....");
        switch (service_code) {
            case 'P':
                System.out.println(" PHARMACY | ID =" + studentID + "| Code=" + code_display);
                break;
            case 'T':
                    System.out.println("Summary: TRIAGE | ID=" + studentID + " | BMI=" + metric +" | Code=" + code_display);
                    break;
            case 'L':
                    System.out.println("Summary: LAB | ID=" + studentID + " | Code=" + code_display);
            case 'C':
                System.out.println("Summary: COUNSELING | ID=" + studentID + " | Code=" + code_display);
                break;
            default:
                System.out.println("Invalid service summary");
        }









    }
    }
