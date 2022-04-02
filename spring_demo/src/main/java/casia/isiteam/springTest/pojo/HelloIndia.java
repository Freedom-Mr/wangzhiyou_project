package casia.isiteam.springTest.pojo;

/**
 * @ClassName: HelloIndia
 * @Description: unknown
 * @Vsersion: 1.0
 * <p>
 * Created by casia.wangzhiyou on 2022/3/21
 * Email: zhiyou_wang@foxmail.com
 */
public class HelloIndia {
    private String message;
    private String message2;
    private String message3;

    public void setMessage(String message){
        this.message  = message;
    }

    public void setMessage2(String message){
        this.message2  = message;
    }

    public void setMessage3(String message){
        this.message3  = message;
    }

    public void getMessage(){
        System.out.println("India Message1 : " + message);
    }

    public void getMessage2(){
        System.out.println("India Message2 : " + message2);
    }

    public void getMessage3(){
        System.out.println("India Message3 : " + message3);
    }
}
