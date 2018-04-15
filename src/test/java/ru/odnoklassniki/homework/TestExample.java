package ru.odnoklassniki.homework;

import org.hamcrest.Matchers;
import org.junit.*;
import ru.odnoklassniki.ClassToBeTested;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by danny on 15.04.18 at 10:23.
 **/

public class TestExample {
    private List<String> list;

    @Before
    public void init() throws Exception{
        list=ClassToBeTested.sortStringsByLength("World!","Hello");
    }


    @Test(timeout = 10000)
    public void testHasItem(){
        Assert.assertThat(("list has not value"),list, Matchers.hasItem(equalTo("Hello")));
    }

    @Test(timeout = 10000)
    public void testHasValue(){
        Assert.assertThat("String does not match",list.get(1),Matchers.<String>hasToString(equalTo("Hello")));
    }
}

