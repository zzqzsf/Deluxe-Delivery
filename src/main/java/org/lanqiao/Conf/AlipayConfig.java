package org.lanqiao.Conf;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101200666383";


	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDwwEyF2ii77iMFquRClowB+WGNFb2ohXPQfkGLSmheFLsmKjzoJBcVZmaMLMy5r1jABPa9QwlW86PfuqtWzQIRSjsdMyxgrsYZxKrI/ol9o/W6UvuXfYFtclVupOWvXd8qqexaVtGvlkTf/tzwW1ROrUoTymidTcUgAq/3al1L+RSEqhH5YIoosx5343uqohNkCDLxbaYswcESMdRqks+7HkA/0Z6QIacxzcABXyU5pct2E7CZOseyLjZGYsuflo9H0c9uJYIJsvvvjXkOlLXtwX8nbWBIuq4hC1UBTjqeNDTfM116x5AaDm5x0Y2tXwIgwWRxDhQcjYC8LIaJa9jDAgMBAAECggEAWD+1DS+d1N2C2vX8e+ghZCvctVGt1tMsU9WkAwIAZdQlkeTTtKheCcsidemKFdqPprtrEo87IjNm84DCg6vcQSg7qQV0E/Cczx9HFywui+6JCYaXkL1BrzPE2yz4wKKhRktJRwgiDsH/dzg+FqDzs29UAxMj691xD73McN39WvY5o1xms09g4MB1/QVgaQNNhLevxygD5l5gkxECzPAo15DZ4a2bBuJhjJzaVmszHYbDwQxPPhLvHXRvot38bIZ6s0NeE3VaqH1VwMooZSSGc7b7VowThtX9qO701UEG6EaSRKxp53ILAHR2ZiO0LVn9Lw9A/HKs2M3LpxbWSilHYQKBgQD9ZC22NywcroywmIHJ2lj0jJysqJaM3pGhADfkYioFdfst/abxbJ3EDCnod2RpbQ/SIQfMV22lyEFtdqA3KioTYhZGtUbqbc5nD+UBABSrZ8tncAwFZZgamagDaCUGFYRxTvOeTq11AETn5UZ5dUv8qH/HgDOjePQt6Z7Gb1fN0wKBgQDzOs6KVJS9Gc0vJMBRvdTqtbuXhId735/Tq1vs1iHyxzaDu8BsiLnQowe8b80r6yvPtcj6Bip4aHbm2U/yAZmMNxVM6Ml4SpLVUpQHJfdt/6y47qPnX0mzlZNnNRO4VyO+M17pJki71l6Zq8FDgEqUEutesGKlzIt51kSBKjTDUQKBgQClFEbTl04dwXnW8wRbROz/JTxNH+g1DitCAKppF6rYs+xYIhBI6MI/ns0Orfm01WChPPOfpLXCc5xsfAQU7FtNFXH9zsvMno0Bh9FhvXO5130kflLWkUFu0vwqfAbi19HZH96HHCrVNr+tdCldp5VBnWThzBvYPEyYPMM78/34EQKBgQDMTTD/cFwfGnUGjFAeWN1m6I9RjbhfjE6rdNwZ6yNI0Zwwupu+jnnFjasJ1L75jOeX6JGPsW4rBVQaQ56rIDzhUcNKfp37tGfxVxOPjYxvkLp7+7cguSEm/xR5NFQEGu2i7XNjUwz0+fMsEOCc2j3KcrnRJ0c1DMJ67EdOVy1KgQKBgQDARAIYnlrueYoKF0JljOBeiHZmvOnZsLnTHGIBH3mpMvWceaFX2z13IBSwETsJONYQ/Y8qp8eMRhnxTd2NTJ7N1R1D6svRwAuKFBBZ299rq/iNRocuplEg4UBqvpJEBpmfAZNozA5GHZ9hMVRRvJVA+49OgOiaWlO7ct1VGB4ieA==";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhHmuOPFr8FJvHk11f9JyWMtyhjY0FCWMpJNFqx4usn7w2gt0FDIxxiJzOqU8X+dcXAuZosoiyAhpj/Mg3TpaXXxULDK3w89N1yUApzMS8+FbIPw3nvJcxqLkjgVKHHQBMEqAAtUI9qcQ1uZTu3uEkC7zq6klrHaaEBRW6BMdAUktueZr/wzXPSqgM/fK0svS5RfL0blsGQbPa35D8jCyBssHGf5OMZuZ3BpgBz7Q9ztEq9eGFdVetNajEXLPZYfaHWMqwYTQnWwvF8DEunL9GQrxFnHQ49kKqcVJ/H625bBThAPy3GrlDBfnJ8qXEhFMx6wN0+FRCicmNaFPxbjqfQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/takeOrderSuccess.html";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "F:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 *
	 * @param sWord 要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

