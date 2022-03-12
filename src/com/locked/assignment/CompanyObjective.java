package com.locked.assignment;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CompanyObjective {

	public static void main(String[] args)throws IOException {
		System.out.println("Welcome to Lockers Pvt. Ltd.");
		System.out.println("Developed by Mehali");
		System.out.println("Please select an option:");
		Scanner sc = new Scanner(System.in);
		int choice=0; int ch=0;
		while(true) {
			System.out.println(" 1. Get the names of files in ascending order\n 2. Add, Delete, Search\n 3. Close");
			try{    
				choice = sc.nextInt();
			}
			catch(Exception e)  
             {  
              System.out.println(e); 
          
             }   
		switch(choice) {
		case 1:
			listingOfFiles(); 	
			break;
		
		case 2:
			System.out.println("Choose to ADD DELETE or SEARCH");
			System.out.println("1.ADD\n2.DELETE\n3.SEARCH");
			try{    
				ch = sc.nextInt();
			}
			catch(Exception e)  
             {  
              System.out.println("Null Exception occurred");  
             }   
			{
				switch(ch) {
				case 1:
				// creation of file
					creationOfFile();
					break;
				case 2:
				// Deletion of file
					deletionOfFile();
					break;
				
				case 3:
				// searching of file
					searchingOfFile();
					break;
				default:
					System.out.println("Invalid input!! Please try again");
				
				}
				break;
			}
			
		
		case 3:
			sc.close();
			System.out.println("THANK YOU FOR CHOOSING OUR APPLICATION");
			System.exit(1);
		break;
		default:
			System.out.println("Invalid input!! Please try again");
			break;
		}
				}
	}
static void listingOfFiles(){
	File directoryPath = new File(System.getProperty("user.dir"));
	String [] listOfFiles = directoryPath.list();
	for(int i = 0; i < listOfFiles.length-1; ++i) {  
         for (int j = i + 1; j < listOfFiles.length; ++j) {  
            if (listOfFiles[i].compareToIgnoreCase(listOfFiles[j]) > 0) {  
               String temp = listOfFiles[i];  
               listOfFiles[i] = listOfFiles[j];  
               listOfFiles[j] = temp;  
            }  
         }  
      } 
	
	// Printing of sorted array
	for(String name: listOfFiles) {
		System.out.println(name);
	}
}

// creation of file
 static void creationOfFile()
{
	System.out.println("Please enter the file to be added:");
	    Scanner sc = new Scanner(System.in);
		String createdFile=sc.next();
		
		File file = new File(System.getProperty("user.dir")+"//"+createdFile);
		try{
		if(file.createNewFile()) {
			System.out.println(createdFile+" hasbeen created successfully");
		}
		else {
			System.out.println(createdFile+"already exists");
		}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
}
 
 // Deletion of file
 static void deletionOfFile() {
	 
		System.out.println("Enter the file to be deleted:");
		Scanner sc = new Scanner(System.in);
			String deletedFile= sc.next();
			File file1 =  new File(System.getProperty("user.dir")+"//"+deletedFile);
			if(file1.exists()) {
				if(file1.delete()) {
				System.out.println(deletedFile+" is deleted successfully");
			
			}
			}
			else {
				System.out.println("File Not Found!");
			}
					 
 }
 
 //Searching of file
 static void searchingOfFile() {
	 
		System.out.println("Enter the file to be searched");
		Scanner sc = new Scanner(System.in);
			String searchFile= sc.next();
			File file2 = new File(System.getProperty("user.dir")+"\\"+searchFile);
			if(file2.exists()) {
				System.out.println("FILE FOUND");
			}
			else {
				System.out.println("FILE DOESNOT EXISTS");	
			}
		
 }
}