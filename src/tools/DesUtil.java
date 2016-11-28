package tools;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.RandomStringUtils;

public class DesUtil {

	private final static String DES = "DES";

	/**密匙 **/
	private static final String LUNA_SALT = "lunaluna";


	/**
	 * 加密
	 * 
	 * @param src 数据源
	 * @param key 密钥，长度必须是8的倍数
	 * @return 返回加密后的数据
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密匙工厂，然后用它把DESKeySpec转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
		// 现在，获取数据并加密
		// 正式执行加密操作
		return cipher.doFinal(src);
	}

	/**
	 * 解密
	 * 
	 * @param src 数据源
	 * @param key 密钥，长度必须是8的倍数
	 * @return 返回解密后的原始数据
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
		// 一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
		// 现在，获取数据并解密
		// 正式执行解密操作
		return cipher.doFinal(src);
	}

	/**
	 * 加密
	 * 
	 * @param encryptStr
	 * @return
	 */
	public static byte[] encrypt(byte[] src, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(DES);
		SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), DES);
		cipher.init(Cipher.ENCRYPT_MODE, securekey);// 设置密钥和加密形式
		return cipher.doFinal(src);
	}

	/**
	 * 解密
	 * 
	 * @param decryptStr
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, String key) throws Exception {
		Cipher cipher = Cipher.getInstance(DES);
		SecretKeySpec securekey = new SecretKeySpec(key.getBytes(), DES);// 设置加密Key
		cipher.init(Cipher.DECRYPT_MODE, securekey);// 设置密钥和解密形式
		return cipher.doFinal(src);
	}


	/**
	 * 二行制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		StringBuilder hs = new StringBuilder();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs.append("0" + stmp);
			} else {
				hs.append(stmp);
			}
		}
		return hs.toString().toUpperCase();
	}

	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0) {
			throw new IllegalArgumentException("长度不是偶数");
		}
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte)Integer.parseInt(item, 16);
		}
		return b2;
	}


	/**
	 * 通讯解密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public final static String decrypt(String data) {
		try {
			return new String(decrypt(hex2byte(data.getBytes()), LUNA_SALT.getBytes()));
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * @author 通讯加密 
	 * @version
	 * @see 通讯加密
	 * @param id 通讯加密的原字符串
	 * @return 返回加密后字符串
	 * @exception
	 */
	public final static String encrypt(String id) {
		try {
			return byte2hex(encrypt(id.getBytes(), LUNA_SALT.getBytes()));
		} catch (Exception e) {
		}
		return null;
	}
	//https://active.celuechaogu.com/calculator/calculator.html?calculator=086399AA7158071B4639326AFF071E0C955FD5C7D25CE7696A9921D5DED49BBA290631E67A754363084462084DFA34FB75119F86E5EE30B8CB82566AE9C08285C71C4F553E9CCD20",
	public static void main(String[] args) throws UnsupportedEncodingException {
//		String str = "A4C08C51B179DEA1,BF5771FF538A715E,7D389BD04BB7F178,B94F8D97E935C9B8,1668A55607A9F93E,6B6E3325658BDC42,05A8C3968D76BEB7,9A0384F583FDF7F3,F41144EAEAE1912A,06A9BDE962273309,50A541F4A600521A,88FF5B8D5708BB8B,D562A7C38DE16172,133A00EED789E00F,2AA2D67C56A2299D,1D62DE1FFABCA5D0,5327F33BE365995A,8D081FB4755FCC29,6540649D77A2D774,134089A2D52FF41D,5BD0B9C5370957DC";
//		String strs[] = str.split(",");
//		System.out.println(strs.length);
//		for (String s: strs) {
//			System.out.println(String.format("INSERT INTO `factor_vote` (`fid`, `create_time`) VALUES (%s, '2016-08-15 14:44:31');", decrypt(s)));
//		}
		//7581, 3595, 84531, 43502, 157887, 20608, 38857, 45838, 25522, 46499
		//System.out.println("=====加密======"+encrypt("stockPool=300366,600871,601018,600153,600982&position=20&name=卒子"));
		//System.out.println("=====解密======"+decrypt("086399AA7158071B4639326AFF071E0C955FD5C7D25CE7696A9921D5DED49BBA290631E67A754363084462084DFA34FB10DBF8FDDE4F79E06DA9B98346E325F1"));
		//System.out.println("=====加密======"+encrypt("405"));
		//System.out.println("=====加密======"+encrypt("335"));
		//System.out.println("=====解密======"+decrypt("E38337FA21DB645D"));
		System.out.println("=====解密======"+decrypt("C5112C73BAE24AE78BABD5C8C0300317970E39AE72AB97ECAEF3DB75984683060CCC3D2700756CB40905552A6B2B3F63CA7CC7FFC1B9B00D7AB989DCD1E95C1F"));
//		for (int i = 0; i < 5; i++) {
//			System.out.println("=====加密======"+RandomStringUtils.randomAlphabetic(16));
//		}
		
	}
}
