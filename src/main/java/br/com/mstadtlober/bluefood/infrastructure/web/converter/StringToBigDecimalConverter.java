package br.com.mstadtlober.bluefood.infrastructure.web.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.mstadtlober.bluefood.util.StringUtils;

@Component
public class StringToBigDecimalConverter implements Converter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String source) {
		if (StringUtils.isEmpty(source)) {
			return null;
		}
		
		source = source.replace(",", ".").trim();
		return BigDecimal.valueOf(Double.valueOf(source));
	}

}
