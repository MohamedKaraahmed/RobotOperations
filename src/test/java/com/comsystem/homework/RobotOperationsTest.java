package com.comsystem.homework;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class RobotOperationsTest {
    private static RobotOperations robotOperations;

    @BeforeEach
    public void setUp() {
        robotOperations = new RobotOperations();
    }

    @Test
    public void testExcavateStonesForDays() {
        int randomGivenDaysCount = new Random().nextInt(100);
        RobotPlan robotPlan = robotOperations.excavateStonesForDays(randomGivenDaysCount);
        List<RobotAction> cloneOperations = robotPlan.robotActions()
                .stream()
                .filter(e -> e.equals(RobotAction.CLONE))
                .toList();
        int performedActionsCount = robotPlan.robotActions().size();
        int neededDaysToCompleteThePlan = robotPlan.numberOfDays();

        Assertions.assertEquals(performedActionsCount, neededDaysToCompleteThePlan);
        Assertions.assertEquals(cloneOperations.size(), randomGivenDaysCount <= 0 ? 0 : randomGivenDaysCount - 1);
    }

    @Test
    public void testDaysRequiredToCollectStones() {
        int randomGivenStonesCount = new Random().nextInt(100);
        RobotPlan robotPlan = robotOperations.daysRequiredToCollectStones(randomGivenStonesCount);
        int collectedStones = robotPlan.numberOfStones();

        Assertions.assertEquals(collectedStones, randomGivenStonesCount);
    }
}
