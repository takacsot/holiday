package app.config;

import org.javalite.activeweb.controller_filters.HttpSupportFilter;

import app.models.*;

public class CurrentUserFilter extends HttpSupportFilter {

  @Override
  public void before() {
    User u = (User)session(AppUser.SESSION_VAR);
    view("currentUsername", null == u?"NA": u.get("username"));
  }

}
