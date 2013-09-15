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

import java.io.*;
import java.sql.*;
import java.util.*;

import org.javalite.activeweb.*;

import com.google.common.base.Splitter;

/**
 * @author Igor Polevoy
 */
public class DbConfig extends AbstractDBConfig {
  String driver = "org.h2.Driver";
  String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
  String uname = "sa";
  String pwd = "";

  public void init(AppContext context) {
    init_database(getStatements(";", "create_database.sql", "sample_data.sql"));

    environment("development").jdbc(driver, url, uname, pwd);
    environment("development").testing().jdbc(driver, url, uname, pwd);

//    environment("development").testing().jdbc("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/simple_test", "root", "p@ssw0rd");

    environment("production").jndi("jdbc/simple_production");
  }

  private void init_database(List<String> sqls) {
    try {
      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, uname, pwd);
      Statement st = con.createStatement();
      for (String sql : sqls) {
        //System.out.println(sql);
        st.execute(sql);
      }
      st.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

  public List<String> getStatements(String delimiter, String... files) {
    List<String> sqls = new ArrayList<String>();
    for (String file : files) {
      try {
        //System.out.println("Getting statements from file: " + file);
        InputStreamReader isr = new InputStreamReader(DbConfig.class.getClassLoader().getResourceAsStream(file));
        BufferedReader reader = new BufferedReader(isr);
        StringBuffer text = new StringBuffer();
        String t;
        while ((t = reader.readLine()) != null) {
          text.append(t + '\n');
        }
        sqls.addAll(Splitter.on(delimiter).omitEmptyStrings().splitToList(text));
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
    //System.out.println("Nr of statements: "+sqls.size());
    return sqls;
  }
}
