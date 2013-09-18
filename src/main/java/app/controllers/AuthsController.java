package app.controllers;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;

import app.models.*;

public class AuthsController extends AppController {

  public void index() {
  }

  @GET
  public void login() {
  }
  
  @POST
  public void authenticate(){
    logInfo("authenticate");
    User u = User.findById(1L);
    session(AppUser.SESSION_VAR, u);
    redirect(HolidaysController.class);
  }
}
