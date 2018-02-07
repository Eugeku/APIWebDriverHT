package com.epam.kuzora.hometask.core.runner.runner_core;

import com.epam.kuzora.hometask.core.constant.RunnerConstants;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
    private static final CommandParser instance = new CommandParser();

    private CommandParser() {
    }

    public ArrayList<String> parse(String request) {
        Pattern pattern = Pattern.compile(RunnerConstants.COMMAND_PARSER_REG_EXP);
        Matcher matcher = pattern.matcher(request);
        ArrayList<String> arrayList = new ArrayList<>();
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static CommandParser getInstance() {
        return instance;
    }
}
