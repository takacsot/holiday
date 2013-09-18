package app.models;

import java.io.Serializable;

public interface AppUser extends Serializable{
  public final static String SESSION_VAR = "user";
  public boolean authorized();
}
