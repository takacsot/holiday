/*
Copyright 2009-2010 Igor Polevoy 

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License. 
*/
package app.config;

import java.sql.*;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;

/**
 * @author Igor Polevoy
 */
public class DbConfig extends AbstractDBConfig {
  String driver = "org.h2.Driver";
  String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
  String uname = "sa";
  String pwd = "";

  public void init(AppContext context) {
    createTable();

    environment("development").jdbc(driver, url, uname, pwd);

    environment("development").testing().jdbc("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/simple_test", "root", "p@ssw0rd");

    environment("production").jndi("jdbc/simple_production");
  }

  private void createTable() {
      try{
        String sql = "CREATE TABLE books ( "+
            "id  int(11) DEFAULT NULL auto_increment PRIMARY KEY, "+
            "author VARCHAR(128), "+
            "title VARCHAR(128), "+
            "isbn VARCHAR(128), "+
            "created_at DATETIME, "+
            "updated_at DATETIME "+
          ") ";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, uname, pwd);
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
      }catch(Exception e){
        e.printStackTrace(System.err);
      }
    }
}
