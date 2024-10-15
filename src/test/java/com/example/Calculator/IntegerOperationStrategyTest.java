package com.example.Calculator;

import com.example.Calculator.strategy.OperationStrategy;
import com.example.Calculator.strategy.add.IntegerAddOperation;
import com.example.Calculator.strategy.divide.IntegerDivOperation;
import com.example.Calculator.strategy.multiply.IntegerMulOperation;
import com.example.Calculator.strategy.subtract.IntegerSubOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerOperationStrategyTest {
    private OperationStrategy addOpp;
    private OperationStrategy subOpp;
    private OperationStrategy mulOpp;
    private OperationStrategy divOpp;
    @BeforeEach
    public void setUp(){
        addOpp= new IntegerAddOperation();
        subOpp=new IntegerSubOperation();
        mulOpp=new IntegerMulOperation();
        divOpp=new IntegerDivOperation();
    }
    @Test
    public void testAddIntOperation(){
        assertEquals(5,addOpp.execute(2,3) );
        assertEquals(0,addOpp.execute(2,-2));
        assertEquals(-5,addOpp.execute(-2,-3));
        assertEquals(Integer.MAX_VALUE, addOpp.execute(Integer.MAX_VALUE,0));
        assertThrows(ArithmeticException.class, ()->addOpp.execute(Integer.MAX_VALUE,1));
    }
    @Test
    public void testSubIntOperation(){
        assertEquals(2,subOpp.execute(5,3));
        assertEquals(-4,subOpp.execute(-2,2));
        assertEquals(1,subOpp.execute(-2,-3));
        assertEquals(Integer.MIN_VALUE,subOpp.execute(Integer.MIN_VALUE,0));
        assertThrows(ArithmeticException.class,()->subOpp.execute(Integer.MIN_VALUE,1));
    }
    @Test
    public void testMulIntOperation(){
        assertEquals(6, mulOpp.execute(2, 3));
        assertEquals(-4, mulOpp.execute(-2, 2));
        assertEquals(6, mulOpp.execute(-2, -3));
        assertEquals(0, mulOpp.execute(Integer.MAX_VALUE,0));
        assertThrows(ArithmeticException.class, () -> mulOpp.execute(Integer.MAX_VALUE, 2));
    }
    @Test
    public void testDivIntOperation(){
        assertEquals(2.0,divOpp.execute(6,3));
        assertEquals(-1.0,divOpp.execute(-2,2));
        assertEquals(1.0,divOpp.execute(-3,-3));
        assertEquals((double)Integer.MIN_VALUE,divOpp.execute(Integer.MIN_VALUE,1));
        assertThrows(ArithmeticException.class,()->divOpp.execute(1,0));
    }
}
