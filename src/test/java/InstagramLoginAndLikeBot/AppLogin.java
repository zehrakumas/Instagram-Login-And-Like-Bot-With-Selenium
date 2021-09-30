package InstagramLoginAndLikeBot;

import org.openqa.selenium.WebElement;

import java.util.Scanner;

public class AppLogin extends App{
    public static void main(String[] args){
        App app=new App();
        //username is your instagram username
        //password is your instagram password
        app.Login("zehraakumas","********");
        app.navigateToProfile("uberkuloz");
        app.firstimgClick();
        app.likeClick();
    }
}
