import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// import Myobject.*;



public class SaveAndRead {
	public static void main(String[] args) {
		try {
			Myobject myobject = Myobject.getInstance();
			FileOutputStream fos = new FileOutputStream(
				new File("myobjectFile.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(myobject);
			oos.close();
			fos.close();
			System.out.println(myobject.hashCode());
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream(
				new File("myobjectFile.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			Myobject myObject = (Myobject)ois.readObject();
			ois.close();
			fis.close();
			System.out.println(myObject.hashCode());

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	} 
}
