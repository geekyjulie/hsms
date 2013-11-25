/* When we create a main class, it will first get all personal information. For example,
 * it asks id, name and department number
 * Then when the user selects a number of operation(i.e Employee class or Finance class)
 * it will initiate with all this information.
 * HSMS is a parent class to deal with personal information since the personal information is used universally through the program.
 */

import java.util.Scanner;

public class HSMS
{
    private int employee_ID;
    private String employee_name;
    private int dept_num; // department is indecated as an interger. For example, 1: HR, 2:Technical, 3: Coordinating/Event, 4:Finance, 5:Legal
    
    public HSMS(int emplID, String employeeName, int deptNum)
    {
        employee_ID = emplID;
        employee_name = employeeName;
        dept_num = deptNum;
    }
    
    //set - id, name and dept num -> modify the information
    public void reset(int emplID, String employeeName, int deptNum)
    {
        employee_ID = emplID;
        employee_name = employeeName;
        dept_num = deptNum;
    }
    
    public void setEmplId(int new_id)
    {
        employee_ID = new_id;
    }
    public void setEmplName(String new_name)
    {
        employee_name = new_name;
    }
    public void setDeptNum(int new_dept_num)
    {
        dept_num = new_dept_num;
    }
    
    //Get - id, name and department number
    
    public long getEmplID()
    {
        return employee_ID;
    }
    public String getEmplName()
    {
        return employee_name;
    }
    public int getDeptNum()
    {
        return dept_num;
    }
    
}