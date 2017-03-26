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
 * <p>Description:���Զ�������л��ͷ����л�<p>
 * @author PengLiu
 * @version 1.0v
 * @since 2016-3-26
 */
public class TestObjSerializeAndDeserialize {

	public static void main(String[] args) throws Exception{
		//���л�Person����
		SerializePerson();
		//������Person����
		Person p =DeserializePerson();
		System.out.println(MessageFormat.format("name={0},age={1},sex={2}",p.getName(),p.getAge(),p.getSex()));
		
	}

	/**
	 * MethodName:SerializePerson
	 * Description:���л�Person����
	 * @author PengLiu
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	private static void SerializePerson() throws Exception {
		Person person = new Person();
		person.setName("pengyangyang");
		person.setAge(13);
		person.setSex("��");
		//ObjectOutputStream �������������Person����洢��E�̵�Person.txt�ļ��У���ɶ�Person��������л�����
		ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
		oo.writeObject(person);
		System.out.println("Person�������л��ɹ���");
		oo.close();
	}
	
	/**
	 * MethodName:DeserializePerson
	 * Description:������Person����
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
		System.out.println("Person�������л��ɹ���");
	    return person;
	}
	
	
	
	
	
	
	
	
	
}
