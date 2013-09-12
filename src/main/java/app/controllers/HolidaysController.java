package app.controllers;

import org.javalite.activeweb.AppController;

import app.models.Holiday;

public class HolidaysController extends AppController{

  public void index(){
    System.out.println(Holiday.getTableName());
    view("holidays", Holiday.findAll());
  }
}
