package com.atahanyengin.animalhospital.data.entity.orm.view;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public interface IAnimalWithoutOwner {
    int getId();
    String getName();
    String getType();

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    LocalDate getBirthDate();
    boolean getSterile();
}
