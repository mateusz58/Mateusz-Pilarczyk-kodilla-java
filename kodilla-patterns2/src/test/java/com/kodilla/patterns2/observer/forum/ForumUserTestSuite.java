package com.kodilla.patterns2.observer.forum;

import org.junit.jupiter.api.Test;

import static com.kodilla.patterns2.generators.EasyRandomConfigure.fillObject;
import static org.junit.jupiter.api.Assertions.*;

public class ForumUserTestSuite {
    @Test
    public void testUpdate() {
        //Given
        //Given
        ForumTopic javaHelpForum=new JavaHelpForumTopic();
        ForumTopic javaToolsForum=new JavaToolsTopic();

        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");

        javaHelpForum.registerObserver(johnSmith);
        javaToolsForum.registerObserver(ivoneEscobar);
        javaHelpForum.registerObserver(jessiePinkman);

        //When
        javaHelpForum.addPost("Hi everyone! Could you help me with for loops?");
        javaHelpForum.addPost("Better try to use while loop in this case.");
        javaToolsForum.addPost("Help pls, my MySQL db doesn't want to work :(");
        javaHelpForum.addPost("Why while? Is it better?");
        javaToolsForum.addPost("When I try to log in I got 'bad credentials' message.");

        //Then
        assertEquals(2, ivoneEscobar.getUpdateCount());
        assertEquals(3, jessiePinkman.getUpdateCount());
    }
}