package com.evaluate.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * URL参数值加解密类
 * 
 * @author 陈猛
 * @version $Revision: 1.1 $
 * @since 0.1
 */
public class Arithmetic implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7736489648581564856L;

	/**
	 * 设置固定的KEY值 将加密与解密方式统一
	 */
	public SecretKey generateDES_ECBMode_Key() throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
		DESKeySpec keySpec = new DESKeySpec(generateDESKeyBytes("orz"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(keySpec);
		return key;
	}

	public byte[] generateDESKeyBytes(String keyWord) {
		byte[] key = new byte[8];

		byte[] tmp = keyWord.getBytes();
		for (int i = 0; i < key.length; i++) {
			if (i < tmp.length)
				key[i] = tmp[i];
		}
		return key;
	}

	/**
	 * 加密String明文输入,String密文输出
	 * 
	 * @param strMing
	 * @return
	 */
	public String getEncString_old(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		try {
			return byte2hex(getEncCode(strMing.getBytes()));

			// byteMing = strMing.getBytes("UTF8");
			// byteMi = this.getEncCode(byteMing);
			// strMi = new String( byteMi,"UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public String getDesString_old(String strMi) {
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			return new String(getDesCode(hex2byte(strMi.getBytes())));

			// byteMing = this.getDesCode(byteMi);
			// strMing = new String(byteMing,"UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, this.generateDES_ECBMode_Key());
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, this.generateDES_ECBMode_Key());
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 二行制转字符串
	 * 
	 * @param b
	 * @return
	 */
	public String byte2hex(byte[] b) { // 一个字节的数，
		// 转成16进制字符串
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase(); // 转成大写
	}

	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}

		return b2;
	}

	/**
	 * 加密
	 */
	public String getEncString(String reg) {
		if (reg == null || "".equals(reg)) {
			return 3137 + "";
		} else {
			StringBuffer str = new StringBuffer();
			char[] chars = reg.toCharArray();
			String[] strs = new String[chars.length];
			for (int i = 0; i < chars.length; i++) {
				strs[i] = chars[i] + 3137 + "";
			}
			String temp = strs[strs.length - 1].substring(0, 2);
			for (int i = strs.length - 1; i > 0; i--) {
				strs[i] = strs[i - 1].substring(0, 2) + strs[i].substring(2);
			}
			strs[0] = temp + strs[0].substring(2);
			for (int i = 0; i < strs.length; i++) {
				str.append("-").append(strs[i]);
			}
			return str.toString().substring(1);
		}
	}

	/**
	 * 解密
	 */
	public String getDesString(String mw) {
		if (mw == null || "".equals(mw) || "3137".equals(mw)) {
			return "";
		}
		String[] mws = mw.split("-");
		String temp = mws[0].substring(0, 2);
		for (int i = 0; i < mws.length - 1; i++) {
			mws[i] = mws[i + 1].substring(0, 2) + mws[i].substring(2);
		}
		mws[mws.length - 1] = temp + mws[mws.length - 1].substring(2);
		char[] minws = new char[mws.length];
		for (int i = 0; i < mws.length; i++) {
			minws[i] = (char) (Integer.parseInt(mws[i]) - 3137);
		}
		return new String(minws);
	}

}
