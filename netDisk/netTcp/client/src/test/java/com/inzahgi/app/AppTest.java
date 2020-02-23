package com.inzahgi.app;

import static org.junit.Assert.assertTrue;

import com.alibaba.fastjson.JSON;
import com.inzahgi.app.entity.Frame;
import org.junit.Test;

/**
 * Unit test for simple ClientApp.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        byte[] a = new byte[]{0x12, 0x32, 0x67};
        System.out.println(JSON.toJSONString(a));

        Frame frame = new Frame(Frame.TYPE.NAME_REQ,  0, 0, "1.txt", null);
        String s = JSON.toJSONString(frame);
        System.out.println(s);
        Frame newF = JSON.parseObject(s, Frame.class);
        System.out.println(newF.toString());
    }
}
