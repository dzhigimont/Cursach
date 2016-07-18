package tests;


import forms.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

public class TestSentMessage extends BaseTest{

    String userName,userPass,userNameSend,head,textMessage;
    /**
     * Before Class method
     */
    @BeforeTest


    @Parameters({"userName","userPass","userNameSend","head","textMessage"})
    /**
     * readParam
     * this method read parameter  from an external file TestSuite.xml
     *
     */

    public void readParam(String userName,String userPass,String userNameSend,String head,String textMessage){
        this.userName=userName;
        this.userPass=userPass;
        this.userNameSend=userNameSend;
        this.head=head;
        this.textMessage=textMessage;
    }

    public void runTest(){


        MainOnlinerForm mainOnlinerForm = new MainOnlinerForm();
        mainOnlinerForm.login(userName,userPass);

        logger.step(1);
        mainOnlinerForm.navigate(MainOnlinerForm.Buttons.userMessage.toString());
        MessagesUserForm messagesUserForm = new MessagesUserForm();

        logger.step(2);
        messagesUserForm.navigate(MessagesUserForm.Buttons.newMessages.toString());
        NewMessageForm newMessageForm = new NewMessageForm();

        logger.step(3);
        newMessageForm.fillTheMessage(userNameSend,head,textMessage);
        newMessageForm.sendMessage();

        logger.step(4);
        messagesUserForm.navigate(MessagesUserForm.Buttons.sentMessages.toString());
        ListSentMessagesForm listSentMessagesForm = new ListSentMessagesForm();

        logger.step(5);
        listSentMessagesForm.clickTopMessage();
        SentMessageForm sentMessageForm = new SentMessageForm();

        logger.step(6);
        sentMessageForm.assertSentMessage(userNameSend,head,textMessage);
        sentMessageForm.delMessage();
        mainOnlinerForm.navigate(MainOnlinerForm.Buttons.userQuit.toString());




    }



}
