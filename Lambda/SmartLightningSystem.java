package lambda;

import java.util.*;

public class SmartLightningSystem {
    // Functional interface for light behavior
    interface LightBehavior {
        void activate();
    }

    public static void main(String[] args) {
        // Define behaviors using lambdas
        LightBehavior motionTrigger = () -> System.out.println("Lights ON: Motion detected!");
        LightBehavior morningTrigger = () -> System.out.println("Lights ON: Gentle sunrise mode.");
        LightBehavior nightTrigger = () -> System.out.println("Lights ON: Dim night mode.");
        LightBehavior voiceTrigger = () -> System.out.println("Lights ON: Voice command received.");

        // Map triggers to behaviors
        Map<String, LightBehavior> triggers = new HashMap<>();
        triggers.put("motion", motionTrigger);
        triggers.put("morning", morningTrigger);
        triggers.put("night", nightTrigger);
        triggers.put("voice", voiceTrigger);

        // Simulate trigger activation
        List<String> simulatedTriggers = Arrays.asList("motion", "morning", "voice", "night");

        for (String trigger : simulatedTriggers) {
            System.out.print("Trigger: " + trigger + " → ");
            LightBehavior behavior = triggers.get(trigger);
            if (behavior != null) {
                behavior.activate();
            } else {
                System.out.println("No behavior defined.");
            }
        }
    }
}