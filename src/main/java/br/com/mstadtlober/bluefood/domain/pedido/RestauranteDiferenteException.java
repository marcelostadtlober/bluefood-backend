package br.com.mstadtlober.bluefood.domain.pedido;

@SuppressWarnings("serial")
public class RestauranteDiferenteException extends Exception {

	public RestauranteDiferenteException() {
		super();
	}

	public RestauranteDiferenteException(String message) {
		super(message);
	}

}
