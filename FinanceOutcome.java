import java.util.Scanner;
import java.util.ArrayList;

public class FinanceOutcome extends HSMS
{
    private double salary;
    private double bonus;
    private int category;
    private String title;
    private double amountSpent;
    private String location;
    private String date;
    private int emplIDcharge;
    private String description;
    
    Scanner scan = new Scanner(System.in);
    
    ArrayList<Integer> Category;
    ArrayList Title;
    ArrayList AmountSpent;
    ArrayList Location;
    ArrayList Date;
    ArrayList EmplIDCharge;
    ArrayList Description;
    
    public FinanceOutcome(int emplID, String emplName, int deptNum)
    {
        
        super (emplID, emplName, deptNum);
        
        Category = new ArrayList<Integer>();
        Title = new ArrayList();
        Date = new ArrayList();
        AmountSpent = new ArrayList();
        Location = new ArrayList();
        EmplIDCharge = new ArrayList();
        Description = new ArrayList();
    }
    public void outcomeMenu()
    {
        int user_option;
        boolean flag = true;
        
        System.out.println("Enter 0 to exit");
        while (flag)
        {
            System.out.println("Homless Shelter Management System - Outcome Information");
            System.out.println("1. Expenditure record");
            System.out.println("0. Exit");
    
            System.out.print("Please choose a number >>>  ");
            user_option = scan.nextInt();
        
            switch(user_option)
            { 
                case(1):
                    expenditureRecord();
                    break;
                case(0):
                    System.out.println("Bye!");
                    flag = false;
                    break;
            }
        }
        
    }
    
    private void expenditureRecord()
    {
        int user_option;
        String search_title;
        
        System.out.println("---------------Expenditure record DB--------------");
        System.out.println("1. Display a record");
        System.out.println("2. Create a record");
        System.out.println("3. Modify a record");
        System.out.println("4. Delete a record");
        System.out.println("0. Exit");
        System.out.print("Please choose an option >>>   ");
        user_option = scan.nextInt();
            
        while (user_option != 0)
        {
            System.out.println("---------------Expenditure record DB--------------");
            System.out.println("1. Display a record");
            System.out.println("2. Create a record");
            System.out.println("3. Modify a record");
            System.out.println("4. Delete a record");
            System.out.println("0. Exit");
            System.out.print("Please choose an option >>>   ");
            user_option = scan.nextInt();
        
        
            switch(user_option)
            {
                case (1):
                    exDisplayRecord();
                    break;
                case (2):
                    exCreateRecord();
                    break;
                case(3):
                    System.out.println("Type the title to search: ");
                    search_title = scan.next();
                    exModifyRecord(getIndexNum(search_title));
                    break;
                case(4):
                    System.out.println("Type the title to search: ");
                    search_title = scan.next();
                    exDeleteRecord(getIndexNum(search_title));
                    break;
            }
        }
        System.out.println("Good bye!");
        System.exit(0);
    }
    
    private void exDisplayRecord()
    {
        int c;
        String category_str;
        
        System.out.println("-------------Expenditure record display---------------");
        
        if (Category.size() == 0)
        {
            System.out.println("The information is empty. Pleae check again.");
        }
        else
        {
            for (int i=0; i < Category.size(); i++)
            {
                c = Category.get(i);
                category_str = getCategoryName(c);
                System.out.println("Category: " + category_str);
                System.out.println("Title: " + Title.get(i));
                System.out.println("Date: " + Date.get(i));
                System.out.println("Amount of money spent: " + AmountSpent.get(i));
                System.out.println("Location: " + Location.get(i));
                System.out.println("Employee ID in charge: " + EmplIDCharge.get(i));
                System.out.println("Description/note: " + Description.get(i));
            }
        }
    }
    
    private String getCategoryName(int num)
    {
        String c = "";
     
        if (num == 1)
        {
            c = "Clothing";
        }
        else if (num == 2)
        {
            c = "Event";
        }
        else if (num == 3)
        {
            c = "Food";
        }
        else if (num == 4)
        {
            c = "Supplies";
        }
        
        return c;
        
    }
    private void exCreateRecord()
    {
        int user_category;
        String input_title;
        String input_date; 
        double input_amountspent;
        String input_location;
        int input_emplIDcharge;
        String input_description;
        
        System.out.println("Expenditure record DB - Create a new record");
        
        user_category = displayCategory();
        
        System.out.print("Title >>>   ");
        input_title = scan.next() + scan.nextLine();
        System.out.println();
        System.out.print("Date >>>   ");
        input_date = scan.next() + scan.nextLine();
        System.out.println();
        System.out.print("Amount of spent >>>   ");
        input_amountspent = scan.nextDouble();
        System.out.println();
        System.out.print("Location >>>   ");
        input_location = scan.next() + scan.nextLine();
        System.out.println();
        System.out.print("Employee ID in charge >>>   ");
        input_emplIDcharge = scan.nextInt();
        System.out.println();
        System.out.print("Description >>>   ");
        input_description = scan.next() + scan.nextLine();
        System.out.println();
        
        //add all input information to arraylist
        Category.add(user_category);
        Title.add(input_title);
        Date.add(input_date);
        AmountSpent.add(input_amountspent);
        Location.add(input_location);
        EmplIDCharge.add(input_emplIDcharge);
        Description.add(input_description);
        
        
    }
    private int displayCategory()
    {
        int category;
        
        System.out.println("Expenditure category");
        System.out.println("1. Clothing");
        System.out.println("2. Event");
        System.out.println("3. Food");
        System.out.println("4. Supplies");
        category = scan.nextInt();
        
        return category;
        
    }
    
    private int getIndexNum(String title)
    {
        int index_num;
        index_num = Category.indexOf(title);
        return index_num;
    }
    
    private void exModifyRecord(int indexNum)
    {
        int input_option;
        int index = indexNum;
        int new_category;
        String new_title;
        String new_date;
        double new_amount;
        String new_location;
        int new_id;
        String new_description;
        
        System.out.println("----------------Expenditure record DB Modify------------------");
        System.out.println("Enter a number to modify");
        System.out.println("1. Category");
        System.out.println("2. Title");
        System.out.println("3. Date");
        System.out.println("4. Amount of money spent");
        System.out.println("5. Location");
        System.out.println("6. Employee ID in charge");
        System.out.println("7. Description");
        System.out.print(">>>   ");
        input_option = scan.nextInt();
        
        switch (input_option)
        {
            case (1):
                System.out.println("Enter a new category: ");
                new_category = displayCategory();
                modifyCategory(index, new_category);
                break;
            case (2):
                System.out.println("Enter a new title: ");
                new_title = scan.next() + scan.nextLine();                   
                modifyTitle(index, new_title);
                break;
            case (3):
                System.out.println("Enter a new date: ");
                new_date = scan.next() +scan.nextLine();
                modifyDate(index, new_date);
            case (4):
                System.out.println("Enter a new amount: ");
                new_amount = scan.nextDouble();
                modifyAmount(index, new_amount);
                break;
            case (5):
                System.out.println("Enter a new location: ");
                new_location = scan.next() + scan.nextLine();
                modifyLocation(index, new_location);
                break;
            case(6):
                System.out.println("Enter a new employee ID in charge: ");
                new_id = scan.nextInt();
                modifyEmplID(index, new_id);
                break;
            case(7):
                System.out.println("Enter a new description: ");
                new_description = scan.next() + scan.nextLine();
                modifyDescription(index, new_description);
                break;
        }
        
        System.out.println("Data modification is successfully done.");
    }
    
    private void modifyCategory(int indexNum, int nCategory)
    {
        Category.set(indexNum, nCategory);
    }
    private void modifyTitle(int indexNum, String nTitle)
    {
        Title.set(indexNum, nTitle);
    }
    private void modifyDate(int indexNum, String nDate)
    {
        Date.set(indexNum, nDate);
    }
    private void modifyAmount(int indexNum, double nAmount)
    {
        AmountSpent.set(indexNum, nAmount);
    }
    private void modifyLocation(int indexNum, String nLocation)
    {
        Location.set(indexNum, nLocation);
    }
    private void modifyEmplID(int indexNum, int nID)
    {
        EmplIDCharge.set(indexNum, nID);
    }
    private void modifyDescription(int indexNum, String nDescription)
    {
        Description.set(indexNum, nDescription);
    }
    
    
    private void exDeleteRecord(int index)
    {
        System.out.println("Deleting the information...");
        Category.remove(index);
        Title.remove(index);
        AmountSpent.remove(index);
        Location.remove(index);
        EmplIDCharge.remove(index);
        Description.remove(index);
        
        System.out.println();
        System.out.println("The deletion is successfully done.");
    }
}