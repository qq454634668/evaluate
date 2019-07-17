package com.evaluate.license;

import de.schlichtherle.license.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.prefs.Preferences;


@Component
public class LicenseVertify {

	@Autowired
	private  LicenseManagerHolder licenseManager;

	/**
	 * 公钥别名
	 */
	@Value("${license.pubAlias}")
	public  String pubAlias;
	/**
	 * 该密码是在使用keytool生成密钥对时设置的密钥库的访问密码 
	 */
	@Value("${license.keyStorePwd}")
	public  String keyStorePwd;
	/**
	 * 系统的统一识别码
	 */
	@Value("${license.onlykey}")
	public  String onlykey;
	/**
	 * 证书路径 
	 */
	@Value("${license.licName}")
	public  String licName;
	/**
	 * 公钥库路径
	 */
	@Value("${license.pubPath}")
	public  String pubPath;








	public  boolean setParam() {

		try
		{
			System.out.println(licName);
			LicenseManager licenseManager=getLicenseManager();
			licenseManager.install(new File(licName));
			System.out.println("安装证书成功!");
		}
		catch (Exception e)
		{
			System.out.println("安装证书失败!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 初始化证书的相关参数
	 * @param
	 * @return
	 */
	private  LicenseParam initLicenseParams()
	{
		Class<LicenseVertify> clazz=LicenseVertify.class;
		Preferences pre=Preferences.userNodeForPackage(clazz);
		CipherParam cipherParam=new DefaultCipherParam(keyStorePwd);
		KeyStoreParam pubStoreParam=new DefaultKeyStoreParam(clazz, pubPath, pubAlias, keyStorePwd, null);
		LicenseParam licenseParam=new DefaultLicenseParam(onlykey, pre, pubStoreParam, cipherParam);
		return licenseParam;
	}
	private  LicenseManager getLicenseManager()
	{
		licenseManager.setLicenseParam(initLicenseParams());
		return licenseManager;
	}

	
	/**
	 * 验证证书的合法性
	 * @return 0、合法，1、证书过期，2、证书错误
	 */
	public  int vertify()
	{
		try
		{
//			LicenseManager licenseManager=getLicenseManager();
			licenseManager.verify();
//			System.out.println("验证证书成功!");
			return 0;
		}
		catch(LicenseContentException ex)
		{
			System.out.println("证书已经过期!");
			ex.printStackTrace();
			return 1;
		}
		catch (Exception e)
		{
			System.out.println("验证证书失败!");
			e.printStackTrace();
			return 2;
		}
	}

}