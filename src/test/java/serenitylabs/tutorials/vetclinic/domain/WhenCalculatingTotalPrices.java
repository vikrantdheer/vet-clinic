package serenitylabs.tutorials.vetclinic.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class WhenCalculatingTotalPrices {

	@Test
	public void total_consultation_price_should_include_20_percent_tax() throws Exception {
		// GIVEN
		int netPrice = 100;

		// WHEN
		int totalPrice = TotalConsultationPrice.includingTax().forANetPriceOf(netPrice);

		// THEN
		assertThat(totalPrice, equalTo(120));
		assertThat(totalPrice, greaterThan(netPrice));

	}
}
