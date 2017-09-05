package client;

import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;




public class RSAEncrypt {
	private static String ALGORITHM = "RSA";
	private static int KEYSIZE = 1024;
	public void generateKeyPair(String name) throws Exception{
		  /** RSA算法要求有一个可信任的随机数源 */
		   SecureRandom sr = new SecureRandom();
		   /** 为RSA算法创建一个KeyPairGenerator对象 */
		   KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
		  /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
		   kpg.initialize(KEYSIZE, sr);
		   /** 生成密匙对 */
		   KeyPair kp = kpg.generateKeyPair();
		   /** 得到公钥 */
		   Key publicKey = kp.getPublic();
		   /** 得到私钥 */
		   Key privateKey = kp.getPrivate();
		   /** 用对象流将生成的密钥写入文件 */
		   File filea=new File("F:\\netuser\\"+name+"");
		   filea.mkdirs();
		   File file=new File("F:\\netuser\\"+name+"","publickey.txt");
		   File fileb=new File("F:\\netuser\\"+name+"");
		   fileb.mkdirs();
		   File file2=new File("F:\\netuser\\"+name+"","privatekey.txt");
		   ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(file));
		   ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(file2));
		   oos1.writeObject(publicKey);
		   oos2.writeObject(privateKey);
		   /** 清空缓存，关闭文件输出流 */
		   oos1.close();
		   oos2.close();
		}

	public byte[] encrypt(File source,String name) throws Exception{
		   /** 将文件中的公钥对象读出 */
		   File file=new File("F:\\netuser\\"+name+"","publickey.txt");
		   ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		   Key key = (Key) ois.readObject();
		   ois.close();
		   /** 得到Cipher对象来实现对源数据的RSA加密 */
		   Cipher cipher = Cipher.getInstance(ALGORITHM);
		   cipher.init(Cipher.ENCRYPT_MODE, key);
		   byte[] b = new byte[(int) source.length()];
		   FileInputStream fs = new FileInputStream(source);
			fs.read(b);
		   /** 执行加密操作 */
		   byte[] b1 = cipher.doFinal(b);
		   return b1;
		}

	public byte[] decrypt(byte[] cryptograph,String name) throws Exception{
		   /** 将文件中的私钥对象读出 */
		   File file2=new File("F:\\netuser\\"+name+"","privatekey.txt");
		   ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file2));
		   Key key = (Key) ois.readObject();
		   /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
		   Cipher cipher = Cipher.getInstance(ALGORITHM);
		   cipher.init(Cipher.DECRYPT_MODE, key);
		   byte[] b1 = cryptograph;
		   /** 执行解密操作 */
		   byte[] b = cipher.doFinal(b1);
		   return b;
		}

	public byte[] encrypt2(File ofile,byte[] b) throws Exception{
		   ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ofile));
		   Key key = (Key) ois.readObject();
		   ois.close();
		   /** 得到Cipher对象来实现对源数据的RSA加密 */
		   Cipher cipher = Cipher.getInstance(ALGORITHM);
		   cipher.init(Cipher.ENCRYPT_MODE, key);
		   /** 执行加密操作 */
		   byte[] b1 = cipher.doFinal(b);
		   return b1;
	}
	
	public static void main(String[] args) throws Exception{
		RSAEncrypt rSAEncrypt = new RSAEncrypt();
		rSAEncrypt.generateKeyPair("test");
	}
}
