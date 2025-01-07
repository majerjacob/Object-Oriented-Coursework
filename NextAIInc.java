class NextAIInc {
    // Method to calculate and print total weekly pay

    public void calculatePay(double basePay, int hoursWorked) {
        // Check if base pay is below UGX 30,000
        if (basePay < 30000) {
            System.out.println("Error: Base pay must not fall below UGX 30,000. Payment not calculated.");
            return;
        }

        // Check if hours worked exceed 72
        if (hoursWorked > 72) {
            System.out.println("Error: Contractors are not allowed to work more than 72 hours per week. Payment not calculated.");
            return;
        }

        // Calculate total pay
        double totalPay;
        if (hoursWorked <= 48) {
            totalPay = basePay * hoursWorked;
        } else {
            int overtimeHours = hoursWorked - 48;
            totalPay = (basePay * 48) + (overtimeHours * basePay * 2); // Overtime paid at double the base pay
        }
        System.out.printf("Total weekly pay: UGX %.2f%n", totalPay);
    }


    // Main method to test the program
    public static void main(String[] args) {
        NextAIInc contractor = new NextAIInc();


        // Test Case A
        System.out.println("Contractor A:");
        contractor.calculatePay(30000, 51);

        // Test Case B
        System.out.println("\nContractor B:");
        contractor.calculatePay(20000, 40);


        // Test Case C
        System.out.println("\nContractor C:");
        contractor.calculatePay(35000, 96);
    }
}
