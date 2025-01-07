// Base class for TriathlonResults
class TriathlonResults {
    private final String name;
    private final int id;
    private final int swimmingTime;
    private final int cyclingTime;
    private final int runningTime;

    public TriathlonResults(String name, int id, int swimmingTime, int cyclingTime, int runningTime) {
        this.name = name;
        this.id = id;
        this.swimmingTime = validateTime(swimmingTime);
        this.cyclingTime = validateTime(cyclingTime);
        this.runningTime = validateTime(runningTime);
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSwimmingTime() {
        return swimmingTime;
    }

    public int getCyclingTime() {
        return cyclingTime;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public int getTotalTime() {
        return swimmingTime + cyclingTime + runningTime;
    }

    public static int validateTime(int time) {
        if (time < 0) {
            throw new IllegalArgumentException("Time cannot be negative.");
        }
        return time;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Total Time: " + getTotalTime() + " minutes");
    }
}

// Derived class for EliteParticipant
class EliteParticipant extends TriathlonResults {
    private final String sponsorName;

    public EliteParticipant(String name, int id, int swimmingTime, int cyclingTime, int runningTime, String sponsorName) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
        this.sponsorName = sponsorName;
    }

    @Override
    public void displayDetails() {
        System.out.println("Name: " + getName() + ", ID: " + getId() + ", Total Time: " + getTotalTime() +
                " minutes, Sponsor: " + sponsorName);
    }
}

// Derived class for BeginnerParticipant
class BeginnerParticipant extends TriathlonResults {
    public BeginnerParticipant(String name, int id, int swimmingTime, int cyclingTime, int runningTime) {
        super(name, id, swimmingTime, cyclingTime, runningTime);
    }
}

// Main class for managing and displaying triathlon results
public class TriathlonApp {
    public static void main(String[] args) {
        // Create participants
        TriathlonResults[] participants = {
                new EliteParticipant("Alice", 1, 25, 40, 20, "Fitness Inc."),
                new BeginnerParticipant("Bob", 2, 20, 35, 25),
                new BeginnerParticipant("Charlie", 3, 30, 50, 30),
                new EliteParticipant("Diana", 4, 28, 42, 18, "Health Pro.")
        };

        // Display all participant details
        for (TriathlonResults participant : participants) {
            participant.displayDetails();
        }

        // Calculate rankings
        calculateRankings(participants);
    }

    public static void calculateRankings(TriathlonResults[] participants) {
        // Sort participants by total time
        java.util.Arrays.sort(participants, java.util.Comparator.comparingInt(TriathlonResults::getTotalTime));

        System.out.println("\nRankings:");
        System.out.println("1st: " + participants[0].getName() + " with " + participants[0].getTotalTime() + " minutes");
        System.out.println("2nd: " + participants[1].getName() + " with " + participants[1].getTotalTime() + " minutes");

        System.out.println("\nSorted by Total Time:");
        for (TriathlonResults participant : participants) {
            participant.displayDetails();
        }
    }
}

