package com.jdyh.springfeature.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcDemoTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void apiTest() throws Exception {
        // perform: 执行一个 RequestBuilder 请求
        // andExpect: 添加 ResultMatcher -> MockMvcResultMatchers 验证规则
        // andReturn: 最后返回相应的 MvcResult
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/sysLog/excute").param("pk","111"))
        		.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("请求接口返回状态值：【"+status+"】");
    }

}
