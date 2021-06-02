package app;

import static org.junit.Assert.*;

import org.junit.Test;

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
