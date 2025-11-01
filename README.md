# 🛑 Autonomous Braking System Simulation in Java

This Java program simulates a simplified **Autonomous Emergency Braking (AEB)** system for a self-driving vehicle. It demonstrates how a car uses sensor data (simulated distance to an obstacle) to decide whether to apply the brakes or safely accelerate, while also implementing a basic **adaptive learning** mechanism.

---

## ✨ Features

* **Obstacle Detection Simulation:** Uses a random number generator to simulate the distance of an obstacle ahead of the vehicle.
* **Automatic Braking Logic:** If the detected obstacle distance is less than the current **Safe Following Distance**, the system triggers a brake command.
* **Safe Acceleration:** When the path is clear, the system gradually increases speed, capped at $\mathbf{100 \text{ km/h}}$.
* **Adaptive Learning:** Implements a simple AI-like feature where the `safeDistance` threshold is adjusted based on recent braking events, simulating system refinement over time.

---

## 🧠 How It Works (The Core Logic)

The simulation runs for $\mathbf{10 \text{ cycles}}$. In each cycle, the system takes the following steps:

1.  **Detects Obstacle:** A random distance (between $\mathbf{0 \text{ and } 29 \text{ meters}}$) is generated to represent the obstacle.
2.  **Compares Distance:** The obstacle distance is compared against the current $\mathbf{safeDistance}$ threshold (initially set to $\mathbf{10 \text{ meters}}$).

| Condition | Action | Speed Adjustment | Adaptive Learning |
| :--- | :--- | :--- | :--- |
| **Obstacle Distance $\mathbf{< safeDistance}$** | **⚠️ Apply Brakes** | Speed $\mathbf{-30 \text{ km/h}}$ (Min speed is 0) | $\mathbf{safeDistance}$ reduced by $\mathbf{2 \text{ m}}$ (Min distance is 5 m) |
| **Obstacle Distance $\mathbf{\ge safeDistance}$** | **✅ Accelerate/Maintain** | Speed $\mathbf{+10 \text{ km/h}}$ (Max speed is 100) | No change to $\mathbf{safeDistance}$ |

3.  **Outputs Status:** The system prints the current speed and the adjusted safe distance (if applicable) before pausing for $\mathbf{0.7 \text{ seconds}}$ to simulate a time delay.

> **Note on Adaptive Logic:** The simulation's adaptive logic currently *reduces* the safe distance after a braking event. In a real-world, complex AI system, this adjustment would be more sophisticated (e.g., increasing the distance after a near-miss or adjusting based on road friction), but here it demonstrates the concept of the system **learning** and **fine-tuning** its parameters.

---

## ▶️ Getting Started

### Prerequisites

* **Java Development Kit (JDK)** installed on your system.

### Running the Simulation

1.  **Save the Code:** Save the provided code into a file named `AutonomousBrakingSystem.java`.
2.  **Compile:** Open a terminal or command prompt, navigate to the directory where you saved the file, and compile the code:
    ```bash
    javac AutonomousBrakingSystem.java
    ```
3.  **Run:** Execute the compiled class file:
    ```bash
    java AutonomousBrakingSystem
    ```

The output will show the step-by-step decision process of the autonomous system for each of the $\mathbf{10 \text{ cycles}}$.

---

Would you like to see an example of how the adaptive logic could be changed to adjust the safe distance based on the **current vehicle speed**?
