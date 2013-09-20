package app.config;

import org.javalite.activeweb.controller_filters.*;

import app.controllers.AuthsController;
import app.models.*;

public class AuthFilter extends HttpSupportFilter {
  private boolean DISABLED= true; 
  @Override
  public void before() {
    if(DISABLED){
      User u = User.findById(1L);
      session(AppUser.SESSION_VAR, u);
      return;
    }
    AppUser loggedIn = (AppUser) session(AppUser.SESSION_VAR);
    if (null == loggedIn || !loggedIn.authorized()) {
      redirect(AuthsController.class, "login");
    }

  }

  @Override
  public void after() {
    // TODO Auto-generated method stub

  }

  @Override
  public void onException(Exception e) {
    // TODO Auto-generated method stub

  }

}
