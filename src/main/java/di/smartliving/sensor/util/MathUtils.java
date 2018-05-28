package di.smartliving.sensor.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class MathUtils {

	private MathUtils() {
	}

	public static BigDecimal random(BigDecimal min, BigDecimal max) {
		return new BigDecimal(ThreadLocalRandom.current().nextDouble(min.doubleValue(), max.doubleValue())).setScale(2,
				RoundingMode.DOWN);
	}
}
