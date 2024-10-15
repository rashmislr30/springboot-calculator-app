package com.example.Calculator;

import com.example.Calculator.strategy.OperationStrategy;
import com.example.Calculator.strategy.add.DoubleAddOperation;
import com.example.Calculator.strategy.add.IntegerAddOperation;
import com.example.Calculator.strategy.divide.DoubleDivOperation;
import com.example.Calculator.strategy.divide.IntegerDivOperation;
import com.example.Calculator.strategy.multiply.DoubleMulOperation;
import com.example.Calculator.strategy.multiply.IntegerMulOperation;
import com.example.Calculator.strategy.subtract.DoubleSubOperation;
import com.example.Calculator.strategy.subtract.IntegerSubOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoubleOperationStrategyTest {
    private OperationStrategy addOpp;
    private OperationStrategy subOpp;
    private OperationStrategy mulOpp;
    private OperationStrategy divOpp;
    @BeforeEach
    public void setUp(){
        addOpp= new DoubleAddOperation();
        subOpp=new DoubleSubOperation();
        mulOpp=new DoubleMulOperation();
        divOpp=new DoubleDivOperation();
    }
    @Test
    public void testAddDoubleOperation(){
        assertEquals(5.0,addOpp.execute(2,3) );
        assertEquals(0.0,addOpp.execute(2,-2));
        assertEquals(3.5,addOpp.execute(1.5,2));

    }
    @Test
    public void testSubDoubleOperation(){
        assertEquals(2.0, subOpp.execute(5.0, 3.0));
        assertEquals(-4.0, subOpp.execute(-2.0, 2.0));
        assertEquals(-0.5, subOpp.execute(1.5, 2.0));
    }
    @Test
    public void testMulDoubleOperation(){
        assertEquals(6.0, mulOpp.execute(2.0, 3.0));
        assertEquals(-4.0, mulOpp.execute(-2.0, 2.0));
        assertEquals(3.0, mulOpp.execute(1.5, 2.0));
        assertThrows(ArithmeticException.class,()->mulOpp.execute(1e308, 1e308));
    }
    @Test
    public void testDivDoubleOperation(){
        assertEquals(2.0, divOpp.execute(6.0, 3.0));
        assertEquals(-1.0, divOpp.execute(-2.0, 2.0));
        assertEquals(0.75, divOpp.execute(1.5, 2.0));
        assertThrows(ArithmeticException.class,()->divOpp.execute(1.0, 0.0));
    }

}
