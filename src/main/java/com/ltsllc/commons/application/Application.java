package com.ltsllc.commons.application;

import com.ltsllc.commons.commadline.CommandLine;

/**
 * A command line application.
 */
abstract public class Application {
    abstract public CommandLine createCommandLine (String[] argv);
    abstract public String getName ();
    abstract public String getUsageString ();

    private CommandLine commandLine;

    public void execute (String[] argv) {
        CommandLine commandLine = createCommandLine(argv);

    }

    public void usage() {
        System.err.println (getName() + ": " + getUsageString());
        System.exit(1);
    }


    public CommandLine getCommandLine() {
        return commandLine;
    }

    public void setCommandLine(CommandLine commandLine) {
        this.commandLine = commandLine;
    }


}
