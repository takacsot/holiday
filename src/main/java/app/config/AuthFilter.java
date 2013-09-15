package app.config;

import org.javalite.activeweb.controller_filters.*;

import app.controllers.AuthsController;
import app.models.*;

public class AuthFilter extends  HttpSupportFilter{

  @Override
  public void before() {
    AppUser loggedIn = (AppUser)session("user");
    if(null == loggedIn || !loggedIn.authorized()){
      redirect(AuthsController.class);
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
