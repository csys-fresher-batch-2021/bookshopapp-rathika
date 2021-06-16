package app;

import static org.junit.Assert.fail;

import org.junit.Test;

import in.rathika.util.ConnectionUtil;

public class ConnectionTest {
    
	@Test
	public static void main(String[] args) {
		try {
			ConnectionUtil.getConnection();
		} catch (Exception e) {
			fail();
		}
	}

}
