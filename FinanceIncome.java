import java.util.Scanner;
import java.util.ArrayList;

public class FinanceIncome extends HSMS
{
    private String donator;
    private double amountOfDonation;
    private String duration;
    private int emplID_in_charge;
    private String description;
    
    ArrayList Donator;
    ArrayList DonationAmount;
    ArrayList Duration;
    ArrayList EmplIDCharge;
    ArrayList Description;
    
    Scanner scan = new Scanner(System.in);
    
    public FinanceIncome(int emplID, String emplName, int dept)
    {
        super(emplID, emplName, dept);
        donator = "No information yet";
        amountOfDonation = 0.0;
        this.duration = "No information yet";
        
        //Initiate array list
        Donator = new ArrayList();
        DonationAmount = new ArrayList();
        Duration = new ArrayList();
        EmplIDCharge = new ArrayList();
        Description = new ArrayList();
        
    }
    
    //Form for donation
    
    public void incomeMenu()
    {
        int user_input;
        String donator_name;
        int indexNumber;
        boolean flag = true;
        
        System.out.println("Enter 0 to exit");
        while (flag)
        {
            System.out.println("Homeless Shelter Management System Donation Information");
            System.out.println("1. View the list");
            System.out.println("2. Create");
            System.out.println("3. Modifiy");
            System.out.println("4. Delete");
            System.out.println("0. Exit");
    
            System.out.println();
            System.out.println();
            System.out.print("Please choose a number for an operation: ");
            user_input = scan.nextInt();
            switch (user_input)
            {
                case(1):
                    displayInfo();
                    break;
                case(2):
                    createInfo();
                    break;
                case(3):
                    System.out.println("Please type donator's name to find the records:");
                    donator_name = scan.next();
                    indexNumber = getIndexNum(donator_name);
                    modifyInfo(indexNumber);
                    break;
                case(4):
                    System.out.println("Please type donator's name to find the records:");
                    donator_name = scan.next();
                    indexNumber = getIndexNum(donator_name);
                    deleteInfo(indexNumber);
                    break;
                case(0):
                    flag = false;
                    break;
            }
        }        
        
    }
    
    //
    private void displayInfo()
    {
        int arraySize = Donator.size();
        
        if (arraySize == 0)
        {
            System.out.println("The information is empty. Pleae check again.");
        }
        else
        {
            System.out.println("--------Donation Information DB----------");
            for (int i=0; i < arraySize; i++)
            {
                System.out.println("Donator name : " + Donator.get(i));
                System.out.println("Donation amount : " + DonationAmount.get(i));
                System.out.println("Duration : " + Duration.get(i));
                System.out.println("Employee ID in charge : " + EmplIDCharge.get(i));
                System.out.println("Description: " + Description.get(i));
            }
        
        System.out.println();
        System.out.println("-----------------------------------------");
        }
    }
    
    private void createInfo()
    {
        System.out.println("Create a new form for donation information");
        System.out.print("1. Donator Name >>>    ");
        donator = scan.next() + scan.nextLine();
        System.out.println();
        System.out.print("2. Amount of donation >>>   ");
        amountOfDonation = scan.nextDouble();
        System.out.println();
        System.out.print("3. duration >>>   ");
        duration = scan.next() + scan.nextLine();
        System.out.println();
        System.out.print("4. Employee ID in charge >>>   ");
        emplID_in_charge = scan.nextInt();
        System.out.println();
        System.out.print("5. Description/Note >>>   ");
        description = scan.next() + scan.nextLine();
        System.out.println();
        
        //Insert the information into list
        Donator.add(donator);
        DonationAmount.add(amountOfDonation);
        Duration.add(duration);
        EmplIDCharge.add(emplID_in_charge);
        Description.add(description);
        System.out.println("The information is successfuly saved.");
        System.out.println("Index number :  " + Donator.indexOf(donator));
        
    }
    private int getIndexNum(String name)
    {
        int index_num;
        index_num = Donator.indexOf(name);
        return index_num;
    }
    private void modifyInfo(int indexNum)
    {
            int user_option;
            String new_name;
            double new_amount;
            String new_duration;
            int new_id;
            String new_description;
            
            
            System.out.println("Please enter a number to modify: ");
            System.out.println("1. Modify donator name");
            System.out.println("2. Modify amount of donation");
            System.out.println("3. Modify duration");
            System.out.println("4. Modify employee id in charge");
            System.out.println("5. Modify description");
            user_option = scan.nextInt();
            
            switch(user_option)
            {
                case(1):
                    System.out.println("New donator's name: ");
                    new_name = scan.next() + scan.nextLine();
                    modifyDonator(indexNum, new_name);
                    break;
                case(2):
                    System.out.println("New amount of donation: ");
                    new_amount = scan.nextDouble();
                    modifyAmount(indexNum, new_amount);
                    break;
                case(3):
                    System.out.println("New duration: ");
                    new_duration = scan.next() + scan.nextLine();
                    modifyDuration(indexNum, new_duration);
                    break;
                case(4):
                    System.out.println("New employee ID: ");
                    new_id = scan.nextInt();
                    modifyEmplID(indexNum, new_id);
                    break;
                case(5):
                    System.out.println("New description: ");
                    new_description = scan.next() + scan.nextLine();
                    modifyDescription(indexNum, new_description);
                    break;
            }
            
            System.out.println("The information is successfully changed.");
            
            
    }
    
    private void modifyDonator(int indexNum, String newDonator)
    {
        Donator.set(indexNum, newDonator);
    }
    private void modifyAmount(int indexNum, double newAmount)
    {
        
        DonationAmount.set(indexNum, newAmount);
    }
    
    private void modifyDuration(int indexNum, String newDuration)
    {
        
        Duration.set(indexNum, newDuration);
    }
    private void modifyEmplID(int indexNum, int newID)
    {
        EmplIDCharge.set(indexNum, newID);
    }
    private void modifyDescription(int indexNum, String newDescription)
    {
        Description.set(indexNum, newDescription);
    }
    
    
    private void deleteInfo(int index)
    {
        System.out.println("Deleting the information...");
        Donator.remove(index);
        DonationAmount.remove(index);
        Duration.remove(index);
        EmplIDCharge.remove(index);
        Description.remove(index);
        
        System.out.println();
        System.out.println("The information is successfully deleted.");
    }
    
    
}
