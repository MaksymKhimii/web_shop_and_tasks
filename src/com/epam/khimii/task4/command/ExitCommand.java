package com.epam.khimii.task4.command;

import com.epam.khimii.task4.Command;
import com.epam.khimii.task4.controller.OnlineStore;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        OnlineStore.finish = true;
    }
}