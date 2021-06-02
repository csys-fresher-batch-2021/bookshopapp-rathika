package app;

import static org.junit.Assert.fail;

import in.rathika.util.ConnectionUtil;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
			ConnectionUtil.getConnection();
		} catch (Exception e) {
			fail();
		}
	}

}
