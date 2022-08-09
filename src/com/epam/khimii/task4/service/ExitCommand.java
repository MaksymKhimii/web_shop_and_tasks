package com.epam.khimii.task4.service;

import com.epam.khimii.task4.command.Command;
import com.epam.khimii.task4.controller.OnlineStore;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        OnlineStore.finish = true;
    }
}