package com.erumf.ui;

import java.io.IOException;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.BorderLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class LanternaWindow {

    public static void startWindow() {
        try {
            Screen screen = new DefaultTerminalFactory().createScreen();
            screen.startScreen();

            final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
            final BasicWindow window = new BasicWindow("Lanterna Window");

            Panel mainPanel = new Panel(new BorderLayout());

            // Left panel (2/3 of the screen)
            Panel leftPanel = new Panel();
            leftPanel.setLayoutData(BorderLayout.Location.LEFT);
            leftPanel.setPreferredSize(new TerminalSize(screen.getTerminalSize().getColumns() * 2 / 3, screen.getTerminalSize().getRows()));
            leftPanel.addComponent(new Label("Left Panel").addStyle(SGR.BOLD).setForegroundColor(TextColor.ANSI.BLUE));

            // Right panel (console)
            Panel rightPanel = new Panel();
            rightPanel.setLayoutData(BorderLayout.Location.RIGHT);
            rightPanel.setPreferredSize(new TerminalSize(screen.getTerminalSize().getColumns() / 3, screen.getTerminalSize().getRows()));
            TextBox console = new TextBox(new TerminalSize(screen.getTerminalSize().getColumns() / 3, screen.getTerminalSize().getRows()), TextBox.Style.MULTI_LINE);
            rightPanel.addComponent(console);

            mainPanel.addComponent(leftPanel);
            mainPanel.addComponent(rightPanel);

            window.setComponent(mainPanel);

            textGUI.addWindowAndWait(window);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
