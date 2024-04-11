package com.solidstone.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class CalculatorCommand {
	
	@ShellMethod("Add two numbers")
    public int add(int a, int b) {
        return a + b;
    }

}
