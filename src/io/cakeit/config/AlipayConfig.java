package io.cakeit.config;

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
	public static String app_id = "2016102400751405";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCUZ7TIsWRWlzE4YgG0vMoLV/EdUT2dSjEqLEp6ONCR7gYuYQ1tI7F+ZObygFV7ebPlpwGdDalI3Cz1rSs2i+eOVNwYVVG4IgjP8l21q3SnisBtXb6sFBLCDMLm1Jur+0xBFvusqI3EX3hZdkLaVmrNGBWV3xVRpY1cBV5YiTxEDkECLn34WSWFCh8rsfFhe+eFDeFFmzvVXmZ5opCPM9npHQQfPxtOrHoLD35+wA6i3DjmpY26RO4fEG4I6CkuEbTvPTd7Psg8bAhr1iWQLzTW20BXkiiPGNsGuJvQ/Wbv8N8YNyU1xPhIOJ+cx0BNyQS3kSx0OVKi2E6UL8sI1WvJAgMBAAECggEAIUWC5X/H1BX/hfmLEl9FGPf1abI+ExaAIUlexToZoK3xmtJNdUuMTp8GnBWjlJQ7feBMX06hxmD+f3H8fzUsi9+AnL/8G0EeIqje040GEU3tSFe9GM1DS1gbFi9SW2NyvCEP+aysY/tXew8le9fmB+c/Z6NlHzHzmE7n0QeriEImKujPs9wiAbc3QNLrK37W28DRsVDfNBDQ0aU7Vzf/HpzAUut2T1rANG7mGr98MY5/9BbACEWNMJZ+4+HD1DHccBjGwB8iG7J6lp+fDq6NJPoQTHkENNPpk6ZiUTAWFKiZYmCwEF1v7sPQjnFJ4BkazAYI9lZy22FprjPLGBW/FQKBgQDS9LVjiW0KBPWj8RwBbDV4KJ7lzborhdb0OkdJWxOSGMz+cAEXdRWaLU/Migtw6IyS99VNiK7xyj0y1pHhJL+RFdXT52eKhSWShmxWekAyOcaDm5ydxo8l2oldgiAaKmOHNJ5fC2ozD//mViwRCISYgclCqGaZB3XXVLnjAPMn8wKBgQC0F9cbx9YI00E5j1RWv4YyrtVw1DrjlhNW9GIkpTtnE+88sg0WJce8qwKtn6b9/ZZyipmb+qPhovBoKNR3OCR/W2CvBaJXDWNgz+1BbeShBEZ+R6dD1qqGrXLLQJZ4OtD2Viu/wLVmqPjPQm1kCfV2WSK5OyaP9+W/wLcrMxioUwKBgAnrrCQUMGaKOSsOiayfdBxEfMR92kV1s9gkbXnLqK30MJ++kK6TuQJZIymRTFxw8ztuID/XL7L7OcmMQav+2GtwRXADr+DZxhyP6cRfV2mFQgqqZMEet1imYFNfbTcNy0RuewwpM0NXe0dPwh7C8cliQR67YKfNrAMGXv+H6ed1AoGAUwV6gLALF15r/yD3/FWmg87dTnpH+4q/t6JJbCNP0yD5dL2QEtmvzmX3ghrLXON+a6dBUQqmaeo3cY0BBUS4bo2tcIHkaMUfPw4bjcIfV6sk5CocDcX0Lsne1Zwcwag7lJP87xTji0PyD3nL/AYrRjepLkL6b/wTyeYJiryvbUkCgYAVdFtyL8OKZ39m7mR9TDcZLWwi21uHcRfgc2y1ii/ZDJTXHQVN47h7wO+C3EQUMLhZrIeMIH+r3eUNwDp+R6RyusGNiqMnu1veSe/81ykjmPm5x9t/yzBHwX071thB+4EZXb082IYs/1E8Qdwgn9FbFmgrSVN/ah2j79o6x6WD9A==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlCCuLJejRggnpFx5PrF3B8G8TxYdDHqP0iz1dP1oXH8tyC+bnnbtvzNyBfO2A0CGORk51gpum9PTjXhSs/qbTO2Z/oXUqfRBt/rpORfkoH/twU0wIo+VmpkR9mVL7Uyp5J5+gLckse0LNYfK7iyRCw1SLl3KgyVjVJEQmPHyPFlZAGs3l8qh+13HrXKpUN5b43K5w84uEbd+bq6juDgcbkbmW+C0ADvPiOiX6LQ6Z2Ai1aqBM0k5IFcEqRXWY/Yp6AZRRSKkO2T+Nz0cmfbBevtUrdPHSFLkLDvx8d2zwvZt6O1gVSQmakCn921zA/gwMsrl9MEPXf0wpAmvSE3Q3wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	//这里的notify_url和return_url改成自己项目要返回页面的地址，由于是沙箱环境，所以支付宝网关也有修改。
	//return_url是指付款成功之后返回给用户查看的界面，如付款成功之后返回到商品详情或者网站首页等等。
	//notify_url则是支付包与服务器交互的页面，用户看不到，支付成功以notify_url返回的参数或者查询订单返回的参数为准。
	
		
		
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
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

