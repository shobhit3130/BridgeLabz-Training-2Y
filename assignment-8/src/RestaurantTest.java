// Superclass: RestaurantPerson
class RestaurantPerson {
    String name;
    int id;

    RestaurantPerson(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void showIdentity() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Interface: Worker
interface Worker {
    void performDuties();
}

// Subclass: Chef
class Chef extends RestaurantPerson implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes.");
    }
}

// Subclass: Waiter
class Waiter extends RestaurantPerson implements Worker {
    int tableCount;

    Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tableCount + " tables.");
    }
}

// Main class to test hybrid inheritance
public class RestaurantTest {
    public static void main(String[] args) {
        Chef chef = new Chef("Raj", 101, "Italian");
        Waiter waiter = new Waiter("Amit", 202, 5);

        System.out.println("Chef Details:");
        chef.showIdentity();
        chef.performDuties();

        System.out.println("\nWaiter Details:");
        waiter.showIdentity();
        waiter.performDuties();
    }
}