//Manager class
public class Manager{
  private String managerID;
  private String managerName;
  private String managerPassword;
  private String managerTeam;
  
  public Manager(){
  }
  
  //Manager member variables
  public Manager(String managerID, String managerName, String managerPassword, String managerTeam){
    this.managerID = managerID;
    this.managerName = managerName;
    this.managerPassword = managerPassword;
    this.managerTeam = managerTeam;
  }
  
  //Manager getters
  public String getManagerID(){
    return this.managerID;
  }
  public String getManagerName(){
    return this.managerName;
  }
  public String getManagerPassword(){
    return this.managerPassword;
  }
  public String getManagerTeam(){
    return this.managerTeam;
  }
  
  //For manager login validation
  public static boolean login(String id, String pw){
    for (Manager m: ReadData.managerArrayList){
      if (m.managerID.equals(id) && m.managerPassword.equals(pw)){
        ReadData.userid = id;
        return true;
      }
    }
    return false;
  }
  
}