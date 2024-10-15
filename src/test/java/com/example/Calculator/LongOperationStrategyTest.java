package com.example.Calculator;

import com.example.Calculator.strategy.OperationStrategy;
import com.example.Calculator.strategy.add.IntegerAddOperation;
import com.example.Calculator.strategy.add.LongAddOperation;
import com.example.Calculator.strategy.divide.IntegerDivOperation;
import com.example.Calculator.strategy.divide.LongDivOperation;
import com.example.Calculator.strategy.multiply.IntegerMulOperation;
import com.example.Calculator.strategy.multiply.LongMulOperation;
import com.example.Calculator.strategy.subtract.IntegerSubOperation;
import com.example.Calculator.strategy.subtract.LongSubOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongOperationStrategyTest {
    private OperationStrategy addOpp;
    private OperationStrategy subOpp;
    private OperationStrategy mulOpp;
    private OperationStrategy divOpp;
    @BeforeEach
    public void setUp(){
        addOpp=new LongAddOperation();
        subOpp=new LongSubOperation();
        mulOpp=new LongMulOperation();
        divOpp=new LongDivOperation();
    }
    @Test
    public void testAddLongOperation(){
        assertEquals(5L, addOpp.execute(2L, 3L));
        assertEquals(0L, addOpp.execute(2L, -2L));
        assertEquals(-5L, addOpp.execute(-2L, -3L));
        assertEquals(Long.MAX_VALUE, addOpp.execute(Long.MAX_VALUE, 0L));
        assertThrows(ArithmeticException.class, () -> addOpp.execute(Long.MAX_VALUE, 1L));
    }
    @Test
    public void testSubLongOperation(){
        assertEquals(2L,subOpp.execute(5L,3L));
        assertEquals(-4L,subOpp.execute(-2L,2L));
        assertEquals(1L,subOpp.execute(-2L,-3L));
        assertEquals(Long.MIN_VALUE,subOpp.execute(Long.MIN_VALUE,0L));
        assertThrows(ArithmeticException.class,()->subOpp.execute(Long.MIN_VALUE,1));

    }
    @Test
    public void testMulLongOperation(){
        assertEquals(6L, mulOpp.execute(2L, 3L));
        assertEquals(-4L, mulOpp.execute(-2L, 2L));
        assertEquals(6L, mulOpp.execute(-2L, -3L));
        assertEquals(0L, mulOpp.execute(Integer.MAX_VALUE,0L));
        assertThrows(ArithmeticException.class, () -> mulOpp.execute(Long.MAX_VALUE, 2L));
    }
    @Test
    public void testDivLongOperation(){
        assertEquals(2.0,divOpp.execute(6L,3L));
        assertEquals(-1.0,divOpp.execute(-2L,2L));
        assertEquals(1.0,divOpp.execute(-3L,-3L));
        assertEquals((double)Long.MIN_VALUE,divOpp.execute(Long.MIN_VALUE,1L));
        assertThrows(ArithmeticException.class,()->divOpp.execute(1L,0L));
    }
}
