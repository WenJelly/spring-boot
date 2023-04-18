package com.atguigu.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;



/*@RunWith*/

/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith(SpringExtension.class)
 */
//@SpringBootTest
@DisplayName("junit5功能测试类")
public class Junit5Test {


    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testassumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("111111");

    }



    /**
     * 断言：前面断言失败，后面的代码都不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions() {
        int cal = cal(3, 3);
        //前面的是认为的值，后面的是这个程序的值
        assertEquals(5,cal,"测试失败");

        //如果前面的断言失败了，那么后面的代码就不会运行
        Object o = new Object();
        Object o1 = new Object();
        assertSame(o,o1,"俩个对象不一样");

    }

    @Test
    @DisplayName("array assertion")
    void array() {
        //前面要传的是 期望，后面传的是需要比较的
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, "数组内容不相等");
    }

    @Test
    @DisplayName("组合断言")
    void all() {
        /**
         * 所有断言全部需要成功
         */
        assertAll("testAll",
                () -> assertEquals(1,1),
                () -> assertEquals(1,2),
                () -> assertTrue(true && true));
        System.out.println("========================");
    }

    @DisplayName("异常断言")
    @Test
    void testException() {

        //断定业务逻辑一定出现异常
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 2;
        }, "业务逻辑居然正常运行？");
    }

    @DisplayName("快速失败")
    @Test
    void testFail(){
        //xxxxx
        if(1 == 2){
            fail("测试失败");
        }

    }


    int cal(int i, int j) {
        return i + j;
    }

    @DisplayName("测试displayname注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    void test3() {
        System.out.println(5);
    }

    /**
     * 规定方法超时时间。超出时间测试出异常
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }


    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了...");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了...");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了...");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试以及结束了...");

    }


}
