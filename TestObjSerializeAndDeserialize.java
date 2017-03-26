package work04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.MessageFormat;

/**
 * <p>ClassName:TestObjSerializeAndDeserialize<p>
 * <p>Description:测试对象的序列化和反序列化<p>
 * @author PengLiu
 * @version 1.0v
 * @since 2016-3-26
 */
public class TestObjSerializeAndDeserialize {

	public static void main(String[] args) throws Exception{
		//序列化Person对象
		SerializePerson();
		//反序列Person对象
		Person p =DeserializePerson();
		System.out.println(MessageFormat.format("name={0},age={1},sex={2}",p.getName(),p.getAge(),p.getSex()));
		
	}

	/**
	 * MethodName:SerializePerson
	 * Description:序列化Person对象
	 * @author PengLiu
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	private static void SerializePerson() throws Exception {
		Person person = new Person();
		person.setName("pengyangyang");
		person.setAge(13);
		person.setSex("男");
		//ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
		oo.writeObject(person);
		System.out.println("Person对象序列化成功！");
		oo.close();
	}
	
	/**
	 * MethodName:DeserializePerson
	 * Description:反序列Person对象
	 * @author PengLiu
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	private static Person DeserializePerson() throws Exception {
	    @SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
		Person person = (Person)ois.readObject();
		System.out.println("Person对象反序列化成功！");
	    return person;
	}
	
	
	
	
	
	
	
	
	
}
