package com.epam.khimii.task4.service;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.repository.BufferRepository;

public class ShowBufferCommand implements Command {
    @Override
    public void execute() {
        BufferRepository.printBuffer();
    }
}