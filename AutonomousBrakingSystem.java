import java.util.Scanner;
import java.util.Random;

/**
 * AutonomousBrakingSystem
 * ------------------------
 * A Java simulation that demonstrates how an autonomous vehicle’s
 * braking system reacts to detected obstacles. The system monitors
 * distances and automatically decides when to apply brakes or
 * accelerate safely.
 *
 * It also includes simple AI-like adaptive logic that fine-tunes
 * the safe following distance over time based on recent encounters.
 */

public class AutonomousBrakingSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // --- Initial setup ---
        int speed = 60;            // starting speed (km/h)
        int safeDistance = 10;     // initial safe distance (meters)
        int cycles = 10;           // number of simulation cycles

        System.out.println("🚗 AUTONOMOUS VEHICLE BRAKING SIMULATION 🚗");
        System.out.println("This program simulates how a self-driving car detects obstacles "
                         + "and adjusts speed automatically.");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Initial Speed      : " + speed + " km/h");
        System.out.println("Initial Safe Range : " + safeDistance + " meters\n");

        // --- Begin simulation loop ---
        for (int i = 1; i <= cycles; i++) {

            // Randomly simulate obstacle distance (0–29 meters)
            int obstacleDistance = rand.nextInt(30);
            System.out.println("Cycle " + i + " → Obstacle detected at " + obstacleDistance + " meters");

            // --- Decision-making logic ---
            if (obstacleDistance < safeDistance) {
                System.out.println("⚠️  WARNING: Obstacle too close! Applying brakes...");
                speed = Math.max(0, speed - 30);   // Decrease speed safely (not below 0)

                // --- AI adaptive adjustment ---
                safeDistance = Math.max(5, safeDistance - 2);   // Reduce threshold slightly
                System.out.println("🤖 AI adjusted safe distance to " + safeDistance
                                   + " meters (adaptive tuning).");
            } else {
                System.out.println("✅ Path is clear. Maintaining or increasing speed...");
                speed = Math.min(100, speed + 10);  // Gradually increase but cap at 100
            }

            // --- Display current vehicle status ---
            System.out.println("Current Speed : " + speed + " km/h");
            System.out.println("-------------------------------------------------------------\n");

            // Small delay for visualization
            try {
                Thread.sleep(700); // pause for 0.7 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // --- End of simulation summary ---
        System.out.println("✅ SIMULATION COMPLETE ✅");
        System.out.println("Final Speed            : " + speed + " km/h");
        System.out.println("Final Learned Distance  : " + safeDistance + " meters");
        System.out.println("-------------------------------------------------------------");
        System.out.println("System executed successfully. Safe driving achieved!");
        
        sc.close();
    }
}
