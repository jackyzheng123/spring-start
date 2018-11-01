package com.zjx.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapTest {

	/**
	 * >>> 运算高于 &|^
	 * Java基础位运算
	 * 按位与&：两位全为1，结果是1
	 * 按位或|：只要有一个为1，结果是1
	 * 异或^：两个相应位值不同，则结果是1，否则是0
	 */
	@Test
	public void baseTest() {
		int n = 16 - 1;
		// n >>> 1 -》 00001111 右移1位 00000111      00001111|00000111=00001111=15
        n |= n >>> 1;
        // n >>> 2 -》 00001111 右移2位 00000011     00001111|00000011=00001111=15
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int a = (n < 0) ? 1 : (n >= 1 << 30) ? (1 << 30) : n + 1;
        System.out.println(a);
	}
	
	/**
	 * hashCode测试
	 */
	private int hash;
	private final char value[] = {'s','t','r','i','n','g'};
	@Test
	public void hashCodeTest() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        System.out.println(h);
        System.out.println("string".hashCode());
        System.out.println(1+'a');
    }
	
	public void hashMapTest(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "zjx");
	}
}
