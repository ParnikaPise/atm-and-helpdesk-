import java.util.Scanner;

public class HelpDeskManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HelpDeskSystem helpDesk = new HelpDeskSystem();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nHelp Desk Management System");
            System.out.println("1. Create Ticket");
            System.out.println("2. View All Tickets");
            System.out.println("3. Update Ticket Status");
            System.out.println("4. View Ticket by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter issue description: ");
                    String issue = scanner.nextLine();
                    helpDesk.createTicket(customerName, issue);
                    break;

                case 2:
                    helpDesk.viewAllTickets();
                    break;

                case 3:
                    System.out.print("Enter ticket ID to update: ");
                    int ticketId = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character
                    System.out.print("Enter new status (Open/In Progress/Resolved): ");
                    String status = scanner.nextLine();
                    helpDesk.updateTicketStatus(ticketId, status);
                    break;

                case 4:
                    System.out.print("Enter ticket ID: ");
                    int id = scanner.nextInt();
                    helpDesk.viewTicketById(id);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
