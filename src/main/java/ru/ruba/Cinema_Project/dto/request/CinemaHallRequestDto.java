package ru.ruba.Cinema_Project.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class CinemaHallRequestDto {
    @Min(10)
    private int capacity;
    @Size(max = 200)
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public String getDescription() {
        return description;
    }
}