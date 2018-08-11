package com.coderap;

import com.coderap.impl.UnionFindBasicImpl;
import com.coderap.impl.UnionFindTreeImpl;
import com.coderap.impl.UnionFindTreeOptimizeRankImpl;
import com.coderap.impl.UnionFindTreeOptimizeSizeImpl;
import org.junit.Test;

import java.util.Random;

/**
 * @program: Data-Structure-Practices
 * @description:
 * @author: Lennon Chin
 * @create: 2018/08/11 19:24:52
 */
public class PerformanceTest {
    
    private static int size = 100000;
    private static int loopCount = 100000;
    private static Random random = new Random();
    
    public static void testBasicUnionFindPerformance() {
        
        UnionFindBasicImpl unionFindBasic = new UnionFindBasicImpl(size);
        
        long startTime = System.nanoTime();
        
        for (int i = 0; i < loopCount; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFindBasic.unionElements(p, q);
        }
        
        for (int i = 0; i < loopCount; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFindBasic.isConnected(p, q);
        }
        
        long endTime = System.nanoTime();
        
        System.out.println("UnionFindBasicImpl cost: " + (endTime - startTime) / 1000000000.0 + " s.");
    }
    
    public static void testTreeUnionFindPerformance() {
        
        UnionFindTreeImpl unionFindTree = new UnionFindTreeImpl(size);
        
        long startTime = System.nanoTime();
        
        for (int i = 0; i < loopCount; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFindTree.unionElements(p, q);
        }
        
        for (int i = 0; i < loopCount; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFindTree.isConnected(p, q);
        }
        
        long endTime = System.nanoTime();
        
        System.out.println("UnionFindTreeImpl cost: " + (endTime - startTime) / 1000000000.0 + " s.");
    }
    
    public static void testTreeUnionFindOptimizeSizePerformance() {
        
        UnionFindTreeOptimizeSizeImpl unionFindTreeOptimizeSize = new UnionFindTreeOptimizeSizeImpl(size);
        
        long startTime = System.nanoTime();
        
        for (int i = 0; i < loopCount; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFindTreeOptimizeSize.unionElements(p, q);
        }
        
        for (int i = 0; i < loopCount; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFindTreeOptimizeSize.isConnected(p, q);
        }
        
        long endTime = System.nanoTime();
        
        System.out.println("UnionFindTreeOptimizeSizeImpl cost: " + (endTime - startTime) / 1000000000.0 + " s.");
    }
    
    public static void testTreeUnionFindOptimizeRankPerformance() {
        
        UnionFindTreeOptimizeRankImpl unionFindTreeOptimizeRank = new UnionFindTreeOptimizeRankImpl(size);
        
        long startTime = System.nanoTime();
        
        for (int i = 0; i < loopCount; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFindTreeOptimizeRank.unionElements(p, q);
        }
        
        for (int i = 0; i < loopCount; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            unionFindTreeOptimizeRank.isConnected(p, q);
        }
        
        long endTime = System.nanoTime();
        
        System.out.println("UnionFindTreeOptimizeRankImpl cost: " + (endTime - startTime) / 1000000000.0 + " s.");
    }
    
    @Test
    public void testPerformance() {
        testBasicUnionFindPerformance();
        testTreeUnionFindPerformance();
        testTreeUnionFindOptimizeSizePerformance();
        testTreeUnionFindOptimizeRankPerformance();
    }
}
