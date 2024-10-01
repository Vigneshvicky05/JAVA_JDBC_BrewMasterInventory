package cof;

public class user {
      private String username;
      private String password;
public user() {
}
public user(String username, String password) {
this.username = username;
this.password = password;
}
public String getName() {
return username;
}
public void setName(String username) {
this.username = username;
}
public String getPass() {
return password;
}
public void setPass(String password) {
this.password = password;
}
}

