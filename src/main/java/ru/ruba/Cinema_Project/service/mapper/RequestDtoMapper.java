package ru.ruba.Cinema_Project.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
