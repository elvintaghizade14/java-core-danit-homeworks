package Step_Project_1.controller;

import Step_Project_1.io.Console;
import Step_Project_1.io.ConsoleMain;
import Step_Project_1.service.Service;

public class Controller {
  private final Service service;
  private final Console console;

  public Controller(ConsoleMain console, Service service) {
    this.service = service;
    this.console = console;
  }

}
