package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;

import app.models.*;

public class HolidaysController extends AppController {

  public void index() {
    view("holidays", Holiday.findAllForUser(user()));
  }

  private User user() {
    return (User)session(AppUser.SESSION_VAR);
  }

  public void newForm() {
  }

  @POST
  public void create() {
    Holiday holiday = Holiday.draft(params1st());
    if (!holiday.save()) {
      flash("message", "Something went wrong, please  fill out all fields");
      flash("errors", holiday.errors());
      flash("params", params1st());
      redirect(HolidaysController.class, "new_form");
    } else {
      flash("message", "New holiday was added: ");
      redirect(HolidaysController.class);
    }
  }

  @DELETE
  public void delete() {
    Holiday b = Holiday.findById(getId());
    b.delete();
    flash("message", "Holiday: '' was deleted");
    redirect(HolidaysController.class);
  }

  public void show() {
    Holiday b = Holiday.findById(getId());
    if (b != null) {
      view("holiday", b);
    } else {
      view("message", "are you trying to hack the URL?");
      render("/system/404");
    }
  }
  
  @GET
  public void toRequested(){
    Holiday h = Holiday.findById(getId());
    h.toRequested();
    h.saveIt();
    flash("message","request is sent to supervisor");
    redirect(HolidaysController.class);
  }
  
  @GET
  public void allHolidays(){
    view("holidays", Holiday.findAll());
    render("index");
  }
}
