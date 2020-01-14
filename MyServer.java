import java.net.*;
import java.io.*;
import java.util.*;

public class MyServer{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    try{
      ServerSocket ss = new ServerSocket(1000);
      Socket s = ss.accept();

      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

	while(true)
	{
		String other = din.readUTF();
        	System.out.println("Client Says: " + other);
		
		System.out.print("Say Something to Client: ");
        	String str = sc.nextLine();
        	dout.writeUTF(str);

        	if(str.equals("Bye")) break;
	}      
      ss.close();
      s.close();
      din.close();
    }
    catch(Exception e){
      System.out.println("Connection Error!!!(Server)");
    }
  }
}
