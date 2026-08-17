package avaj;

import java.util.List;

public record Scenario(int simulationCount, List<Flyable> aircrafts) {
};
// the keyword record generate the constructor and the accessors of aircrafts
// and simulationCount
