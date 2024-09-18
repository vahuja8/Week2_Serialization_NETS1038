package com.va.week2.inclass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestDriver {

	public static void main(String[] args) {

		SerializationDemo d1 = new SerializationDemo(1, "Demo..");
		// d1 is the object!
		// parms inputs given to the constructor -- when creating the object..
		String filename = "file.ser";

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// Method for serialization of object
			out.writeObject(d1);

			out.close();
			file.close();

			System.out.println("Object has been serialized");

		} catch (IOException ex) {
			System.out.println("IOException is caught");
			System.out.println(ex.getMessage());
			System.out.println(ex.toString());
			
		}

		SerializationDemo d2 = null;

		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// Method for deserialization of object
			d2 = (SerializationDemo) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized ");
			System.out.println("a = " + d1.a);
			System.out.println("b = " + d1.b);
		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
			System.out.println(ex.getMessage());
			System.out.println(ex.toString());
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
			System.out.println(ex.getMessage());
			System.out.println(ex.toString());
		}

	}
}
