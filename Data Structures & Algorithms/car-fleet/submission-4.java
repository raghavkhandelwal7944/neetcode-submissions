

// ==========================================
// THE ENTRY POINT (What LeetCode calls)
// ==========================================
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // We do not do logic here. We instantiate a Facade to hide the extreme complexity of our system.
        EnterpriseFleetManagementSystemFacade facade = new EnterpriseFleetManagementSystemFacade();
        return facade.calculateOptimalFleetGroupings(target, position, speed);
    }
}

// ==========================================
// 1. CUSTOM EXCEPTIONS
// ==========================================
class EnterpriseFleetProcessingException extends RuntimeException {
    public EnterpriseFleetProcessingException(String message) {
        super("ENTERPRISE_ERROR_CODE_0x00F: " + message);
    }
}

// ==========================================
// 2. INTERFACES (Abstractions for everything)
// ==========================================
interface ITimeCalculationStrategy {
    double calculateTimeToTarget(int target, int position, int speed);
}

interface IFleetGroupingStrategy {
    int groupFleetsAndCount(List<ICarEntity> cars);
}

interface ICarEntity {
    int getPosition();
    int getSpeed();
    double getTimeToTarget();
}

// ==========================================
// 3. IMPLEMENTATIONS & DATA MODELS
// ==========================================
class DefaultTimeCalculationStrategy implements ITimeCalculationStrategy {
    @Override
    public double calculateTimeToTarget(int target, int position, int speed) {
        if (speed == 0) {
            throw new EnterpriseFleetProcessingException("Speed cannot be zero in an enterprise environment.");
        }
        return (double) (target - position) / speed;
    }
}

abstract class AbstractCarEntity implements ICarEntity {
    private final int position;
    private final int speed;
    private final double timeToTarget;

    protected AbstractCarEntity(int position, int speed, double timeToTarget) {
        this.position = position;
        this.speed = speed;
        this.timeToTarget = timeToTarget;
    }

    @Override public int getPosition() { return position; }
    @Override public int getSpeed() { return speed; }
    @Override public double getTimeToTarget() { return timeToTarget; }
}

class EnterpriseCarImpl extends AbstractCarEntity {
    public EnterpriseCarImpl(int position, int speed, double timeToTarget) {
        super(position, speed, timeToTarget);
    }
}

// ==========================================
// 4. THE BUILDER PATTERN
// ==========================================
class EnterpriseCarEntityBuilder {
    private int position;
    private int speed;
    private int target;
    private ITimeCalculationStrategy strategy;

    public EnterpriseCarEntityBuilder withPosition(int position) {
        this.position = position;
        return this;
    }

    public EnterpriseCarEntityBuilder withSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public EnterpriseCarEntityBuilder withTarget(int target) {
        this.target = target;
        return this;
    }

    public EnterpriseCarEntityBuilder withTimeCalculationStrategy(ITimeCalculationStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public ICarEntity build() {
        if (strategy == null) {
            // Fallback to default if no strategy is injected
            strategy = new DefaultTimeCalculationStrategy();
        }
        double time = strategy.calculateTimeToTarget(target, position, speed);
        return new EnterpriseCarImpl(position, speed, time);
    }
}

// ==========================================
// 5. THE CORE LOGIC (Strategy Pattern)
// ==========================================
class MonotonicStackFleetGroupingStrategyImpl implements IFleetGroupingStrategy {
    
    @Override
    public int groupFleetsAndCount(List<ICarEntity> cars) {
        // Sort descending by position using a highly verbose custom comparator class
        cars.sort(new CarPositionDescendingComparator());

        Stack<Double> fleetArrivalTimesStack = new Stack<>();

        // The actual 5 lines of logic hidden inside 150 lines of boilerplate
        for (ICarEntity car : cars) {
            double expectedArrivalTime = car.getTimeToTarget();
            if (fleetArrivalTimesStack.isEmpty() || expectedArrivalTime > fleetArrivalTimesStack.peek()) {
                fleetArrivalTimesStack.push(expectedArrivalTime);
            }
        }

        return fleetArrivalTimesStack.size();
    }

    // Nested private class just to handle sorting
    private static class CarPositionDescendingComparator implements Comparator<ICarEntity> {
        @Override
        public int compare(ICarEntity c1, ICarEntity c2) {
            return Integer.compare(c2.getPosition(), c1.getPosition());
        }
    }
}

// ==========================================
// 6. THE FACADE PATTERN (System Coordinator)
// ==========================================
class EnterpriseFleetManagementSystemFacade {
    private final ITimeCalculationStrategy timeCalculationStrategy;
    private final IFleetGroupingStrategy fleetGroupingStrategy;

    public EnterpriseFleetManagementSystemFacade() {
        // Simulated Dependency Injection
        this.timeCalculationStrategy = new DefaultTimeCalculationStrategy();
        this.fleetGroupingStrategy = new MonotonicStackFleetGroupingStrategyImpl();
    }

    public int calculateOptimalFleetGroupings(int target, int[] positions, int[] speeds) {
        if (positions == null || speeds == null || positions.length != speeds.length) {
            throw new EnterpriseFleetProcessingException("Data integrity violation: Array mismatch.");
        }

        List<ICarEntity> carRegistry = new ArrayList<>();

        // Building objects using our overly complex Builder
        for (int i = 0; i < positions.length; i++) {
            ICarEntity car = new EnterpriseCarEntityBuilder()
                    .withTarget(target)
                    .withPosition(positions[i])
                    .withSpeed(speeds[i])
                    .withTimeCalculationStrategy(timeCalculationStrategy)
                    .build();
            carRegistry.add(car);
        }

        // Passing the heavily processed objects to the Strategy engine
        return fleetGroupingStrategy.groupFleetsAndCount(carRegistry);
    }
}