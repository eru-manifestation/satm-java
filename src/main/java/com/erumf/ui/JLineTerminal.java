package com.erumf.ui;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.Display;
import org.jline.utils.InfoCmp;
import org.jline.utils.Log;

public class JLineTerminal {

    public static void createTerminal() {
        try {
            Terminal terminal;
            try {
                terminal = TerminalBuilder.builder()
                        .system(true)
                        .build();
            } catch (IOException e) {
                Log.debug("Unable to create a system terminal", e);
                terminal = TerminalBuilder.builder()
                        .dumb(true)
                        .build();
            }

            LineReader reader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();

            Display display = new Display(terminal, true);
            terminal.puts(InfoCmp.Capability.clear_screen);

            while (true) {
                display.resize(terminal.getSize().getRows(), terminal.getSize().getColumns());
                // display.update(null, 0);

                int width = terminal.getSize().getColumns();
                int height = terminal.getSize().getRows();

                // Left panel (2/3 of the screen)
                int leftPanelWidth = width * 2 / 3;
                for (int i = 0; i < height; i++) {
                    terminal.writer().print("\033[" + (i + 1) + ";1H");
                    terminal.puts(InfoCmp.Capability.clr_eol);
                    terminal.writer().append("Left Panel").flush();
                }

                // Right panel (console)
                int rightPanelWidth = width / 3;
                for (int i = 0; i < height; i++) {
                    terminal.writer().print("\033[" + (i + 1) + ";" + (leftPanelWidth + 1) + "H");
                    terminal.puts(InfoCmp.Capability.clr_eol);
                    terminal.writer().append("Right Panel").flush();
                }

                String line = reader.readLine("> ");
                terminal.writer().println("You entered: " + line);
                terminal.writer().flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
