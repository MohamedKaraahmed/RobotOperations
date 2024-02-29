package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    /**
     * An algorithm that converts a number of days into an action plan.
     *
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     * algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     * number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     * days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        int collectedStonesCount = 0;
        int availableRobotsCount = 1;
        List<RobotAction> robotActions = new ArrayList<>();
        for (int currentDay = 1; currentDay <= days - 1; currentDay++) {
            robotActions.add(RobotAction.CLONE);
            availableRobotsCount *= 2;
        }
        robotActions.add(RobotAction.DIG);
        collectedStonesCount += availableRobotsCount;

        return new RobotPlan(days, collectedStonesCount, robotActions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     *
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     * provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     * {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     * {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */
    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        int daysCount = 0;
        List<RobotAction> robotActions = new ArrayList<>();
        int availableRobots = 1;
        while (availableRobots < numberOfStones) {
            robotActions.add(RobotAction.CLONE);
            availableRobots *= 2;
            daysCount++;
        }
        robotActions.add(RobotAction.DIG);
        daysCount++;

        return new RobotPlan(daysCount, numberOfStones, robotActions);
    }

}
