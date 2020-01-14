import java.net.*;
import java.io.*;
import java.util.*;

public class MyClient{
  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      try{
      Socket s = new Socket("localhost", 1000);

      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      while(true) {
        System.out.print("Say Something to Server: ");
        String str = sc.nextLine();
        dout.writeUTF(str);

        if(str.equals("Bye")) break;

        String other = din.readUTF();
        System.out.println("Server Says: " + other);
      }
      s.close();
      din.close();
      dout.close();
    }
    catch(Exception e){
      System.out.println("Connection Error!!!(Client)");
    }
  }
}
