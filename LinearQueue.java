import java.util.Scanner;

public class LinearQueue {

    int[] queue;
    int front, rear, size;

    LinearQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Enqueue operation
    void enqueue(int customer) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow! Queue is full.");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear++;
        queue[rear] = customer;

        System.out.println("Customer " + customer + " added to the queue.");
    }

    // Dequeue operation
    void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow! Queue is empty.");
            return;
        }

        System.out.println("Customer " + queue[front] + " is served and removed.");

        front++;

        if (front > rear) {
            front = -1;
            rear = -1;
        }
    }

    // Peek operation
    void peek() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Customer at front: " + queue[front]);
    }

    // Display operation
    void display() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        LinearQueue q = new LinearQueue(size);

        int choice;

        do {
            System.out.println("\n----- Railway Ticket Reservation Queue -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter customer number: ");
                    int customer = sc.nextInt();
                    q.enqueue(customer);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}