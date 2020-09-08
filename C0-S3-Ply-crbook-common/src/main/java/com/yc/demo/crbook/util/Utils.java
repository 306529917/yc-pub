package com.yc.demo.crbook.util;

import com.yc.demo.crbook.biz.BizException;

public class Utils {

	public static void must(boolean mustTrue, String msg) throws BizException {
		if (mustTrue == false) {
			throw new BizException(msg);
		}
	}

	public static void must(boolean mustTrue, String msg, Exception e) throws BizException {
		if (mustTrue == false) {
			throw new BizException(msg, e);
		}
	}

	public static void must(boolean mustTrue, String code, String msg) throws BizException {
		if (mustTrue == false) {
			throw new BizException(code, msg);
		}
	}

	public static void must(boolean mustTrue, String code, String msg, Exception e) throws BizException {
		if (mustTrue == false) {
			throw new BizException(code, msg, e);
		}
	}

}
