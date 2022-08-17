import java.util.*;
public class Hotel {
    public static void initialize(Room RoomList[])
    {
        for(int i=0; i<RoomList.length; i++)
        {
            RoomList[i]=new Room();
            RoomList[i].setName("EMPTY");
            RoomList[i].setRoom(i+1);
        }
    }

    public static void viewList(Room RoomList[])
    {
        for(int i=0; i<RoomList.length; i++)
        {
            if(RoomList[i].getName()=="EMPTY")
                System.out.println("Room number "+RoomList[i].getRoom()+" is vacant.");
            else
                System.out.println("Room number "+RoomList[i].getRoom()+" is occupied by "+RoomList[i].getName()+".");
        }
        System.out.println();
    }

    public static boolean addCustomer(Room RoomList[], String name ,int room)
    {
        for(int i=0; i<RoomList.length; i++)
        {
            if (RoomList[i].getName() == "EMPTY")
            {
                RoomList[room - 1].setRoom(room);
                RoomList[room - 1].setName(name);

                return true;
            }
        }

        return false;
    }

    public static void showEmptyRooms(Room RoomList[])
    {
        System.out.println("Available rooms are:");
        for(int i=0; i<RoomList.length; i++)
            if(RoomList[i].getName()=="EMPTY")
                System.out.println(RoomList[i].getRoom());
        System.out.println();
    }

    public static boolean deleteCustomer(Room RoomList[], String name)
    {
        for(int i=0; i<RoomList.length; i++)
            if(RoomList[i].getName().equals(name))
            {
                RoomList[i].setName("EMPTY");
                System.out.println("Deletion successful.\n");
                return true;
            }
        return false;
    }

    public static int getIndex(Room RoomList[], String name)
    {
        for(int i=0; i<RoomList.length; i++)
            if(RoomList[i].getName().equals(name))
                return i;
        return -1;
    }

    public static void ViewGuestsAlp(Room RoomList[],String temp)
    {
        for (int i = 0; i < RoomList.length; i++)
        {
            for (int j = i + 1; j < RoomList.length; j++) {
                if (RoomList[i].getName().compareTo(RoomList[j].getName())>0)
                {
                    temp = RoomList[i].getName();
                    RoomList[i].getName().equals(RoomList[j].getName());
                    RoomList[j].getName().equals(temp);
                }
            }
        }

        //Displaying the strings after sorting them based on alphabetical order
        System.out.print("customers names  ");
        for (int i = 0; i <= RoomList.length - 1; i++)
        {
            if(RoomList[i].getName()!="EMPTY")
                System.out.print(RoomList[i].getName() + ", ");

        }
    }

    public static void AdditionalInformation()
    {

    }



    




    public static void main(String[] args)
    {
        Room[] RoomList = new Room[8];
        Person[] Personlist = new Person[8];
        String name;
        int room;
        String temp="'";
        int guests=0;
        int roomNum;
        String FirstName="null";
        String Surname="null";
        int CreditCardNum=0;
        initialize(RoomList);

        Scanner input = new Scanner(System.in);
        String Option;

        do
        {
            System.out.println("        Hotel Booking Options Menu");
            System.out.println("=====================================");
            System.out.println("V: To View all rooms");
            System.out.println("A: To Add customer to a room");
            System.out.println("E: To Display empty rooms");
            System.out.println("D: To Delete customer from a room");
            System.out.println("F: Find room from customer name");
            System.out.println("O:  View guests Ordered alphabetically by name");
            System.out.println("G: Details about room occupants");
            System.out.println("B: Exit");

            System.out.print("\nEnter your choice: ");
            Option = input.next();
            System.out.println();

            switch(Option)
            {
                case "V":
                {
                    viewList(RoomList);
                    break;
                }
                case "A":
                {
                    System.out.print("Customer's name: ");
                    name=input.next();
                    System.out.print("Enter room Num: ");
                    room =input.nextInt();


                    System.out.println();
                    if(!addCustomer(RoomList, name , room))
                        System.out.println("No rooms available!");
                    break;
                }
                case "E":
                {
                    showEmptyRooms(RoomList);
                    break;
                }
                case "D":
                {
                    System.out.print("Customer's name: ");
                    name=input.next();
                    System.out.println();
                    deleteCustomer(RoomList, name);
                    break;
                }
                case "F":
                {
                    System.out.print("Customer's name: ");
                    name=input.next();
                    System.out.println();
                    System.out.println("Customer's room: "+RoomList[getIndex(RoomList, name)].getRoom()+"\n");
                    break;
                }
                case "B":
                {
                    System.out.println("\nThank you!\n");
                    break;
                }

                case "O":
                {
                    ViewGuestsAlp(RoomList, temp);
                    break;
                }


                default:
                {
                    System.out.println("Invalid option!\n");
                    break;
                }
            }


        }while(!Option.equals("B"));


    }
}
