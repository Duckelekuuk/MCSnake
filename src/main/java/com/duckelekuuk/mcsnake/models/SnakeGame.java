package com.duckelekuuk.mcsnake.models;

import com.duckelekuuk.mcsnake.utils.InventoryUtils;
import com.duckelekuuk.mcsnake.utils.Properties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class SnakeGame {

    private final Console console;
    private final List<Integer> parts = new ArrayList<>();

    @Setter
    private Direction currentDirection;
    private int size = 1;
    private int foodAmount = 0;

    public SnakeGame(Console console) {
        this.console = console;
    }

    public void eatFood() {
        // Increase size
        foodAmount--;
        size++;
    }

    public void spawnFood() {
        // Place new food block
        List<Integer> spots = IntStream.range(0, (Properties.WIDTH * Properties.HEIGHT) - 1).boxed().collect(Collectors.toList());
        // Remove snake parts
        spots.removeAll(parts);

        // Shuffle options
        Collections.shuffle(spots);

        // Pick random spot
        console.getScreen().setItem(spots.get(0), Properties.FOOD);
        foodAmount++;
    }

    public boolean canGo(Direction direction) {
        // Check if movement cancels out
        return !(direction.getOffsetX() + currentDirection.getOffsetX() == 0 && direction.getOffsetY() + currentDirection.getOffsetY() == 0);
    }

    public void spawnSnake() {
        console.getScreen().setItem(Properties.START_POSITION, Properties.SNAKE);
        parts.add(Properties.START_POSITION);
    }

    /**
     * Update the snake's position
     * Check for collision
     * @return boolean if the snake should be dead
     */
    public boolean update() {
        int head = parts.get(parts.size() - 1);
        int nextX = InventoryUtils.getCoordinates(head)[0] + currentDirection.getOffsetX();
        int nextY = InventoryUtils.getCoordinates(head)[1] + currentDirection.getOffsetY();

        // Checking for collision with wall
        if (nextX < 0 || nextX > (Properties.WIDTH - 1)) return false;
        if (nextY < 0 || nextY > (Properties.HEIGHT - 1)) return false;

        // Check if next block is food
        if (console.getScreen().getItem(InventoryUtils.getLocation(nextX, nextY)).isSimilar(Properties.FOOD)) eatFood();

        // Let the last item stay to increase size
        if (parts.size() + 1 > size) {
            int tail = parts.remove(0);
            console.getScreen().setItem(tail, Properties.SCREEN_BACKGROUND);
        }

        // Checking for collision with itself
        if (parts.contains(InventoryUtils.getLocation(nextX, nextY))) return false;

        // Move snake in direction
        parts.add(InventoryUtils.getLocation(nextX, nextY));

        //spawn new blocks
        if (foodAmount < Properties.FOOD_AMOUNT) spawnFood();
        console.getScreen().setItem(InventoryUtils.getLocation(nextX, nextY), Properties.SNAKE);

        return true;
    }
}
