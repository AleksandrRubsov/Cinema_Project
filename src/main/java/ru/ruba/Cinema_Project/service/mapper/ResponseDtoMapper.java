package ru.ruba.Cinema_Project.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}